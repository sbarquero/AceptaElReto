

import java.util.Scanner;

/**
 * Problema485 - Senda pirenaica
 * 
 * https://www.aceptaelreto.com/problem/statement.php?id=485
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.31
 */

public class Problema485 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder salida = new StringBuilder();

        int etapas = sc.nextInt();
        int pendiente;
        int[] distancias;
        
        while (etapas != 0) {
            pendiente = 0;
            distancias = new int[etapas];
            for (int i = 0; i < etapas; i++) {
                distancias[i] = sc.nextInt();
                pendiente += distancias[i];
            }
            for (int i = 0; i < etapas-1; i++) {
                salida.append(pendiente).append(' ');
                pendiente -= distancias[i];
            }
            salida.append(pendiente).append('\n');
            etapas = sc.nextInt();
        }
        System.out.print(salida);
    }
}
