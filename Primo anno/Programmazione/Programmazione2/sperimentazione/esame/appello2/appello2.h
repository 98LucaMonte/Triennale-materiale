#include<stdio.h>
#include<stdlib.h>
#define SIZE 50

struct nodo
{
 char codice[SIZE];
 char titolo[SIZE]; 
 int prezzo;
 char formato[SIZE]; 
 struct nodo*nextnodo;	
};

typedef struct nodo Disco;

void fine(void);
Disco*crea_file(char nome_file[]);
void stampa_lista(Disco*testa);

