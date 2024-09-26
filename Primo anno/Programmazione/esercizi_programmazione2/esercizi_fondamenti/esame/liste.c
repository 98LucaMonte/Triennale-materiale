#include"liste.h"

void fine(void)
{
 printf("\nPROGRAMMA TERMINATO\n");	
}

Lista*lista_crea(char nome_file[])
{
 Lista*testa,*nodo,*coda;
 int i=0;
 FILE*fpr;
 fpr=fopen(nome_file,"r");
 
 if(fpr==NULL)
   {
	printf("\nERRORE IL FILE NON E' DISPONIBILE\n");
    exit(EXIT_FAILURE);	
   }
 
 int ore;
 char azienda[20],studente[20];
 
 while(!feof(fpr))
      {
	   if(i==0)	  
	     {
		 testa=malloc(sizeof(Lista));
         if(testa==NULL)
		   {
		   printf("\nERRORE AREA DI MEMORIA NON ALLOCATA\n");
           exit(EXIT_FAILURE);	      
		   }			 
		   else
		      {
			   fscanf(fpr,"%s %s %d",azienda,studente,&ore);	  
			   coda=testa;
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
			  printf("\nERRORE AREA DI MEMORIA NON ALLOCATA\n");
              exit(EXIT_FAILURE);	      
		      }			 
		      else
		         {
			     fscanf(fpr,"%s %s %d",azienda,studente,&ore);	  
			     coda->nextnodo=nodo;
				 coda=nodo;
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

void stampa_lista(Lista*testa)
{
 if(testa==NULL)
	return;

 else
    {
	printf("AZIENDA:%s || STUDENTE:%s || ORE:%d\n",testa->azienda,testa->studente,testa->ore);	
	return stampa_lista(testa->nextnodo);	
	}
}

int lista_ore(Lista*testa,char studente[])
{
 int ore=0,cont=0;	
 Lista*nodo=testa;
 
 while(nodo!=NULL)
      {
	   if(strcmp(nodo->studente,studente)==0)
	     {
		 ore=ore+nodo->ore;
		 cont++;
		 }	 
      nodo=nodo->nextnodo;
	  }	 
 
 if(cont==0)
    ore=0;   
 
 return ore;
}

Lista*lista_azienda(Lista*testa,char azienda[])
{
 Lista*testa1,*nodo1,*coda1;	
 Lista*nodo=testa;
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
				printf("\nERRORE AREA DI MEMORIA NON ALLOCATA\n");
                exit(EXIT_FAILURE);	   
			   }
			   else
			      {
				  coda1=testa1;
				  strcpy(testa1->azienda,nodo->azienda);
				  strcpy(testa1->studente,nodo->studente);
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
				   printf("\nERRORE AREA DI MEMORIA NON ALLOCATA\n");
                   exit(EXIT_FAILURE);	   
			       }
			       else
			          {
					  coda1->nextnodo=nodo1;	  
				      coda1=nodo1;
				      strcpy(coda1->azienda,nodo->azienda);
				      strcpy(coda1->studente,nodo->studente);
				      coda1->ore=nodo->ore;
				      coda1->nextnodo=NULL;
				      }  
			   }
		 }
      nodo=nodo->nextnodo;
	  }
	  
 return testa1;
}

void funzione5(Lista*testa)
{
 Lista*nodo=testa;
 FILE*fpr;
 fpr=fopen("dati1.txt","w+");
 char studente[20],azienda[20];
 int ore;
 
 if(fpr==NULL)
    {
    printf("\nERRORE IL FILE NON E' DISPONIBILE\n");
    exit(EXIT_FAILURE);		
	}
 
 while(nodo!=NULL)
      {
	  strcpy(azienda,nodo->azienda);
      strcpy(studente,nodo->studente);	  
      fprintf(fpr,"%s %s %d\n",azienda,studente,nodo->ore);		  
	  nodo=nodo->nextnodo;
	  }	 
 
 fclose(fpr);
}