#include"liste.h"

void fine(void)
{
 printf("\nPROGRAMMA TERMINATO\n");	
}

Lista*crea_lista(int n)
{
 Lista*testa; 
 if(n==0)
   return NULL;
 else
    {
	testa=malloc(sizeof(Lista));
	if(testa==NULL)
	  {
      printf("\nArea di memoria non allocata\n");	  
	  exit(EXIT_FAILURE);
	  }
	  else
	     { 
	     testa->dato=17+rand()%14;
	     testa->nextnodo=crea_lista(n-1);	
	     }
	return testa;
	}	 
}

void stampa_lista(Lista*testa)
{
 if(testa==NULL)
    return;	 
 else
    {
	printf("%d-->",testa->dato);	
	return stampa_lista(testa->nextnodo);
	}	 
}

int cerca_nodo(Lista*testa)
{
 int pos=-1,c=-1;	
 Lista*nodo=testa;
 
 while(nodo!=NULL)
      {
	  c++;
	  if(nodo->dato==17)	  
	    {
		pos=c;	
		break;
		}
      nodo=nodo->nextnodo;
	  }
	  
 return pos; 
}

Lista*elimina_nodi(Lista*testa,int pos)
{
 Lista*nodo=testa;	
 int c=0;
 
 if(pos==c) 
   {
    testa=nodo->nextnodo;   
    free(nodo);
    return testa;
   }
 
 Lista*nodo1,*nodocanc;
 
 while(nodo!=NULL && c==pos-1)
      {
	  c++;
	  nodo=nodo->nextnodo;
	  }	 
 
 nodo1=nodo->nextnodo->nextnodo;
 nodocanc=nodo->nextnodo; 
 free(nodocanc);
 nodo->nextnodo=nodo1;
 
 return testa;	
}