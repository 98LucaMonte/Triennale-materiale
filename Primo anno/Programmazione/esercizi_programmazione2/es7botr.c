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
Lista*funzione7(Lista*testa,Lista*testa1,int n);

int main(void)
{
 int x=7,n=2,y=5;
 
 printf("Inserisci nodi seconda lista\n");
 Lista*testa=crea_lista(x);
 printf("\nStampa prima lista\n");
 stampa_lista(testa);
 
 printf("Inserisci nodi seconda lista\n");
 Lista*testa1=crea_lista(y);
 printf("\nStampa seconda lista\n");
 stampa_lista(testa1);
 
 testa=funzione7(testa,testa1,n);
 printf("\nPrima lista modificata");
 stampa_lista(testa);
 
 return 0;
}

Lista*funzione7(Lista*testa,Lista*testa1,int n)
{
 Lista*nodotemp=testa,*nodotemp1=testa1;
 Lista*nodo;
 
 while(nodotemp!=NULL)
      {
	   if(nodotemp1==NULL)
	     {
		 if(nodotemp->dato%n==0)	 
		   {   
		   
		   }
	     } 
	     else if(nodotemp->dato+nodotemp1->dato%n==0)	  
	            {
		        
				}
      nodotemp=nodotemp->nextnodo;
	  nodotemp1=nodotemp1->nextnodo;
	  }	 
 
 return testa;
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
			printf("Inserire nodo:");
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