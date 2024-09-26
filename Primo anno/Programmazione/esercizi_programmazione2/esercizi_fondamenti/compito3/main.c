#include"liste.h"

int main(void)
{
 int nodi;
 
 atexit(fine);
 
 do
  {
   printf("Inserire numero di nodi:");	  
   scanf("%d",&nodi);
   if(nodi<1 || nodi>20)
     printf("\nErrore --> 1<=nodi<=20\n");
  }
  while(nodi<1 || nodi>20);	

 srand(time(NULL)); 
 Lista*testa;
 testa=crea_lista(nodi);
 stampa_lista(testa);
 printf("NULL\n");
 
 Lista*nodo=testa;
 int pos=-1,i=0;
 
 for(i=0;i<nodi;i++)
      {
      pos=cerca_nodo(testa);
	  if(pos>=0)
	     {
	     testa=elimina_nodi(testa,pos-1);
         }	  
	  }
	  
 stampa_lista(testa);
 
 exit(EXIT_SUCCESS);	
}