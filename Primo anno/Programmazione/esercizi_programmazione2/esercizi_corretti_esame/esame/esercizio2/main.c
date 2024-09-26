#include"liste.h"

int main(int argc,char*argv[])
{
if(argc!=2)
   {
   printf("\nERRORE IN LINEA DI COMANDO\n");	
   exit(EXIT_FAILURE);
   }
 
 Lista*testa;
 testa=crea_lista(argv[1]); 
 stampa_lista(testa);
 printf("NULL\n"); 
 
 int result;
 result=lista_simboli(testa);
 printf("\nSIMBOLI:%d\n",result);
 
 Lista*consonanti;
 consonanti=funzione3(testa);
 stampa_lista(consonanti);
 printf("NULL\n");
 
 exit(EXIT_SUCCESS);	
}