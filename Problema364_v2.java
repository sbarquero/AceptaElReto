package terminados_2018;

/**
 * Ejercicio 364 - Espionaje en Navidad
 *
 * Versión 2 con BufferedReader y StringBuffer
 *
 * https://www.aceptaelreto.com/problem/statement.php?id=364
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.16
*/
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problema364_v2 {

    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer salida = new StringBuffer();
        String entrada = teclado.readLine();
        while (!entrada.equals("FIN")) {
            char c;
            for (int i = 0; i < entrada.length(); i++) {
                c = entrada.charAt(i);
                if (c == ' ') {
                    salida.append(c);
                } else if (c == 'Z') {
                    salida.append('A');
                } else {
                    salida.append((char) (c + 1));
                } //if
            } //for
            System.out.println(salida);
            entrada = teclado.readLine();
            salida = new StringBuffer();
        } //while
    } //main
} //class
