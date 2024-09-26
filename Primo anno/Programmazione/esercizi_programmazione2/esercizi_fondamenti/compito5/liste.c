#include"liste.h"

void fine(void)
{
printf("\nPROGRAMMA TERMINATO\n");	
}

void scrivi_file(FILE*fpr,int n)
{
 int i=0,x;
 
 while(i<n)
      {
	   x=rand()%101;
       fwrite(&x,sizeof(int),1,fpr);
	   i++;	   
	  }
}

Lista*crea_lista(int n,FILE*fpr)
{
 Lista*testa;
 int x;

 if(n==0)	
	return NULL;
 else
    {
	testa=malloc(sizeof(Lista));    
    if(testa==NULL)
	  {
	  printf("\nAREA DI MEMORIA NON ALLOCATA\n");	  
	  exit(EXIT_FAILURE);
	  }
	  else
	     {
		 fread(&x,sizeof(int),1,fpr);	
		 testa->dato=x;
		 testa->nextnodo=crea_lista(n-1,fpr);
		 return testa;
		 }
	}	 
}

void stampa_lista(Lista*testa,int n)
{
 if(testa==NULL)
	return;
 else
    {
	printf("\nNodo[%d]:%d",n,testa->dato);	
	return stampa_lista(testa->nextnodo,n+1);
	}
}

Lista*crea_lista_pari(Lista*testa)
{
 Lista*testa1,*nodo1,*coda1;
 int i=0;
 Lista*nodo=testa;
 
 while(nodo!=NULL)
       {
		if(nodo->dato%2==0)   
		   {
	       if(i==0)   
		     {
			 testa1=malloc(sizeof(Lista));
             coda1=testa1;
			 testa1->dato=nodo->dato;
             testa1->nextnodo=NULL;			 
			 i++;
			 }
	         else
			    {
				nodo1=malloc(sizeof(Lista));
                coda1->nextnodo=nodo1;
				coda1=nodo1;
			    nodo1->dato=nodo->dato;
                nodo1->nextnodo=NULL;	
				}
		   }
	    nodo=nodo->nextnodo;   
	   }
 return testa1;
}

void scrivi_file_pari(FILE*fpr2,Lista*testa1)
{
 Lista*nodo=testa1;
 
 while(nodo!=NULL)
      {
	  fwrite(&nodo->dato,sizeof(int),1,fpr2);	  
	  printf("\nDato scritto nel file e'%d",nodo->dato);	  
	  nodo=nodo->nextnodo;	  
	  }
}