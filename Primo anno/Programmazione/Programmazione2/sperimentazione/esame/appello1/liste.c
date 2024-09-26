#include"appello.h"

void fine(void)
{
 printf("\nPROGRAMMA TERMINATO\n");	
}

Corsa*crea_lista(char nome_file[])
{
 Corsa*testa,*nodotemp,*coda;
 int i=0,day,km;
 FILE*fpr;
 
 fpr=fopen(nome_file,"r");
 if(fpr!=NULL)
   {
   rewind(fpr);	   
   while(!feof(fpr))
        {
	    if(i==0)	  
	      {
		  testa=malloc(sizeof(Corsa));
          if(testa!=NULL)
		    {
			fscanf(fpr,"%d,%d",&day,&km);	  
		    coda=testa;
			testa->day=day;
			testa->km=km;
			testa->nextnodo=NULL;
			i++;
			}			
		    else
			   {
			   printf("Area di memoria non allocata");	   
			   exit(EXIT_FAILURE);
			   }
		  } 
          else
		     {
		     nodotemp=malloc(sizeof(Corsa));
			 if(nodotemp!=NULL)
			   {
			    fscanf(fpr,"%d,%d",&day,&km);
				coda->nextnodo=nodotemp;
				coda=nodotemp;
				coda->day=day;
			    coda->km=km;
			    coda->nextnodo=NULL;
			    i++;
			   }
		       else
			      {
			      printf("Area di memoria non allocata");	   
			      exit(EXIT_FAILURE);
			      }
			 }
	    }
   }
   else
      {
	   printf("file non disponibile\n");	  
	   exit(EXIT_FAILURE);
	  }
	  
 fclose(fpr);
 
 return testa;
}

void stampa_lista(Corsa*testa)
{
 //caso base
 if(testa==NULL)
    {
	return;	
	}	 
 //caso ricorsivo
 else
    {
	printf("Giorno numero[%d]:%dkm\n",testa->day,testa->km);	
	return stampa_lista(testa->nextnodo);
	}	 
}

int ricerca_km(Corsa*testa,int day)
{
 Corsa*nodotemp=testa;
 int trovato;
 
 while(nodotemp!=NULL)
      {
      if(nodotemp->day==day)
	    {
	    trovato=nodotemp->km;
        break;		
		}
      nodotemp=nodotemp->nextnodo; 
	  } 		
 return trovato;	
}

Corsa*crea_lista2(Corsa*testa)
{
 int somma_km=0,i=0; 
 Corsa*nodotemp=testa;
 
 while(nodotemp!=NULL)
      {
	  somma_km=testa->km+somma_km;	  
	  nodotemp=nodotemp->nextnodo;
	  i++;
	  }
 
 int media=0;
 media=somma_km/i;
 
 int y=0;
 
 printf("\nmedia:%d\n",media);
 
 Corsa*testa1,*nodotemp1,*coda1,*nodotemp2=testa;
 
 while(nodotemp2!=NULL)
    {
	 if(media<nodotemp2->km)	
	   {
       if(y==0)
	     {
	     testa1=malloc(sizeof(Corsa));
         if(testa1==NULL)
		   {
           printf("Area di memoria non allocata");	   
		   exit(EXIT_FAILURE);
		   }			  
	       else
		      {
			  coda1=testa1;	  
		      testa1->km=nodotemp2->km;
              testa1->day=nodotemp2->day;
              testa1->nextnodo=NULL;			  
			  y++;
			  nodotemp2=nodotemp2->nextnodo;
			  }
	     }
         else
		    {
			nodotemp1=malloc(sizeof(Corsa));
            if(nodotemp1==NULL)
		      {
              printf("Area di memoria non allocata");	   
		      exit(EXIT_FAILURE);
		      }			  
	          else
		         {
				 coda1->nextnodo=nodotemp1;	 
			     coda1=nodotemp1;	  
		         coda1->km=nodotemp2->km;
                 coda1->day=nodotemp2->day;
                 coda1->nextnodo=NULL;			 
			     nodotemp2=nodotemp2->nextnodo;
				 }	
			}
       }
	   else
	   {    
	   nodotemp2=nodotemp2->nextnodo;
	   }
    }
	
 return testa1;
}

void stampa_asterischi(Corsa*testa)
{
 Corsa*nodotemp=testa;
 int km,i=0;

 while(nodotemp!=NULL)
      {
      km=nodotemp->km;
	  printf("\n%d:",nodotemp->day);	
	  while(i<km)
	       {
		    printf("*");	   
		    i++;
		   }
	  i=0;
	  nodotemp=nodotemp->nextnodo;
	  }		  
}