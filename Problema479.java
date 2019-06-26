

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Problema 479 - El hombre sin miedo y sin radar
 *
 * https://www.aceptaelreto.com/problem/statement.php?id=479
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.23
 */
public class Problema479 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        PrintStream salida = new PrintStream(System.out);
        char[][] sala;
        byte filas, columnas;
        byte numConsulta;
        byte f, c; // fila y columna recibida en la consulta
        String direccion;

        // leo las filas y columnas de la sala
        filas = entrada.nextByte();
        columnas = entrada.nextByte();

        // termino cuando filas y columnas es cero
        while (filas != 0 && columnas != 0) {
            //guarda la cadena de salida
            StringBuilder resultado = new StringBuilder();
            entrada.nextLine(); // vacio el retorno de carro
            sala = new char[filas][columnas];
            for (f = 0; f < filas; f++) {
                String fila = entrada.nextLine();
                for (c = 0; c < columnas; c++) {
                    sala[f][c] = fila.charAt(c);
                }
            }

            // leo el número de consultas
            numConsulta = entrada.nextByte();

            for (byte i = 0; i < numConsulta; i++) {
                // leo fila de entrada de la consulta
                f = (byte) (entrada.nextByte() - 1);
                // leo columna de entrada de la consulta
                c = (byte) (entrada.nextByte() - 1);
                // leo dirección
                direccion = entrada.nextLine().trim();
                byte distancia = 0;
                switch (direccion) {
                    case "IZQUIERDA":
                        // mientras no haya llegado al extremo izquierdo y
                        // en la celda de la sala no hay un villano
                        while (--c > 0 && sala[f][c] == '.') {
                            distancia++;
                        }
                        resultado.append((c >= 0 && sala[f][c] == 'X') ? distancia+1 : "NINGUNO");
                        break;
                    case "DERECHA":
                        // mientras no haya llegado al extremo derecho y
                        // en la celda de la sala no hay un villano
                        while (++c < columnas && sala[f][c] == '.') {
                            distancia++;
                        }
                        resultado.append((c < columnas && sala[f][c] == 'X') ? distancia+1 : "NINGUNO");
                        break;
                    case "ARRIBA":
                        // mientras no haya llegado al extremo de arriba y
                        // en la celda de la sala no hay un villano
                        while (--f > 0 && sala[f][c] == '.') {
                            distancia++;
                        }
                        resultado.append((f >= 0 && sala[f][c] == 'X') ? distancia+1 : "NINGUNO");
                        break;
                    case "ABAJO":
                        // mientras no haya llegado al extremo de abajo y
                        // en la celda de la sala no hay un villano
                        while (++f < filas && sala[f][c] == '.') {
                            distancia++;
                        }
                        resultado.append((f < filas && sala[f][c] == 'X') ? distancia+1 : "NINGUNO");
                        break;
                } //switch
                resultado.append("\n");
            } // for

            resultado.append("---\n");
            salida.append(resultado);
            // leo las filas y columnas de la sala
            filas = entrada.nextByte();
            columnas = entrada.nextByte();
        } //while
        salida.flush();
    } //main
} //class
