/* Lezione 3: concatenazione di liste */

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
void lista_concatena(Lista *l1, Lista *l2);

int main(void)
{
	// l1 è il puntatore alla testa della prima lista
	// l2 è il puntatore alla testa della seconda lista
	Lista *l1, *l2;
	l1 = lista_crea();
	printf("Lista 1: \n");
	lista_visualizza(l1);
	l2 = lista_crea();
	printf("Lista 2: \n");
	lista_visualizza(l2);
	// aggiunge i dati di l2 in l1
	lista_concatena(l1,l2);
	printf("Lista 1 (concatenata a Lista 2)\n");
	lista_visualizza(l1);
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
			//printf("Nodo testa creato all'indirizzo: %p \n", headPtr);
			// inizialmente, testa e coda puntano lo stesso nodo
			tailPtr = headPtr;
			headPtr->data = (i+1)*10;	// dati
			headPtr->nextPtr = NULL;	// link
		}
		else
		{
			// crea lo spazio e ottiene l'indirizzo di memoria per il nuovo nodo
			tempPtr = malloc(sizeof(Lista));
			//printf("Nodo creato all'indirizzo: %p \n", tempPtr);

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

void lista_concatena(Lista *l1, Lista *l2)
{
	// puntatore (temporaneo) a una lista
	Lista *tempPtr;
	// salva la testa della lista di l1 nel puntatore temporaneo
	tempPtr = l1;

	while(tempPtr!=NULL){
		// verifica se è l'ultimo nodo della lista
		if (tempPtr->nextPtr == NULL){
			tempPtr->nextPtr = l2;
			break;
		}
		tempPtr = tempPtr->nextPtr;
	}
}


