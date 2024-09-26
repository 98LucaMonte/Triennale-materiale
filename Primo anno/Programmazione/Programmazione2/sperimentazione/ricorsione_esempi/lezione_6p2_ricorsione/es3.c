/* Lezione 6: ricorsione */

#include <stdio.h>
#define MAX_SIZE 100

void array_visualizza(int vett[], int start, int len);

int main()
{
  int vett[MAX_SIZE];
  int n, i;

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

  printf("Valori nell'array: \n");
  array_visualizza(vett, 0, n);

  return 0;

    return 1;
}

void array_visualizza(int vett[], int p, int len)
{
  // caso base
  if (p >= len)
      return;

  printf("[%d]:%d \n", p, vett[p]);

  // caso ricorsivo
  return array_visualizza(vett, p + 1, len);
}
