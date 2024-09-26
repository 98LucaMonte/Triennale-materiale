#include"liste.h"

int main(int argc,char*argv[])
{
 atexit(fine);
 if(argc!=2)
   {
	printf("\nErrore di sintassi in linea di comando:nome eseguibile numero nodi\n");   
    exit(EXIT_FAILURE);
   }	 
 
 int nodi=atoi(argv[1]);
 Lista*testa;
 int somma,minimo,massimo,posizione=0;
 srand(time(NULL));
 
 if(argc==2)
  {
  if(nodi>=1 && nodi<=20)	  
    {
    testa=crea_lista(nodi);
	stampa_lista(testa,posizione);
	somma=lista_somma(testa);
	printf("\nIl somma e'%d",somma);
	minimo=lista_minimo(testa);
	printf("\nIl minimo e'%d",minimo);
	massimo=lista_massimo(testa);
	printf("\nIl massimo e'%d",massimo);
	}  
    else
	   {
		printf("\nErrore di sintassi in linea di comando:nome eseguibile numero nodi che deve essere compreso tra 1 e 20 estremi inclusi\n");   
        exit(EXIT_FAILURE);   
	   }
  }	
 exit(EXIT_SUCCESS);
}