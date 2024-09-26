/* Lezione 5: stringhe e caratteri */

#include <stdio.h>
#include <stdlib.h>
#include <string.h> // per usare strcpy, ecc...

int main(void)
{
  char sa[] = "Happy New Year"; // stringa in formato array
  char *sb = "New"; 			// stringa in formato puntatore
  
  printf("sa: %s\n", sa);
  printf("sb: %s\n", sb);
  
  // contiene il risultato della ricerca
  char *r = NULL; 
  
  // cerca sb in sa
  r = strstr(sa, sb);
  
  if (r!=NULL){
	printf("La stringa '%s' e\' presente in sa all'indirizzo di memoria %p\n", sb, r);
	printf("Stringa puntata risultante: %s\n", r);
  }
  else{
	printf("La stringa '%s' non e\' presente in sa\n", sb);
  }
  
  // cerca "new" (stringa costante) in sa
  r = strstr(sa, "new");
  
  if (r!=NULL){
	printf("La stringa 'new' e\' presente in sa all'indirizzo di memoria %p\n", r);
	printf("Stringa puntata risultante: %s\n", r);
  }
  else{
	printf("La stringa 'new' non e\' presente in sa\n", sb);
  }
  
  return 1;
}






