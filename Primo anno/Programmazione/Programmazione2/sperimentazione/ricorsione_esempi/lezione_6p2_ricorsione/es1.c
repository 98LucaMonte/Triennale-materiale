/* Lezione 6: ricorsione */

#include <stdio.h>

double potenza(double base, int expo);

int main()
{
    double base;
    int expo;
    double r; // risultato

    printf("Base: ");
    scanf("%lf", &base);
    do{
      printf("Esponente: ");
      scanf("%d", &expo);
    }
    while(expo<0);
    r = potenza(base, expo);

    printf("%.2lf ^ %d = %.2f\n", base, expo, r);
    
    return 1;
}


double potenza(double base, int expo)
{
    // caso base
    if (expo == 0)
        return 1;
    // caso ricorsivo
    if (expo > 0)
        return base * potenza(base, expo - 1);
}
