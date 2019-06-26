

/**
 * Ejercicio 364 - Espionaje en Navidad
 *
 * Versión 1 con Scanner y String
 *
 * https://www.aceptaelreto.com/problem/statement.php?id=364
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.16
 */


import java.util.Scanner;

public class Problema364_v1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String salida = "";
        String entrada = teclado.nextLine();
        while (!entrada.equals("FIN")) {
            char c;
            for (int i = 0; i < entrada.length(); i++) {
                c = entrada.charAt(i);
                if (c == ' ') {
                    salida += c;
                } else if (c == 'Z') {
                    salida += 'A';
                } else {
                    salida += (char) (c + 1);
                } //if
            } //for
            System.out.println(salida);
            entrada = teclado.nextLine();
            salida = "";
        } //while
    } //main
} //class
