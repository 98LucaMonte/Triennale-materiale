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
Lista*crea_lista(int n,FILE*fpr);
void stampa_lista(Lista*testa,int n);
void scrivi_file(FILE*fpr,int n);
Lista*crea_lista_pari(Lista*testa);
void scrivi_file_pari(FILE*fpr2,Lista*testa1);