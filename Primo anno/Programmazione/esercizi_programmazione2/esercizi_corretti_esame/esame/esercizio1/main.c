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
 if(nodi<1 || nodi>20)
   {
   printf("\nERRORE IN LINEA DI COMANDO IL NUMERO DI NODI DEVE ESSERE COMPRESO TRA 1 E 20\n");	
   exit(EXIT_FAILURE);   
   }
 
 srand(time(NULL));
 Lista*testa;
 testa=crea_lista(nodi);
 stampa_lista(testa);
 printf("NULL\n");
 
 int somma,media;
 somma=lista_media(testa,nodi);
 media=somma/nodi;
 printf("\nMEDIA:%d\n",media);
 
 Lista*testa1;
 testa1=lista_media_sup(testa,media);
 stampa_lista(testa1);
 printf("NULL\n");
  
 exit(EXIT_SUCCESS);	
}