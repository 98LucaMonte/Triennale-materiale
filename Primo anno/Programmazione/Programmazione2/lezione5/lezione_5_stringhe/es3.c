/* Lezione 5: stringhe e caratteri */

#include <stdio.h>
#include <stdlib.h>

int main(void)
{
  char colore[]= "blu";
  char *colorePtr = "blu";
  int i;

  // di fatto l'array è un puntatore
  printf("Indirizzo array: %p\n",colore); // è possibile omettere la &
  i = 0;
  // scorre la prima stringa e determina gli indirizzi in memoria
  while(colore[i]!='\0')
  {
    printf("Carattere %c (ASCII %d) -> indirizzo di memoria %p\n", colore[i], colore[i], &colore[i]);
    i++;
  }

  printf("\n");
  // scorre la seconda stringa
  // &colorePtr restituisce l'indirizzo di memoria in cui è salvato il puntatore
  // colorePtr contiene l'indirizzo di memoria del primo carattere della stringa
  // quindi è un puntatore a un carattere
  // *colorePtr accede al contenuto puntato
  printf("Indirizzo del puntatore alla stringa: %p\n",&colorePtr);
  printf("Indirizzo puntato inizialmente dal puntatore: %p\n",colorePtr);
  while(*colorePtr!='\0')
  {
    printf("Carattere %c (ASCII %d) -> indirizzo di memoria %p \n", *colorePtr, *colorePtr, colorePtr);
    //(*colorePtr)++; // ERRORE! Cerca di modificare il contenuto
    // sposta il puntatore all'elemento successivo
    colorePtr++;
  }
  return 1;
}
