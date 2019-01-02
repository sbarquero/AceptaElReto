package terminados_2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Problema 480 - ¿Cuántas pido?
 * 
 * https://www.aceptaelreto.com/problem/statement.php?id=480
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.31
 */

public class Problema480 {

    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter salida = new PrintWriter(System.out);

        short casos = Short.parseShort(entrada.readLine());
        String[] valoresLeidos;
        short total; // total de uvas compradas
        short malas; // uvas malas en cada muestra
        short muestra; // Cantidad de uvas de cada muestra
        short resto; // resto de uvas sin grupo
        
        

        for (short i = 0; i < casos; i++) {
            // lectura de valores
            valoresLeidos = entrada.readLine().split(" ");
            total = Short.parseShort(valoresLeidos[0]);
            malas = Short.parseShort(valoresLeidos[1]);
            muestra = Short.parseShort(valoresLeidos[2]);
            
            // calculo el resto de uvas que no pertenecen a un grupo de muestra
            resto = (short) (total % muestra);
            
            // si las uvas sin grupo es mayor al las malas sumo las malas
            if (resto > malas)
                salida.append((total/muestra*malas + malas)+"\n");
            else
                // sino sumo lo que queda sin grupo de muestra
                salida.append((total/muestra*malas + resto)+"\n");
        }
        
        salida.flush();
    }

}
