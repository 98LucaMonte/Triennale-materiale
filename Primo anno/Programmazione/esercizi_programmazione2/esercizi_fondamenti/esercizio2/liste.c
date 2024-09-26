#include"liste.h"

void fine(void)
{
printf("\nPROGRAMMA TERMINATO\n");	
}

Lista*crea_lista(int n,char stringa[])
{
 Lista*testa,*nodo,*coda;
 int i=0;
 
 for(i=0;i<n;i++)
    {
	if(i==0)
	   {
		testa=malloc(sizeof(Lista));
        if(testa==NULL)
		   {
			printf("Area di memoria non allocata");   
		    exit(EXIT_FAILURE);
		   }			
	       else
		      {
			   coda=testa;
               testa->lettera=stringa[i];			   
			   testa->nextnodo=NULL;
			  }
	   }
       else
	      {
		  nodo=malloc(sizeof(Lista));
		  if(nodo==NULL)
		   {
			printf("Area di memoria non allocata");   
		    exit(EXIT_FAILURE);
		   }			
	       else
		      {
			   coda->nextnodo=nodo;
			   coda=nodo;
               coda->lettera=stringa[i];			   
			   coda->nextnodo=NULL;
			  }
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
    printf("%c->",testa->lettera);	
	return stampa_lista(testa->nextnodo);
	}
}

int lista_vocali(Lista*testa)
{
  int cont=0;
  
  if(testa==NULL)
    {
    return 0;
    } 
  
  else
     {
	 if(testa->lettera=='A'||testa->lettera=='a'||testa->lettera=='E'||testa->lettera=='e'||testa->lettera=='I'||testa->lettera=='i'||testa->lettera=='O'||testa->lettera=='o'||
	    testa->lettera=='U'||testa->lettera=='u')	 
	    {
		cont++;	
		}
	 return cont+lista_vocali(testa->nextnodo);
	 }
}

Lista*lista_consonanti(Lista*testa)
{
 Lista*nodotemp=testa;	
 Lista*testa1,*nodo1,*coda1;	
 int i=1;
 
 while(nodotemp!=NULL)
      {
	   if(nodotemp->lettera!='A'&& nodotemp->lettera!='a'&& nodotemp->lettera!='E'&& nodotemp->lettera!='e'&&nodotemp->lettera!='I'&&nodotemp->lettera!='i'
	      &&nodotemp->lettera!='O'&&nodotemp->lettera!='o'&&nodotemp->lettera!='U'&&nodotemp->lettera!='u')
		  {
		  if(i==1)	  
		     {
			 testa1=malloc(sizeof(Lista));	 
			 if(testa1==NULL)
			   {
			   printf("Area di memoria non allocata");   
		       exit(EXIT_FAILURE);  
			   }
			   else
			      {
				  coda1=testa1;	  
				  testa1->lettera=nodotemp->lettera;
				  testa1->nextnodo=NULL;
				  }
			 }
	         else
			    {
				nodo1=malloc(sizeof(Lista));
				if(nodo1==NULL)
			       {
			       printf("Area di memoria non allocata");   
		           exit(EXIT_FAILURE);  
			       }
			       else
			          {
				      coda1->nextnodo=nodo1;
					  coda1=nodo1;	  
				      coda1->lettera=nodotemp->lettera;
				      coda1->nextnodo=NULL;
				      }
				} 
			}
			i++;
			nodotemp=nodotemp->nextnodo;
	}

 return testa1;  
}

Lista*cifrata(Lista*testa)
{
 Lista*testa1,*nodo,*coda;
 int i=0;
 Lista*nodotemp=testa;
 
 while(nodotemp!=NULL)
      {
	  if(i==0)
	    {
		testa1=malloc(sizeof(Lista));
        if(testa1==NULL)
		   {
		   printf("Area di memoria non allocata");   
		   exit(EXIT_FAILURE);
		   }			
	       else
		      {
			  coda=testa1;
              testa1->lettera=nodotemp->lettera+1;			   
			  testa1->nextnodo=NULL;
			  }
	   }
       else
	      {
		  nodo=malloc(sizeof(Lista));
		  if(nodo==NULL)
		   {
		   printf("Area di memoria non allocata");   
		   exit(EXIT_FAILURE);
		   }			
	       else
		      {
			  coda->nextnodo=nodo;
			  coda=nodo;
              coda->lettera=nodotemp->lettera+1;			   
			  coda->nextnodo=NULL;
			  }
		  }	  
	  nodotemp=nodotemp->nextnodo;
	  i++;
	  } 
	  
 return testa1;
}