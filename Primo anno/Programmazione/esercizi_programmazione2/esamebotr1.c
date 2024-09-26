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
int funzioneA(Lista*testa,int x);

int main(void)
{
 int x=5;
 Lista*testa=crea_lista(x);
 printf("\nStampa prima lista\n");
 stampa_lista(testa);
 int cont=0,i=0,val;
 cont=funzioneA(testa->nextnodo,2);
 printf("\nOutput:%d",cont);
 return 0;
}

int funzioneA(Lista*testa,int x)
{
 Lista*nodo=testa;
 int i=0,cont=0;
 Lista*nodocanc;
 if(nodo->dato%x==0)
   {
	testa=nodo->nextnodo;
	free(nodo);
	cont++;
    nodo=testa;
   }
 
 while(nodo!=NULL)
      {
	  if(nodo->nextnodo->dato%x==0)	  
	    {
		nodocanc=nodo->nextnodo;
        nodo->nextnodo=nodo->nextnodo->nextnodo;
        free(nodocanc);
        cont++;		
		} 
	  nodo=nodo->nextnodo;
	  }
	  
 return cont;
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