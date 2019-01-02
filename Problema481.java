package terminados_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problema481 - Ajedrez asistido por computador
 * 
 * https://www.aceptaelreto.com/problem/statement.php?id=481
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.31
 */

public class Problema481 {

    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        // array de caracteres de equivalencia de las casillas del tablero
        char[] letra = {'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};
        String[] datos;
        byte fila;
        byte columna;
        // lectura fila y columna
        datos = entrada.readLine().split(" ");
        fila = Byte.parseByte(datos[0]);
        columna = Byte.parseByte(datos[1]);
        while (fila != 0 && columna != 0) {
            System.out.println("" + letra[fila - 1] + columna);
            // lectura nuevo dato
            datos = entrada.readLine().split(" ");
            fila = Byte.parseByte(datos[0]);
            columna = Byte.parseByte(datos[1]);
        }
    }
}
