

/**
 * ProgramaMe Calentamiento Pre-Navideño
 * Problema 478 - Conjuritis
 * 
 * https://www.aceptaelreto.com/problem/statement.php?id=478
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.23
 */
import java.io.PrintWriter;
import java.util.Scanner;

public class Problema478 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        StringBuilder resultado = new StringBuilder();
        PrintWriter salida = new PrintWriter(System.out);

        int numHechizos; // número de hechizo totales conjurados
        long danioVerdadero; // total del daño real causado sobre el villano
        long danioTotal; // suma de daños de todos los hechizos, verdaderos y falsos
        long danioFalsos; // suma de daños de los dos conjuros falsos
        boolean encontrado; // indicador de encontrado en la busqueda
        int[] hechizos; // array con todos los hechizos conjurados.

        // leo el primer parámetro número total de hechizos
        numHechizos = teclado.nextInt();

        while (numHechizos != 0) {  // Termino con 0 número de hechizos
            teclado.nextLine(); // leo en salto de línea
            hechizos = new int[numHechizos];
            danioTotal = 0;
            // leo de la entrada todos los daños causados por los hechizos
            for (int i = 0; i < numHechizos; i++) {
                hechizos[i] = teclado.nextInt();
                danioTotal += hechizos[i];
            }
            danioVerdadero = teclado.nextLong();
            danioFalsos = danioTotal - danioVerdadero;

            encontrado = false;
            int p1 = 0; // indice del primer valor en el array
            int p2; // indice del segundo valor en el array
            while ((p1 < numHechizos - 1) && (!encontrado)) {
                p2 = busquedaBinaria(hechizos, p1+1, numHechizos-1, (int) (danioFalsos - hechizos[p1]));
                if (p2 != -1) { // segundo valor encontrado
                    resultado.append(hechizos[p1]).append(" ").append(hechizos[p2]).append('\n');
                    encontrado = true;
                }
                else {
                    p1++;
                }
            }
            numHechizos = teclado.nextInt();
        }
        salida.append(resultado);
        salida.flush();
    }
    
    /**
     * Algoritmo de búsqueda binarias
     * @param array Array donde buscar el dato
     * @param izq Indice izquierdo del array
     * @param der Indice derecho del array
     * @param datoBuscado Datos que estamos buscando
     * @return Posición del elemento
     */
    static int busquedaBinaria(int[] array, int izq, int der, int datoBuscado) {
        //se encuentra la mitad del array
        int m = (izq + der) / 2;
        
        // se verifica si el número no está en el arreglo
        if ((izq == der && array[m] != datoBuscado) || 
                array[der] < datoBuscado || 
                array[izq] > datoBuscado) {
            return -1;
        }
        
        // caso base de la recursividad. Cuando se encuentra el datos buscado
        if (array[m] == datoBuscado) {
            return m;
        }
        else {
            if (datoBuscado < array[m]) {
                return busquedaBinaria(array, izq, m -1, datoBuscado);
            }
            else {
                return busquedaBinaria(array, m + 1, der, datoBuscado);
            }
        }
    }
}
