#include<stdio.h>
#include<stdlib.h>

//es: start 3, end 6 -->3+4+5+6=18
int sommatoria(int start,int end);

int main(void)
{
 int result,ni,nf;
 
 printf("\ninserire numero iniziale:");
 scanf("%d",&ni);
 printf("\ninserire numero finale:");
 scanf("%d",&nf);	
 
 result=sommatoria(ni,nf);
 printf("\nresult:%d",result);
 	
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
 if(start!=end)	
   {
   return start+sommatoria(start+1,end);	
   }	

}
