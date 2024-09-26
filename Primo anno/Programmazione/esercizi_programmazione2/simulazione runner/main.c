#include "esame2.h"

int main ()
{
	char nomefile[] = "runner.txt";
	List *L1, *L2;
	int chosenday, runnedkm;
	float meankm;
	
	L1 = make_list (nomefile);
	print_list (L1);
	
	do
	{
		printf ("Digita un giorno per sapere quanti km vi hai percorso: ");
		scanf ("%d", &chosenday);
		
		if (chosenday < 1 || chosenday > 31)
			printf ("Il giorno deve essere compreso tra 1 e 31!\n");
	} while (chosenday < 1 || chosenday >31);
	
	runnedkm = find_km (L1, chosenday);
	
	if (runnedkm != -1)
		printf ("Il giorno %d hai percorso %dkm\n", chosenday, runnedkm);
	else
		printf ("Non ho dati sul giorno %d\n");
	
	meankm = mean_km (L1);
	
	if (meankm != -1)
	{
		printf ("Media giornaliera km percorsi: %.2f\n", meankm);
		L2 = make_list_overmean (L1, meankm);
		printf ("Giorni in cui la media giornaliera di km percorsi e' stata superata\n");
		print_list (L2);
	}
	
	printf ("Rappresentazione grafica dei km percorsi:\n");
	print_histogram (L1);
	
	return 0;
}