import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame{
    // Panel Principal
    public JPanel panel;
    private JLabel labelRetornos1, labelRetornos4
        , labelRetornos2, labelRetornos3;
    private JTextField textoCodigo, textoNombre
            , textoHoras, textoValorHora
            , textoPorcentaje;
    private String inputHoras, inputValorHora
            , inputPorcentaje;
    private float salarioBruto;
    private float salarioNeto;

    public Ventana(){
        // Ventana principal
        this.setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cápitulo 3:  Ejercicio 18"); // Titulo a la ventana
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
        etiquetaCodigo.setText("Ingrese el código del Empleado: ");
        etiquetaCodigo.setBounds(10,10,185,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaCodigo);

        JLabel etiquetaNombre = new JLabel();
        etiquetaNombre.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaNombre.setText("Ingrese el nombre del Empleado: ");
        etiquetaNombre.setBounds(10,60,190,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaNombre);

        JLabel etiquetaHoras = new JLabel();
        etiquetaHoras.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaHoras.setText("Ingrese las horas trabajadas del Empleado: ");
        etiquetaHoras.setBounds(10,110,250,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaHoras);

        JLabel etiquetaValorHora = new JLabel();
        etiquetaValorHora.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaValorHora.setText("Ingrese el valor de la hora trabajada del Empleado: ");
        etiquetaValorHora.setBounds(10,170,290,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaValorHora);

        JLabel etiquetaPorcentaje = new JLabel();
        etiquetaPorcentaje.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaPorcentaje.setText("Ingrese el porcentaje de retención del Empleado: ");
        etiquetaPorcentaje.setBounds(10,230,285,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaPorcentaje);
    }
    public void entradaTexto(){
        textoCodigo = new JTextField();
        textoCodigo.setBounds(150,35,200,17);
        panel.add(textoCodigo);
        System.out.println(textoCodigo.getText());

        textoNombre = new JTextField();
        textoNombre.setBounds(150,85,200,17);
        panel.add(textoNombre);

        textoHoras = new JTextField();
        textoHoras.setBounds(150,135,200,17);
        panel.add(textoHoras);

        textoValorHora = new JTextField();
        textoValorHora.setBounds(150,195,200,17);
        panel.add(textoValorHora);

        textoPorcentaje = new JTextField();
        textoPorcentaje.setBounds(150,255,200,17);
        panel.add(textoPorcentaje);
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

        labelRetornos3 = new JLabel();
        labelRetornos3.setBounds(10,410,300,17);
        panel.add(labelRetornos3);

        labelRetornos4 = new JLabel();
        labelRetornos4.setBounds(10,430,300,17);
        panel.add(labelRetornos4);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputHoras = textoHoras.getText();
                inputValorHora = textoValorHora.getText();
                inputPorcentaje = textoPorcentaje.getText();
                int valorHora = Integer.parseInt(inputValorHora);
                float horasTrabajadasAlMes = Float.parseFloat(inputHoras);
                salarioBruto = valorHora * horasTrabajadasAlMes;
                float bruto = salarioBruto;
                float porcentajeRetencion = Float.parseFloat(inputPorcentaje);
                salarioNeto = bruto - (bruto * (porcentajeRetencion / 100));
                labelRetornos1.setText("El codigo del empleado es: "+textoCodigo.getText());
                labelRetornos2.setText("El nombre del empleado es: "+textoNombre.getText());
                labelRetornos3.setText("El salario bruto del empleado es: "+salarioBruto);
                labelRetornos4.setText("El salario neto del empleado es: "+salarioNeto);
            }
        };
        botonLiquidacion.addActionListener(accion);
    }
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
    }
}
