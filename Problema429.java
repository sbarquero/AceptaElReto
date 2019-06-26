

/**
 * Problema 429 - Organizando los hangares
 *
 * https://www.aceptaelreto.com/problem/statement.php?id=429
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.17
 */

import java.util.Scanner;

public class Problema429 {

    // numero de hangares que introducen por teclado
    private static byte numHangares;
    // array con los tamaños que le queda disponible a cada hangar
    private static int[] tamanoHangar = new int[10];

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        short numNaves; // Número de naves que llegan
        int tamanoNave; // variable temporal que guarda el tamaño de la nave

        numHangares = teclado.nextByte(); //lee el primer número de hangares

        while (numHangares != 0) { //si cero termina
            //lee los tamaños de los hangares desde el teclado
            for (int i = 0; i < numHangares; i++) {
                tamanoHangar[i] = (teclado.nextInt());
            }
            //lee los tamaños de las naves desde el teclado
            numNaves = teclado.nextShort();
            boolean lleno = false;
            // Bucle que lee todas las naves de entrada y va comprobando si 
            // caben en el hangar de mayor tamaño. Utilizo una bandera "lleno"
            // que al principio vale "false" y valdrá true si llega una nave que
            // no cabe en el mayor hangar disponible. En ese caso hago un break
            // del bucle.
            for (int i = 0; i < numNaves; i++) {
                tamanoNave = teclado.nextInt();
                if (!lleno) {
                    byte mayorHangar = buscaMayorHangar();
                    if (tamanoNave <= tamanoHangar[mayorHangar]) 
                    {
                        // Si la nave cabe en el hangar resto el tamaño de la nave
                        // al hangar
                        tamanoHangar[mayorHangar] -= tamanoNave;
                    } else {
                        lleno = true; // La nave no ha entrado en el hangar mayor
                    }
                } //if
            }
            // Al terminar el bucle compruebo el valor de la bandera "lleno"
            System.out.println(lleno ? "NO" : "SI");
            numHangares = teclado.nextByte(); // lee el siguiente número de 
            // hangares, si igual a cero termina
        }
    }

    /**
     * Función que busca en el array de angares el hangar con mayor tamaño
     * disponible y devuelve el índice del array
     *
     * @return Devuelve el índice del array de hangares con el hangar con mayor
     * disponible.
     */
    private static byte buscaMayorHangar() {
        byte iMayor = 0; // supongo que el hangar más grande es el primero
        // Recorro el array de hangares en busca del de mayor tamaño

        for (byte i = 1; i < numHangares; i++) {
            // comparo el angar que tengo como de mayor tamaño con el siguiente

            if (tamanoHangar[iMayor] < tamanoHangar[i]) {
                iMayor = i; // Me quedo con el nuevo índice que es el de un 
            }                            // hangar de mayor tamaño.

        }
        return iMayor;
    }
}
