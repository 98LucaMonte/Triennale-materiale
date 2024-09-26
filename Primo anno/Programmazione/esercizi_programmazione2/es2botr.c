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
int funzione2(Lista*testa,int n,int m);

int main()
{
 int x=8;
 Lista*testa=crea_lista(x);
 stampa_lista(testa);
 int n=3,m=5,result;
 result=funzione2(testa,n,m);
 printf("\nresult:%d\n",result);
 
 return 0;
}

int funzione2(Lista*testa,int n,int m)
{
 Lista*nodotemp=testa;
 int i=1,somma=0,somma1=0,result=0; 
 
 while(i<=m)
      {
	   if(i<=n)
          somma=somma+nodotemp->dato;		   
	   else
          somma1=somma1+nodotemp->dato;		   
	   
       i++;	   
	   nodotemp=nodotemp->nextnodo;	
	  }	 
 
 result=somma-somma1;
 
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
			testa->dato=n+2;   
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