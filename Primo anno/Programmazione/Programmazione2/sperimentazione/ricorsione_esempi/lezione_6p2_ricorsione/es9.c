/* Lezione 6: ricorsione */

#include <stdio.h>
#include <ctype.h> // per l'uso di isupper()

#define MAX_SIZE 100

void stringa_maiuscole(char *s, int *count);

int main()
{
  char s1[MAX_SIZE];
  int r; // risultato

  printf("Inserisci una stringa: ");

  gets(s1);

  r = 0;

  stringa_maiuscole(s1, &r);

  printf("Maiuscole nella stringa: %d \n", r);

  return 1;
}

void stringa_maiuscole(char *s, int *count)
{
  // caso base
  // *s accede al contenuto puntato da s
  if (*s == '\0')
      return;

  // caso ricorsivo
  if (isupper(*s)){
    *count = *count + 1;
  }

  return stringa_maiuscole(s+1, count);
}
