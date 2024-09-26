/* Lezione 5: stringhe e caratteri */

#include <stdio.h>
#include <stdlib.h>
#include <string.h> // per usare strcpy, ecc...

int main(void)
{
  char sa[] = "Happy New Year"; 
  char *sb = "Buon anno"; 
  
  printf("sa: %s\n", sa);
  printf("sb: %s\n", sb);
  
  char x = 'n';
  
  // contiene il risultato della ricerca
  char *r = NULL; 
  
  r = strchr(sa, x);
  
  if (r!=NULL){
	printf("Il carattere '%c' e\' presente in sa all'indirizzo di memoria %p\n", x, r);
  }
  else{
	printf("Il carattere '%c' non e\' presente in sa\n", x);
  }
  
  r = strchr(sb, x);
  
  if (r!=NULL){
	printf("Il carattere '%c' e\' presente in sb all'indirizzo di memoria %p\n", x, r);
  }
  else{
	printf("Il carattere '%c' non e\' presente in sb\n", x);
  }
  
  return 1;
}




