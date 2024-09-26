#include<stdio.h>
#include<stdlib.h>

int fatt(int n);

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
 
 result=fatt(x);
 printf("\nresult:%d",result);
 
 return 0;	
}

int fatt(int n)
{
 //caso base
 if(n<=1)
   {
   return 1;	
   }	
 //caso ricorsivo
 if(n>1)	
   {
   return n*fatt(n-1);	
   }		
}
