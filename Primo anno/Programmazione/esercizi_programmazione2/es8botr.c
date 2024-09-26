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
int funzione8(Lista*testa);

int main(void)
{
 int x=15,n=2,m=5;
 Lista*testa=crea_lista(x);
 printf("\nStampa prima lista\n");
 stampa_lista(testa);
 
 int result;
 result=funzione8(testa);
 printf("result:%d",result);
 
 return 0;
}

int funzione8(Lista*testa)
{
  Lista*nodotemp=testa;	
  int cont=1,n=1,output=1,y;	
  
  while(nodotemp!=NULL)
       {
		if(n==1)  
		  {
		  y=nodotemp->dato;	  
		  n++;
		  }
          else if(y==nodotemp->dato)
		         {
				 cont++;				  
				 }
	              else
				     {
					 if(output<cont)
					   {    
					   output=cont;
					   }
					 y=nodotemp->dato;	 
					 cont=1; 
					 }
		nodotemp=nodotemp->nextnodo;
	   }
	   
  return output;
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
    printf("Nodo:%d\n",testa->dato);		
	return stampa_lista(testa->nextnodo);
	}
}