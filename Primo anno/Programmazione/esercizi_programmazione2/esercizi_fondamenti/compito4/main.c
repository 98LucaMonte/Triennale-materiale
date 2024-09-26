#include"liste.h"

int main(void)
{
 int nodi,a,b;  
 
 do
  {
  printf("\nInserire il numero di nodi:"); 
  scanf("%d",&nodi);	
  if(nodi>10 || nodi<1)
     printf("\nErrore il numero dei nodi deve essere compreso tra 1 e 10\n");	  
  }
 while(nodi>10 || nodi<1);
 
 printf("\nInserire numero a:");
 scanf("%d",&a);
 
 do
  {
  printf("\nInserire numero b:");
  scanf("%d",&b);  
  if(a>b)
     printf("\nErrore a deve essere strettamente minore di b\n");
  }
 while(a>b);
 
 srand(time(NULL));
 Lista*testa;
 testa=crea_lista(nodi,a,b);
 stampa_lista(0,testa);
 
 int massimo;
 lista_max(testa,&massimo,0);
 printf("\nIl valore massimo e' %d",massimo);
 
 
 int cont=0,i=0;
 
 for(i=0;i<nodi;i++)
    {
    testa=elimina_nodi(testa,&cont);
    }
 
 printf("\nStampa Lista senza numeri pari\n"); 
 stampa_lista(0,testa);
 printf("\nIl numero di nodi cancellati e' %d",cont);
 
 int x,result=0;
 
 do  
  {
  printf("\nInserire un numero x:");	  
  scanf("%d",&x);
  if(x<a || x>b)
	 printf("\nErrore inserisci la x con rispettando la seguente condizione\n");
  }
 while(x<a || x>b); 
 
 result=funzione7(testa,x);
 printf("\nResult:%d",result);
 
 exit(EXIT_SUCCESS);	
}