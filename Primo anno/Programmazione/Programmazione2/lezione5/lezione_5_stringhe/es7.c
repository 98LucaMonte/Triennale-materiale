/* Lezione 5: stringhe e caratteri */

#include <stdio.h>
#include <stdlib.h>
#define SIZE 64

int main(void)
{
  char *frase = "Andrea 20 75.88";
  char nome[SIZE]; // non può essere un char *
  int eta;
  float peso;

  // legge la frase (primo parametro) e salva i dati formattandoli nel rispettivo formato
  // lo spazio tra i formati è inutile rende solo più leggibili i formati
  // si noti la & per le variabili eta e peso (come per scanf)
  // si noti che nome è stato dichiarato array per essere modificabile
  sscanf(frase, "%s %d %f", nome, &eta, &peso);

  printf("Dati ricavati dalla stringa:\n");
  printf("nome: %s\n", nome);
  printf("eta: %d\n", eta);
  printf("peso: %f\n", peso);

  return 1;
}
