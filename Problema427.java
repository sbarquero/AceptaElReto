package terminados_2018;

/**
 * Problema 427 - Yo soy tu ...
 * 
 * https://www.aceptaelreto.com/problem/statement.php?id=427
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.16
 */

import java.util.Scanner;

public class Problema427 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int numCasos = teclado.nextInt();
        teclado.nextLine(); // descarto resto de la línea
        String cadena1, cadena2;
        for (int i=0; i < numCasos; i++) {
            cadena1 = teclado.nextLine();
            cadena2 = teclado.nextLine();
            if (cadena1.equals("Luke") && cadena2.equals("padre")) {
                System.out.println("TOP SECRET");
            }
            else {
                System.out.println(cadena1 + ", yo soy tu " + cadena2);
            }
        } // for
    } //main
} //class
