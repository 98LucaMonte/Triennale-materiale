/* Lezione 6: ricorsione */

#include <stdio.h>
#define MAX_SIZE 100

int array_somma(int vett[], int start, int len);

int main()
{
  int vett[MAX_SIZE];
  int n, i;
  int r; // risultato

  do{
    printf("Elementi da inserire nell'array: ");
    scanf("%d", &n);
  }
  while(n>MAX_SIZE);

  for(i=0; i<n; i++)
  {
    printf("Valore da inserire nell'array: ");
    scanf("%d", &vett[i]);
  }

  r = array_somma(vett, 0, n);
  printf("Sommatoria elementi nell'array: %d \n", r);

  return 1;
}

int array_somma(int vett[], int p, int len)
{
  // caso base
  if (p >= len)
      return 0;

  // caso ricorsivo
  return (vett[p] + array_somma(vett, p + 1, len));
}
