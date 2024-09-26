#include"liste.h"

int main(int argc,char*argv[])
{
 atexit(fine);	
 
 if(argc!=2)
   {
	printf("\nERRORE IN LINEA DI COMANDO\n");   
    exit(EXIT_FAILURE);
   }
 
 int nodi;
 nodi=atoi(argv[1]);
 srand(time(NULL));
 Lista testa; 
 testa=crea_lista(nodi);
 stampa_lista(testa);
 printf("NULL\n");
 
 int somma;
 somma=lista_somma(testa);
 printf("\nSOMMA:%d",somma);
 
 int minimo;
 minimo=lista_minimo(testa);
 printf("\nMINIMO:%d",minimo);
 
 int massimo;
 lista_massimo(testa,&massimo,0);
 printf("\nMASSIMO:%d",massimo);
 
 exit(EXIT_SUCCESS);	
}