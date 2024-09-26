#include<stdio.h>
#include<stdlib.h>

#define DIM 5

void inserisci_vettore(int vet[],int i);
void stampa_vettore(int vet[],int p);
int somma_elementi_vettore(int vet[],int i);
int cerca_valore_vettore(int vet[],int i,int x);

int main(void)
{
 int result=0,vet[DIM],p=0,trovato,val;	
 
 inserisci_vettore(vet,p);
 stampa_vettore(vet,p);	
 result=somma_elementi_vettore(vet,p);
 printf("\nresult:%d",result);
 printf("\nval=");
 scanf("%d",&val);
 trovato=cerca_valore_vettore(vet,p,val);
 if(trovato!=-1)
   printf("\nIl valore %d e'assente\n");
   else
   printf("\nIl valore %d e'presente\n");
   	
 return 0;	
}

void inserisci_vettore(int vet[],int i)
{
 //caso base
 if(i==DIM)
   {
   return;
   }
 //caso ricorsivo
 if(i<DIM)
   {
   printf("\ninserisci valore in posizione[%d]:",i);
   scanf("%d",&vet[i]);
   
   return inserisci_vettore(vet,i+1);	
   }
 		
}

void stampa_vettore(int vet[],int p)
{
 //caso base
 if(p>=DIM)
   {
   return;
   }	
 //caso ricorsivo
 if(p<DIM)
   {
   printf("%d\t",vet[p]);
   return stampa_vettore(vet,p+1);
   }
   	
}

int somma_elementi_vettore(int vet[],int p)
{
 //caso base
 if(p==DIM)
   {
   return 0;	
   }	
 //caso ricorsivo
 if(p<DIM)
   {
   return vet[p]+somma_elementi_vettore(vet,p+1);	
   }		

}

int cerca_valore_vettore(int vet[],int p,int x)
{
 //caso base
 if(p>=DIM)	
   {
   return -1;	
   }	
 
 //caso ricorsivo
  if(vet[p]==x)	
    return p;	
  	   
  else
    return cerca_valore_vettore(vet,p+1,x);
	
}
