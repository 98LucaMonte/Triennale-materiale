
#include"appello2.h"

void fine(void)
{	
 printf("\nPROGRAMMA TERMINATO\n");
}

Disco*crea_file(char nome_file[])
{
 Disco*testa,*nodotemp,*coda;
 int i=0;
 FILE*fpr=fopen(nome_file,"r");
 
 if(fpr==NULL) 
   {
   printf("\nFile non disponibile\n");	   
   exit(EXIT_FAILURE);
   }
   else
      {
	   while(feof(fpr)!=0)	  
	        {
			if(i==0)	
			  {
			   testa=malloc(sizeof(Disco));
               if(testa!=NULL)
			     {
			      coda=testa;
                  fscanf(fpr,"%s %s %d %s",testa->codice,testa->titolo,&testa->prezzo,testa->formato);
				  i++;
				 }				   
			     else
				    {
					printf("\nArea di memoria non allocata\n");	   
                    exit(EXIT_FAILURE);	
					}
			  }
		      else
			     {
				 nodotemp=malloc(sizeof(Disco));	 
				 if(nodotemp!=NULL)
				   {
					coda->nextnodo=nodotemp;
                    coda=nodotemp;					
				    fscanf(fpr,"%s %s %d %s",coda->codice,coda->titolo,&coda->prezzo,coda->formato);
				   }
				   else
				      {
					   printf("\nArea di memoria non allocata\n");	   
                       exit(EXIT_FAILURE);		  
					  }
				 }
			}
      }	   
 fclose(fpr);
 
 return testa;	
}


void stampa_lista(Disco*testa)
{
 //caso base
 if(testa==NULL)
   {
    return;	   
   }
 //caso ricorsivo
 else
    {
    printf("1)%s %s %d %s\n",testa->codice,testa->titolo,testa->prezzo,testa->formato);		
	return stampa_lista(testa->nextnodo);
	}
}