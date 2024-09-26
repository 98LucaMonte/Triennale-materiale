/* Lezione 6: ricorsione */

#include <stdio.h>

int sommatoria(int start, int end);

int main()
{
    int start, end;
    int r; // risultato

    printf("Estremo inferiore: ");
    scanf("%d", &start);
    printf("Estremo superiore: ");
    scanf("%d", &end);

    r = sommatoria(start, end);

    printf("Sommatoria da %d a %d: %d\n", start, end, r);

    return 1;
}


int sommatoria(int start, int end)
{
    if (start == end)
        return start;
    else
        return start + sommatoria(start + 1, end);
}
