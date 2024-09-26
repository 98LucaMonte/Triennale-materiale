#include<stdio.h>
#include<stdlib.h>
#include<time.h>
/*
1.crea la prima lista
2.visualizza prima lista
3.conteggio elementi prima lista
4.ricerca elemento nella lista
5.crea la seconda lista
6.concatena le due liste 
7.elimina nodi con un determinato valore e ristampa lista aggiornata
*/
struct nodo
{
 int dato;	
 struct nodo*nextnodo;	
};

typedef struct nodo Lista;
Lista*crea_lista();
void visualizza_lista(Lista*testa);
int conteggio_elementi(Lista*testa,int valore);
int ricerca_elemento(Lista*testa);
int cerca_nodo_canc(Lista*testa,int val);
Lista*concatena_liste(Lista*testa1,Lista*testa2);
Lista*elimina_nodi(Lista*testa,int pos);


int main(void)
{
 Lista*testa_lista=crea_lista();	
 printf("\nstampo lista numero 1\n");
 visualizza_lista(testa_lista);	
 
 int val;
 
 printf("\ninserire valore da cercare nella lista="); 
 scanf("%d",&val);
 
 unsigned int conteggio=conteggio_elementi(testa_lista,val);
 if(conteggio==0)
   printf("\nNella lista e'assente il valore %d\n",val);
   else
   printf("\nNella lista il valore %d e' presente %d\n",val,conteggio);
 
 int posizione=ricerca_elemento(testa_lista);
 if(posizione==-1)
   printf("\n\nIl numero cercato e' assente\n");
   else
   printf("\n\nIl valore cercato si trova nella prima occorenza in posizione %d",posizione); 
 
 Lista*testa_lista2=crea_lista();
 printf("\n\nstampo lista numero 2\n");
 visualizza_lista(testa_lista2);
 
 testa_lista=concatena_liste(testa_lista,testa_lista2);
 printf("\n\nStampa Lista 1 e lista 2 concatenate\n");
 visualizza_lista(testa_lista);
  
 Lista*testa_lista3=crea_lista();
 printf("\n\n\nstampo lista 3\n\n");
 visualizza_lista(testa_lista3);
 
 int dato,pos;
 printf("\n\ninserire il dato che si vuole eliminare dalla lista3:");
 scanf("%d",&dato);
 
 int i=1;
 
 while(i<=15 || pos==-1)
      {
      pos=cerca_nodo_canc(testa_lista3,dato);
      if(pos>=0)
        {
        testa_lista=elimina_nodi(testa_lista3,pos);
        }
        i++;
      }
 
 visualizza_lista(testa_lista3);
 
 free(testa_lista);
 free(testa_lista2);
 	
 return 1;	
}

Lista*crea_lista()
{
 Lista*testa;
 Lista*nodotemp;
 Lista*coda;
 int i=0;
 
 srand(time(NULL));
 for(i=0;i<=14;i++)
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
		   exit(EXIT_FAILURE);
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
		           exit(EXIT_FAILURE);	
				   }
			  }
	  }
	
	
 return testa;
}

void visualizza_lista(Lista*testa)
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
}

int conteggio_elementi(Lista*testa,int valore)
{
 Lista*nodotemp=testa;
 unsigned int cont=0;
 
 while(nodotemp!=NULL)
      {
      if(nodotemp->dato==valore)
	    {
	    cont++;	
		}	
	    nodotemp=nodotemp->nextnodo;
	  }	
	
 return cont;
}

int ricerca_elemento(Lista*testa)
{
 Lista*nodotemp=testa;	
 int pos=-1,x,i=0;
 
 printf("\n\nInserire il numero da cercare nella lista:");
 scanf("%d",&x);
  
 while(nodotemp!=NULL)
      {
       i++;
	   if(nodotemp->dato==x)	
      	 {
      	 pos=i; 	
		 return pos;
		 }
	     else
	        {
	        nodotemp=nodotemp->nextnodo;	
			}
	  }
	  
 return pos;
}

Lista*concatena_liste(Lista*testa1,Lista*testa2)
{
 Lista*nodotemp=testa1;
 
 while(nodotemp!=NULL)
      {
	   if(nodotemp->nextnodo==NULL)
	     {
	     nodotemp->nextnodo=testa2;	
	     return testa1;	
		 }
	   nodotemp=nodotemp->nextnodo;
	  }	
 return testa1;
}

int cerca_nodo_canc(Lista*testa,int val)
{
 Lista*nodotemp=testa;
 int pos=-1,trovato=-1;
 
 while(nodotemp!=NULL)
      {
       pos++;	
       if(nodotemp->dato==val)
	   	 {
	     trovato=pos;
		 break;	 
		 }
	   nodotemp=nodotemp->nextnodo;
	  }
	  
 return trovato;	
}

Lista*elimina_nodi(Lista*testa,int pos)
{
 Lista*nodotemp=testa;	
 int pos1=0;//posizione precedente a quella che dobbiamo cancellare
 Lista*nodocanc;
 if(pos==0)
   {
   testa=nodotemp->nextnodo;
   free(nodotemp);
   return testa;
   }	
   else
      {
	  nodocanc=testa;
      while(pos1==pos-1 && nodocanc!=NULL)  
  	      {
  	      pos1++;
	      nodocanc=nodocanc->nextnodo;			
	      }	
      }
      
 Lista*nodotemp2=nodocanc->nextnodo->nextnodo;
 free(nodocanc->nextnodo);
 nodocanc->nextnodo=nodotemp2;
 
 return testa;
}

