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
Lista*funzioneD(Lista*testa,Lista*testa1,int pos); 

int main(void)
{
  atexit(fine);	
  
  int n=10,n1=7;  
  printf("\nInserisci nodi della prima lista\n");
  Lista*testa1=crea_lista(n1);
  printf("\nInserisci nodi della seconda lista\n");
  Lista*testa2=crea_lista(n);
  
  stampa_lista(testa1);
  printf("\n");
  stampa_lista(testa2);
  Lista*testa3;
  testa3=funzioneD(testa1,testa2,1);
  stampa_lista(testa3);
  printf("\n");
  
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
    printf("%d->",testa->dato);		
	return stampa_lista(testa->nextnodo);
	}
}

Lista*funzioneD(Lista*testa,Lista*testa1,int pos) 
{
 Lista*testa3;
 
 if(testa==NULL || testa1==NULL)
    return NULL;
 
 if((testa->dato-testa1->dato)%pos==0)
   {
   testa3=malloc(sizeof(Lista));
   testa3->dato=testa->dato-testa1->dato;  
   testa3->nextnodo= funzioneD(testa->nextnodo,testa1->nextnodo,pos+1);
   return testa3;
   }
   else
      {
	  return funzioneD(testa->nextnodo,testa1->nextnodo,pos+1);
      }
	  
}