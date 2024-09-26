/* Lezione 7: i file */

#include <stdio.h>

int main(void)
{
  // puntatore al file
  FILE *fPtr;
  // dati da estrarre dal FILE
  unsigned int idconto;
  double saldo;

  int n;

  // apre il file in lettura nella stessa cartella dove è eseguito il programma
  fPtr = fopen("es2.txt","r");

  // se ha potuto aprile il file
  if (fPtr!=NULL)
  {
    // finché non viene raggiunta la fine del file
    while (feof(fPtr)==0)
    {
      // estrae i dati da una riga di dati dal file e li salva in due variabili
      n = fscanf(fPtr,"%d %lf",&idconto, &saldo);
      if (n>0)
      {
        printf("Valori letti: %d \n", n);
        printf("ID conto: %d, Saldo: %.2f \n", idconto, saldo);
      }
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
