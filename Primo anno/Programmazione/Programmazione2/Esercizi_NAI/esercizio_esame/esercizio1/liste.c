#include"liste.h"

void fine(void)
{
 printf("\nPROGRAMMA TERMINATO\n");	
}

Lista*crea_lista(int n)
{
 Lista*L1;
 
 if(n==0)	
	return NULL;
 
 else
 {
  L1=malloc(sizeof(Lista));
  if(L1==NULL)
  {
	printf("Errore area di memoria non allocata\n");  
    exit(EXIT_FAILURE);
  }
  else
  {
  L1->d=rand()%101; 
  L1->next=crea_lista(n-1);
  return L1;	
  }
 }	
}

void stampa_lista(Lista*L1)
{
 if(L1==NULL)
   {
	printf("NULL\n");   
    return;
   }
   
 else	
 {
	printf("%d-->",L1->d);
    return stampa_lista(L1->next);
 }
 
}

Lista*crea_lista_pari(Lista*L1)
{
 Lista*L2;	
 if(L1==NULL)	
   return NULL;
 
 else
 {
	if(L1->d%2==0)
    {
	 L2=malloc(sizeof(Lista));
     if(L2==NULL)
     {
	    printf("Errore area di memoria non allocata\n");  
		exit(EXIT_FAILURE);
     }
     else
     {
		L2->d=L1->d; 
		L2->next=crea_lista_pari(L1->next);
		return L2;	
     }	 
	}		
   return crea_lista_pari(L1->next);
 }	 
 
}

void file_pari(Lista*L1)
{
 FILE*fpw;
 
 fpw=fopen("pari.txt","w");
 if(fpw==NULL)
 {
	 printf("Errore file non disponibile\n");
     exit(EXIT_FAILURE);
 }
 else
 {
  while(L1==NULL)
  {
	if(L1->next==NULL)
	   fprintf(fpw,"%d",L1->d);
	   else
		fprintf(fpw,"%d,",L1->d);   
  
  L1=L1->next;
  }
 }
 fclose(fpw);
}