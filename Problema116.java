
/**
 * Problema116 - ¡Hola mundo!
 *
 * https://www.aceptaelreto.com/problem/statement.php?id=116
 *
 * Mandaremos n veces el texto "Hola mundo.". Donde n es un número entero
 * entre 0 y 5 que recibiremos por la entrada estándar
 *
 * Autor: Santiago Barquero
 * Fecha: 01/11/2018
 */
import java.util.Scanner;

public class Problema116 {

  public static void main(String[] args) {
    int numero;
    Scanner in = new Scanner(System.in);

    numero = in.nextInt();

    for (int i = 0; i < numero; i++) {
      System.out.print("Hola mundo.\n");
    }
  }
}
