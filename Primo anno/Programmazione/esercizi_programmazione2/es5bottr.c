#include<stdio.h>
#include<stdlib.h>

struct nodo
{
 int dato;
 struct nodo*nextnodo;
};

typedef struct nodo Lista;

Lista*crea_lista(int n);
void stampa_lista(Lista*testa);
Lista*funzione5(Lista*testa);
void fine(void);

int main(void)
{
  atexit(fine);	
  
  int n=10;  
  Lista*testa1=crea_lista(n);
  stampa_lista(testa1);
  Lista*testa2=funzione5(testa1);
  printf("\nseconda lista\n");
  stampa_lista(testa2);
  
  exit(EXIT_SUCCESS);  
}

void fine(void)
{
 printf("\nPROGRAMMA TERMINATO\n");	
}

Lista*crea_lista(int n)
{
 Lista*testa;
 if(n==0)
    return NULL;
 else
     {
     testa=malloc(sizeof(Lista));
	 if(testa==NULL)
	    {
	    printf("area di memroia non allocata");		
		exit(EXIT_FAILURE);
		}
		else
		    {
			printf("\nInserire nodo:");
			scanf("%d",&testa->dato);   
		    testa->nextnodo=crea_lista(n-1);	 
			}
     }
 return testa;
}

void stampa_lista(Lista*testa)
{
 if(testa==NULL)
    return;
 else
    {
    printf("Nodo:%d\n",testa->dato);		
	return stampa_lista(testa->nextnodo);
	}
}

Lista*funzione5(Lista*testa)
{
 Lista*nodotemp=testa; 
 Lista*testa1,*nodo1,*coda1;
 int somma=0,i=1,k=1,y;
 while(nodotemp!=NULL)
      {
	   if(i>=3)
	     {
	     if(somma==nodotemp->dato)		 
		   {		     
			if(k==1)
			   {
		       testa1=malloc(sizeof(Lista));
               coda1=testa1;			   
			   testa1->dato=nodotemp->dato;
			   testa1->nextnodo=NULL;  
	           k++;
			   }
		       else
			      {
				  nodo1=malloc(sizeof(Lista));	  
				  coda1->nextnodo=nodo1;
				  coda1=nodo1;
				  coda1->dato=nodotemp->dato;
				  coda1->nextnodo=NULL;
				  }
		   }
	     }		   
	   if(i!=1)
	     {
		 somma=nodotemp->dato+y;
		 y=nodotemp->dato; 
		 } 
	   	 else
		    {
			y=nodotemp->dato; 	
			}
		 
	   nodotemp=nodotemp->nextnodo;
       i++;
	  }
	  
 return testa1;
}

