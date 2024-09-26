#include<stdio.h>
#include<stdlib.h>
#include<time.h>

struct nodo
{
 int dato;	
 struct nodo*nextnodo;	
};

typedef struct nodo Lista;

Lista*crea_lista(int n);
Lista*elimina_nodi(Lista*testa,int p);
Lista*aggiungi_nodo(Lista*testa,int p,int x);
int cerca_posizione(Lista*testa,int x);
int conteggio_elementi();
void stampa_lista(Lista*testa);

int main()
{
 int dim;
 
 printf("\nInserisci dimensione lista:");
 scanf("%d",&dim);
 Lista*testa_lista=crea_lista(dim);	
 printf("\n\nstampo prima lista\n\n");
 stampa_lista(testa_lista);
 
 int i=0,pos,val;

 printf("\n\nInserisci valore da eliminare dalla prima lista:");
 scanf("%d",&val);
 
 for(i=0;i<dim;i++)
    {
    pos=cerca_posizione(testa_lista,val);	
    if(pos>=0)
	  {
	  testa_lista=elimina_nodi(testa_lista,pos);	
	  }	
	i++;
	}
 
 printf("\n\nstampa lista senza il valore:%d\n\n",val);
 stampa_lista(testa_lista);
 
 int newnodo,pos1;
 
 Lista*testa_lista2=crea_lista(dim);
 printf("\n\nstampo seconda lista\n\n");
 stampa_lista(testa_lista2);
 printf("\n\ninserisci il valore del nuovo nodo che verra' inserito nella seconda lista:");
 scanf("%d",&newnodo);
 
 do
  {
  printf("\nInserisci la posizione in cui inserire il nuovo nodo:");
  scanf("%d",&pos1);
  if(pos1>=dim || pos1<0)
    printf("\n\nErrore la posizione inserita non esiste\n\n");	
  }
 while(pos1>=dim || pos1<0);
 
 testa_lista2=aggiungi_nodo(testa_lista2,pos1,newnodo);
 stampa_lista(testa_lista2);
 
 free(testa_lista);
 free(testa_lista2);
 	
 return 1;
}

Lista*crea_lista(int n)
{
 Lista*testa;
 Lista*nodotemp;
 Lista*coda;
 int i=0;
 	
 srand(time(NULL));	
 for(i=0;i<n;i++)
    {
    if(i==0)	
      {
      testa=malloc(sizeof(Lista));
	  if(testa!=NULL)
	    {
	    coda=testa;
		testa->dato=rand()% 10;	
		testa->nextnodo=NULL;
		}	
	    else
	       {
	       printf("\nArea di memoria non allocata\n");	
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
		   coda->dato=rand()% 10;	
		   coda->nextnodo=NULL;
		   }	
		   else
		      {
		      printf("\nArea di memoria non allocata\n");	
	          return 0;	
			  }
		 }
	}	
 
 return testa;
}

void stampa_lista(Lista*testa)
{
 Lista*nodotemp=testa;
 int i=0;
 
 while(nodotemp!=NULL)
      {
      if(i% 5==0)
	  	{
	  	printf("\n");	
		}
	    printf("%d\t",nodotemp->dato);
	    i++;
	    nodotemp=nodotemp->nextnodo;
	  }
 printf("\n\n");  	
}

int cerca_posizione(Lista*testa,int x)
{
 Lista*nodotemp=testa;
 int pos=-1,cont=0;
 
 
 while(nodotemp!=NULL)
      {
      if(nodotemp->dato==x)	
      	{
      	pos=cont;	
		break;
		}
	  cont++;
	  nodotemp=nodotemp->nextnodo;
	  }	
 
 return pos;	
}

Lista*elimina_nodi(Lista*testa,int p)
{
 Lista*nodotemp=testa;
 
 if(p==0)	
   {
   testa=nodotemp->nextnodo;
   free(nodotemp);	
   return testa;	
   }
   
 nodotemp=testa;
 int pos=0;
 
 while(nodotemp!=NULL && pos!=p-1)  
   	  {
   	  pos++;
	  nodotemp=nodotemp->nextnodo;	 	
	  }
 
 Lista*nodocanc;	  
 nodocanc=nodotemp->nextnodo;
 nodotemp->nextnodo=nodotemp->nextnodo->nextnodo;
 free(nodocanc);	  
 	
 return testa;	
}

Lista*aggiungi_nodo(Lista*testa,int p,int x)
{
 Lista*nodonuovo=malloc(sizeof(Lista));
 Lista*nodotemp=testa;
 Lista*nodotemp1=NULL;
 int cont=0;//contatore nodi attraversati
 
 if(nodonuovo!=NULL)
   {
   nodonuovo->dato=x;
   nodonuovo->nextnodo=NULL;	
   //se siamo nella testa della lista oppure siamo nella coda non entriamo nel ciclo 
   while(cont!=p && nodotemp!=NULL)	
        {
        cont++;	
        nodotemp1=nodotemp;
		nodotemp=nodotemp->nextnodo;	
		}
   
   //se entriamo dentro questa condizione vuol dire che siamo nella testa della lista		
   if(nodotemp1==NULL)
     {
     nodonuovo->nextnodo=testa;	
     testa=nodonuovo;	
	 }
     else
	    {
	    nodotemp1->nextnodo=nodonuovo;
		nodonuovo->nextnodo=nodotemp;	
		} 
   }	
   else
      {
	  printf("\narea di memoria non allocata per il nuovo nodo da inserire\n");
	  return 0;
	  }	
	
 return testa;
}
