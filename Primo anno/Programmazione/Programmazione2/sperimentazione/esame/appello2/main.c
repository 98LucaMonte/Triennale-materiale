#include"appello2.h"

int main(int argc,char*argv[])
{
 atexit(fine); 
 
 if(argc!=2)
   {
    printf("\nSIntassi in linea di comando errata:Nome eseguibile nome file\n");	   
    exit(EXIT_FAILURE);	   
   }
  
  
  Disco*testa=crea_file(argv[1]);
  stampa_lista(testa);
 
	
 exit(EXIT_FAILURE);	
}