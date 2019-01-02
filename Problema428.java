package terminados_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Problema 428 - Tendencia al lado oscuro
 *
 * https://www.aceptaelreto.com/problem/statement.php?id=428
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.17
 */
public class Problema428 {

    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter consola = new PrintWriter(System.out);
        //lee número de casos
        int numCasos = Integer.parseInt(teclado.readLine());
        int numeroEntrada;
        String base5;
        
        for (int i = 0; i < numCasos; i++) {
            numeroEntrada = Integer.parseInt(teclado.readLine());
            base5 = Integer.toString(numeroEntrada, 5);
            //consola.println((base5.indexOf('4') == base5.lastIndexOf('4'))?"NO":"SI");
            if (base5.indexOf('4') == base5.lastIndexOf('4')) 
                consola.println("NO");
            else
                consola.println("SI");
            //fin if
        } //for
        consola.flush();
    } //main
} // class
