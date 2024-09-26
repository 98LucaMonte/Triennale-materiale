/*1) creare una funzione che:
- crea una lista contenente 10 nodi (il primo nodo deve contenere il valore 1, il secondo nodo 
deve contenere il valore 2 e così via sino all'ultimo che deve contenere 10).
2) creare una funzione che:
- visualizza i numeri pari della lista nel seguente modo: 2 --> 4 --> 6 --> 8 --> 10 --> NULL
3) creare una funzione che:
- esegue e restituisce nel main la media dei numeri dispari (visualizzare il risultato nel main)*/

#include<stdio.h>
#include<stdlib.h>

struct nodo
{
 int dato;
 struct nodo*nextnodo;		
};

typedef struct nodo Lista;
Lista*crea_lista(int dim);
void stampa_lista(Lista*testa);
float media_valori_lista(Lista*testa);

int main(void)
{
 Lista*testa_lista;	
 int n;
 
   do
   {
   printf("\nInserire lunghezza della lista:");	
   scanf("%d",&n);	
   if(n<1)
     {
	 printf("\nLa lista in questo caso e' vuota");
     printf("\nInserisci un valore maggiore di zero per creare una lista non vuota\n");
	 }
   }
   while(n<1);
     
 testa_lista=crea_lista(n);	
 stampa_lista(testa_lista);
 
 float risultato;
 
 risultato=media_valori_lista(testa_lista);
 if(risultato==0)
   printf("\nnella lista non sono presenti valori pari\n");	
   else
   printf("\nLa media dei valori pari nella lista e'%f\n",risultato);
   
 free(testa_lista);	
	
 return 1;	
}

Lista*crea_lista(int dim)
{
 Lista*testa;
 Lista*nodotemp;
 Lista*coda;
 int i=1;
 
 for(i=1;i<=dim;i++)	
	{
	if(i==1)		
	  {
      testa=malloc(sizeof(Lista));	
	  if(testa!=NULL)
	    {
	     coda=testa;    	
	     testa->dato=i;	
	     testa->nextnodo=NULL;	
		}
	    else
	       {
	       printf("\narea di memoria non allocata\n");
	       return 0;
	       }
	  }	
    else
	   {
	   nodotemp=malloc(sizeof(Lista));
       if(nodotemp!=NULL)
         {
         coda->nextnodo=nodotemp;	
         coda=nodotemp;
	     coda->dato=i;
	     coda->nextnodo=NULL;	
	     }
	     else
	        {
		    printf("\narea di memoria non allocata\n"); 
		    return 0; 
		    }
	   }
    }
 return testa;
}

void stampa_lista(Lista*testa)
{
 Lista*nodotemp;	
 
 nodotemp=testa;
 printf("\nstampa della lista\n");
 
 while(nodotemp!=NULL)
      {
      printf("%d-->",nodotemp->dato);	
	  nodotemp=nodotemp->nextnodo;		
	  }
	  
 printf("NULL\n");	
}

float media_valori_lista(Lista*testa)
{
 Lista*nodotemp;
 float result=0,n=0;
 nodotemp=testa;
 
 while(nodotemp!=NULL)
      {
	  if(nodotemp->dato% 2==0)		  
	    {
		result=nodotemp->dato+result;
		n++;
		} 
	  nodotemp=nodotemp->nextnodo;
	  }	
	  	
 result=result/n;
 
 return result;	
}
