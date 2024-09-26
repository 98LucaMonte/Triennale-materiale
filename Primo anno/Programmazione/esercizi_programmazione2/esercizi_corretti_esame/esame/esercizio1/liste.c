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
	   printf("\nAREA DI MEMORIA NON ALLOCATA\n");	
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

int lista_media(Lista*testa,int nodi)
{
 int somma=0;
 
 if(testa==NULL)
	return 0;
 
 else
    {
	somma=testa->dato+lista_media(testa->nextnodo,nodi);	
	return somma;	
	}	 
}

Lista*lista_media_sup(Lista*testa1,int media)
{
 Lista*nodo1=testa1;
 Lista*testa,*nodo,*coda;
 int i=0;
 
 while(nodo1!=NULL)
      {
      if(media<nodo1->dato)	  
	     {
		 if(i==0)	 
		    {
			testa=malloc(sizeof(Lista));
            if(testa==NULL)
			  {
			  printf("\nAREA DI MEMORIA NON ALLOCATA\n");	
              exit(EXIT_FAILURE);   
			  }
			  else
			     {
			     coda=testa;			
			     testa->dato=nodo1->dato;	
			     testa->nextnodo=NULL;
			     }
			}
	        else
			   {
			   nodo=malloc(sizeof(Lista));
			   if(testa==NULL)
			     {
			     printf("\nAREA DI MEMORIA NON ALLOCATA\n");	
                 exit(EXIT_FAILURE);   
			     }
			     else
			        {
					coda->nextnodo=nodo;	
			        coda=nodo;			
			        nodo->dato=nodo1->dato;	
			        nodo->nextnodo=NULL;
			        }
			   }  
		 }
	  i++;
	  nodo1=nodo1->nextnodo;
	  }
	  
 return testa;	
}