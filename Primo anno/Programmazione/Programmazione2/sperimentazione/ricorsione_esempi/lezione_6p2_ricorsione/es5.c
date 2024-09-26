/* Lezione 6: ricorsione */

#include <stdio.h>
#define MAX_SIZE 100

int array_cerca(int vett[], int p, int len, int x);

int main()
{
  int vett[MAX_SIZE];
  int n, i;
  int x; // elemento da cercare
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

  printf("Valore da cercare nel vettore: ");
  scanf("%d",&x);

  r = array_cerca(vett, 0, n, x);
  if (r==-1){
    printf("Valore non trovato\n");
  }
  else{
    printf("Valore trovato alla posizione %d\n",r);
  }

  return 1;
}

int array_cerca(int vett[], int p, int len, int x)
{
  // caso base
  if (p >= len)
      return -1;

  // caso ricorsivo
  if (vett[p]==x)
    return p;
  else
    return array_cerca(vett, p + 1, len, x);
}
