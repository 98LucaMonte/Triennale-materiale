#include<stdio.h>
#include<stdlib.h>

struct nodo
{
 int dato;	
 struct nodo*nextnodo;	
};

typedef struct nodo Lista;
Lista*crea_lista();
void stampa_lista(Lista*testa);
Lista*inserisci_elemento(Lista*testa,int x,int p);

int main(void)
{
 Lista*testalista;	
 testalista=crea_lista();
 stampa_lista(testalista);
 int x=100;//elemento da inserire nella lista
 int p=2;//posizione in cui inserire l'elemento
 inserisci_elemento(testalista,x,p);
 stampa_lista(testalista);
	
 return 1;	
}

Lista*crea_lista()
{
 Lista*testa;
 Lista*nodotemp;
 Lista*coda;	
 int i=0;
 
 for(i=0;i<=5;i++) 	
	{
    if(i==0)		
	  {
	  testa=malloc(sizeof(Lista));	
	  if(testa!=NULL)
	    {
	    coda=testa;
	    testa->dato=i*10;
		testa->nextnodo=NULL;
		}
	    else
	       {
	       printf("\narea di memoria non alloccata\n");	
	       return 0;
		   }
	  }
	  else
	     {
		 nodotemp=malloc(sizeof(Lista));
         if(nodotemp!=NULL)
		   {
		   coda->nextnodo=nodotemp;
		   coda=nodotemp;
		   coda->dato=i*10;
		   coda->nextnodo=NULL;
		   }		 
		   else
		      {
		      printf("\narea di memoria non alloccata\n");	
	          return 0;	
		      }
		 }	
	}
	
 return testa;	
}

void stampa_lista(Lista*testa)
{
 Lista*nodotemp;
 nodotemp=testa;
 
 while(nodotemp!=NULL)
 	  {
	  printf("%d-->",nodotemp->dato);
	  nodotemp=nodotemp->nextnodo;
	  }
 printf("NULL");
}

Lista*inserisci_elemento(Lista*testa,int x,int p)
{
 Lista*nodonuovo;
 nodonuovo=malloc(sizeof(Lista));	
 Lista*nodotemp;
 nodotemp=testa;
 Lista*ptr=NULL;
 int c=0;//contatore dei nodi attraversati
 
 if(nodonuovo!=NULL)
   {
   	nodonuovo->dato=x;
   	nodonuovo->nextnodo=NULL;
   while(nodotemp!=NULL && c!=p)
        {
        c++;
        ptr=nodotemp;
		nodotemp=nodotemp->nextnodo;	
		}
   if(ptr==NULL)
     {
     nodonuovo->nextnodo=testa;
	 testa=nodonuovo;		
	 }
     else
        {
        ptr->nextnodo=nodonuovo;
		nodonuovo->nextnodo=nodotemp;	
		}
   }
   else
      printf("\nspazio in memoria esaurito\n");
	  	
 return testa;	
}
