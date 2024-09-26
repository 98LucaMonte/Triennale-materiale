#include"liste.h"

int main(int argc,char*argv[])
{
 atexit(fine);	
 
 if(argc!=2)
   {
   printf("\nErrore in linea di comando\n");	   
   exit(EXIT_FAILURE);
   }	 
 
 Lista*testa;
 testa=lista_crea(argv[1]);
 stampa_lista(testa,0);
 
 int totale_ore;
 char studente[10];
 
 printf("\nInserire Codice di uno studente:");
 scanf("%s",studente);
 
 totale_ore=lista_ore(testa,studente);
 printf("\nLo studente %s ha fatto %d ore di stage",studente,totale_ore);
 
 Lista*testa1;
 char azienda[10];
 
 printf("\nInserire Codice di una azienda:");
 scanf("%s",azienda);
 testa1=lista_azienda(testa,azienda);
 stampa_lista(testa1,0);
 
 scrivi_file(testa1);
 
 exit(EXIT_SUCCESS);
}


