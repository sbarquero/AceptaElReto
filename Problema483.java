

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problema483 - Preparando el reloj
 *
 * https://www.aceptaelreto.com/problem/statement.php?id=483
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.31
 */

public class Problema483 {

  public static void main(String[] args) throws IOException {
    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    Hora hora1 = new Hora();
    Hora hora2 = new Hora();
    String[] arrayEntrada; // array donde capturamos las entradas
    int totalCampanadas; // número total de campanadas
    int campanada; // número de campandas de la que se desea saber la hora
    float intervalo; //intervalo de tiempo entre campanadas
    int segundos; //segundos que pasan desde la primera campanada hasta la campanada pedida

    //lectura del número de casos
    int casos = Integer.parseInt(entrada.readLine());

    for (int i = 0; i < casos; i++) {
      // lectura de la primera línea del caso con las dos horas
      arrayEntrada = entrada.readLine().split(" ");
      hora1.setHora(arrayEntrada[0]);
      hora2.setHora(arrayEntrada[1]);
      // lectura de la segunda línea del caso 
      arrayEntrada = entrada.readLine().split(" ");
      totalCampanadas = Integer.parseInt(arrayEntrada[0]);
      campanada = Integer.parseInt(arrayEntrada[1]);

      //calculo el intervalo entre cada campanada
      intervalo = Hora.dif(hora1, hora2) / (totalCampanadas - 1);
      //calculo el tiempo en segundos hasta el número de campanada pedido
      segundos = Math.round(intervalo * (campanada - 1));
      //sumo los segundos a la hora 
      hora1.suma(segundos);

      System.out.println(hora1);
    } //for
  } //main
} //class

/**
 * Clase Hora que para el manejo de hora en el formato HH:MM:SS
 *
 * @author Santiago
 */
class Hora {

  private byte hora; // hora de 0 a 24
  private byte minutos; // minutos de 0 a 59
  private byte segundos; // segundos de 0 a 59
  private int horaEnSegundos; // hora del objeto en segundos

  /**
   * Establece la hora del objeto.
   * @param cadHora Cadena con la hora a inicializar con formato HH:MM:SS
   */
  public void setHora(String cadHora) {
    hora = Byte.parseByte(cadHora.substring(0, 2));
    minutos = Byte.parseByte(cadHora.substring(3, 5));
    segundos = Byte.parseByte(cadHora.substring(6, 8));
    horaEnSegundos = hora * 3600 + minutos * 60 + segundos;
  }

  @Override
  public String toString() {
    return String.format("%02d:%02d:%02d", hora, minutos, segundos);
  }

  /**
   * Compara la hora del objeto actual con la hora h recibida como parámetro.
   * @param h Hora a compara de la clase Hora.
   * @return Devuelve los segundos de diferencia entre la fecha del objeto 
   *         actual y la fecha h recibida como parámetro.
   */
  public int compare(Hora h) {
    return horaEnSegundos - h.horaEnSegundos;
  }

  /**
   * Devuelve la diferencia en segundos entre las horas h1 y h2.
   * @param h1 Primera hora de la clase Hora
   * @param h2 Segunda hora de la clase Hora
   * @return Devuelve los segundos de la hora h1 hasta la hora h2
   */
  static public int dif(Hora h1, Hora h2) {
    int difSegundos = h2.compare(h1);
    //compruebo si la hora h2 es anterior a la h1 tengo en cuentra el cambio de día
    if (difSegundos < 0) {
      difSegundos = 86400 + difSegundos;
    }
    return difSegundos;
  }

  /**
   * Suma s segundos a la hora
   * @param s Cantidad de segundos
   */
  public void suma(int s) {
    horaEnSegundos += s;
    if (horaEnSegundos >= 86400) {
      horaEnSegundos -= 86400;
    }
    hora = (byte) (horaEnSegundos / 3600);
    minutos = (byte) ((horaEnSegundos % 3600) / 60);
    segundos = (byte) (horaEnSegundos % 60);
  }

} //class Hora
