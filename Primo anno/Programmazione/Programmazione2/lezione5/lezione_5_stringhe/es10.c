/* Lezione 5: stringhe e caratteri */

#include <stdio.h>
#include <stdlib.h>
#include <string.h> // per usare strcpy, ecc...
#define SIZE 64

int main(void)
{
  char sa[] = "Happy New Year"; 
  char *sb = "Happy New Year"; 
  int r;
  
  printf("sa: %s\n", sa);
  printf("sb: %s\n", sb);
  
  r = strcmp(sa,sb);
  
  if (r==0){
	printf("sa e sb sono uguali (%d)\n", r);
  }
  else{
	printf("sa e sb non sono uguali (%d)\n", r);
  }
  
  r = strcmp(sa,"Happy New year");
  
  if (r==0){
	printf("sa e \"Happy New year\" sono uguali (%d)\n", r);
  }
  else{
	printf("sa e \"Happy New year\" non sono uguali (%d)\n", r);
  }
  
  return 1;
}



