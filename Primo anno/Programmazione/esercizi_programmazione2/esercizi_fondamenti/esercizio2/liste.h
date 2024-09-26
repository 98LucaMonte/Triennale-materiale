#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct nodo
{
 char lettera; 
 struct nodo*nextnodo;	
};

typedef struct nodo Lista;

void fine(void);
Lista*crea_lista(int n,char stringa[]);
void stampa_lista(Lista*testa);
int lista_vocali(Lista*testa);
Lista*lista_consonanti(Lista*testa);
Lista*cifrata(Lista*testa);