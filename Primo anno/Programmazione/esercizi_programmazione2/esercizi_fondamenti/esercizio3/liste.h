#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct nodo
{
 char azienda[10];
 char studente[10];
 int ore; 
 struct nodo*nextnodo;	
};

typedef struct nodo Lista;

void fine(void);
Lista*lista_crea(char nome_file[]);
void stampa_lista(Lista*testa,int n);
int lista_ore(Lista*testa,char studente[]);
Lista*lista_azienda(Lista*testa,char azienda[]);
void scrivi_file(Lista*testa1);