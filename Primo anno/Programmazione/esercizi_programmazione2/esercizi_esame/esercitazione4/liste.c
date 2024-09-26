
#include"es4.h"

void print(void)
{
 printf("\nFINE PROGRAMMA\n");
}

Lista*crea_lista(int n,int a,int b)
{
 Lista*testa;
 //caso base
 if(n==0)
    {
	return NULL;	
	}
 //caso ricorsivo
 else
    {
	testa=malloc(sizeof(Lista));
    if(testa==NULL)
	   {
	   printf("\narea di memoria non allocata\n");	   
	   exit(EXIT_FAILURE);
	   }		
	   else
	      {
		  testa->dato=a+rand()%(b-a)+1;	  
		  testa->nextnodo=crea_lista(n-1,a,b);
		  return testa;
		  }
	}
}

void stampa_lista(Lista*testa,int pos)
{
  //caso base
  if(testa==NULL)
     {
	 return;	 
	 }	  
  //caso ricorsivo
     else
        {
	 	printf("\nNodo[%d]:%d",pos,testa->dato); 
	    return stampa_lista(testa->nextnodo,pos+1);
		}	  	
}

void valore_max_lista(Lista*testa,int*max,int pos)
{
 //caso base
 if(testa==NULL)
   {
	return;   
   }	 
 //caso ricorsivo
   else
      {
	  if(pos==0)
	    {
		*max=testa->dato;	 
		}
        else if(*max<testa->dato)
		   {
		   *max=testa->dato;   
		   }
	  }	  
 
 return valore_max_lista(testa->nextnodo,max,pos+1);
}