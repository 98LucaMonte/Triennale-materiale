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
void stampa_lista(int n,Lista*testa);
void lista_max(Lista*testa,int*max,int p);
Lista*elimina_nodi(Lista*testa,int*cont);
int funzione7(Lista*testa,int x);