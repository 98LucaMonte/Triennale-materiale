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
int funzioneD(Lista*testa,Lista*testa1,int n,int i); 

int main(void)
{
  atexit(fine);	
  
  int n=10,n1=6;  
  printf("\nInserisci nodi della prima lista\n");
  Lista*testa1=crea_lista(n1);
  printf("\nInserisci nodi della seconda lista\n");
  Lista*testa2=crea_lista(n1);
  
  stampa_lista(testa1);
  printf("\n");
  stampa_lista(testa2);
  
  int result;
  
  result=funzioneD(testa1,testa2,3,1);
  printf("\nResult:%d",result);
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

int funzioneD(Lista*testa,Lista*testa1,int n,int i) 
{
 if(testa==NULL || testa1==NULL)
     return 1;
  
  else
     {
	 if(n<i)
	   {
       if(testa->dato!=testa1->dato)
	     return 0;
       }		   
	 }
 return funzioneD(testa->nextnodo,testa1->nextnodo,n,i+1);
}