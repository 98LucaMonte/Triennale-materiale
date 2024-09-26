/* Lezione 5: stringhe e caratteri */

#include <stdio.h>
#include <stdlib.h>
#define SIZE 32

int main(void)
{
  char nome[SIZE]; // 0 .. 31

  puts("Inserisci il tuo nome:");

  // legge al massimo SIZE-1 caratteri da stdin (la tastiera) e li salva in nome
  fgets(nome, SIZE, stdin);

  puts("Stringa ricevuta:");
  puts(nome); // simile a printf("%s", nome);

  return 1;
}
