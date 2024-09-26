#include"liste.h"

int main(int argc,char*argv[])
{
 atexit(fine);
 
 if(argc!=2)
   {
   printf("\nERRORE DI SINTASSI IN LIENA DI COMANDO\n");   
   exit(EXIT_FAILURE);   
   }	 

 char nome_file[20];
 strcpy(nome_file,argv[1]);
 
 Lista*testa;
 testa=lista_crea(nome_file);
 stampa_lista(testa);
 
 int ore;
 char studente[20];
 printf("\nInserisci studente:");
 scanf("%s",studente);
 ore=lista_ore(testa,studente);
 if(ore==0)
    printf("\nSTUDENTE non presente\n");
    else
        printf("\n%s ha lavorato %d ore\n",studente,ore);
 
 char azienda[20];
 printf("\nInserisci azienda:");
 scanf("%s",azienda);
 Lista*testa1;
 testa1=lista_azienda(testa,azienda);
 
 printf("\nStampa lista della azienda %s\n");   
 stampa_lista(testa1);
 
 funzione5(testa1);
	   
 exit(EXIT_SUCCESS);
}

