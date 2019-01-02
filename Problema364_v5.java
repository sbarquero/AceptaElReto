package terminados_2018;

/**
 * Ejercicio 364 - Espionaje en Navidad
 *
 * Versión 5 con cambio System.out.println por PrintWriter
 *
 * https://www.aceptaelreto.com/problem/statement.php?id=364
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.16
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Problema364_v5 {

    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter consola = new PrintWriter(System.out);
        String entrada;
        char[] array; 
        char c;
        int i;
        int tamaño;
        entrada = teclado.readLine();
        while (!entrada.equals("FIN")) {
            array = entrada.toCharArray();
            tamaño = entrada.length();
            for (i = 0; i < tamaño; i++) {
                c = array[i];
                switch (c) {
                    case ' ':
                        // No hago nada
                        break;
                    case 'Z':
                        array[i] = ('A');
                        break;
                    default:
                        array[i] = (char)(c+1);
                        break; 
                } //switch
            } //for
            consola.println(array);
            entrada = teclado.readLine();
        } //while
        consola.flush();
    } //main
} //class
