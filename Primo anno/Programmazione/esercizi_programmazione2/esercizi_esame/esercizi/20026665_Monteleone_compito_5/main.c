/*CONSEGNA
1)chiedere in input nel main() un numero n compreso tra 1 e 10 e due valori a e b 
(con b strettamente maggiore di a);
es.: n = 3 , a = 5, b = 10

2)scrivere una funzione che ha in input n, a e b e scrive su un file 
ad accesso diretto chiamato "dati.txt" gli n valori casuali tra a e b;

3)scrivere una funzione che ha in input il puntatore al file "dati.txt" e crea 
una lista con i dati contenuti nel file;

4)scrivere una funzione che ha in input la lista e la visualizza ricorsivamente;

5)scrivere una funzione che dalla lista ricavata dal file ne genera 
una seconda con i soli nodi contenenti valori pari;

6)visualizzare la lista con la funzione sviluppata al punto 4);

7)scrivere una funzione che riceve la lista dei numeri pari e la scrive in un 
file ad accesso diretto chiamato "pari.txt".
*/

#include<stdio.h>
#include<stdlib.h>
#include<time.h>

struct nodo
{
 int dato;
 struct nodo*nextnodo;		
};

typedef struct nodo Lista;

void crea_file(int a,int b,int n);
Lista*crea_lista(int n,FILE*fwr1);
void stampa_lista(Lista*testa,int p);
Lista*crea_lista_pari(int n,Lista*testa);
void crea_file_pari(Lista*testa);

int main(void)
{
 int n,a,b;
 
 do
 {
 printf("\ninserire quanti n numeri si vogliono nel file dati.txt n:");
 scanf("%d",&n);
 if(n<0 || n>10)
   printf("\nerrore il numero deve essere 0<=n<=10\n");
 }
 while(n<0 || n>10);
 
 printf("\ninserire a:");
 scanf("%d",&a);
 
 do
 {
 printf("\ninserire un numero b:");
 scanf("%d",&b);
 if(b<a)
   printf("\nerrore b deve essere maggiore di a\n");	
 }
 while(b<a);
 
 printf("\ncreiamo un file dati.txt con numeri che vanno da %d a %d estremi inclusi\n",a,b);
 crea_file(a,b,n);
 printf("\nIl File dati.txt e'stato creato\n");
 
 int p=0;
 FILE*fp=fopen("dati.txt","rb");
 Lista*testa_lista=crea_lista(n,fp);
 printf("\nstampa lista con valori presi dal file dati.txt\n");
 stampa_lista(testa_lista,p);
 fclose(fp);
 
 Lista*testa_lista1=crea_lista_pari(n,testa_lista);
 printf("\nstampa seconda lista con i numeri pari presenti nella prima\n");
 stampa_lista(testa_lista1,p);
 
 crea_file_pari(testa_lista1);
 
 return 1;	
}
/*
*@funzione:crea_file
*@parametro a:variabile intera che indica l'estremo minore dei valori dell'intevallo 
che posso inserire nel file 
*@parametro b:variabile intera che indica l'estremo maggiore dei valori dell'intevallo 
che posso inserire nel file 
*parametro n:variabile intera che indica quanti numeri si possono inserire nel file
*@return:-
*@see:crea_file
*/
void crea_file(int a,int b,int n)
{
 FILE*fwr;	
 int i=0,x,j;
 
 fwr=fopen("dati.txt","wb");
 
 if(fwr!=NULL)
   {
   srand(time(NULL));
   for(i=0;i<n;i++)	
	  {
	  x=a+rand()% ((b-a)+1);
	  j=fwrite(&x,sizeof(int),1,fwr);	
	  if(j!=0)
	    {
	    printf("\nDato scritto sul file dati.txt:%d",x);	
		}
	  }  
   }
   else
      {
      printf("\nerrore file dati.txt non disponibile\n");	
	  }	
 	
 fclose(fwr);	
}
/*
*@funzione:crea_lista
*@parametro n:variabile intera che indica il numero di nodi da inserire nella lista 
*@parametro fwr1:puntatore di tipo FILE  che punta al file dati.txt 
*@return:testa, la funzione ritorna la testa della lista appena creata
*@see:crea_lista
*/
Lista*crea_lista(int n,FILE*fwr1)
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
    if(testa!=NULL)
      {
	  fread(&testa->dato,sizeof(int),1,fwr1);
	  testa->nextnodo=crea_lista(n-1,fwr1);	
	  return testa;
      }
      else
	     {
	     printf("\narea di memoria non allocata\n");	
		 return 0;
		 } 
	}
}
/*
*@funzione:stampa_lista
*@parametro testa:variabile di tipo Lista che porta nella funzione la testa di una lista  
*@parametro p:variabile intera che indica il nodo in che stiamo stampando a video 
*@return:-
*@see:stampa_lista
*/
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
    printf("nodo[%d]:%d\n",p,testa->dato);	
    return stampa_lista(testa->nextnodo,p+1);	
	}
}
/*
*@funzione:crea_lista_pari
*@parametro n:variabile intera che indica il numero di nodi della lista che stiamo portando
nella funzione
*@parametro testa:variabile di tipo Lista che porta nella funzione la testa di una lista   
*@return testa1:la funzione ritorna la testa della lista appena creata
*@see:crea_lista_pari
*/
Lista*crea_lista_pari(int n,Lista*testa)
{
 Lista*testa1;	
 //caso base	
 if(n==0)
   {
   return NULL;	
   }	
 //caso ricorsivo
 else
    {
      testa1=malloc(sizeof(Lista));
	  if(testa1!=NULL)
	    {
	    if(testa->dato% 2==0)
		  {
		  testa1->dato=testa->dato; 	
          testa1->nextnodo=crea_lista_pari(n-1,testa->nextnodo);   	
	      return testa1;
	      }
		  else
		     {
		     crea_lista_pari(n-1,testa->nextnodo);	
			 }
		}
	    else
	     {
	     printf("\narea di memoria non allocata\n");	
		 return 0;
		 }	
    }
}
/*
*@funzione:crea_file_pari
*@parametro testa:variabile di tipo Lista che porta nella funzione la testa di una lista   
*@return:-
*@see:crea_file_pari
*/
void crea_file_pari(Lista*testa)
{
 FILE*frd=fopen("pari.txt","wb");	
 int j;
 
 if(frd!=NULL)
   {
   while(testa!=NULL)
        {
		j=fwrite(&testa->dato,sizeof(int),1,frd);	
        if(j!=0)
		  {
		  printf("\nDato scritto sul file pari.txt:%d",testa->dato);
		  } 
		testa=testa->nextnodo;
		}
   }	
   else
      {
	  printf("\nerrore il file non è disponibile\n");
	  }	
 printf("\nIl File pari.txt creato\n");
 fclose(frd);	
}
