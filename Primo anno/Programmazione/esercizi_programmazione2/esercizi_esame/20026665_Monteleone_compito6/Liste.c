
#include"compito5.h"

void crea_file(int a,int b,int n)
{
 FILE*fpw;
 int i=0,x,y;
 
 fpw=fopen("dati.txt","wb"); 
 if(fpw==NULL)
    {
	printf("\nErrore il file non e' disponibile\n");	
	}
    else 
	   {  
       srand(time(NULL));
	   for(i=0;i<n;i++)
	      {
		  x=a+rand()%((b-a)+1);	  
		  y=fwrite(&x,sizeof(int),1,fpw);
		  if(y>0)
		     {
			 printf("\nDato scritto nel file dati.txt:%d",x);	 
			 }
		     else
			    {
				printf("\nErrore dato non scritto nel file\n");	
				}
		  }
	   }
  fclose(fpw);
}

Lista*crea_lista(FILE*fpw,int n)
{
 Lista*testa;
 //caso base
 if(n==0)
   {
    return NULL;	   
   }
 //caso ricorsivo
 else
   {
	testa=malloc(sizeof(Lista));
    if(testa==NULL)
	  {
	   printf("\narea di memoria non allocata\n"); 
	  }		
      else
	     {
		  fread(&testa->dato,sizeof(int),1,fpw); 
		  testa->nextnodo=crea_lista(fpw,n-1);
		  return testa;
		 }
   }

}

void stampa_lista(Lista*testa,int p)
{
 //caso base
 if(testa==NULL)
    {
	return;	
	}
 //caso ricorsivo
    else
	   {
		printf("Nodo[%d]:%d\n",p,testa->dato);
        return stampa_lista(testa->nextnodo,p+1);		
	   }

}

Lista*lista_pari(Lista*testa,int n)
{
 Lista*testa2;	
 //caso base
 if(n==0) 
    {
	return NULL;	
	}
 //caso ricorsivo
 else
    {
	if(testa->dato%2!=0)	
	  {
	  lista_pari(testa->nextnodo,n-1);	  
	  }
      else
	     {
		  testa2=malloc(sizeof(Lista));
          if(testa2==NULL)
		    {
			printf("\narea di memoria non allocata\n");	
			}			  
		    else
			   {
			    testa2->dato=testa->dato;	   
			    testa2->nextnodo=lista_pari(testa->nextnodo,n-1);
			    return testa2;
			   }
		 }
	}	 	
}

void crea_file_pari(Lista*testa)
{
 FILE*fpw;
 fpw=fopen("pari.txt","wb"); 
 int y,cont=0; 
 
 if(!feof(fpw))
   {
    while(testa!=NULL)
    {
	y=fwrite(&testa->dato,sizeof(int),1,fpw); 	
	if(y>0)
	  {
      printf("\nDato scritto sul file pari.txt:%d",testa->dato);
	  cont++;
	  }
	testa=testa->nextnodo;
	}
   }	
   else
      {
	  printf("\nFile non disponibile\n");	  
	  }
  
  fclose(fpw);
  if(cont==0)
	 printf("\nNella lista non sono presenti valori pari"); 
  
}