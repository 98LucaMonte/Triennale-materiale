/* Lezione 7: i file */

#include <stdio.h>

int main(void)
{
  // puntatore al file
  FILE *fPtr;
  char *f = "es4.txt";
  int x;

  int n;

  // apre il file ad accesso diretto (attenzione alla b)
  fPtr = fopen(f,"rb");

  // se ha potuto accedere al file
  if (fPtr!=NULL)
  {
    while(!feof(fPtr))
    {
      // fread legge il dato puntato da fPtr e lo salva all'indirizzo di memoria di x
      // essendo x intero legge una numero di byte determinato dal sizeof(int)
      // 1 indica di leggere un dato solo
      n = fread(&x, sizeof(int), 1, fPtr);
      printf("Dati letti dal file: %d --> %d \n", n, x);
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
