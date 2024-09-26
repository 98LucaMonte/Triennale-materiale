/* Lezione 7: i file */

#include <stdio.h>

int main(void)
{
  // puntatore al file
  FILE *fPtr;
  char *f = "es6.txt";
  int x = 10;

  // apre il file
  fPtr = fopen(f,"wb");

  // se ha potuto accedere al file
  if (fPtr!=NULL)
  {
      unsigned int p = 5; // partendo da 0, indica posizione 4
      // esegue l'offset
      // sposta il puntatore di p-1 posizioni partendo da inizio file (SEEK_SET)
      // ogni posizione contiene un intero
      // quindi la dimensione di ogni posizione è sizeof(int) --> 4 byte
      fseek(fPtr, (p-1) * sizeof(int), SEEK_SET);
      int n = fwrite(&x, sizeof(int), 1, fPtr);
      printf("Dati scritti su file: %d \n", n);
      printf("Record scritto su file: %d \n", x);
      printf("Dimensione di ogni record: %d \n", sizeof(int));
      printf("Offset su file: %d \n", (p-1) * sizeof(int));
      // chiude il file puntato
      fclose(fPtr);
  }
  else
  {
    printf("Impossibile accedere al file %s", f);
  }

  return 1;
}
