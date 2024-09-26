#include<stdio.h>
#include<stdlib.h>
#include<time.h>

struct nodo
{
 int dato;
 struct nodo*nextnodo; 
};

typedef struct nodo Lista;

void fine(void);
Lista*crea_lista(int n);
void stampa_lista(Lista*testa);
Lista*elimina_nodi(Lista*testa,int pos);
int cerca_nodo(Lista*testa);