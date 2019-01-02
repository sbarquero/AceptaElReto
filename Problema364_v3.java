package terminados_2018;

/**
 * Ejercicio 364 - Espionaje en Navidad
 *
 * Versión 3 con cambio if por switch
 *
 * https://www.aceptaelreto.com/problem/statement.php?id=364
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.16
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problema364_v3 {

    public static void main(String[] args) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer salida = new StringBuffer();
        String entrada = teclado.readLine();
        while (!entrada.equals("FIN")) {
            char c;
            for (int i = 0; i < entrada.length(); i++) {
                c = entrada.charAt(i);
                switch (c) {
                    case ' ':
                        salida.append(c);
                        break;
                    case 'Z':
                        salida.append('A');
                        break;
                    default:
                        salida.append((char) (c + 1));
                        break; 
                } //switch
            } //for
            System.out.println(salida);
            entrada = teclado.readLine();
            salida = new StringBuffer();
        } //while
    } //main
} //class
