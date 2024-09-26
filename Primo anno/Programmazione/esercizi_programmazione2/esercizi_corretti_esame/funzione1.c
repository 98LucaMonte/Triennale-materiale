/*
Scrivere una funzione in ricorsione che prese in input due liste e un intero n, 
calcoli se dopo la posizione n le due liste sono uguali (ovvero i nodi hanno la stessa parte dati)
restituisca 1 in caso affermativo altrimenti 0.
*/

#include<stdio.h>
#include<stdlib.h>

struct nodo
{
 int d;
 struct nodo*next;
};

typedef struct nodo element;
typedef element *list;

list newnode()
{
	return (list) malloc(sizeof(element)); 	
}

list crea_lista()
{
 int x;
 printf("x:"); 
 scanf("%d",&x);
 
 if(x<0)
    return NULL;
 
 else
 {
 list p;
 p=newnode(); 
 p->d=x;
 p->next=crea_lista();
 return p; 
 }

}


void stampa(list L1)
{
 if(L1==NULL)	
 {
 printf("NULL\n");	 
 return;
 }
 else
    {
		printf("%d-->",L1->d);
	    stampa(L1->next);
	}
}

int funzione(list L1,list L2,int n)
{
 if(L1==NULL && L2==NULL)
   return 1;
 
 if(L1!=NULL && L2==NULL)
	return 0;
 
 if(L1==NULL && L2!=NULL)
	return 0;
 
 if(L1!=NULL && L2!=NULL)
   {
	   if(n==0)
       {
		  if(L1->d==L2->d)
          {   
		  return funzione(L1->next,L2->next,n);	  
		  }		  
	      else
		  { 
		  return 0;
	      }
	   }
       else
	   {	   
	   return funzione(L1->next,L2->next,n-1);
	   }
   }
}

int esercizio1(list l1,int x)
{
int cont=0,result=0;

while(l1!=NULL)
{
if(l1->d==x)
   cont++;
   else
    cont=0;

if(cont>result)
  result=cont;

l1=l1->next;
}	
	
return result;	
}

void esercizio2(list l2,int k,list*node,int *pos)
{
 list p;

 if(l2==NULL)
   return;	 
 
 if(k==1 && (*pos)==1)
   {
    p=l2;	   
    l2=l2->next;
    free(p);
	return;
   }	 
  else if(k==1 && (*pos)!=1)
         {
		 p=l2;	 
		 (*node)->next=l2->next;
		 free(p);
		 return;
		 }
		 else
		    {
			*node=l2;	
	        esercizio2(l2->next,k-1,node,pos+1);	  
            }
}

int main(void)
{
 list L1,L2;
 
 L1=crea_lista();
 stampa(L1);
 
 int out;
 out=esercizio1(L1,1);
 printf("\nout=%d\n\n",out);
 
 int posizione=1;
 list node;
 
 L2=crea_lista();
 stampa(L2);
 esercizio2(L2,6,&node,&posizione);
 stampa(L2);
 
 return 0;
}