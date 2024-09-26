#include"liste.h"

int main(int argc,char*argv[])
{
 atexit(fine);
 if(argc!=2)	
 {
	 printf("Errore di sintassi in linea di comando");
	 exit(EXIT_FAILURE);
 }
 
 int nodi=atoi(argv[1]);
 
 if(nodi<1 || nodi>20)
 {
	 printf("Errore il numero di nodi non rispetta le condizioni 1<=nodi<=20");
     exit(EXIT_FAILURE);
 }
 
 
 Lista*L1;
 srand(time(NULL));
 L1=crea_lista(nodi);
 stampa_lista(L1);
 
 Lista*L2;
 L2=crea_lista_pari(L1);
 stampa_lista(L2);
 
 file_pari(L1);
 
 exit(EXIT_SUCCESS);
}