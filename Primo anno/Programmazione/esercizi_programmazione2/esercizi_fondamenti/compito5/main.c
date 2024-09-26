#include"liste.h"

int main(void)
{
 atexit(fine);	
 
 int nodi;
 printf("\nInserire numero nodi:");
 scanf("%d",&nodi);
 
 srand(time(NULL));
 Lista*testa;
 
 FILE*fpr=fopen("dati.txt","wb");
 if(fpr==NULL)
   {
   printf("\nFILE NON DISPONIBILE\n");   
   exit(EXIT_FAILURE);   
   }
   
 scrivi_file(fpr,nodi);
 fclose(fpr);
 
 FILE*fpr1=fopen("dati.txt","rb");
 if(fpr==NULL)
   {
   printf("\nFILE NON DISPONIBILE\n");   
   exit(EXIT_FAILURE);   
   }
 testa=crea_lista(nodi,fpr1);
 fclose(fpr1);
 stampa_lista(testa,0);
 
 Lista*testa1;
 testa1=crea_lista_pari(testa);
 printf("\nStampa lista pari\n");
 stampa_lista(testa1,0);
 
 FILE*fpr2=fopen("dati1.txt","wb+");
 if(fpr2==NULL)
   {
   printf("\nFILE NON DISPONIBILE\n");   
   exit(EXIT_FAILURE);   
   }
 scrivi_file_pari(fpr2,testa1);
 fclose(fpr2);
 
 exit(EXIT_SUCCESS);	
}