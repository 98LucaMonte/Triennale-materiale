/*CONSEGNA
 Scrivere un programma che esegua le seguenti funzionalità:
1)chiedere in input nel main() un numero n compreso tra 1 e 10 e due 
 valori a e b (con b strettamente maggiore di a);
 es: n=3, a=5, b=10

2)scrivere una funzione ricorsiva che genera n nodi in una lista 
 contenente valori interi casuali tra a e b (estremi inclusi);
 es: (L1)->5->7->10

3)scrivere una funzione ricorsiva che visualizza la lista creata;

4)scrivere una funzione ricorsiva che determina il valore 
 massimo; visualizzare il risultato nel main();

5)scrivere una funzione ricorsiva che elimina dalla lista i nodi contenenti 
 valori pari; la funzione deve restituire il numero di nodi cancellati;

6)visualizzare la lista ottenuta a seguito del punto 5) tramite la funzione definita al punto 3);

7)chiedere nel main() un numero x compreso tra a e b (estremi inclusi) quindi scrivere 
 una funzione ricorsiva che restituisce il numero di nodi contenenti valori multipli del numero x; 
 visualizzare il risultato nel main().
 es: 
 x=5 
 (L1)->5->7->10
 risultato=2
 Documentare ogni funzione con i gli opportuni commenti(anche quelli iniziali).
*/

#include<stdio.h>
#include<stdlib.h>
#include<time.h>

struct nodo
{
 int dato;
 struct nodo*nextnodo;	
};

typedef struct nodo Lista;

Lista*crea_lista(int dim,int val1,int val2);
void stampa_lista(Lista*testa,int i);
void ricerca_val_max_lista(Lista*testa,int*max,int p);
void multipli_lista(Lista*testa,int x,int*result);
Lista*elimina_nodi(Lista*testa);

int main(void)
{
 int n,a,b;
 
 do
 {
 printf("\ninserire numero di nodi della lista:");
 scanf("%d",&n);
 if(n>10 || n<1)
   printf("\nerrore inserire un numero compreso tra 1 e 10\n");
 }
 while(n>10 || n<1);
 
 printf("\nInserire valore a:");
 scanf("%d",&a);
 
 do
 {
 printf("\nInserire valore b:");
 scanf("%d",&b);	
 if(b<=a)
   printf("\nerrore b deve essere strettamente maggioredi a\n");
 }
 while(b<=a);
 
 int p=0;
 srand(time(NULL));
 Lista*testa_lista=crea_lista(n,b,a);
 stampa_lista(testa_lista,p);	
 
 int massimo;
 ricerca_val_max_lista(testa_lista,&massimo,p);
 printf("\nil valore massimo:%d",massimo);
 
 int x,result=0;
 
 do
  {
  printf("\ninserire un numero compreso tra %d e %d:",a,b);
  scanf("%d",&x);
  if(b<x && x>a)
    printf("\nErrore il numero deve essere compreso tra %d e %d\n",a,b);	
  }
 while(b<x && x>a); 
 
 multipli_lista(testa_lista,x,&result);
 printf("\nmultipli:%d",result);
 
 int i=0;
 
 for(i=0;i<n;i++)
    {
    testa_lista=elimina_nodi(testa_lista);
    }
 
 printf("\nstampa lista senza numeri pari\n");
 stampa_lista(testa_lista,p);
    
 return 1; 
}

/**Funzione punto1 crea_lista
*parametro dim:porto nella funzione la dimensione della lista
*parametro val1:porto nella funzione un valore intero
*parametro val2:porto nella funzione un valore intero
*return:la funzione ritorna al main la testa della lista 
*see:richiamo la funzione crea_lista
**/

Lista*crea_lista(int dim,int val1,int val2)
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
     testa->dato=val2+rand()% ((val1-val2)+1);
	 testa->nextnodo=crea_lista(dim-1,val1,val2);
	 return testa;
	 }	
   } 	

}

/**Funzione punto2 stampa_lista
*parametro testa:porto per riferimento alla funzione la testa della lista creata in precedenza nella 
 funzione crea_lista
*parametro i:porto nella funzione un valore da stampare per vedere in quale nodo mi trovo 
*return:la funzione ritorna al main la testa della lista 
*see:richiamo la funzione stampa_lista
**/

void stampa_lista(Lista*testa,int i)
{	
 //caso base
 if(testa==NULL)
   {
   return;	
   }	
 //caso ricorsivo
 else
   {
   printf("nodo[%d]:%d\n",i,testa->dato);
   return stampa_lista(testa->nextnodo,i+1);
   }	
}

/**Funzione punto3 ricerca_val_max_lista
*parametro testa:porto per riferimento alla funzione la testa della lista creata in precedenza nella 
 funzione crea_lista
*parametro max:porto per riferimento la variabile intera per contenere il valore massimo trovato
*parametro p:porto la variabile intera per vedere se sono nel primo nodo oppure no
*return:- 
*see:richiamo la funzione ricerca_val_max_lista
**/

void ricerca_val_max_lista(Lista*testa,int*max,int p)
{
 //caso base
 if(testa==NULL)
   {
   return;	
   }	
 //caso ricorsivo
   if(p==0)	
	 {
	 *max=testa->dato;	
	 }
	 else if(*max<testa->dato)
		    {
		    *max=testa->dato;
		    }
		    
  return ricerca_val_max_lista(testa->nextnodo,max,p+1);			
}

/**Funzione punto7 multipli_lista
*parametro testa:porto per riferimento alla funzione la testa della lista creata in precedenza nella 
 funzione crea_lista
*parametro result:porto per riferimento la variabile intera per contenere il numero dei multipli trovati
*parametro x:porto la variabile intera del numero che voglio come multiplo
*return:- 
*see:richiamo la funzione multipli_lista
**/

void multipli_lista(Lista*testa,int x,int*result)
{
 //caso base
 if(testa==NULL)
   {
   return;
   }	
 //caso ricorsivo
 else
    {
    if(testa->dato% x==0)	
      (*result)++;	
	
	return multipli_lista(testa->nextnodo,x,result);
	}
}

/**Funzione punto5 elimina_nodi
*parametro testa:porto per riferimento alla funzione la testa della lista creata in precedenza nella 
 funzione crea_lista
*return testa:ritorno la testa della lista
*see:richiamo la funzione elimina_nodi
**/

Lista*elimina_nodi(Lista*testa)
{
 //caso base 	
  if(testa==NULL)
    {
   	return NULL;
    }
 //caso ricorsivo	
  if(testa->dato% 2==0)	
    {
    Lista*nodotemp=testa->nextnodo;  	
	free(testa);
	return nodotemp;  
	}	
  
  testa->nextnodo=elimina_nodi(testa->nextnodo);
  return testa;   	
}
 	


