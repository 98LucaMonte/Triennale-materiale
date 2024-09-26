
#include"es4.h"

int main(void)
{
 atexit(print);	
 int n,b,a;
 
 do
 {
 printf("\nInserire numero di nodi della lista che verra' creata\nn:");
 scanf("%d",&n);
 if(n<1 || n>10)
	printf("\nErrore il numero di nodi deve essere compreso tra 1 e 10 estremi inclusi\n");
 }
 while(n<1 || n>10);
 
 printf("\nInserire a:");
 scanf("%d",&a);
 
 do
 {
 printf("\nInserire b:");
 scanf("%d",&b);
 if(b<a)
	printf("\nErrore b deve essere maggiore di a\n");
 }
 while(b<a);
 
 int pos=0;
 
 srand(time(NULL));
 Lista*testa_lista=crea_lista(n,a,b);
 stampa_lista(testa_lista,pos);
 
 int max,dim;
 
 dim=n;
 
 valore_max_lista(testa_lista,&max,pos);
 printf("\nStampa il valore massimo della lista\nmax=%d",max);
 
 exit(EXIT_SUCCESS);
}