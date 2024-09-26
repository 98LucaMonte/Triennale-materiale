#include<stdio.h>
#include<stdlib.h>

#define DIM 5

void inserisci_vettore(int vet[],int p);
void visualizza_vettore(int vet[],int p);
int somma_valori_vettore(int vet[],int p);
int cerca_valore_vettore(int vet[],int p,int x);
void max_valore_vettore(int vet[],int p,int *r);

int main(void)
{
 int vet[DIM],p=0,somma=0;	
 
 inserisci_vettore(vet,p);
 printf("\n");
 visualizza_vettore(vet,p);
 somma=somma_valori_vettore(vet,p);
 printf("\nsomma:%d\n",somma);
 int trovato,val;
 printf("\nInserire il valore da cercare:");
 scanf("%d",&val);
 trovato=cerca_valore_vettore(vet,p,val);
 
 if(trovato==-1)
   {
   printf("\nIl valore cercato e' assente");	
   }
   else
      {
      printf("\nIl valore cercato e' in posizione:%d",trovato);	
	  }
 
 int r;
 
 max_valore_vettore(vet,p,&r); 
 printf("\nIl valore massimo e'%d",r);
 
 
 return 0;	
}

void inserisci_vettore(int vet[],int p)
{
 //caso base
 if(p==DIM)
   {
   return;
   }
 //caso ricorsivo
 if(p<DIM)
   {
   printf("\nInserire valore nel vettore in posizione[%d]:",p);	
   scanf("%d",&vet[p]);	
   return inserisci_vettore(vet,p+1);
   }	
}

void visualizza_vettore(int vet[],int p)
{
 //caso base
 if(p==DIM)
   {
   return;
   }
 //caso ricorsivo
 if(p<DIM)
   {
   printf("%d\t",vet[p]);		
   return visualizza_vettore(vet,p+1);
   }	
}

int somma_valori_vettore(int vet[],int p)
{
 //caso base
 if(p==DIM)
   {
   return 0;	
   }	
 //caso ricorsivo
 if(p<DIM)
   {
   return (vet[p]+somma_valori_vettore(vet,p+1));	
   }	
}

int cerca_valore_vettore(int vet[],int p,int x)
{
 //caso base
 if(p==DIM)
   {
   return -1;	
   }	
 //caso ricorsivo
 if(vet[p]==x)
   {
   return p;	
   }
   else	
      {  
      return cerca_valore_vettore(vet,p+1,x);
      }	
}

void max_valore_vettore(int vet[],int p,int *r)
{
 //caso base	
 if(p==DIM)
   {
   return;	
   }	
 //caso ricorsivo
 if(p==0)
   {
   *r=vet[p];	
   }
   else
      {
      if(*r<vet[p])
	    {
	    *r=vet[p];	
		}	
      	else
      	   {
      	   return max_valore_vettore(vet,p+1,r);	
		   }
	  }
}
