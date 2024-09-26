/* Lezione 3: ricerca di un elemento in una lista */

#include <stdio.h>
#include <stdlib.h>

struct node
{
	int data;
	struct node *nextPtr;
};

// definisce un alias Lista
typedef struct node Lista;

Lista * lista_crea();
void lista_visualizza(Lista *headPtr);
int lista_cerca_elemento(Lista * headPtr,int x);

int main(void)
{
	Lista *headPtr;
	int n;
	int x; // dato da cercare
	int trovato; // posizione del nodo
	headPtr = lista_crea();
	printf("Lista creata: \n");
	lista_visualizza(headPtr);
	printf("Inserisci un dato da cercare: ");
	scanf("%d",&x);
	trovato = lista_cerca_elemento(headPtr,x);
	if (trovato < 0)
	{
		printf("Elemento non trovato\n");
	}
	else
	{
		printf("Elemento trovato nel nodo %d\n",trovato);
	}
	return 1;
}

Lista * lista_crea()
{
	// puntatori ai nodi
	Lista *headPtr; 	// testa
	Lista *tailPtr; 	// coda (nodi successivi sino all'ultimo)
	Lista *tempPtr; 	// nodo temporaneo

	int i;
	int n = 3;

	for (i=0; i<n; i++) // i varrà 0, 1, 2
	{
		if (i==0) // primo nodo (testa)
		{
			headPtr = malloc(sizeof(Lista));
			printf("Nodo testa creato all'indirizzo: %p \n", headPtr);
			// inizialmente, testa e coda puntano lo stesso nodo
			tailPtr = headPtr;
			headPtr->data = (i+1)*10;	// dati
			headPtr->nextPtr = NULL;	// link
		}
		else
		{
			// crea lo spazio e ottiene l'indirizzo di memoria per il nuovo nodo
			tempPtr = malloc(sizeof(Lista));
			printf("Nodo creato all'indirizzo: %p \n", tempPtr);

			// salva l'indirizzo nel campo next del nodo precedente
			// in questo modo il nuovo nodo temp è collegato al nodo precedente
			tailPtr->nextPtr = tempPtr;

			tailPtr = tempPtr;
			// sposta il puntatore al nuovo nodo
			// in questo modo al prossimo passaggio il nodo "corrente" è l'ultimo creato

			tailPtr->data = (i+1)*10;
			tailPtr->nextPtr = NULL; // se è l'ultimo nodo il next rimarrà NULL
		}
	}
	return headPtr;
}

void lista_visualizza(Lista *headPtr)
{
	// puntatore (temporaneo) a una lista
	Lista *tempPtr;

	// salva la testa della lista nel puntatore temporaneo
	tempPtr = headPtr;

	// scorre i nodi della lista
	while(tempPtr!=NULL)
	{
		printf("Dato nel nodo: %d\n", tempPtr->data);
		tempPtr = tempPtr->nextPtr;
	}
}

int lista_cerca_elemento(Lista *headPtr,int x)
{
	// puntatore (temporaneo) a una lista
	Lista *tempPtr;
	// salva la testa della lista nel puntatore temporaneo
	tempPtr = headPtr;
	int trovato = -1;
	int c = -1;
	// scorre i nodi della lista tramite il puntatore temporaneo
	while(tempPtr!=NULL){
		c++;
		// dato trovato
		if (tempPtr->data == x){
			trovato = c;
			break; // interrompe il ciclo
		}
		tempPtr = tempPtr->nextPtr;
	}
	return trovato;
}