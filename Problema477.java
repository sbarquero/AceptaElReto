package terminados_2018;

/**
 * Problema 477 - La captura del doctor muerte
 *
 * https://www.aceptaelreto.com/problem/statement.php?id=477
 *
 * Utilizo un ArrayList para guardar todas las armas y luego la ordeno de menor
 * a mayor daño a los inocentes. Así solo tengo que coger las armas desde la
 * primera, mientras existan armas y la suma de daños de las armas empleadas 
 * sea inferior a la vitalidad del Doctor Muerte.
 * 
 * Enlace sobre ordenación: 
 * https://www.geeksforgeeks.org/collections-sort-java-examples/
 * 
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.23
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Problema477 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        short vitalidad; //vitalidad del Doctor Muerte
        short numArmas; //número de armas
        // ArrayList que guarda todas las armas
        ArrayList<ClaseArma> arrayArmas;
        
        //leo vitalidad del Doctor Muerte
        vitalidad = sc.nextShort();
        
        //termino cuando vitalidad sea 0
        while (vitalidad != 0) {
            numArmas = sc.nextShort(); 
            arrayArmas = new ArrayList(); //creo array vacio
            // bucle para leer los valores de entrada de todas las armas
            // y guardalas en el ArrayList
            for (short i = 1; i <= numArmas; i++) {
                // Creo objeto arma de la clase Arma
                ClaseArma arma = new ClaseArma(i);
                // leo valores de entrada de las armas
                arma.setDanioInocentes(sc.nextShort());
                arma.setDanioVillanos(sc.nextShort());
                //añado el objeto arma al array
                arrayArmas.add(arma);
            } //for
            
            // ordeno colección
            Collections.sort(arrayArmas, new OrdenaPorDanio());
            
            //vitalidad restante del Doctor Muerte
            short vitalidadRestante = vitalidad; 
            short i = 0; //puntero que va recorriendo array de principio a fin
            // cadena de salida con las armas empleadas
            StringBuilder cad = new StringBuilder();
            // Leo una a una de la lista cada uno de los daños de las armas y 
            // voy restando los daños a la vitalidadRestante del Dr. Muerte 
            // mientras que sea mayor que ceros y no nos quedemos sin armas
            while (vitalidadRestante > 0 && i < numArmas) {
                vitalidadRestante -= arrayArmas.get(i).getDanioVillanos();
                cad.append(arrayArmas.get(i).getPosicionEntrada());
                cad.append(" ");
                i++;
            }
            cad.deleteCharAt(cad.length()-1); //borro el último espacio añadido
            
            if (vitalidadRestante <= 0) { //si no le queda vitalidad
                // imprimo la secuencia de armas
                System.out.println(cad);
            }
            else { //si le queda vitalidad
                System.out.println("MUERTE ESCAPA");
            }
            //
            //leemos nuevamente la Vitalidad del Doctor Muerte. Si 0 terminamos
            vitalidad = sc.nextShort();
        } //while
    } //main
} //class

/**
 * La ClaseArma se encarga de almacenar los datos del arma, como la posición
 * de entrada, los daños a inocentes y el daño a los villanos.
 * 
 * @author santiago
 */
class ClaseArma {

    private short posicionEntrada; //posición en la entrada de los datos
    private short danioInocentes;  //daño a los inocentes
    private short danioVillanos;   //daño a los villanos

    /**
     * Devuelve posición de entrada
     * @return Posición entrada
     */
    public short getPosicionEntrada() {
        return posicionEntrada;
    }

    /**
     * Constructor de la clase. Recibe como parámetro de entrada la posicón en 
     * la lista
     * @param i posición de entrada en la lista 
     */
    ClaseArma(short i) {
        this.posicionEntrada = i;
    }

    /**
     * @return Devuelve el daño que el arma causa a los inocentes
     */
    public short getDanioInocentes() {
        return danioInocentes;
    }

    /**
     * Establece el valor del daño del arma en los inocentes.
     * @param danioInocentes Valor del daño a los inocentes.
     */
    public void setDanioInocentes(short danioInocentes) {
        this.danioInocentes = danioInocentes;
    }

    /**
     * @return Devuelve el daño que el arma causa a los villanos
     */
    public short getDanioVillanos() {
        return danioVillanos;
    }

    /**
     * Establece el valor del daño del arma en los villanos
     * @param danioVillanos Valor del daño a los villanos
     */
    public void setDanioVillanos(short danioVillanos) {
        this.danioVillanos = danioVillanos;
    }

    /**
     * Retorna cadeña con los valores del arma en formato para poder visualizado
     * @return Cadena con los valores del arma (Posición de entrada, daño a 
     *         inocentes y daño a villanos
     */
    @Override
    public String toString() {
        return "ClaseArma{" + "posicionEntrada=" + posicionEntrada + ", danioInocentes=" + danioInocentes + ", danioVillanos=" + danioVillanos + '}';
    }
} //claseArma

/**
 * Clase que implementa el método compare() para ordenar el objeto ClaseArma.
 * Ordena la armas de menor a mayor daños a los inocentes. En caso de dos armas 
 * que ocasionen el mismo daño a los inocentes se ordenará poniendo primero el
 * arma que cause más daño a los villanos.
 */

class OrdenaPorDanio implements Comparator<ClaseArma> {
    @Override
    public int compare (ClaseArma arma_1, ClaseArma arma_2) {
        short danioInocentes_1 = arma_1.getDanioInocentes();
        short danioInocentes_2 = arma_2.getDanioInocentes();
        //si dos armas causan daños distintos a los inocentes se ordena de 
        //menor a mayor daños
        if (danioInocentes_1 != danioInocentes_2) {
            return arma_1.getDanioInocentes() - arma_2.getDanioInocentes();
        }
        //en caso que el daño a inocentes se igual, ordeno las armas de mayor a
        //menor daño a los villanos
        else {
            return arma_2.getDanioVillanos() - arma_1.getDanioVillanos();
        } //if
    } //compare()
} // clase OrdenaPorDanio