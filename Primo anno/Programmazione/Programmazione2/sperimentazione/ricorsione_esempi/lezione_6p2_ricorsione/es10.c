/* Lezione 6: ricorsione */

#include <stdio.h>
#include <ctype.h> // per l'uso di isupper()

#define MAX_SIZE 100

void stringa_maiuscole(char *s);
void stringa_maiuscole(char s[], int p);

int main()
{
  char s1[MAX_SIZE];

  printf("Inserisci una stringa: ");

  gets(s1);

  printf("Stringa maiuscola: ");
  // stringa_maiuscole(s1); // alternativa con puntatore
  stringa_maiuscole(s1, 0);

  puts(s1);

  return 1;
}

// alternativa con puntatore
void stringa_maiuscole(char *s)
{
  // caso base
  // *s accede al contenuto puntato da s
  if (*s == '\0')
      return;

  // caso ricorsivo
  if (islower(*s)){
    *s = toupper(*s);
  }
  // s+1 sposta il puntatore all'elemento successivo della stringa
  return stringa_maiuscole(s+1);
}

// alternativa con array
void stringa_maiuscole(char s[], int p)
{
  // caso base
  if (s[p] == '\0')
      return;

  // caso ricorsivo
  if (islower(s[p])){
    s[p] = toupper(s[p]);
  }

  // p+1 sposta l'indice all'elemento successivo dell'array
  return stringa_maiuscole(s,p+1);
}
