#include<stdio.h>
#include<stdlib.h>

struct dato
{
 int day;	
 int km;	
 struct dato*nextnodo;	
};

typedef struct dato Corsa;

void fine(void);
Corsa*crea_lista(char nome_file[]);
void stampa_lista(Corsa*testa);
int ricerca_km(Corsa*testa,int day);
Corsa*crea_lista2(Corsa*testa);
void stampa_asterischi(Corsa*testa);
