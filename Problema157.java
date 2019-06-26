
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Problema 157 de Acepta el Reto - ¿Cuantos días faltan? Dado un día del año, ¿sabrías decir cuantos días
 * faltan para Nochevieja? Asumiremos que nos encontramos en un año no bisiesto.
 * https://www.aceptaelreto.com/problem/statement.php?id=157
 *
 * * NOTA: Empleo BufferedReader en vez de Scanner y PrintWriter en vez de ^^^^ System.out para mejorar la
 * posición con el juez virtual.
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018-12-25
 */
public class Problema157 {

    public static void main(String[] args) throws IOException {
        // Declaración de variables e inicialización
        // entrada de la consola
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        // para la salida por consola
        PrintWriter salida = new PrintWriter(System.out);

        // Vector que contiene los días que falta hasta Nochevieja por cada mes
        // La primera posición contiene los días que falta desde enero, la segunda
        // desde febrero y así sucesivamente.
        short[] diasMes = {365, 334, 306, 275, 245, 214, 184, 153, 122, 92, 61, 31};

        // Leo de la entrada el número de casos
        byte dia; // dia entrada
        byte mes; // mes entrada
        String[] fecha;

        // leo el número de casos
        int casos = Integer.parseInt(entrada.readLine());

        // por cada caso
        for (int i = 0; i < casos; i++) {
            // leo línea completa y separo en array de Strings
            fecha = entrada.readLine().split(" ");
            dia = Byte.parseByte(fecha[0]); //posición 0 contiene día
            mes = Byte.parseByte(fecha[1]); //posición 1 contiene el mes
            // le resto a los días que tengo en el array el día del mes actual
            // así obtengo los días que faltan hasta Nochevieja
            salida.append(Integer.toString(diasMes[mes - 1] - dia)).append("\n");
        } //for
        salida.flush(); // descargo buffer de salida a la consola
        salida.close();
    } //main
} //class
