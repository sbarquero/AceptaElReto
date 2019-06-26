
/**
 * PROG03_Ejercicio01
 *
 * Programa que resuelve el Problema 112 de AceptaElReto
 * https://www.aceptaelreto.com/problem/statement.php?id=112
 *
 * El programa recibe un número indeterminado de líneas, donde cada línea tiene
 * tres valores enteros que representan la distancia recorrida (m), la velocidad
 * límite del tramo (Km/h)y el tiempo real que ha tardado el vehículo en
 * recorrer el tramo (seg).
 * La entrada terminará cuando todos los números sean cero.
 * Para cada caso de prueba, el programa generará una línea, indicando si el
 * coche debe ser multado o no. En concreto, indicará "OK" si el coche no superó
 * la velocidad máxima, indicará "MULTA" si se superó esa velocidad en menos de
 * un 20% de la velocidad máxima permitida, y "PUNTOS" si la velocidad fue
 * superada en un 20% o más de esa velocidad; en ese caso además de la multa se
 * le quitarán puntos del carnet. El sistema de radar puede fallar y registrar
 * entradas incorrectas (por ejemplo, indicando que el tiempo que ha tardado el
 * coche es negativo). En esos casos, el sistema mostrará la cadena "ERROR".
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.11.01
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problema112 {

    public static void main(String[] args) throws IOException {

        String entrada; // String que contiene la línea de entrada
        String[] subcadena; // Array que contendrá las subcadenas de la entrada
        float distancia; // Distancia recorrido en metros
        float velocidadLimite; // Velocidad en Km/h
        float tiempo; // Tiempo en segundos que ha tardado el vehículo realmente
        float velocidadCalculada;

        // Podría haber utilizado Scanner para la entrada de datos pero 
        // utilizo BufferedReader por haber visto que es más rápido y
        // me ha permitido subir puestos en el ranking de la web de AceptaElReto
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // Utilizo un bucle infinito y pongo condición de salida con break
        // cuando la distancia, velocidad y tiempo son cero
        while (true) {
            entrada = in.readLine(); // Leo línea de entrada completa
            // Separamos la cadena de entrada en todas las subcadenas que hay 
            // entre espacios en blanco y se guardan en el array de Strings
            subcadena = entrada.split(" ");
            // El primer elemento del array contiene la distancia
            distancia = Integer.parseInt(subcadena[0]);
            // El segundo la velocidad en Km/h
            velocidadLimite = Integer.parseInt(subcadena[1]);
            // El tercero el tiempo empleado en segundos
            tiempo = Integer.parseInt(subcadena[2]);

            // Condición de salida del bucle. Si todos son cero
            if (distancia == 0 && velocidadLimite == 0 && tiempo == 0) {
                break; // Salgo del bucle while y terminamos
            }
            // Si se cumple lanzo ERROR y empiezo desde el principio
            // leyendo una nueva línea
            if (distancia <= 0 || velocidadLimite <= 0 || tiempo <= 0) {
                System.out.println("ERROR");
                continue; // Salto al principio de bucle while
            }

            // Paso velocidad metros/segundo a Kilometros/hora
            velocidadCalculada = (distancia / tiempo) * 3.6F;

            // Si velocidad calculada es menor y igual a la velocidad límite
            if (velocidadCalculada <= velocidadLimite) {
                System.out.println("OK");
            } else if (velocidadCalculada >= velocidadLimite * 1.20) {
                // La velocidad es igual o mayor a la velocidad límite mas un 20%
                System.out.println("PUNTOS");
            } else {
                // Velocidad esta entre la velocidad límite y la velocidad 
                // límite más un 20%
                System.out.println("MULTA");
            } // if

        } // while

    } // main

} // clase
