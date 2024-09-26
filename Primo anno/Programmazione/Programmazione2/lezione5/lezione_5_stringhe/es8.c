/* Lezione 5: stringhe e caratteri */

#include <stdio.h>
#include <stdlib.h>
#include <string.h> // per usare strcpy, ecc...
#define SIZE 64

int main(void)
{
  // stringa a 
  char sa[] = "Ciao"; // oppure char *sa = "Buon"
  char sb[SIZE]; // DEVE essere array per contenere la copia
  char *sc;
  
  printf("sa = %s\n", sa);
  
  // copia sa in sb
  strcpy(sb, sa);
  printf("sb = %s\n", sb);  
  
  // oppure 
  // sc punterà al primo carattere di sb
  sc = strcpy(sb, "UPO");
  printf("sc = %s\n", sc);
  
  return 1;
}


