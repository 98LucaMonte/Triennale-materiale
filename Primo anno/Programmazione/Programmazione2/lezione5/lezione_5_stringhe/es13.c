/* Lezione 5: stringhe e caratteri */

#include <stdio.h>
#include <stdlib.h>
#include <string.h> // per usare strcpy, ecc...

int main(void)
{
  // stringa in formato array
  // non può essere puntatore perché viene modificata
  char sa[] = "Happy New Year"; 
  // il delimitatore può essere un array, un puntatore o una costante
  char *delimitatore = " "; 			
  
  printf("Stringa sa: %s\n", sa);
 
  char *tokenPtr1 = strtok(sa, delimitatore);
  
  while (tokenPtr1!=NULL)
  {
	  printf("Stringa: %s\n", tokenPtr1);
	  // la chiamata con puntatore a NULL indica 
	  // di continuare dall'ultima posizione disponibile del puntatore
	  tokenPtr1 = strtok(NULL,delimitatore);
  }
  
  // sa è stata modificata
  printf("sa dopo la tokenizer: %s \n", sa);
  
  char sb[] = "Andrea;20;70.88";
  
  printf("Stringa sb: %s\n", sb);
  
  char *tokenPtr2 = strtok(sb, ";");
  
  while (tokenPtr2!=NULL)
  {
	  printf("Stringa: %s\n", tokenPtr2);
	  tokenPtr2 = strtok(NULL,";");
  }
  
  // sb è stata modificata
  printf("sb dopo la tokenizer: %s \n", sb);
  
  return 1;
}






