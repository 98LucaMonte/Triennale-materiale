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
int lista_media(Lista*testa,int nodi);
Lista*lista_media_sup(Lista*testa1,int media);