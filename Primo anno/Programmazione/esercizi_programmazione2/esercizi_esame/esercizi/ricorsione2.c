#include<stdio.h>
#include<stdlib.h>

int somma(int n);

int main(void)
{
 int x,result=0;
 
 do
  {
  printf("\ninserisci n:");	
  scanf("%d",&x);	
  if(x<0)
    printf("\nerrore n deve essere maggiore uguale a 0\n");
  }
 while(x<0);
 
 result=somma(x);
 printf("\nresult:%d",result);
	
 return 0;	
}

int somma(int n)
{
 //caso base
 if(n==0)	
   {
   return n;	
   }	
 //caso ricorsivo
 if(n>0)	
   {
   return n+somma(n-1);	
   }	
}

