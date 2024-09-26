#include"liste.h"

void fine(void)
{
 printf("\nPROGRAMMA TERMINATO\n");	
}


Lista*lista_crea(char nome_file[])
{
 FILE*fpr=fopen(nome_file,"r");
 
 if(fpr==NULL)
   {
	printf("\nErrore file non disponibile");   
    exit(EXIT_FAILURE);
   }
 
 Lista*testa,*nodo,*coda;
 char azienda[10],studente[10];
 int i=0,ore;
 
 while(!feof(fpr))
      {
	   if(i==0)	  
	     {
		  testa=malloc(sizeof(Lista));
          if(testa==NULL)
		     {
			 printf("\nErrore area di memoria non allocata");   
             exit(EXIT_FAILURE);	 
			 }			  
		     else
			    {
			    coda=testa;
				fscanf(fpr,"%s %s %d",azienda,studente,&ore);
                strcpy(testa->azienda,azienda);
				strcpy(testa->studente,studente);
				testa->ore=ore;
				testa->nextnodo=NULL;				
				i++;
				}
		 }
         else
		    {
			nodo=malloc(sizeof(Lista));	
			if(nodo==NULL)
			  {
			  printf("\nErrore area di memoria non allocata");   
              exit(EXIT_FAILURE);  
			  } 
			  else
			     {
				 coda->nextnodo=nodo;
                 coda=nodo;
                 fscanf(fpr,"%s %s %d",azienda,studente,&ore);
				 strcpy(coda->azienda,azienda);
				 strcpy(coda->studente,studente);
				 coda->ore=ore;
				 coda->nextnodo=NULL;
				 }
			}
	  }
	  
 fclose(fpr);
 return testa;	
}

void stampa_lista(Lista*testa,int n)
{
  if(testa==NULL)
     return;	  
  else
     {
	 printf("\nNODO %d\nAZIENDA:%s\t|\tSTUDENTE:%s\t|\tORE:%d",n,testa->azienda,testa->studente,testa->ore);	 
	 return stampa_lista(testa->nextnodo,n+1);
	 }	  
}

int lista_ore(Lista*testa,char studente[])
{
 Lista*nodo=testa;	
 int result=0,cont=0;
 
 while(nodo!=NULL)
      {
	  if(strcmp(nodo->studente,studente)==0)	  
	     {
		 result=result+nodo->ore;	 
		 cont++;
		 }
      nodo=nodo->nextnodo;
	  }	 
   
 return result; 
}

Lista*lista_azienda(Lista*testa,char azienda[])
{
 Lista*nodo=testa;
 Lista*testa1,*nodo1,*coda1;
 int i=0;
 
 while(nodo!=NULL)
      {
	  if(strcmp(nodo->azienda,azienda)==0)	  
	    {
		if(i==0)	
		  {
	      testa1=malloc(sizeof(Lista));
          if(testa1==NULL)
		     {
			 printf("\nErrore area di memoria non allocata");   
             exit(EXIT_FAILURE); 
			 }			  
		     else
			   {
				coda1=testa1;   
			    strcpy(testa1->studente,nodo->studente);
			    strcpy(testa1->azienda,nodo->azienda);
				testa1->ore=nodo->ore;
				testa1->nextnodo=NULL;
			    i++;
			   }
		  }
	      else
		     {
			 nodo1=malloc(sizeof(Lista));
             if(nodo1==NULL)
		       {
			   printf("\nErrore area di memoria non allocata");   
               exit(EXIT_FAILURE); 
			   }			  
		       else
			      {
				  coda1->nextnodo=nodo1;
				  coda1=nodo1;   
			      strcpy(coda1->studente,nodo->studente);
			      strcpy(coda1->azienda,nodo->azienda);
				  coda1->ore=nodo->ore;
				  coda1->nextnodo=NULL;
			      }	 
			 }
		}
      nodo=nodo->nextnodo;
	  }
  
 return testa1;
}

void scrivi_file(Lista*testa1)
{
 FILE*fpr;
 
 fpr=fopen("dati01.txt","w+");
 
 if(fpr==NULL)
   {
	printf("Il file non e' disponibile\n");
    exit(EXIT_FAILURE);	
   }	 
 
 Lista*nodo=testa1;
 
 while(nodo!=NULL)
      {
	  fprintf(fpr,"%s %s %d\n",nodo->azienda,nodo->studente,nodo->ore);	  
	  nodo=nodo->nextnodo;
	  }
	  
 fclose(fpr);
}