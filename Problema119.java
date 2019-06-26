
/**
 * Problema 119 de la AceptaElReto.com
 *
 * https://www.aceptaelreto.com/problem/statement.php?id=119
 *
 * Recibimos un número de legionarios romanos de entrada en una línea y
 * mostraremos el número de escudos que necesitan en una línea.
 *
 * Autor: Santiago Barquero
 * Fecha: 01/11/2018
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problema119 {

  public static void main(String[] args) throws IOException {

    int numeroEntrada;
    int restoDeSoldados;
    int ladoFormacion;
    int escudosSuperiores;
    int escudosLaterales;
    int totalEscudos;

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in), 4096);

    // numeroEntrada = in.nextInt();
    numeroEntrada = Integer.parseInt(in.readLine());

    while (numeroEntrada != 0) { // termino cuando el número de entrada sea cero
      totalEscudos = 0;
      restoDeSoldados = numeroEntrada;
      while (restoDeSoldados > 0) {
        // Calculamos el número lateral de soldados de la formación cuadrada
        // más grande posible con los soldados disponibles
        // Al ser cuadrada todos los lados tienen el mismo número de soldados.
        // Para ello calculo el entero resultante de la raíz cuadrada
        ladoFormacion = (int) Math.sqrt(restoDeSoldados);
        // Calculamos el número de escudos superiores necesarios 
        escudosSuperiores = (int) Math.pow(ladoFormacion, 2);
        // Calculamos el número de escudos laterales necesarios
        escudosLaterales = ladoFormacion * 4;
        // Acumulamos al total los escudosLaterales y escudosSuperiores
        totalEscudos = totalEscudos + escudosSuperiores + escudosLaterales;
        // Calculo el resto de soldados sin agrupar en formaciones
        // Resto el número de Escudos superiores ya que es el número de 
        // soldados de la formación obtenida
        restoDeSoldados = restoDeSoldados - escudosSuperiores;

      } // fin while
      System.out.println(totalEscudos);
      numeroEntrada = Integer.parseInt(in.readLine());
    } // while
  } // main
} // class
