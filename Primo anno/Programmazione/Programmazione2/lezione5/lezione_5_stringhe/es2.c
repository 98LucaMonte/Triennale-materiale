/* Lezione 5: stringhe e caratteri */

#include <stdio.h>
#include <stdlib.h>
#include <ctype.h> // funzioni sui caratteri

int main(void)
{
  // carattere inserito dall'utente
  char c;
  
  int c_low = 0, c_upp = 0, c_dig = 0, c_alp = 0, c_spa = 0, c_pun = 0;

  printf("Inserire una password: \n");

  // finché non è stato dato l'invio (return)
  while( (c=getchar()) != '\n' )
  {
    if (isdigit(c)) // cifre
      c_dig++;
    if (isalpha(c)) // lettere
      c_alp++;
    if (islower(c)) // minuscole
      c_low++;
    if (isupper(c)) // maiuscole
      c_upp++;
    if (isspace(c)) // spazi
      c_spa++;
    if (ispunct(c)) // simboli stampabili diversi dallo spazio
      c_pun++;
  }

  printf("\n");
  printf("Cifre: %d \n",c_dig);
  printf("Lettere: %d \n",c_alp);
  printf("Maiuscole: %d \n",c_upp);
  printf("Minuscole: %d \n",c_low);
  printf("Spazi: %d \n",c_spa);
  printf("Caratteri speciali: %d \n",c_pun);

  return 1;
}
