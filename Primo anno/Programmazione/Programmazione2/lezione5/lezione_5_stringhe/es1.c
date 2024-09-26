/* Lezione 5: stringhe e caratteri */

#include <stdio.h>
#include <stdlib.h>

int main(void)
{
  char a, temp;
  printf("Inserire un carattere: ");
  a = getchar();
  temp = getchar(); // consuma l'invio
  printf("Carattere letto (char): %c\n",a);
  printf("Carattere letto (int): %d\n",a);
  printf("Carattere letto (char): %c",temp);
  printf("Carattere letto (int): %d\n",temp);
  printf("Carattere letto (char): ");
  // putchar visualizza a video il carattere in a
  // e salva il suo valore ASCII in x
  int x = putchar(a);
  printf("\n");
  printf("Carattere letto (int): %d\n",x);
}
