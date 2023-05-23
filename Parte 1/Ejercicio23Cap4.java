import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Algoritmo extends JFrame{
    // Panel Principal
    public JPanel panel;
    private JLabel labelRetornos1, labelRetornos2;
    private JTextField textoA, textoB, textoC;
    private String inputA, inputB, inputC;


    public Algoritmo(){
        // Ventana principal
        this.setSize(550, 500);
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
        etiquetaNombre.setText("Ingrese el valor de A: ");
        etiquetaNombre.setBounds(10,10,300,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaNombre);

        JLabel etiquetaHoras = new JLabel();
        etiquetaHoras.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaHoras.setText("Ingrese el valor de B: ");
        etiquetaHoras.setBounds(10,50,350,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaHoras);

        JLabel etiquetaSalario = new JLabel();
        etiquetaSalario.setOpaque(true); // Permiso para configurar la etiqueta
        etiquetaSalario.setText("Ingrese el valor de C: ");
        etiquetaSalario.setBounds(10,90,300,17); // Posiciona y cambia tamaño de la etiqueta
        panel.add(etiquetaSalario);
    }
    public void entradaTexto(){
        textoA = new JTextField();
        textoA.setBounds(150,30,200,17);
        panel.add(textoA);

        textoB= new JTextField();
        textoB.setBounds(150,70,200,17);
        panel.add(textoB);

        textoC= new JTextField();
        textoC.setBounds(150,120,200,17);
        panel.add(textoC);
    }
    public void Boton(){
        JButton botonLiquidacion = new JButton();
        botonLiquidacion.setText("Liquidar estudiante.");
        botonLiquidacion.setBounds(170,250,160,40);
        panel.add(botonLiquidacion);

        labelRetornos1 = new JLabel();
        labelRetornos1.setBounds(10,310,490,17);
        panel.add(labelRetornos1);

        labelRetornos2 = new JLabel();
        labelRetornos2.setBounds(10,330,490,17);
        panel.add(labelRetornos2);

        ActionListener accion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputA = textoA.getText();
                inputB = textoB.getText();
                inputC = textoC.getText();
                float valorA = Float.parseFloat(inputA);
                float valorB = Float.parseFloat(inputB);
                float valorC = Float.parseFloat(inputC);
                double A,B,C,discriminante,x1,x2;
                A=valorA;
                B=valorB;
                C=valorC;
                discriminante=(Math.pow(B,2)-(4*A*C));
                if(discriminante<0){
                    labelRetornos1.setText("El discrimiannte al ser negativo ("+discriminante+"), hará que el sistema tenga soluciones complejas.");
                    labelRetornos2.setText("Y esta es: x = (-"+B+"±√"+Math.abs(Math.pow(B,2)-(4*A*C))+"i"+")/"+(2*A));
                }
                else if (discriminante==0) {

                    labelRetornos1.setText("El sistema tiene una única solución real.");
                    x1=(-B+Math.sqrt((Math.pow(B,2)-(4*A*C))))/(2*A);
                    labelRetornos2.setText("Y esta es: x = "+x1);
                }
                else{
                    labelRetornos1.setText("El sistema tiene dos soluciones reales diferentes.");
                    x1=(-B+Math.sqrt((Math.pow(B,2)-(4*A*C))))/(2*A);
                    x2=(-B-Math.sqrt((Math.pow(B,2)-(4*A*C))))/(2*A);
                    labelRetornos2.setText("Y estas son: x1 = "+x1+", y x2 = "+x2);
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
