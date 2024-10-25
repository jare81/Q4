/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q4;

import java.awt.Color;
import java.util.Random;
import javax.swing.JTextField;

/**
 *
 * @author Dell
 */
public class Controlador extends Abstract {
    
    private JTextField[][] casillas;
    private int[][] tablero = new int[9][9];
     private int[][] solucion = new int[9][9];
    
    public Controlador (JTextField[][] casillas){
        this.casillas=casillas;
         generarSolucion();
    }
    
    
   /*  public void NumerosIniciales(int cantidad) {
        Random rand = new Random();
        int generados = 0;

        while (generados < cantidad) {
            int fila = rand.nextInt(9);
            int col = rand.nextInt(9);
            int numero = rand.nextInt(9) + 1;

            if (casillas[fila][col].getText().isEmpty() && esValido(fila, col, numero)) {
                casillas[fila][col].setText(String.valueOf(numero));
                casillas[fila][col].setEditable(false);  
                generados++;
            }
        }
    }
        public boolean verificarEntrada(int fila, int columna, int numero) {
                String valorOriginal = casillas[fila][columna].getText();
        casillas[fila][columna].setText("");

        boolean esValido = validarFila(fila, numero) && validarColumna(columna, numero) && validarSubcuadro(fila - fila % 3, columna - columna % 3, numero);

        casillas[fila][columna].setText(valorOriginal);
        return esValido;
    }
        
        
    public boolean esValido(int fila, int columna, int numero) {
        return validarFila(fila, numero) && validarColumna(columna, numero) && validarSubcuadro(fila - fila % 3, columna - columna % 3, numero);
    }

    public boolean validarFila(int fila, int numero) {
        for (int col = 0; col < 9; col++) {
            String texto = casillas[fila][col].getText();
            if (!texto.isEmpty() && Integer.parseInt(texto) == numero) {
                return false;
            }
        }
        return true;
    }

    public boolean validarColumna(int columna, int numero) {
        for (int fila = 0; fila < 9; fila++) {
            String texto = casillas[fila][columna].getText();
            if (!texto.isEmpty() && Integer.parseInt(texto) == numero) {
                return false;
            }
        }
        return true;
    }

    public boolean validarSubcuadro(int inicioFila, int inicioCol, int numero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String texto = casillas[inicioFila + i][inicioCol + j].getText();
                if (!texto.isEmpty() && Integer.parseInt(texto) == numero) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean validarTablero() {
        //Filas
    for (int fila = 0; fila < 9; fila++) {
            boolean[] presentes = new boolean[9];
            for (int col = 0; col < 9; col++) {
                String texto = casillas[fila][col].getText();
                if (!texto.isEmpty()) {
                    int num = Integer.parseInt(texto) - 1;
                    if (presentes[num]) return false;
                    presentes[num] = true;
                }
            }
        }
    
    // Columnas
    for (int col = 0; col < 9; col++) {
        boolean[] presentes = new boolean[9];
        for (int fila = 0; fila < 9; fila++) {
            String texto = casillas[fila][col].getText();
            if (!texto.isEmpty()) {
                int num = Integer.parseInt(texto) - 1;
                if (presentes[num]) return false;
                presentes[num] = true;
            }
        }
    }

    //Subcuadros 3x3
    for (int inicioFila = 0; inicioFila < 9; inicioFila += 3) {
        for (int inicioCol = 0; inicioCol < 9; inicioCol += 3) {
            boolean[] presentes = new boolean[9];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    String texto = casillas[inicioFila + i][inicioCol + j].getText();
                    if (!texto.isEmpty()) {
                        int num = Integer.parseInt(texto) - 1;
                        if (presentes[num]) return false;
                        presentes[num] = true;
                    }
                }
            }
        }
    }
    return true;
    }*/
    
    public boolean generarSolucion() {
        return resolverTablero(solucion, 0, 0);
    }

    public boolean resolverTablero(int[][] tablero, int fila, int col) {
        if (fila == 9) return true;
        if (col == 9) return resolverTablero(tablero, fila + 1, 0);
        if (tablero[fila][col] != 0) return resolverTablero(tablero, fila, col + 1);

        for (int num = 1; num <= 9; num++) {
            if (esValido(tablero, fila, col, num)) {
                tablero[fila][col] = num;
                if (resolverTablero(tablero, fila, col + 1)) return true;
                tablero[fila][col] = 0;
            }
        }
        return false;
    }

    public boolean esValido(int[][] tablero, int fila, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (tablero[fila][i] == num || tablero[i][col] == num) return false;
        }
        int inicioFila = (fila / 3) * 3;
        int inicioCol = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[inicioFila + i][inicioCol + j] == num) return false;
            }
        }
        return true;
    }

    public void inicializarTablero(int pistas) {
        copiarSolucionACasillas();
        vaciarCasillas(pistas);
    }

    public void copiarSolucionACasillas() {
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                if (solucion[fila][col] != 0) {
                    casillas[fila][col].setText(String.valueOf(solucion[fila][col]));
                    casillas[fila][col].setEditable(false);
                } else {
                    casillas[fila][col].setText("");
                }
            }
        }
    }

    public void vaciarCasillas(int cantidad) {
        Random rand = new Random();
        int vacias = 81 - cantidad;

        while (vacias > 0) {
            int fila = rand.nextInt(9);
            int col = rand.nextInt(9);
            if (!casillas[fila][col].getText().isEmpty()) {
                casillas[fila][col].setText("");
                casillas[fila][col].setEditable(true);
                vacias--;
            }
        }
    }

    public boolean verificarEntrada(int fila, int col, int numero) {
        return solucion[fila][col] == numero;
    }
}
    
    
    
    




    
    
    
    
    
    
    
            
        
    

