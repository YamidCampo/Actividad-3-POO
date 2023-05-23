import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Algoritmo extends JFrame{
    // Panel Principal
    public JPanel panel;
    private JLabel labelRetornos1, labelRetornos2, labelRetornos3;
    private JTextField textoLado;
    private String inputLado;

    public Algoritmo(){
        // Ventana principal
        this.setSize(350, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cápitulo 3:  Ejercicio 19"); // Titulo a la ventana
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
        JLabel etiquetaNota = new JLabel();
        etiquetaNota.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaNota.setText("Para saber el perímetro, altura y área del triangulo:");
        etiquetaNota.setBounds(10,10,300,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaNota);

        JLabel etiquetaLado = new JLabel();
        etiquetaLado.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaLado.setText("Ingrese el valor del lado del triángulo equilátero: ");
        etiquetaLado.setBounds(10,30,300,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaLado);
    }
    public void entradaTexto(){
        textoLado = new JTextField();
        textoLado.setBounds(75,50,220,17);
        panel.add(textoLado);
        System.out.println(textoLado.getText());
    }
    public void Boton(){
        JButton botonRespuesta= new JButton();
        botonRespuesta.setText("Mostrar respuestas.");
        botonRespuesta.setBounds(95,70,160,40);
        panel.add(botonRespuesta);

        labelRetornos1 = new JLabel();
        labelRetornos1.setBounds(10,160,300,17);
        panel.add(labelRetornos1);

        labelRetornos2 = new JLabel();
        labelRetornos2.setBounds(10,180,300,17);
        panel.add(labelRetornos2);

        labelRetornos3 = new JLabel();
        labelRetornos3.setBounds(10,200,300,17);
        panel.add(labelRetornos3);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textoLado != null && !textoLado.getText().isEmpty()){
                inputLado = textoLado.getText();
                int valorLado= Integer.parseInt(inputLado);
                double altura = Math.sqrt((valorLado*valorLado)-((valorLado/2)*(valorLado/2)));
                double area = (valorLado*altura)/2;
                labelRetornos1.setText("El perimetro del triangulo es: "+valorLado*3);
                labelRetornos2.setText("La altura del triangulo es: "+altura);
                labelRetornos3.setText("El area del triangulo es: "+area);}
                else {
                    labelRetornos1.setText("Debe ingresar algún valor entero.");
                }
            }
        };
        botonRespuesta.addActionListener(accion);
    }
    public static void main(String[] args) {
        Algoritmo ventana = new Algoritmo();
        ventana.setVisible(true);
    }
}
