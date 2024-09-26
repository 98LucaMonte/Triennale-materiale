/* Lezione 6: ricorsione */

#include <stdio.h>
#define MAX_SIZE 100

void array_max(int vett[], int p, int len, int *r);

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

  array_max(vett, 0, n, &r);

  printf("Valore massimo: %d\n", r);

  return 1;
}

void array_max(int vett[], int p, int len, int *r)
{
  // caso base
  if (p >= len)
      return;

  // caso ricorsivo
  if (p==0){ // primo elemento come "campione"
    *r = vett[0];
  }
  else{
    if (vett[p] > *r){
      *r = vett[p];
    }
  }
  return array_max(vett, p + 1, len, r);
}
