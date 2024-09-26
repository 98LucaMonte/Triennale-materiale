/* Lezione 7: i file */

#include <stdio.h>

int main(void)
{
  // puntatore al file
  FILE *fPtr;
  char *f = "es5.txt";
  int v[]={10, 20, 30, 40, 50}; // [0] --> 10, [1] --> 20, ecc...

  int n;

  // apre il file
  fPtr = fopen(f,"wb");

  // se ha potuto accedere al file
  if (fPtr!=NULL)
  {
      // la fwrite scrive 2 elementi quindi la posizione 0 e 1 dell'array
      n = fwrite(&v, sizeof(int), 2, fPtr); // si può omettere la &
      printf("Dati scritti su file: %d \n", n);
      // chiude il file puntato
      fclose(fPtr);
  }
  else
  {
    printf("Impossibile accedere al file %s", f);
  }

  return 1;
}
