#include<stdio.h>
#include<stdlib.h>
#include<time.h>

struct nodo
{
 int dato;	
 struct nodo*nextnodo;	
};

typedef struct nodo lista;
typedef lista*Lista;

void fine(void);
Lista crea_lista(int n);
void stampa_lista(Lista testa);
int lista_somma(Lista testa);
int lista_minimo(Lista testa);
void lista_massimo(Lista testa,int*massimo,int i);