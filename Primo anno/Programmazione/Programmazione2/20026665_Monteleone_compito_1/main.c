  /*Scrivere un programma che esegua le seguenti funzionalità:
  1)creare una funzione che:
  -crea una lista contenente 10 nodi (il primo nodo deve contenere il valore 1, il secondo 
  nodo deve contenere il valore 2 e così via sino all'ultimo che deve contenere 10).
  2)creare una funzione che:
  -visualizza i numeri pari della lista nel seguente modo: 2 --> 4 --> 6 --> 8 --> 10 --> NULL
  3)creare una funzione che:
  -esegue e restituisce nel main la media dei numeri dispari 
  (visualizzare il risultato nel main)*/

#include<stdio.h>
#include<stdlib.h>

struct nodo
{
 int data;
 struct nodo*nextnodo;	
};

typedef struct nodo lista;

lista*crea_lista();
void funzione2(lista*testa);//visualizza i numeri pari della lista 
int funzione3(lista*testa);

int main(void)
{
 lista*testa_lista=crea_lista();	
 funzione2(testa_lista);
 
 int risultato_funzione3=funzione3(testa_lista);
 printf("\nIl risultato della media dei numeri dispari presenti nella lista e'%d\n",risultato_funzione3);
 
 return 1;	
}

lista *crea_lista()
{
 lista *testa;
 lista *nodotemp;//dichiaro un nodo temporaneo	
 lista *coda;	
 
 int i=1,n=10;
 
 for(i=1;i<=n;i++)
    {
     if(i==1)	
    	{
		testa=malloc(sizeof(lista));
    	if(testa!=NULL)
		   {
		   coda=testa;//all'inizio testa e coda puntano lo stesso nodo
	       testa->data=i;
		   testa->nextnodo=NULL;
		   }
	       else
	       {
		   printf("\narea non allocata\n");
		   }
	    }
		else
	    {
	    nodotemp=malloc(sizeof(lista));	
	    if(nodotemp!=NULL)
		  {
		  coda->nextnodo=nodotemp;//salva l'indirizzo nel campo next del nodo precedente	
	                              //in questo modo il nuovo nodo nodotemp è collegato al precedente
		  coda=nodotemp;
		  coda->data=i;
		  coda->nextnodo=NULL;
		  }
	      else
	      {
	      printf("\narea non allocata\n");		
		  }
		}
	}
 
 return testa;
}

void funzione2(lista*testa)
{
 lista*ptemp;//creo un puntatore temporaneo	
 ptemp=testa;	
 
 while(ptemp!=NULL)	
	  {
	  
	  if(ptemp->data% 2==0)	
	  	{
		printf("%d",ptemp->data);
		}
        else if(ptemp->data!=1 && ptemp->data% 2!=0)
	    {
		printf("-->");
		}
		
	  ptemp=ptemp->nextnodo;		
	  }	
 	  
 printf("-->NULL\n");
}

int funzione3(lista*testa)
{
 int result=0,cont=0;	
 lista*ptemp;
 ptemp=testa;
 
 while(ptemp->nextnodo!=NULL)
      {
       if(ptemp->data% 2!=0)	
      	 {
		  result=ptemp->data+result; 
		  cont++;
		 }	
	   ptemp=ptemp->nextnodo;
	  }
 
 result=result/cont;
 
 return result;
} 
