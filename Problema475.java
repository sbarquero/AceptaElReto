

/**
 * Problema 475 - Cameos de Stan Lee
 *
 * https://www.aceptaelreto.com/problem/statement.php?id=477
 * 
 * Utilizo una expresión regular (UT04)
 * https://docs.oracle.com/javase/tutorial/essential/regex/index.html
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.22
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problema475 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter salida = new PrintWriter(System.out);
        
        // Defino patrón de la expresión regular. Las siguientes son equivalentes
        //Pattern p = Pattern.compile("[Ss][^Ss]*?[Tt][^Tt]*?[Aa][^Aa]*?[Nn][^Nn]*?[Ll][^Ll]*?[Ee][^Ee]*?[Ee]");
        //Pattern p = Pattern.compile("[S][^S]*?[T][^T]*?[A][^A]*?[N][^N]*?[L][^L]*?[E][^E]*?[E]", Pattern.CASE_INSENSITIVE);
        Pattern p = Pattern.compile("(?i)[S][^S]*?[T][^T]*?[A][^A]*?[N][^N]*?[L][^L]*?[E][^E]*?[E]");
        // (i?) -> ignora la diferencia entre mayúsculas y minúsculas
        //         Equivale a Pattern.CASE_INSENSITIVE
        // [Ss] -> busca la letra "S" o "s"
        // [^Ss]*? -> busca cualquier cadena vacia o que no tenga ni "s", ni "S"
        //            El ? en la expresión anterior es un cuantificador reacio o reticente
        //            hace que la cadena buscada se la mínima hasta llegar a la
        //            siguiente parte del patrón que es [Tt]
        // Ver ejemplo: Differences Among Greedy, Reluctant, and Possessive Quantifiers
        // en la página https://docs.oracle.com/javase/tutorial/essential/regex/quant.html
        
        Matcher m;
               
        short contador;
        // leemos el número de casos a procesar
        short n = Short.parseShort(bfr.readLine());

        for (short i = 0; i < n; i++) {
            m = p.matcher(bfr.readLine());
            contador = 0;
            // mientras encuentre coincidencia del patrón incrementa contador
            while (m.find()) {
                //System.out.println(" " + contador + " #" + m.group(1) + "#" + m.group(2));
                contador++;
            }
            //System.out.println(contador + " <-- " + cad);
            salida.println(contador);
        } //for
        salida.flush();
    } //main
} //class
