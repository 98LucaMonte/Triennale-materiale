#include<stdlib.h>
#include<stdio.h>
#include<time.h>

struct nodo
{
 int dato;
 struct nodo*nextnodo; 
};

typedef struct nodo Lista;

Lista*crea_lista(int n);
void stampa_lista(Lista*testa,int n);
int lista_somma(Lista*testa);
int lista_minimo(Lista*testa);
int lista_massimo(Lista*testa);
void fine(void);