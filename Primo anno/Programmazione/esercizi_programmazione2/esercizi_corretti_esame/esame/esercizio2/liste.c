#include"liste.h"

void fine(void)
{
 printf("\nPROGRAMMA TERMINATO\n");	
}

Lista*crea_lista(char parola[])
{
 Lista*testa,*nodo,*coda;
 int i=0;
 
 while(parola[i]!='\0')
      {
	   if(i==0)	  
	     {
		 testa=malloc(sizeof(Lista));
         if(testa==NULL)		 
		   {
		   printf("\nAREA DI MEMERIA NON ALLOCATA\n");   
		   exit(EXIT_FAILURE);
		   }
	        else
			   {
				coda=testa;   
				testa->lettera=parola[i];
                testa->nextnodo=NULL;				
			   }
		 }
         else
		    {
			nodo=malloc(sizeof(Lista));
            if(nodo==NULL)		 
		      {
		      printf("\nAREA DI MEMERIA NON ALLOCATA\n");   
		      exit(EXIT_FAILURE);
		      }
	          else
			     {
				 coda->nextnodo=nodo;	 
				 coda=nodo;   
				 coda->lettera=parola[i];
                 coda->nextnodo=NULL;				
			     }	
			}
	  i++;
	  }
	  
 return testa;
}

void stampa_lista(Lista*testa)
{
 if(testa==NULL)
    return;

  else
     {
	 printf("%c-->",testa->lettera);
	 return stampa_lista(testa->nextnodo);
	 }
}

int lista_simboli(Lista*testa)
{
 int cont=0;	
 if(testa==NULL)
	return 0;
 
 else
    {
	if(testa->lettera>32  && testa->lettera<48)
	  cont++;
    if(testa->lettera>123  && testa->lettera<126)
	  cont++;
    if(testa->lettera>58  && testa->lettera<64)
	  cont++;
	}
	
 return cont+lista_simboli(testa->nextnodo);
}

Lista*funzione3(Lista*testa1)
{
 Lista*testa,*nodo,*coda;	
 Lista*nodo1=testa1;
 int i=0;

 while(nodo1!=NULL)
      {
	  if(isalpha(nodo1->lettera)!=0)  
	    {
		if(nodo1->lettera!='A' && nodo1->lettera!='a' && nodo1->lettera!='E' && nodo1->lettera!='e' && nodo1->lettera!='I' 
		  && nodo1->lettera!='i'&& nodo1->lettera!='O'&& nodo1->lettera!='o'&& nodo1->lettera!='U' &&nodo1->lettera!='u')	
		  {
		  if(i==0)	  
		    {
		    testa=malloc(sizeof(Lista));
            coda=testa;
            testa->lettera=nodo1->lettera;
            testa->nextnodo=NULL;		  
		    }
		    else
			   {
			   nodo=malloc(sizeof(Lista));
               coda->nextnodo=nodo; 				
			   coda=nodo;
			   coda->lettera=nodo1->lettera;
			   coda->nextnodo=NULL;
			   }
		  }
		} 
	  nodo1=nodo1->nextnodo;
	  i++;
	  }	 
	  
 return testa;
}