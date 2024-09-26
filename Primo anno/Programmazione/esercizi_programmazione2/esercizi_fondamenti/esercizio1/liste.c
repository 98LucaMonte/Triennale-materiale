#include"liste.h"

Lista*crea_lista(int n)
{
 Lista*testa;
 //caso base
 if(n==0)   
   return NULL;
 //caso ricorsivo
 else
   {
	testa=malloc(sizeof(Lista));
    if(testa==NULL)
	  {
	  printf("Area di memoria non allocata");	  
	  exit(EXIT_FAILURE);
	  }		
      else
	     {
		  testa->dato=rand()%101;	 
		  testa->nextnodo=crea_lista(n-1);
		  return testa;
		 }
   }	 
}

void stampa_lista(Lista*testa,int n)
{
 if(testa==NULL)
	return;
 
 else
    {
    printf("Nodo(%d):%d\n",n,testa->dato);		
	return stampa_lista(testa->nextnodo,n+1);
	}

}

void fine(void)
{
 printf("\nPROGRAMMA TERMINATO\n");	
}

int lista_somma(Lista*testa)
{	
 if(testa==NULL)
    return 0;	 
 else
	return testa->dato+lista_somma(testa->nextnodo);		 
}

int lista_minimo(Lista*testa)
{
 int min,i=1;	
 Lista*nodo=testa;	
 while(nodo!=NULL)
      {
       if(i==1)
	     {
	     min=nodo->dato;
	     i++;
		 }
	     else if(nodo->dato<min)
		         {
			     min=nodo->dato;
			     } 
		nodo=nodo->nextnodo;		
	  }
 return min;
}

int lista_massimo(Lista*testa)
{
 int max,i=1;
 Lista*nodo=testa;	
 while(nodo!=NULL)
      {
       if(i==1)
	     {
	     max=nodo->dato;
	     i++;
		 }
	     else if(nodo->dato>max)
		         {
			     max=nodo->dato;
			     } 
		nodo=nodo->nextnodo;		
	  }
 return max;
}