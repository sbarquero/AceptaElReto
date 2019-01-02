#include <stdio.h>

/*
 * Problema 364 - Espionaje en Navidad
 * 
 * https://www.aceptaelreto.com/problem/statement.php?id=364
 *
 * Author Santiago Barquero <sbarquero@gmail.com>
 * Version 2018.12.16
 */
int main() {
    char entrada[101]; // array de caracteres de entrada
    int i = 0, c, longitud;

    while ((c = getchar()) != '\n') { // se leen caracteres hasta el nueva línea '\n'
        entrada[i++] = c; // almacena el carácter en el array de entrada
    }
    entrada[i] = '\0'; // añade carácter fin de cadena
    longitud = i;

    while ((longitud != 3) || ((entrada[0] != 'F') && (entrada[1] != 'I') && (entrada[2] != 'N'))) {
        for (i=0; i < longitud; i++) {
            c = entrada[i];
            if (c >= 'A' && c < 'Z') {
                c++;
                entrada[i] = c;
            } else if (c == 'Z') {
                c = 'A';
                entrada[i] = c;
            }
            putchar(c);
        }

        //printf("%s\n", entrada);
        putchar('\n');
        i = 0;
        
        while ((c = getchar()) != '\n') { // se leen caracteres hasta el nueva línea '\n'
            entrada[i++] = c; // almacena el carácter en el array de entrada
        }
        entrada[i] = '\0'; // añade carácter fin de cadena
        longitud = i;
    } //while
    return 0;
} //main
