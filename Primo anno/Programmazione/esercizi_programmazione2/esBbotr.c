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
void fine(void);
int funzioneB(Lista*testa); 

int main(void)
{
  atexit(fine);	
  
  int n=6;  
  Lista*testa1=crea_lista(n);
  stampa_lista(testa1);
  
  int result,val,cont=0,i=0;
  result=funzioneB(testa1);
  printf("result:%d",result);
  
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

int funzioneB(Lista*testa) 
{
  if(testa==NULL || testa->nextnodo==NULL)
	 return 1;
  
  if(testa->dato>=testa->nextnodo->dato)
     return 0;
 
  return funzioneB(testa->nextnodo);
}