/* Lezione 6: ricorsione */

#include <stdio.h>
#define MAX_SIZE 100

int stringa_len(char *s);

int main()
{
  char s1[MAX_SIZE];
  int r; // risultato

  printf("Inserisci una stringa: ");

  gets(s1);

  r = stringa_len(s1);

  printf("Lunghezza stringa: %d\n", r);

  return 1;
}

int stringa_len(char *s)
{
  // caso base
  // *s accede al contenuto puntato da s
  if (*s == '\0')
      return 0;

  // caso ricorsivo
  // s+1 sposta il puntatore all'elemento successivo della stringa
  return 1 + stringa_len(s+1);
}
