import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Algoritmo extends JFrame{
    // Panel Principal
    public JPanel panel;
    private JLabel labelRetornos1, labelRetornos2, labelRetornos3;
    private JTextField textoNumero, textoNombre
            , textoPatrimonio, textoEstrato;
    private String inputPAT, inputEST;
    private double PAGMAT;

    public Algoritmo(){
        // Ventana principal
        this.setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cápitulo 4:  Ejercicio 10"); // Titulo a la ventana
        setLocationRelativeTo(null); // Posiciona la ventana en el centro
        iniciarComponentes(); //Inicia el método componentes
    }
    public void iniciarComponentes(){
        colocarPaneles();
        Etiquetas();
        entradaTexto();
        Boton();
    }
    public void colocarPaneles(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    public void Etiquetas(){
        JLabel etiquetaCodigo = new JLabel();
        etiquetaCodigo.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaCodigo.setText("Ingrese el número de inscripción del estudiante: ");
        etiquetaCodigo.setBounds(10,10,300,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaCodigo);

        JLabel etiquetaNombre = new JLabel();
        etiquetaNombre.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaNombre.setText("Ingrese el nombre del estudiante: ");
        etiquetaNombre.setBounds(10,60,300,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaNombre);

        JLabel etiquetaHoras = new JLabel();
        etiquetaHoras.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaHoras.setText("Ingrese el patrimonio del estudiante: ");
        etiquetaHoras.setBounds(10,110,300,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaHoras);

        JLabel etiquetaValorHora = new JLabel();
        etiquetaValorHora.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaValorHora.setText("Ingrese el estrato social del estudiante: ");
        etiquetaValorHora.setBounds(10,170,300,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaValorHora);
    }
    public void entradaTexto(){
        textoNumero = new JTextField();
        textoNumero.setBounds(150,35,200,17);
        panel.add(textoNumero);
        System.out.println(textoNumero.getText());

        textoNombre = new JTextField();
        textoNombre.setBounds(150,85,200,17);
        panel.add(textoNombre);

        textoPatrimonio = new JTextField();
        textoPatrimonio.setBounds(150,135,200,17);
        panel.add(textoPatrimonio);

        textoEstrato= new JTextField();
        textoEstrato.setBounds(150,195,200,17);
        panel.add(textoEstrato);
    }
    public void Boton(){
        JButton botonLiquidacion = new JButton();
        botonLiquidacion.setText("Liquidar estudiante.");
        botonLiquidacion.setBounds(170,300,160,40);
        panel.add(botonLiquidacion);

        labelRetornos1 = new JLabel();
        labelRetornos1.setBounds(10,370,300,17);
        panel.add(labelRetornos1);

        labelRetornos2 = new JLabel();
        labelRetornos2.setBounds(10,390,300,17);
        panel.add(labelRetornos2);

        labelRetornos3 = new JLabel();
        labelRetornos3.setBounds(10,410,300,17);
        panel.add(labelRetornos3);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputPAT = textoPatrimonio.getText();
                inputEST = textoEstrato.getText();
                int valorPAT= Integer.parseInt(inputPAT);
                float valorEST = Float.parseFloat(inputEST);
                int pagomatricula = 50000;
                if (valorPAT>2000000 && valorEST>3){
                    double PAGMAT = pagomatricula+(0.03*valorPAT);
                    labelRetornos1.setText("El número de inscripción del estudiante es: "+textoNumero.getText());
                    labelRetornos2.setText("El nombre del estudiante es: "+textoNombre.getText());
                    labelRetornos3.setText("El estudiante debe pagar : "+PAGMAT);
                }
                else {
                    labelRetornos1.setText("El número de inscripción del estudiante es: "+textoNumero.getText());
                    labelRetornos2.setText("El nombre del estudiante es: "+textoNombre.getText());
                    labelRetornos3.setText("El estudiante debe pagar : "+pagomatricula);
                }
            }
        };
        botonLiquidacion.addActionListener(accion);
    }
    public static void main(String[] args) {
        Algoritmo ventana = new Algoritmo();
        ventana.setVisible(true);
    }
}
