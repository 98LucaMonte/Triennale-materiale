/* Lezione 7: i file */

#include <stdio.h>
#define SIZE 100

int main(void)
{
  // puntatore al file
  FILE *fPtr;
  char *f = "es5.txt";
  int v[SIZE];
  int n;


  fPtr = fopen(f,"rb");

  // se ha potuto creare il file
  if (fPtr!=NULL)
  {
      while (!feof(fPtr))
      {
            // fread legge 2 interi e li salva nel vettore
            n = fread(&v, sizeof(int), 2, fPtr);
            if (n!=0)
            {
                printf("Dati letti da file: %d\n", n);
                for(unsigned int i = 0; i<n; i++)
                {
                  printf("Dato: %d \n", v[i]);
                }
            }
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
