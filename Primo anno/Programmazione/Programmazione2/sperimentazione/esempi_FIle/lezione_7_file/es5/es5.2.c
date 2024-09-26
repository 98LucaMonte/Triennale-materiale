/* Lezione 7: i file */

#include <stdio.h>

int main(void)
{
  // puntatore al file
  FILE *fPtr;
  char *f = "es5.txt";
  int x;
  int n;

  // apre il file
  fPtr = fopen(f,"rb");

  // se ha potuto creare il file
  if (fPtr!=NULL)
  {
      while (!feof(fPtr))
      {
            n = fread(&x, sizeof(int), 1, fPtr);
            if (n!=0)
              printf("Dati letti da file: %d --> %d\n", n, x);
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
