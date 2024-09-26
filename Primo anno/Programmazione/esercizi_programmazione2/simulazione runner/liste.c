#include "esame2.h"

/**
* Crea una lista a partire dai valori contenuti in un file
* @FUNCTION: make_list
* @PARAM char filename[]: stringa contenente il nome del file dal quale prendere i dati
* @RETURN List *head: testa della lista creata
*/
List * make_list (char filename[])
{
	FILE *fp;
	fp = fopen (filename, "r");
	
	if (fp == NULL)
	{
		printf ("Il file %s non esiste o non si hanno i diritti per accedervi\n", filename);
		exit (EXIT_FAILURE);
	}
	
	List *head, *tail, *temp;
	int i, daynum, kilom;
	
	for (i = 0; feof(fp) == 0; i++)
	{
		if (i == 0)
		{
			head = malloc (sizeof(List));
			
			if (head == NULL)
			{
				printf ("Errore nella richiesta di allocazione dinamica della memoria\n");
				exit (EXIT_FAILURE);
			}
			else
			{
				fscanf (fp, "%d,%d", &daynum, &kilom);
				head -> day = daynum;
				head -> km = kilom;
				head -> next = NULL;
				tail = head;
			}
		}
		else
		{
			temp = malloc (sizeof(List));
			
			if (temp == NULL)
			{
				printf ("Errore nella richiesta di allocazione dinamica della memoria\n");
				exit (EXIT_FAILURE);
			}
			else
			{
				fscanf (fp, "%d,%d", &daynum, &kilom);
				tail -> next = temp;
				temp -> day = daynum;
				temp -> km = kilom;
				temp -> next = NULL;
				tail = temp;
			}
		}
	}
	
	fclose (fp);
	return head;
}

/**
* Stampa a video il contenuto della lista
* @FUNCTION: print_list
* @PARAM List *listPtr: puntatore alla lista da stampare
* @RETURN: -
*/
void print_list (List *listPtr)
{
	if (listPtr == NULL)
		return;
	
	printf ("Day %d: %dkm\n", listPtr -> day, listPtr -> km);
	print_list (listPtr -> next);
	
	return;
}

/**
* Cerca i km percorsi in un determinato giorno
* @FUNCTION: find_km
* @PARAM List *listPtr: testa della lista in cui effettuare la ricerca
* @PARAM int daynumber: giorno in cui cercare
* @RETURN: km percorsi nel giorno scelto, -1 se su quel giorno non ci sono dati
*/
int find_km (List *listPtr, int daynumber)
{
	while (listPtr != NULL)
	{
		if (listPtr -> day == daynumber)
			return listPtr -> km;
		else
			listPtr = listPtr -> next;
	}
	
	return -1;
}

/**
* Calcola la media dei km percorsi ogni giorno
* @FUNCTION: mean_km
* @PARAM List *listPtr: testa della lista su cui calcolare la media
* @RETURN: media dei km percorsi al giorno
*/
float mean_km (List *listPtr)
{
	float meankm = -1, sumkm;
	int daynumber = 0;
	
	while (listPtr != NULL)
	{
		sumkm += listPtr -> km;
		daynumber++;
		listPtr = listPtr -> next;
	}
	
	if (daynumber != 0)
		meankm = sumkm / daynumber;
	else
		printf ("La lista non contiene dati\n");

	return meankm;
}

/**
* Crea una lista contenente solo i giorni in cui si e' superata la media dei km
* @FUNCTION: make_list_overmean
* @PARAM List *listPtr: testa della lista da cui estrapolare i giorni sopra la media
* @PARAM float meankm: media giornaliera dei km percorsi
* @RETURN: media dei km percorsi al giorno
*/
List * make_list_overmean (List *listPtr, float meankm)
{
	List *listOutHead, *listOutTail, *listOutTemp;
	int i = 0;
	
	listOutHead = NULL;
	
	while (listPtr != NULL)
	{
		if (listPtr -> km > meankm)
		{
			if (i == 0)
			{
				listOutHead = malloc (sizeof (List));
				
				if (listOutHead == NULL)
				{
					printf ("Errore nella richiesta di allocazione dinamica della memoria\n");
					exit (EXIT_FAILURE);
				}
				else
				{
					listOutHead -> day = listPtr -> day;
					listOutHead -> km = listPtr -> km;
					listOutHead -> next = NULL;
					listOutTail = listOutHead;
				}
			}
			else
			{
				listOutTemp = malloc (sizeof (List));
				
				if (listOutTemp == NULL)
				{
					printf ("Errore nella richiesta di allocazione dinamica della memoria\n");
					exit (EXIT_FAILURE);
				}
				else
				{
					listOutTail -> next = listOutTemp;
					listOutTemp -> day = listPtr -> day;
					listOutTemp -> km = listPtr -> km;
					listOutTemp -> next = NULL;
					listOutTail = listOutTemp;
				}
				
			}
			i++;
		}
		
		listPtr = listPtr -> next;
	}
	
	return listOutHead;
}

/**
* Visualizza i km percorsi in forma grafica
* @FUNCTION: print_hystogram
* @PARAM List *listPtr: testa della lista su cui la funzione lavora
* @RETURN: -
*/
void print_histogram (List *listPtr)
{
	int i;
	
	while (listPtr != NULL)
	{
		printf ("Day %d: ", listPtr -> day);
		
		for (i = 0; i < listPtr -> km; i++)
			printf ("*");
		
		printf ("\n");
		
		listPtr = listPtr -> next;
	}
}
