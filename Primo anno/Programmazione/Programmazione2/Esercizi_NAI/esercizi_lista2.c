  /*1)creare una funzione che:
   -crea una lista L1 contenente 10 nodi (il primo nodo deve contenere il valore 1, il secondo nodo 
   deve contenere il valore 2 e così via sino all'ultimo che deve contenere 10).
  2)creare una funzione che:
  -crea una lista L2 inserendovi solo gli elementi dispari di L1.
  3)creare una funzione che:
  -crea una lista L3 inserendovi solo gli elementi pari di L1.
  4)creare una funzione che:
  -concatena ad L2 la lista L3 (quindi L2 conterrà tanti elementi quanti L1).*/

#include<stdio.h>
#include<stdlib.h>

struct nodo
{
 int dato;	
 struct nodo*nextnodo;
};

typedef struct nodo Lista;

Lista*crea_lista(int n);//lista principale
void stampa_lista(Lista*testa);//funzione aggiunta rispetto a quelle richieste per poter visualizzare i risultati
Lista*crea_listaL2(Lista*testa);
Lista*crea_listaL3(Lista*testa);
void concatena_liste(Lista*testaL2,Lista*testaL3);

int main(void)
{
 Lista*testa_lista1;	
 int x=10;//imposto x=10 dato che gli elementi della prima lista devono essere 10
 
 testa_lista1=crea_lista(x);
 printf("\nLista iniziale\n");
 stampa_lista(testa_lista1); 
 
 Lista*testa_lista2;
 testa_lista2=crea_listaL2(testa_lista1);
 printf("\nLista numeri dispari\n");
 stampa_lista(testa_lista2);
 
 Lista*testa_lista3;
 testa_lista3=crea_listaL3(testa_lista1);
 printf("\nLista numeri pari\n");
 stampa_lista(testa_lista3);
 
 concatena_liste(testa_lista2,testa_lista3);
 printf("\nStampa delle due liste concatenate\n");
 stampa_lista(testa_lista2);
 
 free(testa_lista1);
 free(testa_lista2);
 free(testa_lista3);
 
 return 1;	
}

Lista*crea_lista(int n)
{
 Lista*testa;
 Lista*nodotemp;
 Lista*coda;
 
 int i=1;
 
 for(i=1;i<=n;i++)
    {
    if(i==1)
	  {
	  testa=malloc(sizeof(Lista));	
	  if(testa!=NULL)
	    {
	    coda=testa;
		testa->dato=i;	
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
		   coda->dato=i;
		   coda->nextnodo=NULL;
		   }
		   else
		      {
		      printf("\narea di memoria non allocata\n");
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
 printf("NULL\n");	  	
}

Lista*crea_listaL2(Lista*testa)
{
 Lista*nodotemp;
 nodotemp=testa;	
 int cont=0;//conteggio elementi dispari della lista 1 e saranno anche gli elementi della lista2
 
 //il ciclo while mi dirà quanti elementi dispari ci sono nella lista1
 while(nodotemp!=NULL)
      {
	   if(nodotemp->dato% 2!=0)
	     cont++;
	   
	   nodotemp=nodotemp->nextnodo;
	  }	
 printf("\nconteggio elementi dispari:%d\n",cont);
 
 Lista*nodotemp1;//nodo temporaneo che mi va a scorrer la lista 1
 nodotemp1=testa;
 Lista*testa_L2;
 Lista*nodotemp_L2;
 Lista*coda_L2;
 int i=1;
 
 if(cont==0)
 {
 printf("\nnon esistono valori dispari nella lista 1\n");
 }
 else
 {
 for(i=1;i<=cont;)
    {
     if(nodotemp1->dato% 2!=0)	
       {
       	if(i==1)
		  {
		  testa_L2=malloc(sizeof(Lista));
       	  if(testa_L2!=NULL)
       	    {
		    coda_L2=testa_L2;
		    testa_L2->dato=nodotemp1->dato;
		    testa_L2->nextnodo=NULL;
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
             nodotemp_L2=malloc(sizeof(Lista));	
			 if(nodotemp_L2!=NULL)
			   {
			   coda_L2->nextnodo=nodotemp_L2;	
			   coda_L2=nodotemp_L2;
			   coda_L2->dato=nodotemp1->dato;
			   coda_L2->nextnodo=NULL;
			   i++;
			   }
			   else
			      {
			      printf("\narea di memoria non allocata\n");	
			      return 0;	
				  }
			 }
	   }
    nodotemp1=nodotemp1->nextnodo;
	}
 }
 return testa_L2;
}

Lista*crea_listaL3(Lista*testa)
{
 Lista*nodotemp;
 nodotemp=testa;	
 int cont=0;//conteggio elementi dispari della lista 1 e saranno anche gli elementi della lista2
 
 //il ciclo while mi dirà quanti elementi dispari ci sono nella lista1
 while(nodotemp!=NULL)
      {
	   if(nodotemp->dato% 2==0)
	     cont++;
	   
	   nodotemp=nodotemp->nextnodo;
	  }	
 printf("\nconteggio elementi pari:%d\n",cont);
 
 Lista*nodotemp1;
 nodotemp1=testa;
 Lista*testa_L3;
 Lista*nodotemp_L3;
 Lista*coda_L3;
 int i=1;
 
 if(cont==0) 
   {
   printf("\nnon esistono elementi pari nella lista 1");
   }
 else
 {
 for(i=1;i<=cont;)
    {
     if(nodotemp1->dato% 2==0)	
       {
       	if(i==1)
		  {
		  testa_L3=malloc(sizeof(Lista));
       	  if(testa_L3!=NULL)
       	    {
		    coda_L3=testa_L3;
		    testa_L3->dato=nodotemp1->dato;
		    testa_L3->nextnodo=NULL;
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
             nodotemp_L3=malloc(sizeof(Lista));	
			 if(nodotemp_L3!=NULL)
			   {
			   coda_L3->nextnodo=nodotemp_L3;	
			   coda_L3=nodotemp_L3;
			   coda_L3->dato=nodotemp1->dato;
			   coda_L3->nextnodo=NULL;
			   i++;
			   }
			   else
			      {
			      printf("\narea di memoria non allocata\n");	
			      return 0;	
				  }
			 }
	   }
    nodotemp1=nodotemp1->nextnodo;
	}
 }
 return testa_L3;
}

void concatena_liste(Lista*testaL2,Lista*testaL3)
{
 Lista*nodotemp;
 nodotemp=testaL2;	
 while(nodotemp!=NULL)	
	  {
	  if(nodotemp->nextnodo==NULL)	
	  	{
	  	nodotemp->nextnodo=testaL3;
		break;  	
		}
	  nodotemp=nodotemp->nextnodo;
	  }
}
