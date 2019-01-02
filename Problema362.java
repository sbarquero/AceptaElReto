package terminados_2018;

import java.util.Scanner;

/**
 * Problema 362 - El día de Navidad
 *
 * https://www.aceptaelreto.com/problem/statement.php?id=362
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.07
 */
public class Problema362 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    short numEntradas = 0;
    byte dia = 0;
    byte mes = 0;

    numEntradas = sc.nextShort();

    for (int i = 0; i < numEntradas; i++) {
      dia = sc.nextByte();
      mes = sc.nextByte();
      if (dia == 25 && mes == 12) {
        System.out.println("SI");
      } else {
        System.out.println("NO");
      }
    } // for
  } // main
} // class
