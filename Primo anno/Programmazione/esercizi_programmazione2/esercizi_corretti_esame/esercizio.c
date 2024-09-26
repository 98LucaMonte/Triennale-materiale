#include<stdio.h>
#include<stdlib.h>

struct nodo
{
 int d;	
 struct nodo*next;
};

typedef struct nodo element;
typedef element*list;

list newnode()
{
 return (list)malloc(sizeof(element));	
}

list crea_lista()
{
 int x;
 printf("x:"); 
 scanf("%d",&x);
 list p;

 if(x<=0) 
    return NULL;
 
 else
    {
	p=newnode();
	p->d=x;
	p->next=crea_lista();
	return p;
	}
}

void stampa_lista(list l1)
{
 list p=l1;	
 
 while(p!=NULL)
 {
 printf("%d-->",p->d);	 
 p=p->next;
 }	 
 printf("NULL\n");
}

void funz(list l1,int n,int *cont,int *result)
{
 if(l1=NULL)
    return;	 
	
 else
 {
 if(l1->d==n)	 
	(*cont)++;
    else
	(*cont)=0;
 
 if((*cont)>=2)
    (*result)++;
 }	 
 
 return funz(l1->next,n,cont,result);
}

int main(void)
{
 list testa; 
 int cont=0,result=0;
 
 testa=crea_lista();
 stampa_lista(testa);
 funz(testa->next,2,&cont,&result);
 printf("\nresult=%d",result);
 
 return 1;	
}