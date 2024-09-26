/* Lezione 7: i file */

#include <stdio.h>
#define SIZE 32
#define MINCC 1
#define MAXCC 1000

struct cc
{
  unsigned int id;
  char cognome[SIZE];
  char nome[SIZE];
  double saldo;
};

typedef struct cc ContoCorrente;

//prototipi
void ccInserisci(FILE *fPtr);
void ccVisualizza(FILE *fPtr);
void ccAggiorna(FILE *fPtr);
void ccCancella(FILE *fPtr);

int main(void)
{
 FILE*fPtr;
 char*nomeFile="cc.txt";
 unsigned int menu;
 char invio;

 fPtr = fopen(nomeFile, "rb+"); // rb+ lettura e scrittura

 if(fPtr==NULL)
   {
   printf("Impossibile accedere al file dei cc: %s \n", nomeFile);
   }
   else
      {
      printf("*** GESTIONE CONTI CORRENTI (CC) *** \n\n");
      do 
	   {
       printf("MENU\n");
       printf("1 - Stampa i CC \n");
       printf("2 - Inserisci nuovo CC \n");
       printf("3 - Aggiorna CC esistente \n");
       printf("4 - Cancella CC \n");
       printf("5 - Fine \n\n");
       printf("SCELTA: ");
       scanf("%d", &menu);
       invio = getchar();

      switch(menu)
            {
            case 1:
                  ccVisualizza(fPtr);
                  break;
            
			case 2:
                  ccInserisci(fPtr);
                  break;
            
			case 3:
                  ccAggiorna(fPtr);
                  break;
            
			case 4:
                  ccCancella(fPtr);
                  break;
            
			case 5:
                  break;
            
			default:
                   printf("Scelta incorretta\n\n");
                   break;
            }
      }
    while(menu!=5);
    printf("\n*** FINE PROGRAMMA *** \n\n");
    fclose(fPtr);
  }
  return 1;
}

void ccVisualizza(FILE*fPtr)
{
  ContoCorrente ccTemp;
  unsigned int n;
  int i=0; // conta i CC
  rewind(fPtr); // porta il puntatore a inizio file per scorrerlo tutto
  printf("\n*** 1 - Stampa i CC *** \n\n");
  
  while(!feof(fPtr))
       {
       n=fread(&ccTemp, sizeof(ContoCorrente), 1, fPtr);
       if(n>0 && ccTemp.id!=0)
         {
         i++;
         printf("ID:%d\tCognome:%s\tNome:%s\tSaldo:%10.2f\n",ccTemp.id,ccTemp.cognome,ccTemp.nome,ccTemp.saldo);
         printf("-----------------------------------------------------------------\n\n");
         }
       }
       
  if(i==0)
    {
    printf("Nessun conto corrente presente in memoria!\n");
    }
         
  printf("\n*** 1 -Fine Stampa i CC*** \n\n");
}

void ccInserisci(FILE *fPtr)
{
  unsigned int idcc;
  ContoCorrente ccTemp;
  unsigned int n;
  char invio;

  printf("\n*** 2 - Inserimento CC *** \n\n");
   
  do
   {
   printf("Inserire l'ID del CC da inserire (tra %d e %d): ",MINCC,MAXCC);
   scanf("%d", &idcc);
   }
  while(idcc < MINCC || idcc > MAXCC);

  // sposta il puntatore del file alla posizione corretta
  fseek(fPtr,(idcc-1)*sizeof(ContoCorrente),SEEK_SET);

  // verifica che il cc non esista giÃ 
  // esegue una lettura
  n=fread(&ccTemp, sizeof(ContoCorrente), 1, fPtr);

  // se ha trovato un record valido
  if(n>0 && ccTemp.id!=0)
  {
  printf("Conto corrente con ID %d gia esistente!\n\n", idcc);
  }
  else
  {
    ccTemp.id=idcc;
    // 31 caratteri perchè un posto deve essere riservato a '\0
    printf("Cognome (max %d caratteri):",SIZE-1);
    scanf("%31s",&ccTemp.cognome);
    
	printf("Nome (max %d caratteri):",SIZE-1);
    scanf("%31s",&ccTemp.nome);
    
	printf("Saldo: ");
    scanf("%lf", &ccTemp.saldo);
    
	// sposta il puntatore del file alla posizione corretta
    // in quanto dopo la fread è¨stato spostato
    fseek(fPtr,(idcc-1)*sizeof(ContoCorrente), SEEK_SET);
    n=fwrite(&ccTemp,sizeof(ContoCorrente),1, fPtr);
    if(n>0)
      {
	  printf("Conto corrente con ID %d salvato correttamente.\n", ccTemp.id);
      }
  }
  printf("\n*** 2 - Fine inserimento CC *** \n\n");
}

void ccAggiorna(FILE *fPtr)
{
  unsigned int idcc;
  ContoCorrente ccTemp;
  unsigned int n;
  double transazione;
  char invio;

  printf("\n*** 3 - Aggiorna CC esistente *** \n\n");
  do
   {
   printf("Inserire l'ID del CC da aggiornare (tra %d e %d): ", MINCC, MAXCC);
   scanf("%d", &idcc);
   }
  while(idcc<MINCC || idcc >MAXCC);

  // sposta il puntatore del file alla posizione corretta
  fseek(fPtr,(idcc-1)*sizeof(ContoCorrente), SEEK_SET);

  // verifica che il CC esista eseguendo una lettura
  n=fread(&ccTemp, sizeof(ContoCorrente), 1, fPtr);

  if(n==0 || ccTemp.id==0)
  {
    printf("Conto corrente con ID %d non esistente!\n", idcc);
  }
  else
  {
    // riporta il puntatore nella posizione corretta (dopo la fread si Ã¨ spostato)
    fseek(fPtr, (idcc-1)*sizeof(ContoCorrente), SEEK_SET);
    printf("Valore transazione: ");
    scanf("%lf", &transazione);
    ccTemp.saldo=ccTemp.saldo + transazione;
    n = fwrite(&ccTemp,sizeof(ContoCorrente), 1, fPtr);
    if (n > 0)
      printf("Conto corrente con ID %d aggiornato correttamente (nuovo saldo: %.2f)\n",ccTemp.id, ccTemp.saldo);
  }
  printf("\n*** 3 - Fine Aggiorna CC *** \n\n");
}

void ccCancella(FILE *fPtr)
{
  unsigned int idcc;
  ContoCorrente ccTemp;
  ContoCorrente ccTempVuoto = {0, "", "", 0};
  unsigned int n;
  double transazione;

  printf("\n*** 4 - Cancella CC esistente *** \n\n");
  do
  {
  printf("Inserire l'ID del CC da cancellare (tra %d e %d): ", MINCC, MAXCC);
  scanf("%d", &idcc);
  }
  while (idcc<MINCC || idcc >MAXCC);

  // sposta il puntatore del file alla posizione corretta
  fseek(fPtr,(idcc-1)*sizeof(ContoCorrente),SEEK_SET);

  // verifica che il CC esista eseguendo una lettura
  n=fread(&ccTemp, sizeof(ContoCorrente), 1, fPtr);

  if(n==0)
  {
  printf("Conto corrente con ID %d non esistente!\n", idcc);
  }
  else
  {
    // riporta il puntatore nella posizione alla corretta(dopo la fread si è spostato)
    fseek(fPtr,(idcc-1)*sizeof(ContoCorrente), SEEK_SET);
    // la cancellazione inserisce un record "vuoto"
    n=fwrite(&ccTempVuoto, sizeof(ContoCorrente), 1, fPtr);
    if(n > 0)
      printf("Conto corrente con ID %d cancellato \n", idcc);
  }
  printf("\n*** 4 - Fine Cancella CC *** \n\n");
}
