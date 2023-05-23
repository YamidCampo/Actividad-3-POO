import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Algoritmo extends JFrame{
    // Panel Principal
    public JPanel panel;
    private JLabel labelRetornos1, labelRetornos2, labelRetornos3;
    private JTextField textoA, textoB;
    private String inputA, inputB;

    public Algoritmo(){
        // Ventana principal
        this.setSize(350, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Cápitulo 4:  Ejercicio 7"); // Titulo a la ventana
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
        etiquetaNota.setText("Para saber si A es mayor, menor o igual que B:");
        etiquetaNota.setBounds(10,10,300,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaNota);

        JLabel etiquetaA = new JLabel();
        etiquetaA.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaA.setText("Ingrese el valor de A: ");
        etiquetaA.setBounds(10,30,300,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaA);

        JLabel etiquetaB = new JLabel();
        etiquetaB.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaB.setText("Ingrese el valor de B: ");
        etiquetaB.setBounds(10,80,300,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaB);
    }
    public void entradaTexto(){
        textoA = new JTextField();
        textoA.setBounds(75,50,220,17);
        panel.add(textoA);
        System.out.println(textoA.getText());

        textoB = new JTextField();
        textoB.setBounds(75,100,220,17);
        panel.add(textoB);
        System.out.println(textoB.getText());
    }
    public void Boton(){
        JButton botonRespuesta= new JButton();
        botonRespuesta.setText("Mostrar respuesta.");
        botonRespuesta.setBounds(95,150,160,40);
        panel.add(botonRespuesta);

        labelRetornos1 = new JLabel();
        labelRetornos1.setBounds(10,210,300,17);
        panel.add(labelRetornos1);


        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((textoA != null && !textoA.getText().isEmpty())
                        || (textoB != null && !textoB.getText().isEmpty())){
                    inputA = textoA.getText();
                    inputB = textoB.getText();
                    float valorA = Float.parseFloat(inputA);
                    float valorB = Float.parseFloat(inputB);
                    if (valorA>valorB){
                        labelRetornos1.setText("A es mayor que B.");
                    } else if (valorA<valorB) {
                        labelRetornos1.setText("A es menor que B.");
                    }
                    else {
                        labelRetornos1.setText("A es igual que B.");
                    }
                    }
                else {
                    labelRetornos1.setText("Debe ingresar un valor en todos los campos.");
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
