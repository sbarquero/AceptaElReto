

/**
 * Ejercicio 364 - Espionaje en Navidad
 *
 * Versión 4 con cambio StringBuffer por array de caracteres
 *
 * https://www.aceptaelreto.com/problem/statement.php?id=364
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.16
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problema364_v4 {

    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String entrada;
        char[] array; 
        char c;
        int tamaño;
        entrada = teclado.readLine();
        while (!entrada.equals("FIN")) {
            array = entrada.toCharArray();
            tamaño = entrada.length();
            for (int i = 0; i < tamaño; i++) {
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
            System.out.println(array);
            entrada = teclado.readLine();
            //salida = new StringBuffer();
        } //while
    } //main
} //class
