

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * ProgramaMe Calentamiento Pre-Navideño Problema 
 * Problema474 - Tu amigable vecino
 *
 * https://www.aceptaelreto.com/problem/statement.php?id=474
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.24
 */
public class Problema474 {

    public static void main(String[] args) throws IOException {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter salida = new PrintWriter(System.out);
        short spiderman, bomba1, bomba2;
        short distanciaMinima = 0;
        short casos = Short.parseShort(entrada.readLine());
        short d1, d2;
        String [] datosEntrada;

        for (short i = 0; i < casos; i++) {
            datosEntrada = entrada.readLine().split("\\s");
            spiderman = Short.parseShort(datosEntrada[0]);
            bomba1 = Short.parseShort(datosEntrada[1]);
            bomba2 = Short.parseShort(datosEntrada[2]);
            
            d1 = (short) Math.abs(spiderman - bomba1);
            d2 = (short) Math.abs(spiderman - bomba2);
            distanciaMinima =(d1 < d2) ? d1 : d2;
            
            distanciaMinima += Math.abs(bomba2 - bomba1);

            salida.append(distanciaMinima + "\n");
        } //for
        salida.flush();
    } //main
} //class
