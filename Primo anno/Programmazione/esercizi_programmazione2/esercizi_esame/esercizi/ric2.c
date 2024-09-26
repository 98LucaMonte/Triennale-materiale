#include<stdio.h>
#include<stdlib.h>

int sommatoria(int start,int end);

int main(void)
{
 int num1,num2,result;	
 
 printf("\nnumero iniziale:");
 scanf("%d",&num1);
 printf("\nnumero finale:");
 scanf("%d",&num2);
 
 result=sommatoria(num1,num2);
 printf("\nla sommatoria dei numeri che vanno da %d a %d e'uguale a %d\n",num1,num2,result);
 	
 return 0;	
}

int sommatoria(int start,int end)
{
 //caso base
 if(start==end)
   {
   return start;	
   }	
 //caso ricorsivo
 if(start<end)
   {
   return start+sommatoria(start+1,end);
   }
 	
}
