

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Problema482 - Los calcetines de Ian Malcolm
 * 
 * https://www.aceptaelreto.com/problem/statement.php?id=482
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.31
 */

public class Problema482 {
    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter salida = new PrintWriter(System.out);
        char calcetin; // calcetin tratado
        int negro; // calcetines negros
        int gris; // calcetines grises
        
        String linea = entrada.readLine();
        
        // mientras no me encuentre una línea con un punto de final
        while (!linea.equals(".")) {
            negro = 0;
            gris = 0;
            for (int i = 0; i < linea.length()-2; i+=2) {
                calcetin = linea.charAt(i);
                if (calcetin == 'N') negro++;
                else gris++;
            }
            if ((negro % 2 == 0) && (gris % 2 == 0)) 
                salida.append("EMPAREJADOS\n");
            else if ((negro%2 != 0) && (gris%2 == 0)) 
                salida.append("NEGRO SOLITARIO\n");
            else if ((negro%2 == 0) && (gris%2 != 0)) 
                salida.append("GRIS SOLITARIO\n");
            else 
                salida.append("PAREJA MIXTA\n");
            // leo otra línea de entrada
            linea = entrada.readLine();
        }
        salida.flush();
    }
    
}
