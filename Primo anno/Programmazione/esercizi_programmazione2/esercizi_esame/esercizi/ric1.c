#include<stdio.h>
#include<stdlib.h>

int potenza(int base,int esp);

int main(void)
{
 int b,e,result;	
 
 printf("\nbase:");
 scanf("%d",&b);
 printf("\nesponente:");
 scanf("%d",&e);
 
 result=potenza(b,e);
 printf("\n%d elevato %d -->%d",b,e,result);
 	
 return 0;	
}

int potenza(int base,int esponente)
{
 //caso base
 if(esponente==0)	
   {
   return 1;	
   }	
 //caso ricorsivo
 if(esponente>0)  	
   {
   return base*potenza(base,esponente-1);
   }	
}
