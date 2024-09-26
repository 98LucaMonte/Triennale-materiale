#include<stdio.h>
#include<stdlib.h>

int fibonacci(int n);

int main(void)
{
 int x,result=0;
 
 do
  {
  printf("\ninserisci posizione  del numero di fibonacci:");	
  scanf("%d",&x);	
  if(x<0)
    printf("\nerrore n deve essere maggiore uguale a 0\n");
  }
 while(x<0);
 
 result=fibonacci(x);
 printf("\nresult:%d",result);
	
 return 0;	
}

int fibonacci(int n)
{	
 //caso base
 if(n==0 || n==1)
   {
   return n;
   }
   
 //caso ricorsivo
 if(n>0)
   {
   return fibonacci(n-1)+fibonacci(n-2);	
   } 	
}


