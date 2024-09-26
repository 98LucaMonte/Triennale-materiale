/* Lezione 5: stringhe e caratteri */

#include <stdio.h>
#include <stdlib.h>

int main(void)
{
  char nome[19]; // 0 .. 18
  int i;

  printf("Inserisci il tuo nome: ");
  scanf("%18s", nome);
  printf("Stringa inserita: %s\n", nome);

  // scorre la stringa
  i = 0;
  while(nome[i]!='\0')
  {
    printf("Carattere %d: %c \n", i, nome[i]);
    i++;
  }
  return 1;
}
