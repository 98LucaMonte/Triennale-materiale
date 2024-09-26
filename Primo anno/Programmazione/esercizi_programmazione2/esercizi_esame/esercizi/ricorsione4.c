#include<stdio.h>
#include<stdlib.h>
//b^x

int potenza(int b,int x);

int main(void)
{
 int x,base,esponente;
 
 printf("\nbase:"); 
 scanf("%d",&base);
 printf("\nesponente:"); 
 scanf("%d",&esponente);	
 
 x=potenza(base,esponente);	
 printf("\n%d elevato %d fa %d",base,esponente,x);
 	
 return 0;	
}

int potenza(int b,int x)
{
 //caso base
 if(x==0)	
   {
   return 1;	
   }	
 //caso ricorsivo
 if(x>0)
   {
   return b*potenza(b,x-1);	
   }	
}
