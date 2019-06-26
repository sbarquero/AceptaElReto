import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * PROG04_EJ3 - Ejercicio3
 *
 * Problema 467 de Acepta el Reto.
 * Dados una serie de casos de prueba debemos indicar si son o no TAUTOLOGIA.
 * https://www.aceptaelreto.com/problem/statement.php?id=467&cat=16
 * 
 * * NOTA: Empleo BufferedReader en vez de Scanner y PrintWriter en vez de 
 *   ^^^^  System.out para mejorar la posición con el juez virtual.
 * Hago esta versión con split ya que no recomiendan el uso se StringTokenizer.
 * https://docs.oracle.com/javase/8/docs/api/java/util/StringTokenizer.html
 * StringTokenizer is a legacy class that is retained for compatibility reasons 
 * although its use is discouraged in new code. It is recommended that anyone 
 * seeking this functionality use the split method of String or the 
 * java.util.regex package instead.
 * Utilizo try-catch para capturar posibles excepciones, aunque con el juez
 * virtual no sirve de mucho. En caso de producirse un error de excepción nos 
 * daría RTE (Runtime Error) sin el control de excepciones. Al incluir el 
 * control de excepciones y mostrar por la salida un mensaje, nos mostrará 
 * posiblemente WA (Wrong Answer).
 * 
 * @author Santiago Barquero López - 1º DAM <sbarquero@gmail.com>
 * @version 2018-12-26
 */

public class Problema467_split {

  public static void main(String[] args) {
    //declaración de variables
    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter salida = new PrintWriter(System.out);
    int casos;
    String[] palabra;
    
    try {
      casos = Integer.parseInt(entrada.readLine());
      
      for (int i = 0; i < casos; i++) {
        // crea array de String con cada palabra de la línea de entrada
        palabra = entrada.readLine().split(" ");
        //comparo la primera y la tercera palabra para la tautología
        salida.append(palabra[0].equalsIgnoreCase(palabra[2]) ?
                "TAUTOLOGIA\n" : "NO TAUTOLOGIA\n");
      } //for
      
    } catch(IOException ex) {
      System.out.println("Se ha producido un error IOExeption");
      System.out.println(ex.getMessage());
    } catch(NumberFormatException ex) {
      System.out.println("Se esperaba un número y se ha recibido otra cosa");
    } catch(Exception ex) {
      System.out.println("Se ha producido otra excepción");
      System.out.println(ex.getMessage());
    }
    salida.flush(); // vacio buffer a la consola
    salida.close();
  } //main
} //class
