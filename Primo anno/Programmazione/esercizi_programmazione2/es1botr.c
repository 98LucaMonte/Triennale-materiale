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
int funzione1(Lista*testa,int x);

int main()
{
 int n=8;
 Lista*testa=crea_lista(n);
 int x=2,result;
 result=funzione1(testa,x);
 printf("\nresult:%d\n",result);
 stampa_lista(testa);
 
 return 0;
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

int funzione1(Lista*testa,int x)
{
 Lista*nodotemp=testa;
 int i=1,somma=0;

 while(nodotemp!=NULL)
      {
	   if(i%x==0)	  
	      {
		   somma=(nodotemp->dato*i)+somma;	  
		  }
       nodotemp=nodotemp->nextnodo;
	   i++;
	  }	 
 return somma;	
}