import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Problema 467 de Acepta el Reto. Dados una serie de casos de prueba debemos
 * indicar si son o no TAUTOLOGIA.
 * https://www.aceptaelreto.com/problem/statement.php?id=467&cat=16
 *
 * * NOTA: Empleo BufferedReader en vez de Scanner y PrintWriter en vez de 
 *   ^^^^  System.out para mejorar la posición con el juez virtual.
 * No hago el control de las excepciones porque el juez virtual se supone que 
 * nos proporciona datos correctos y si da error nos lo mostrará el juez con un
 * error RTE.
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018-12-26
 */
public class Problema467 {

  public static void main(String[] args) throws IOException {
    //declaración de variables
    BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter salida = new PrintWriter(System.out);
    int casos;
    String linea, p1, p2;

    //leemos de la entrada el número de casos
    casos = Integer.parseInt(entrada.readLine());

    for (int i = 0; i < casos; i++) {
      linea = entrada.readLine();
      //creo objeto StringTokenizer para separar las palabras
      StringTokenizer st = new StringTokenizer(linea, " ");
      p1 = st.nextToken(); //leo la primera palabra
      st.nextToken(); //desecho la palabra 'es'
      p2 = st.nextToken(); //leo la segunda palabra
      // comprobación de la tautología
      salida.append((p1.equalsIgnoreCase(p2)) ? "TAUTOLOGIA\n" : "NO TAUTOLOGIA\n");
    } //for

    salida.flush(); //vacio buffer a la consola
    salida.close();
  } //main
} //class
