package terminados_2018;

/**
 * Problema 476 - Lucha de egos
 *
 * https://www.aceptaelreto.com/problem/statement.php?id=476
 *
 * @author Santiago Barquero <sbarquero@gmail.com>
 * @version 2018.12.24
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Problema476 {

  public static void main(String[] args) throws IOException{
    BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter salida = new PrintWriter(System.out);
    byte numSuperheroes;  // número de superheroes
    Superheroe[] sh; // array de objetos de clase Superheroe
    boolean parejaEncontrada; // verdadero si encuentro al menos una pareja
    String[] s;

    // leo el número de superheroes
    numSuperheroes = Byte.parseByte(bfr.readLine());
    // mientras que no sea cero
    while (numSuperheroes != 0) {
      sh = new Superheroe[numSuperheroes]; // inicializo el array
      // leo la línea de las destrezas de la entraada
      s = bfr.readLine().split(" ");
      for (int i = 0; i < numSuperheroes; i++) {
        sh[i] = new Superheroe(); // creo objeto de la clase Superheroe
        sh[i].setDestreza(Byte.parseByte(s[i])); // guardo destreza del superheroe
      }
      // leo las preferencias de los superheroes de la línea de entrada
      s = bfr.readLine().split(" ");
      for (int i = 0; i < numSuperheroes; i++) {
        sh[i].setPreferencia(s[i]);
      }
      // Hacemos intentos de emparejamiento
      // Utilizo dos punteros i y j para recorrer el array y comprobar si son
      // emparejables el superheroe con indice i y el de indice j
      parejaEncontrada = false; // inicializo a false al principio
      for (int i = 0; i < numSuperheroes - 1; i++) {
        if (!sh[i].isEmparejado()) { // compruebo que no esté emparejado
          for (int j = i + 1; j < numSuperheroes; j++) {
            if (!sh[j].isEmparejado() && !sh[i].isEmparejado()) {
              // compruebo que es emparejable superheroe i con el j
              if (esEmparejable(sh[i], sh[j]) && esEmparejable(sh[j], sh[i])) {
                // marco los dos superheroes como emparejados
                sh[i].setEmparejado(true);
                sh[j].setEmparejado(true);
                // muestro los indices (+1) de los dos superheroes emparejados
                salida.append((i+1) + " " + (j+1) + "\n");
                parejaEncontrada = true; // marco flag como que he encontrado pareja
              } //if
            } //if
          } //for
        } //if
      } //for
      // si no encuentro pareja muestro el texto "NO HAY"
      if (!parejaEncontrada) {
        salida.append("NO HAY\n");
      }
      salida.append("---\n"); // separador de casos de prueba 
      // leo el número de superheroes
      numSuperheroes = Byte.parseByte(bfr.readLine());
    } //while
    salida.flush();
  } //main

  private static boolean esEmparejable(Superheroe sh1, Superheroe sh2) {
    char op = sh1.getOpPreferencia();
    switch (op) {
      case '=':
        return sh1.getNivelPreferencia() == sh2.getDestreza();
      case '<':
        return sh1.getNivelPreferencia() > sh2.getDestreza();
      case '>':
        return sh1.getNivelPreferencia() < sh2.getDestreza();
      default:
        return false;
    }
  }

}

/**
 * Clase Superheroe que almacena los datos de un superheroe como su destreza, 
 * su preferencia y si está emparejado.
 * @author santiago
 */
class Superheroe {

  private byte destreza; // nivel de destreza del superheroe
  private char opPreferencia; // operador de la preferencia (<, >, =)
  private byte nivelPreferencia; // nivel de preferencia 
  private boolean emparejado = false; // flag de si está emparejado

  public void setDestreza(byte destreza) {
    this.destreza = destreza;
  }

  public void setPreferencia(String s) {
    this.opPreferencia = s.charAt(0);
    this.nivelPreferencia = Byte.parseByte(s.substring(1));
  }

  public byte getDestreza() {
    return destreza;
  }

  public char getOpPreferencia() {
    return opPreferencia;
  }

  public byte getNivelPreferencia() {
    return nivelPreferencia;
  }

  public boolean isEmparejado() {
    return emparejado;
  }

  public void setEmparejado(boolean emparejado) {
    this.emparejado = emparejado;
  }

  @Override
  public String toString() {
    return "[" + destreza + ", " + opPreferencia + nivelPreferencia + 
           ", emparejado=" + emparejado + ']';
  }
  
}
