#include"liste.h"

void fine(void)
{
 printf("\nPROGRAMMA TERMINATO\n");	
}

Lista crea_lista(int n)
{
 Lista testa;	
 if(n==0)
    return NULL;
 
 else
    {
	testa=(Lista)malloc(sizeof(lista));	
	testa->dato=rand()%101;
	testa->nextnodo=crea_lista(n-1);
	return testa;
	}
}

void stampa_lista(Lista testa)
{
 if(testa==NULL)
    return;	 
 
 else
    {
	printf("%d-->",testa->dato);	
	return stampa_lista(testa->nextnodo);	
	}
}

int lista_somma(Lista testa)
{
 if(testa==NULL)
    return 0;	 
 else
    return testa->dato+lista_somma(testa->nextnodo);		
}

int lista_minimo(Lista testa)
{
 Lista nodo=testa;
 int min,i=0;
 while(nodo!=NULL)
      {
	  if(i==0)
	    {
		min=nodo->dato;	 
		i++;
		} 
		else
		   {
		   if(nodo->dato<min)
		      {
			  min=nodo->dato;  
			  }
	       }
      nodo=nodo->nextnodo;	  
	  }	
 return min;	
}

void lista_massimo(Lista testa,int*massimo,int i)
{
 if(testa==NULL)
    return;	 
 else
    {
	if(i==0)	
	  {
	  *massimo=testa->dato;   
	  }
	  else
	     {
		 if(*massimo<testa->dato)
		    {
			*massimo=testa->dato;	
			} 
		 }
	}	 
 return lista_massimo(testa->nextnodo,massimo,i+1);
}