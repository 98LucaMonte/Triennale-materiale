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
 
 int vocali;
 vocali=lista_vocali(testa);
 printf("\nVOCALI PRESENTI:%d\n",vocali);
 
 Lista*consonanti;
 consonanti=lista_consonanti(testa);
 stampa_lista(consonanti);
 printf("NULL\n");
 
 Lista*testa1;
 testa1=lista_cifrata(testa);
 stampa_lista(testa1);
 printf("NULL\n");
 
 exit(EXIT_SUCCESS);
}