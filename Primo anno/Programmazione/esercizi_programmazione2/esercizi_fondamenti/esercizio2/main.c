#include"liste.h"

int main(int argc,char*argv[])
{
 atexit(fine);
 
 if(argc!=2)
   {
	printf("\nErrore sintassi in linea di comando\n");   
    exit(EXIT_FAILURE);
   }	 
  
  Lista*testa;
  int n,vocali;
  
  n=strlen(argv[1]);
  testa=crea_lista(n,argv[1]);  
  stampa_lista(testa);	  
  printf("NULL\n"); 
  
  vocali=lista_vocali(testa);  
  printf("\nVocali presenti=%d\n",vocali);
  
  Lista*testa1;
  testa1=lista_consonanti(testa);
  stampa_lista(testa1);	  
  printf("NULL\n");
  
  Lista*testa2;
  testa2=cifrata(testa);
  stampa_lista(testa2);	  
  printf("NULL\n");
  
  exit(EXIT_SUCCESS);	
}