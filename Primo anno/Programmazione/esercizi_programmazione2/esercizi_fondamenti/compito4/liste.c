#include"liste.h"

Lista*crea_lista(int n,int a,int b)
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
		 testa->dato=a+rand()%((b-a)+1);	 
		 testa->nextnodo=crea_lista(n-1,a,b);
		 return testa;   
         }
   }
}

void stampa_lista(int n,Lista*testa)
{
 if(testa==NULL)
   return;
 else
    {
    printf("\nNodo(%d):%d",n,testa->dato);	
	return stampa_lista(n+1,testa->nextnodo);
	}
}

void lista_max(Lista*testa,int*max,int p)
{
 if(testa==NULL)
    return;	 
	else
	  {
	   if(p==0)
	      *max=testa->dato;
        	  
       if(*max<testa->dato)
          *max=testa->dato;
       
	   return lista_max(testa->nextnodo,max,p+1);	  
	  }
}

Lista*elimina_nodi(Lista*testa,int*cont)
{
 if(testa==NULL)
   	return NULL; 
 
 if(testa->dato%2==0)	
   {
   Lista*nodotemp=testa->nextnodo; 	   
   free(testa);
   (*cont)++;
   return nodotemp;
   }   
 testa->nextnodo=elimina_nodi(testa->nextnodo,cont);
 return testa;		 
}

int funzione7(Lista*testa,int x)
{
 int cont=0;	
 if(testa==NULL)
    return 0;	 
 
 if(testa->dato%x==0) 
   {
	cont++;   
    return cont+funzione7(testa->nextnodo,cont);
   }

}