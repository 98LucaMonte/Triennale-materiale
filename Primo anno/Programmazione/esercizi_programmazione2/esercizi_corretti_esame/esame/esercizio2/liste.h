#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<ctype.h>

struct nodo
{
 char lettera;	
 struct nodo*nextnodo;
};

typedef struct nodo Lista;

void fine(void);
Lista*crea_lista(char parola[]);
void stampa_lista(Lista*testa);
int lista_simboli(Lista*testa);
Lista*funzione3(Lista*testa1);