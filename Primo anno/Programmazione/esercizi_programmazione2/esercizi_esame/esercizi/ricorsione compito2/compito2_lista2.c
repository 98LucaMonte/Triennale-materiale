/*1) creare una funzione che:
-crea una lista L1 contenente 10 nodi (il primo nodo deve contenere il valore 1 
il secondo nodo deve contenere il valore 2 e così via sino all'ultimo che deve contenere 10).
2) creare una funzione che:
-crea una lista L2 inserendovi solo gli elementi (campo data dei nodi) dispari di L1. 
3)creare una funzione che:
-crea una lista L3 inserendovi solo gli elementi (campo data dei nodi) pari di L1.
4)creare una funzione che:
-concatena ad L2 la lista L3 (quindi L2 conterrà tanti elementi quanti L1).*/

#include<stdio.h>
#include<stdlib.h>
#include<time.h>

struct nodo
{
 int dato;	
 struct nodo*nextnodo;	
};

typedef struct nodo Lista;

Lista*crea_lista(int dim);
void stampa_lista(Lista*testa);
Lista*crea_lista_pari(Lista*testa);
Lista*crea_lista_dispari(Lista*testa);
Lista*concatena_liste(Lista*testa,Lista*testa1);

int main(void)
{
 int num;
 
 printf("\ninserire numero elementi che formeranno la lista:");
 scanf("%d",&num);
 
 srand(time(NULL));
 Lista*testa1=crea_lista(num);
 stampa_lista(testa1);	
 
 Lista*testa2=crea_lista_pari(testa1);
 printf("\nstampa lista pari\n");
 stampa_lista(testa2);
 
 Lista*testa3=crea_lista_dispari(testa1);	
 printf("\nstampa lista dispari\n");
 stampa_lista(testa3);
 
 testa1=concatena_liste(testa2,testa3);
 printf("\nstampa lista concatenatai\n");
 stampa_lista(testa1);
 
 return 1;	
}

Lista*crea_lista(int dim)
{
 Lista*testa;
 //caso base
 if(dim==0)	
   {
   return NULL;	
   }	
 //caso ricorsivo
 else
    {
    testa=malloc(sizeof(Lista));	
    if(testa!=NULL)	
	  {
	  testa->dato=rand()% 10;	
	  testa->nextnodo=crea_lista(dim-1);
	  return testa;
	  }
	  else
	     {
	     printf("\narea di memoria non allocata\n");	
		 }
	}	
}

void stampa_lista(Lista*testa)
{
 //caso base
 if(testa==NULL)	
   {
   return;	
   }
 //caso ricorsivo
 else
    {
    printf("nodo=%d\n",testa->dato);	
    return stampa_lista(testa->nextnodo);	
	}
}

Lista*crea_lista_pari(Lista*testa)
{
 Lista*testa1;	
 //caso base
 if(testa==NULL)
   {
   return NULL;	
   }	
 //caso ricorsivo
 else
    {
    if(testa->dato% 2==0)
	  {
	  testa1=malloc(sizeof(Lista));	
      if(testa1!=NULL)
        {
        testa1->dato=testa->dato;	
        testa1->nextnodo=crea_lista_pari(testa->nextnodo);	
		}
	    else
	       {
	       printf("\narea di memoria non allocata\n");	
		   }
	  }
	  else
	     {
	     crea_lista_pari(testa->nextnodo);	
		 }
	}	
}

Lista*crea_lista_dispari(Lista*testa)
{
 Lista*testa1;	
 //caso base
 if(testa==NULL)
   {
   return NULL;	
   }	
 //caso ricorsivo
 else
    {
    if(testa->dato% 2!=0)
	  {
	  testa1=malloc(sizeof(Lista));	
      if(testa1!=NULL)
        {
        testa1->dato=testa->dato;	
        testa1->nextnodo=crea_lista_dispari(testa->nextnodo);	
		}
	    else
	       {
	       printf("\narea di memoria non allocata\n");	
		   }
	  }
	  else
	     {
	     crea_lista_dispari(testa->nextnodo);	
		 }
	}	
}

Lista*concatena_liste(Lista*testa,Lista*testa1)
{
 Lista*nodotemp;
 nodotemp=testa;
 
 while(nodotemp!=NULL)	
	  {	
	  if(nodotemp->nextnodo==NULL)	
	  	{
	  	nodotemp->nextnodo=testa1;	
		break;
		}
	  nodotemp=nodotemp->nextnodo;
	  }
	  
 return testa;
}

