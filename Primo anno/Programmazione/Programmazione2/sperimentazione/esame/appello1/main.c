#include"appello.h"

int main(void)
{
 atexit(fine);	
 
 char nome_file[]="runner.txt";
 Corsa*testa;
 
 testa=crea_lista(nome_file);
 stampa_lista(testa);
 
 int giorno;
 
 do 
  {
  printf("\nInserire un giorno:");	  
  scanf("%d",&giorno);
  if(giorno<1 || giorno>31)
    printf("\nil giorno deve essere compreso tra 1 e 31\n");
  }
 while(giorno<1 || giorno>31);
 
 int distanza;
 
 distanza=ricerca_km(testa,giorno);
 printf("\nLa distanza percorsa il giorno %d e' %d",giorno,distanza);
 
 Corsa*testa2;
 
 testa2=crea_lista2(testa);
 stampa_lista(testa2);
 stampa_asterischi(testa);
 
 
 exit(EXIT_SUCCESS); 
}