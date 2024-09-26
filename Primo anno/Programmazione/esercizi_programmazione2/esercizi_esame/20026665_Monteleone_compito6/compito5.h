/*
1) chiedere in input nel main() un numero n compreso tra 1 e 10 e due valori a e b (con b strettamente maggiore di a);

es.: n = 3 , a = 5, b = 10

2) scrivere una funzione che ha in input n, a e b e scrive su un file ad accesso diretto chiamato "dati.txt" gli n valori casuali tra a e b;
3) scrivere una funzione che ha in input il puntatore al file "dati.txt" e crea una lista con i dati contenuti nel file;

4) scrivere una funzione che ha in input la lista e la visualizza ricorsivamente;

5) scrivere una funzione che dalla lista ricavata dal file ne genera una seconda con i soli nodi contenenti valori pari;

6) visualizzare la lista con la funzione sviluppata al punto 4);

7) scrivere una funzione che riceve la lista dei numeri pari e la scrive in un file ad accesso diretto chiamato "pari.txt".
*/

#include<stdio.h>
#include<stdlib.h>
#include<time.h>

//strutture
struct nodo
{
 int dato;	
 struct nodo*nextnodo;	
};

//typedef
typedef struct nodo Lista;

//prototipi
void crea_file(int a,int b,int n);
Lista*crea_lista(FILE*fpw,int n);
void stampa_lista(Lista*testa,int p);
Lista*lista_pari(Lista*testa,int n);
void crea_file_pari(Lista*testa);


