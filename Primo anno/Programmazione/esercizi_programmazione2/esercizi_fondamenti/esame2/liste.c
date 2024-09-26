#include"liste.h"

void fine(void)
{
 printf("\nPROGRAMA TERMINATO\n");	
}

Lista*crea_lista(char parola[])
{
 int i=0;
 Lista*testa,*nodo,*coda;
 
 while(parola[i]!='\0')
      {
	  if(i==0)
	     {
		 testa=malloc(sizeof(Lista));
         if(testa==NULL)
		   {
			printf("\nAREA DI MEMORIA NON ALLOCATA\n");   
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
			   printf("\nAREA DI MEMORIA NON ALLOCATA\n");   
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

int lista_vocali(Lista*testa)
{
 int cont=0;	
 if(testa==NULL)
	return 0;
 
 if (testa->lettera=='A' || testa->lettera=='a' || testa->lettera=='E'|| testa->lettera=='e'|| testa->lettera=='I'||testa->lettera=='i'
    ||testa->lettera=='O'|| testa->lettera=='o'||testa->lettera=='U'||testa->lettera=='u')
	{
	cont++; 	
	} 
 return cont+lista_vocali(testa->nextnodo);
}

Lista*lista_consonanti(Lista*testa)
{
 Lista*testa1,*nodo1,*coda1;
 Lista*nodo=testa;
 int i=0,cont=0;
 
 while(nodo!=NULL)
       {
		if(nodo->lettera!='A' && nodo->lettera!='a' && nodo->lettera!='E'&& nodo->lettera!='e'&& nodo->lettera!='I'&& nodo->lettera!='i'
           &&nodo->lettera!='O'&& nodo->lettera!='o'&& nodo->lettera!='U'&& nodo->lettera!='u')   
		   {
	       cont++;
		   if(i==0)
		     {
			 testa1=malloc(sizeof(Lista));
             if(testa1==NULL)
			   {
			   printf("\nAREA DI MEMORIA NON ALLOCATA\n");   
		       exit(EXIT_FAILURE);  
			   }				 
		       else
			      {
				  coda1=testa1;
				  testa1->lettera=nodo->lettera;
				  testa1->nextnodo=NULL;
				  }
			 }
	         else
				{
			     nodo1=malloc(sizeof(Lista));
                 if(nodo1==NULL)
			       {
			       printf("\nAREA DI MEMORIA NON ALLOCATA\n");   
		           exit(EXIT_FAILURE);  
			       }				 
		           else
			          {
				      coda1->nextnodo=nodo1;
					  coda1=nodo1;
				      coda1->lettera=nodo->lettera;
				      coda1->nextnodo=NULL;
				      }
			    }
		   }
	   i++;
	   nodo=nodo->nextnodo;
	   }
 if(cont==0)
    { 
    testa1=NULL;
	}	 
 
 return testa1;
}

Lista*lista_cifrata(Lista*testa)
{
 Lista*testa1,*nodo1,*coda1;
 Lista*nodo=testa;
 int i=0;
 while(nodo!=NULL)
      {
	  if(i==0)	  
	    {
		 testa1=malloc(sizeof(Lista));
         if(testa1==NULL)
		   {
		   printf("\nAREA DI MEMORIA NON ALLOCATA\n");   
		   exit(EXIT_FAILURE);  
		   }				 
		   else
			  {
			  coda1=testa1;
			  if(nodo->lettera=='z')
			     testa1->lettera='a';
			    else if(nodo->lettera=='Z')   
				        testa1->lettera='A';
				        else
				        testa1->lettera=nodo->lettera+1;
				 
				 testa1->nextnodo=NULL;
			  }	 
		}
        else
			{
			nodo1=malloc(sizeof(Lista));
            if(nodo1==NULL)
			  {
			  printf("\nAREA DI MEMORIA NON ALLOCATA\n");   
		      exit(EXIT_FAILURE);  
			  }				 
		      else
			     {
				 coda1->nextnodo=nodo1;
			     coda1=nodo1;
				 if(nodo->lettera=='z')
			        coda1->lettera='a';
				    else if(nodo->lettera=='Z')   
				            coda1->lettera='A';   
					        else
				            coda1->lettera=nodo->lettera+1;
				 
				 coda1->nextnodo=NULL;
				 }
			}
	  i++;
	  nodo=nodo->nextnodo;
	  }
	  
 return testa1; 
}