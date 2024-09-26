/*
Scrivere una funzione in iterazione che presa in input una lista e un intero x restituisce 
il puntatore al massimo valore multiplo di x, in caso di valori uguali si consideri la prima istanza
*/

struct nodo
{
 int d;	
 struct nodo*next;
};

typedef struct nodo element;
typedef element*list;

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

void funzione2(list*l1,int x)
{
	list p;
	
	while(*l1=!=NULL)
	     {
		 if(*l1->d==x)	 
		 {
		  p=newnode();
		  p->d=x+1;
		  p->next=*l1->next;
		  *l1=p;
		 }
	     *l1=*l1->next;
		 }
}