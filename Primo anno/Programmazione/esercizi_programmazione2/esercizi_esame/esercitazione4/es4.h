/*
1)chiedere in input nel main() un numero n compreso tra 1 e 10 e due valori a e b (con b strettamente maggiore di a);
es.:n=3,a= 5,b=10

2)scrivere una funzione ricorsiva che genera n nodi in una lista contenente valori interi casuali tra a e b (estremi inclusi);
es: L1->5->7->10

3)scrivere una funzione ricorsiva che visualizza la lista creata;

4)scrivere una funzione ricorsiva che determina il valore il massimo; visualizzare il risultato nel main();

5)scrivere una funzione ricorsiva che elimina dalla lista i nodi contenenti valori pari; la funzione deve restituire il numero di nodi cancellati;

6)visualizzare la lista ottenuta a seguito del punto 5) tramite la funzione definita al punto 3);

7)chiedere nel main() un numero x compreso tra a e b (estremi inclusi) quindi scrivere una funzione ricorsiva che restituisce 
il numero di nodi contenenti valori multipli del numero x; visualizzare il risultato nel main().
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

Lista*crea_lista(int n,int a,int b);
void stampa_lista(Lista*testa,int pos);
void valore_max_lista(Lista*testa,int*max,int pos);
int ricerca_multipli_lista(Lista*testa,int cont);
void print(void);