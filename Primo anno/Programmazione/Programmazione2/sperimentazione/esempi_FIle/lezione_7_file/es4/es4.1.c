/* Lezione 7: i file */

#include <stdio.h>

int main(void)
{
  // puntatore al file
  FILE *fPtr;
  char *f = "es4.txt";
  unsigned int i;

  int n;

  // apre il file ad accesso diretto (attenzione alla b)
  fPtr = fopen(f,"wb");

  // se ha potuto accedere al file
  if (fPtr!=NULL)
  {
    for(i=1;i <= 20; i++)
    {
      // fwrite scrive il dato contenuto all'indirizzo di i
      // essendo i intero scrive una numero di byte determinato dal sizeof(int)
      // 1 indica di scrivere un dato solo
      // fPtr indica file e posizione in cui scrivere
      n = fwrite(&i, sizeof(int), 1, fPtr);
      printf("Dati scritti su file: %d \n", n);
    }
    // chiude il file puntato
    fclose(fPtr);
  }
  else
  {
    printf("Impossibile accedere al file %s", f);
  }

  return 1;
}
