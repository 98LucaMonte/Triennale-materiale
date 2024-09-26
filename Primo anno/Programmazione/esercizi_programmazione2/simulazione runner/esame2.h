#include <stdio.h>
#include <stdlib.h>

struct node {
	int day;
	int km;
	struct node *next;
};

typedef struct node List;

List * make_list (char filename[]);
void print_list (List *listPtr);
int find_km (List *listPtr, int daynumber);
float mean_km (List *listPtr);
List * make_list_overmean (List *listPtr, float meankm);
void print_histogram (List *listPtr);