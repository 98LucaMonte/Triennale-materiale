/* Lezione 7: i file */

#include <stdio.h>

int main(void)
{
  // puntatore al file
  FILE *fPtr;
  // dati da estrarre dal FILE
  unsigned int idconto;
  double saldo;

  // dato per la ricerca
  unsigned int idc;
  unsigned int c; // per verificare se ha trovato il conto cercato

  int n;

  // apre il file in lettura nella stessa cartella dove è eseguito il programma
  fPtr = fopen("es3.txt","r");

  // se ha potuto aprire il file
  if (fPtr!=NULL)
  {
    // finché non viene raggiunta la fine del file
    while (!feof(fPtr))
    {
      // estrae i dati da una riga di dati (record) dal file e li salva in due variabili
      n = fscanf(fPtr,"%d %lf",&idconto, &saldo);
      // printf("Valori letti: %d \n", n);
      printf("ID conto: %d, Saldo: %.2f \n", idconto, saldo);
    }

    // ricerca di un dato in un file sequenziale
    printf("Inserire l'ID del conto: ");
    scanf("%d", &idc);
    // riporta il puntatore alla prima riga del file
    rewind(fPtr);
    c = 0;
    while (!feof(fPtr))
    {
      // estrae i dati da una riga di dati (record) dal file e li salva in due variabili
      fscanf(fPtr,"%d %lf",&idconto, &saldo);
      // se l'id del conto corriposnde a quello trovato visualizza il saldo
      if (idconto==idc)
      {
        printf("ID conto: %d, Saldo: %.2f \n", idconto, saldo);
        c++;
        break; // interrompe la ricerca
      }
    }
    if (c==0)
    {
      printf("ID conto non trovato.\n");
    }
    // chiude il file puntato
    fclose(fPtr);
  }
  else
  {
    printf("Impossibile accedere al file");
  }

  return 1;
}
