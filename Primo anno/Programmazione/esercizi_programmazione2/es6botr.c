#include<stdio.h>
#include<stdlib.h>

struct nodo
{
 int dato;
 struct nodo*nextnodo;
};

typedef struct nodo Lista;

Lista*crea_lista(int n);
void stampa_lista(Lista*testa);
Lista*funzione6(Lista*testa,Lista*testa1,int n,int m);

int main(void)
{
 int x=8,n=2,m=5;
 Lista*testa=crea_lista(x);
 printf("\nStampa prima lista\n");
 stampa_lista(testa);
 printf("NULL\n");
 
 Lista*testa1=crea_lista(x);
 printf("\nStampa seconda lista\n");
 stampa_lista(testa1);
 printf("NULL\n");
 
 Lista*testa2=funzione6(testa,testa1,n,m);
 printf("\nStampa terza lista\n");
 stampa_lista(testa2);
 printf("NULL\n");
 
 return 0;
}

Lista*funzione6(Lista*testa,Lista*testa1,int n,int m)
{
 Lista*nodotemp=testa,*nodotemp1=testa1;		
 Lista*testa2,*nodo2,*coda2;
 int i=1;
 while(nodotemp!=NULL && nodotemp1!=NULL)
      {
	   if(i<=n)
	      {
		  if(i==1)
			 {
		     testa2=malloc(sizeof(Lista));	  
		     coda2=testa2;
		     testa2->dato=nodotemp->dato;
		     testa2->nextnodo=NULL;
		     }
		  	 else
		        {
			    nodo2=malloc(sizeof(Lista));	 
			    coda2->nextnodo=nodo2;
			    coda2=nodo2;
			    coda2->dato=nodotemp->dato;
			    coda2->nextnodo=NULL;
			    }
	      }
       
       if(i>n && i<m)	   
	     {
	     nodo2=malloc(sizeof(Lista));	 
		 coda2->nextnodo=nodo2;
		 coda2=nodo2;
		 coda2->dato=nodotemp->dato+nodotemp1->dato;
		 coda2->nextnodo=NULL;		 
		 }
	   
	   if(i>=m)
	     {
		 nodo2=malloc(sizeof(Lista));	 
		 coda2->nextnodo=nodo2;
		 coda2=nodo2;
		 coda2->dato=nodotemp1->dato;
		 coda2->nextnodo=NULL;		 
		 }
		 i++;
		 nodotemp1=nodotemp1->nextnodo;
		 nodotemp=nodotemp->nextnodo;
      } 
 
 return testa2;	
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
	    printf("area di memroia non allocata");		
		exit(EXIT_FAILURE);
		}
		else
		    {
			printf("Inserire nodo:");
			scanf("%d",&testa->dato);  
		    testa->nextnodo=crea_lista(n-1);	 
			}
     }
 return testa;
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


