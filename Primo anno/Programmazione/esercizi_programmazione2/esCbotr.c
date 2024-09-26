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
int funzioneC(Lista*testa,Lista*testa1); 

int main(void)
{
  atexit(fine);	
  
  int n=3,n1=5;  
  Lista*testa1=crea_lista(n);
  stampa_lista(testa1);
  Lista*testa2=crea_lista(n1);
  stampa_lista(testa2);
  
  int result;
  result=funzioneC(testa1,testa2);
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

int funzioneC(Lista*testa,Lista*testa1) 
{
 int cont=0;
 
 if(testa==NULL || testa1==NULL)
	return 0;
 
 if(testa->dato==testa1->dato)
   {
   cont++;   
   }
 
 return cont+funzioneC(testa->nextnodo,testa1->nextnodo);
}