/*Scrivere un programma che esegua le seguenti funzionalità:
1)nel main, chiedere all'utente quanti nodi della lista si desiderano creare 
  (n deve essere > 0 e minore o uguale a 20);

2)creare una funzione che ha in input il numero n di nodi da creare e genera 
  quindi n nodi contenenti numeri casuali tra 17 e 30;

3)creare una funzione che visualizza la lista;

4)scrivere una funzione che elimina dalla lista tutti i nodi contenenti il valore 17;
4.1) visualizzare la lista nel main tramite la funzione del punto 3);

5)scrivere una funzione che crea una seconda lista contenente solo i nodi
  che hanno valori (membro ->data) dal 28 (compreso) al 30 (compreso);
5.1) visualizzare la lista nel main tramite la funzione del punto 3).*/

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
void stampa_lista(Lista*testa);
Lista*elimina_nodi(Lista*testa,int posizione);
Lista*crea_lista1(Lista*testa);
int cerca_nodo(Lista*testa,int valorenodo); 

int main(void)
{

 int dim;//dimensione della lista
 
 //faccio un ciclo do while per far inserire i nodi della lista in modo tale che siano tra 0 e 20 nodi
 do
 {
 printf("\nInserire la dimensione della lista:");
 scanf("%d",&dim);
 if(dim<=0 || dim>20)
   printf("\nErrore la lista deve avere almeno un elemento ma meno di venti elementi\n");	
 }	
 while(dim<=0 || dim>20);
 
 printf("\nstampa lista con valori casuali\n");
 Lista*testa_lista1=crea_lista(dim);//creo una nuova lista
 stampa_lista(testa_lista1);//stampo la nuova lista creata nella funzione crea_lista
 
 //creo una lista con i valori che vanno dal 28 al 30 che sono contenuti nella lista creata precedentemente 
 Lista*testa_lista2=crea_lista1(testa_lista1);
 stampa_lista(testa_lista2);//stampo la nuova lista
 
 int x=17;//valore che contengono i nodi che devono essere cancellati 
 int i=1,pos;
 
 for(i=1;i<=dim;i++)
    {
     pos=cerca_nodo(testa_lista1,x);
       if(pos>=0)
       {
        testa_li
		sta1=elimina_nodi(testa_lista1,pos);
       }
    }
 
 printf("\nStampa lista senza i nodi con valore %d\n",x);
 stampa_lista(testa_lista1);
 
 free(testa_lista1);
 free(testa_lista2);
 
 return 0;	
}

//Funzione punto 2 crea lista
/**
*parametro n:passa alla funzione il numero di nodi presenti nella lista
*return:la funzione ritorna al main la testa della lista appena creata
*see:-
**/

Lista*crea_lista(int n)
{
 int i=0;
 Lista*testa;  
 Lista*nodotemp;
 Lista*coda;
 
 srand(time(NULL));
 for(i=0;i<n;i++)
    {
    if(i==0)	
      {
      testa=malloc(sizeof(Lista));
	  if(testa!=NULL)
	    {
		coda=testa;
		testa->dato=17+rand()% 14;
		testa->nextnodo=NULL;
		}	
	    else
	       {
	       	printf("\narea di memoria non allocata\n");
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
		   coda->dato=17+rand()% 14;
		   coda->nextnodo=NULL;
		   }	
     	 }
	}
 
 return testa;	
}

//Funzione punto 3 stampa lista
/**
*parametro testa:porto per riferimento alla funzione la testa della lista che voglio stampare
*return:-
*see:-
**/

void stampa_lista(Lista*testa)
{
 Lista*nodotemp;//creo un nodotemporaneo per poter scorrere la lista
 nodotemp=testa;
 int i=1;
 
 while(nodotemp!=NULL)
      {
      printf("%d\t",nodotemp->dato);	
      if(i% 5==0)	
	    {
		printf("\n");
	    }
      i++;
	  nodotemp=nodotemp->nextnodo;//assegno il nodo successivo al nodotemporaneo in modo di poter scorrere la lista
	  }
 printf("\n");
}

//funzione punto 5 crea lista con valori compresi tra il 28 e la 30
/**	
*parametro testa:porto per riferimento alla funzione la testa della lista creata in precedenza nella 
 funzione crea_lista1	
*return:la funzione ritorna al main la testa della lista appena creata	
*see:-
**/

Lista*crea_lista1(Lista*testa)
{
 Lista*nodotemp;//dichiaro questo nodotemporaneo per poter scorrere i nodi di questa lista
 nodotemp=testa;//e dichiaro la variabile cont per poter contare i nodi che hanno il campo dato
 int cont=0;    //compreso tra 28 e 30 con 28 e 30 compresi
 
 while(nodotemp!=NULL)
      {
      if(nodotemp->dato>=28 && nodotemp->dato<=30)	
      	{
		cont++;
		}
	  nodotemp=nodotemp->nextnodo;
	  }
 
 Lista*nodotemp2;//dichiaro un altro nodotemporaneo per poter riscorrere la lista
 nodotemp2=testa;
 //dichiaro la testa,il nodotemp e la coda della nuova lista che sto andando a creare
 Lista*testa1;   
 Lista*nodotemp1;
 Lista*coda1;    
 int i=0;
 
 if(cont==0)
   {
   printf("\nNella lista non sono presenti elementi che vanno dal 28 al 30\n");
   printf("\nla seconda che dovrebbe contenere i valori da 28 a 30 e'vuota\n");
   return 0;	
   }
   else
      {
      printf("\nNella lista sono presenti %d elemento/i che vanno dal 28 al 30\n",cont);
      printf("\nstampo seconda lista con valori che vanno dal 28 al 30\n");
      for(i=0;i<cont;)
         {
		 if(nodotemp2->dato>=28 && nodotemp2->dato<=30)
		   {
		   if(i==0)	
		     {
		     testa1=malloc(sizeof(Lista));	 
			 if(testa1!=NULL)
			   {
			   coda1=testa1;	
			   testa1->dato=nodotemp2->dato;
			   testa1->nextnodo=NULL;	
			   i++;
			   }
			   else
			      {
			      printf("\narea di memoria non allocata\n");	
			      return 0;	
				  }
			 }	
		     else
		        {
		        nodotemp1=malloc(sizeof(Lista));	
		        if(nodotemp1!=NULL)
				  {
				  coda1->nextnodo=nodotemp1;
				  coda1=nodotemp1;
				  coda1->dato=nodotemp2->dato;
				  coda1->nextnodo=NULL;
				  i++;
				  }	
				  else
				     {
				     printf("\narea di memoria non allocata\n");	
			         return 0;	
					 }
				}
		   }
		 nodotemp2=nodotemp2->nextnodo;
		 }   
	  }
	  
 return testa1;	
}

//Funzione punto 4 elimina i nodi con valori nel campo dato uguale a 17
/**
*parametro testa:porto per riferimento alla funzione la testa della lista creata in precedenza nella 
 funzione crea_lista1
*parametro posizione:porto nella funzione il valore della posizione o meglio dove si trova il nodo da eliminare
*return:la funzione ritorna al main la testa della lista modificata
*see:-
**/

Lista*elimina_nodi(Lista*testa,int posizione)
{
 
 Lista*nodotemp;
 nodotemp=testa;
 int cont= 0;
 Lista*nodotemp1;
 if(posizione==0)
   {
	testa=nodotemp->nextnodo;
	free(nodotemp);
	return testa;
   }
   else if(posizione>0)
          {
	      while(nodotemp!=NULL && cont!=posizione-1)
               {
		       cont++;
		       nodotemp=nodotemp->nextnodo;
               }
          nodotemp1=nodotemp->nextnodo->nextnodo;
	      free(nodotemp->nextnodo);
	      nodotemp->nextnodo=nodotemp1;
          }
	
 return testa;	
}

//Funzione cerca_nodo
/**
*parametro testa:porto per riferimento alla funzione la testa della lista creata in precedenza nella 
 funzione crea_lista1
*parametro valorenodo:porto nella funzione il valore che devono avere i nodi nel campo data che verrano 
poi eliminati nella funzione elimina_nodi
*return:la funzione ritorna al main la testa della lista modificata
*see:-
**/

int cerca_nodo(Lista*testa,int valorenodo)
{
 Lista*nodotemp;
 nodotemp=testa;
 int trovato=-1;
 int cont=-1;
    
 while(nodotemp!=NULL)
      {
	  cont++;
      if(nodotemp->dato==valorenodo)
        {
		trovato=cont;
		break; 
		}
		nodotemp=nodotemp->nextnodo;
	  }
	  
 return trovato;		
}
