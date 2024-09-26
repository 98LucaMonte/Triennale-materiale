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
int funzione3(Lista*testa,int x);
void fine(void);

int main(void)
{
 int n=13,x=3,result;	
 Lista*testa=crea_lista(n);	
 stampa_lista(testa);
 result=funzione3(testa,x);
 printf("\nresult=%d",result);
 
 exit(EXIT_SUCCESS);
}
/*
complessità in tempo
O(1)+O(1)+O(1)+[O(1)+O(1)+O(1)]*O(i)=
=O(1)+O(i)=O(i)

*/
int funzione3(Lista*testa,int x)
{
 Lista*nodotemp=testa;	
 int cont=0,result=0;                      
 while(nodotemp!=NULL)
      {
	  if(nodotemp->dato==x)	  
	    {
		cont++;
		}	
        else
		   {
		    cont=0;  
		   }
	  if(cont>=3)
	    {
		result++;	
		}		  
	  nodotemp=nodotemp->nextnodo;
	  }
 return result; 
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

void fine(void)
{
 printf("\nPROGRAMMA TERMINATO\n");	
}

