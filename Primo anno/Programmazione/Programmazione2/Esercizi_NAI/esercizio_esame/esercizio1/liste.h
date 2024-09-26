#include<stdio.h>
#include<stdlib.h>
#include<time.h>

struct nodo
{
 int d;	
 struct nodo*next;	
};

typedef struct nodo Lista;
/**
*Funzione che stampa la fine del programma una volta terminato
*see:-
*return:-
**/
void fine(void);
/**
*Funzione che crea una nuova lista con numero di nodi uguali a n
*parametro n:indica il numero di nodi della lista che andiamo a crea
*see:-
*return:ritorna la testa della lista appena creata
**/
Lista*crea_lista(int n);
/**
*Funzione che stampa una lista
*parametro L1:indica la testa di una lista
*see:-
*return:-
**/
void stampa_lista(Lista*L1);
/**
*Funzione che crea una lista di numeri pari partendo da una lista che esiste
*parametro L1:passo alla funzione la testa di una lista
*see:-
*return:ritorna la testa della lista appena creata
**/
Lista*crea_lista_pari(Lista*L1);
/**
*Funzione che scrive nel file pari.txt i numeri pari della lista_pari
*parametro L1:passa alla funzione la testa di una lista
*see:-
*return:-
**/
void file_pari(Lista*L1);