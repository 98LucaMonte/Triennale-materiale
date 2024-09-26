#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(void)
{ 
 char s1[100];
 char nome1[]="Luca";
 char cognome1[]="Monteleone";
 int eta=22;
 
 sscanf(s1,"%s %s %d",nome1,cognome1,eta);
 puts(s1);
 
 
 return 0;	
}
