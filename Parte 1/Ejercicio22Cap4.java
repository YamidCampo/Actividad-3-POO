import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Algoritmo extends JFrame{
    // Panel Principal
    public JPanel panel;
    private JLabel labelRetornos1, labelRetornos2;
    private JTextField textoNombre, textoHoras, textoSalario;
    private String inputNombre, inputHoras, inputSalario;


    public Algoritmo(){
        // Ventana principal
        this.setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cápitulo 4:  Ejercicio 23"); // Titulo a la ventana
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

        JLabel etiquetaNombre = new JLabel();
        etiquetaNombre.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaNombre.setText("Ingrese el nombre del empleado: ");
        etiquetaNombre.setBounds(10,10,300,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaNombre);

        JLabel etiquetaHoras = new JLabel();
        etiquetaHoras.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaHoras.setText("Ingrese las horas trabajadas en el mes por el empleado ");
        etiquetaHoras.setBounds(10,50,350,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaHoras);

        JLabel etiquetaSalario = new JLabel();
        etiquetaSalario.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaSalario.setText("Ingrese el salario básico por hora del empleado: ");
        etiquetaSalario.setBounds(10,90,300,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaSalario);
    }
    public void entradaTexto(){
        textoNombre = new JTextField();
        textoNombre.setBounds(150,30,200,17);
        panel.add(textoNombre);

        textoHoras= new JTextField();
        textoHoras.setBounds(150,70,200,17);
        panel.add(textoHoras);

        textoSalario= new JTextField();
        textoSalario.setBounds(150,120,200,17);
        panel.add(textoSalario);
    }
    public void Boton(){
        JButton botonLiquidacion = new JButton();
        botonLiquidacion.setText("Liquidar empleado.");
        botonLiquidacion.setBounds(170,300,160,40);
        panel.add(botonLiquidacion);

        labelRetornos1 = new JLabel();
        labelRetornos1.setBounds(10,370,300,17);
        panel.add(labelRetornos1);

        labelRetornos2 = new JLabel();
        labelRetornos2.setBounds(10,390,300,17);
        panel.add(labelRetornos2);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputNombre = textoNombre.getText();
                inputHoras = textoHoras.getText();
                inputSalario = textoSalario.getText();
                int valorHoras= Integer.parseInt(inputHoras);
                float valorSalarioBasico = Float.parseFloat(inputSalario);
                float valorSalario = valorSalarioBasico * valorHoras;
                if (valorSalario>450000){
                    labelRetornos1.setText("El nombre del empleado es: "+textoNombre.getText());
                    labelRetornos2.setText("El salario del empleado es : "+valorSalario);
                }
                else {
                    labelRetornos1.setText("El nombre del empleado es: "+textoNombre.getText());
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
