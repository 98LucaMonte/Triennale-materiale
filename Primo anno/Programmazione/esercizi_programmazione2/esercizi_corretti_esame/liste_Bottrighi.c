// LISTE - BOTTRIGHI

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct node
{
	int d;
	struct node *next;
};

typedef struct node element;
typedef element *list;
// typedef struct node *list;

int node_number ();
list make_list (int n);
void print_list (list listPtr);
int cerca_massimo(list L1,int x);
list funzione(list L1,int x);
list funzione1(list L1,int x);
void funzione2(list*l1,int x);
list newnode();
int esercizio1(list l1,int x);
void esercizio2(list l2,int k,list*node,int *pos);

int main (void)
{
	srand (time (NULL));
	
	list listPtr,p;
	int n;
	
	n = node_number ();
	listPtr = make_list (n);
	print_list (listPtr);
	
	int output;
	output=esercizio1(listPtr,1);
	printf("\nOutput:%d\n",output);
	
	return 0;
}

void funzione2(list*l1,int x)
{
	list p;
	
	while(*l1!=NULL)
	     {
		 if((*l1)->d==x)	 
		 {
		  p=newnode();
		  p->d=x+1;
		  p->next=(*l1)->next;
		  (*l1)->next=p;
		 }
	     *l1=(*l1)->next;
		 }
}

list newnode()
{
 return (list)malloc(sizeof(element));	
}

int node_number ()
{
	int n;
	
	do
	{
		printf ("Quanti nodi (0-20)? ");
		scanf ("%d", &n);
		
		if (n < 0 || n > 20)
			printf ("In numero dei nodi deve essere compreso tra 0 e 20\n");
	}
	while (n < 0 || n > 20);
	
	return n;
}

list make_list (int n)
{
	if (n == 0)
		return NULL;
	
	int i;
	list headPtr;
	list tailPtr;
	list tempPtr;
	
	headPtr = (list) malloc (sizeof (element));
	// headPtr = malloc (sizeof (element));
	// headPtr = malloc (sizeof (list));
	
	if (headPtr == NULL)
	{
		printf ("Errore! Richiesta di allocazione memoria dinamica fallita\n");
		return headPtr;
	}
	
	headPtr -> d = 1 + rand () % 2;
	headPtr -> next = NULL;
	tailPtr = headPtr;
	
	for (i = 1; i < n; i++)
	{
		tempPtr = (list) malloc (sizeof (element));
		// tempPtr = malloc (sizeof (element));
		// tempPtr = malloc (sizeof (list));
		
		if (tempPtr == NULL)
		{
			printf ("Errore! Richiesta di allocazione memoria dinamica fallita\n");
			return headPtr;
		}
		
		tailPtr -> next = tempPtr;
		tempPtr -> d = 1 + rand () % 2;
		tempPtr -> next = NULL;
		tailPtr = tempPtr;
	}
	
	return headPtr;
}

void print_list (list listPtr)
{
	int i = 0;
	
	while (listPtr != NULL)
	{
		printf ("Valore contenuto nel nodo(%p) %d: %d\n",listPtr, i, listPtr -> d);
		i++;
		listPtr = listPtr -> next;
	}
}

list funzione(list L1,int x)
{
 int max;
 list p;
 if(L1!=NULL)
    {
	max=cerca_massimo(L1,x);
    
    while(L1!=NULL)	
	     {
		 if(L1->d==max)	  
		    {
			p=L1;	
			break;
			}
	     L1=L1->next;
		 }
	}	 
 
 return p; 
}

int cerca_massimo(list L1,int x)
{
 int max,i=0;	
 
 while(L1!=NULL)
      {
	  if(L1->d%x==0)	  
	     {
		 if(i==0)	 
		   {
			max=L1->d;   
		   }
	       else if(max<L1->d)
			      {
			      max=L1->d;
			      }
		 } 
	  L1=L1->next;
	  i++;
	  }
 
 return max; 
}

list funzione1(list L1,int x)
{
 list p;	
 p=NULL;
 
 while(L1!=NULL)
      {
	  if(L1->d%x==0)	  
	    {
		 if(p==NULL)	
		 {
		 p=L1;	 
		 }
	     else if(p->d<L1->d)
		    {
			p=L1;	
			}
		} 
	  L1=L1->next;
	  }	 
 
 return p;
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
 
 if(k==0 && (*pos)==1)
   {
    p=l2;	   
    l2=l2->next;
    free(p);
	return;
   }	 
  else if(k==0 && (*pos)!=1)
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