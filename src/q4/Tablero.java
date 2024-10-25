/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q4;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Dell
 */
public class Tablero extends JFrame {
   private JTextField [][] casillas = new JTextField[9][9];
   private JPanel tablero = new JPanel();
   private Button botonVerificar = new Button();
   private Button botonLlenar = new Button();
   private JPanel ventana = new JPanel();
   private Controlador control;
   
   
   
   public Tablero(){
       configurarVentana();
        this.control = new Controlador(casillas);
        iniciarCasillas();
        control.inicializarTablero(20); 
        
      
       
   }
   
   
    /*private void iniciarCasillas() {
    tablero.setLayout(new GridLayout(9, 9));

    for (int fila = 0; fila < 9; fila++) {
        for (int columna = 0; columna < 9; columna++) {
            casillas[fila][columna] = new JTextField();
            casillas[fila][columna].setHorizontalAlignment(JTextField.CENTER);
            casillas[fila][columna].setFont(new Font("Times New Roman", Font.BOLD, 25));
            casillas[fila][columna].addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isDigit(c) || c == '0') { 
                        e.consume(); 
                    }
                }

                public void keyReleased(KeyEvent e) {
                    JTextField campo = (JTextField) e.getSource();
                    String texto = campo.getText();

                    if (!texto.isEmpty()) {
                        int numero = Integer.parseInt(texto);
                        int fila = -1, columna = -1;

                        outerloop:
                        for (int i = 0; i < 9; i++) {
                            for (int j = 0; j < 9; j++) {
                                if (casillas[i][j] == campo) {
                                    fila = i;
                                    columna = j;
                                    break outerloop;
                                }
                            }
                        }

                        if (!control.verificarEntrada(fila, columna, numero)) {
                            campo.setText(""); 
                            campo.setBackground(Color.PINK);
                        } else {
                            campo.setBackground(Color.GREEN); 
                        }
                    }
                }
            });

            if ((fila / 3 + columna / 3) % 2 == 0) {
                casillas[fila][columna].setBackground(Color.LIGHT_GRAY);
            } else {
                casillas[fila][columna].setBackground(Color.WHITE);
            }

            tablero.add(casillas[fila][columna]);
        }
    }

    tablero.setPreferredSize(new Dimension(450, 450));
    ventana.add(tablero);
    ventana.revalidate();
    ventana.repaint();

    control.NumerosIniciales(20);
}

   
   
    private void configurarVentana() {
        setTitle("Tablero de Sudoku");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); 
        setSize(700, 700);
        add(ventana, BorderLayout.CENTER); 
        setVisible(true);
    }
   
    public static void main(String[] args) {
        new Tablero ();
    }*/
   
   private void iniciarCasillas() {
        tablero.setLayout(new GridLayout(9, 9));

        for (int fila = 0; fila < 9; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                casillas[fila][columna] = new JTextField();
                casillas[fila][columna].setHorizontalAlignment(JTextField.CENTER);
                casillas[fila][columna].setFont(new Font("Times New Roman", Font.BOLD, 25));
                casillas[fila][columna].addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (!Character.isDigit(c) || c == '0') {
                            e.consume();
                        }
                    }

                    public void keyReleased(KeyEvent e) {
                        JTextField campo = (JTextField) e.getSource();
                        String texto = campo.getText();

                        if (!texto.isEmpty()) {
                            int numero = Integer.parseInt(texto);
                            int fila = -1, columna = -1;

                            outerloop:
                            for (int i = 0; i < 9; i++) {
                                for (int j = 0; j < 9; j++) {
                                    if (casillas[i][j] == campo) {
                                        fila = i;
                                        columna = j;
                                        break outerloop;
                                    }
                                }
                            }

                            if (!control.verificarEntrada(fila, columna, numero)) {
                                campo.setText("");
                                campo.setBackground(Color.PINK);
                            } else {
                                campo.setBackground(Color.GREEN);
                            }
                        }
                    }
                });

                if ((fila / 3 + columna / 3) % 2 == 0) {
                    casillas[fila][columna].setBackground(Color.LIGHT_GRAY);
                } else {
                    casillas[fila][columna].setBackground(Color.WHITE);
                }

                tablero.add(casillas[fila][columna]);
            }
        }

        tablero.setPreferredSize(new Dimension(450, 450));
        ventana.add(tablero);
        ventana.revalidate();
        ventana.repaint();
    }

    private void configurarVentana() {
        setTitle("Tablero de Sudoku");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(700, 700);
        add(ventana, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Tablero();
    }
}
    
    

   
   
    
    

