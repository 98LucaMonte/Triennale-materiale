/* Lezione 7: i file */

#include <stdio.h>

int main(void)
{
  // puntatore al file
  FILE *fPtr;
  // dati da inserire nel FILE
  unsigned int idconto;
  double saldo;

  // crea il file nella stessa cartella dove è eseguito il programma
  fPtr = fopen("es1.txt","w");

  // se ha potuto creare il file
  if (fPtr!=NULL)
  {
    do
    {
      printf("Inserire ID del conto (0 per terminare): ");
      scanf("%d", &idconto);
      if (idconto>0)
      {
        printf("Inserire saldo: ");
        scanf("%lf", &saldo);
        int n = fprintf(fPtr,"%d %.2f\n", idconto, saldo);
        printf("Caratteri scritti su file: %d\n", n);
      }
    }
    while(idconto!=0);

    // chiude il file puntato
    fclose(fPtr);
  }
  else
  {
    printf("Impossibile accedere al file");
  }

  return 1;
}
