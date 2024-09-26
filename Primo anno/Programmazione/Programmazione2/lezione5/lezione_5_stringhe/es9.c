/* Lezione 5: stringhe e caratteri */

#include <stdio.h>
#include <stdlib.h>
#include <string.h> // per usare strcpy, ecc...
#define SIZE 64

int main(void)
{
  // stringa a 
  char sa[] = "Felice"; // oppure char *sa = "Felice"
  char sb[] = "Anno"; 
  char *sc = "Nuovo";
  char sd[SIZE] = ""; // DEVE essere array per contenere la copia
  
  strcat(sd, sa);
  strcat(sd, " ");
  strcat(sd, sb);
  strcat(sd, " ");
  strcat(sd, sc);
  
  printf("Stringa concatenata: %s\n",sd);
  
  return 1;
}



