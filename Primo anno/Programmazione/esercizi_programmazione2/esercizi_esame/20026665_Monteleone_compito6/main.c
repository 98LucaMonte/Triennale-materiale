
#include"compito5.h"

int main(void)
{
 int n,a,b;
 
 do
   {
   printf("\nInserire un numero compreso tra 1 e 10 estremi inclusi\nn:");
   scanf("%d",&n);
   if(n<1 || n>10)
      printf("\nErrore il numero n appena inserito non rispetta la condizione 1<=n<=10\n");
   }
 while(n<1 || n>10);
 
 printf("\nInserire valore a:");
 scanf("%d",&a);
 
  do
   {
   printf("\nInserire valore b:");
   scanf("%d",&b);
   if(a>b)
      printf("\nErrore il numero b appena inserito non rispetta la condizione b>a\n");
   }
 while(a>b);
 
 crea_file(a,b,n);
 
 Lista*testa1;
 FILE*fpr;
 int pos=0;
 
 fpr=fopen("dati.txt","rb");
 if(fpr==NULL)
    { 
     printf("\nErrore il file non e' disponibile\n");
	}
    else
	  {
	  testa1=crea_lista(fpr,n);
	  fclose(fpr);
	  printf("\nStampa Lista con valori casuali tra %d e %d scritti nel file dati.txt e poi inseriti nella lista\n\n",a,b);
	  stampa_lista(testa1,pos);
	  }
	  
 Lista*testa2=lista_pari(testa1,n);
 printf("\nStampa lista con soli valori pari\n");
 stampa_lista(testa2,pos);
 
 crea_file_pari(testa2);
 
 return 1;	
}