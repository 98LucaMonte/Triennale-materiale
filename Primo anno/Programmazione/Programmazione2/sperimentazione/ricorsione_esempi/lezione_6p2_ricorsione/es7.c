/* Lezione 6: ricorsione */

#include <stdio.h>
#define MAX_SIZE 100

void stringa_view(char *s);

int main()
{
  char s1[MAX_SIZE];

  printf("Inserisci una stringa: ");

  gets(s1);

  stringa_view(s1);

  return 1;
}

void stringa_view(char *s)
{
  // caso base
  // *s accede al contenuto puntato da s
  if (*s == '\0')
      return;

  // s contiene l'indirizzo di memoria puntato
  printf("Carattere puntato: %p -> valore: %c (%d) \n", s, *s, *s);

  // caso ricorsivo
  // s+1 sposta il puntatore all'elemento successivo della stringa
  return stringa_view(s+1);
}
