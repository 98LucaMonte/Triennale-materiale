/* Lezione 5: stringhe e caratteri */

#include <stdio.h>
#include <stdlib.h>
#define SIZE 64

int main(void)
{
  char *nome = "Andrea";
  int eta = 20;
  float peso = 75.88;

  char frase[SIZE];

  // legge i dati (dal terzo parametro in poi) e li salva formattati in stringa
  sprintf(frase, "%s;%d;%.2f", nome, eta, peso);

  puts("Stringa creata:");
  puts(frase);

  return 1;
}
