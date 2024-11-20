#include <stdio.h>
#include <math.h>

//cap phat dong
//malloc
//calloc
//realloc
//syntax: --> dataType *pointerName = (type_cast*)malloc(size_of_byte);
//dynamically allocated memory.
//		- malloc: malloc(size_of_memory) --> (void*);
//		- calloc: calloc(numberElements, size_of_each_element); --> (void*)
//		- realloc: realloc(pointer, size_of_memory); -->(void*)
int main(){	
	printf("Size of integer type: %d", sizeof(int));
	printf("\nSize of float type: %d", sizeof(float));
	printf("\nSize of double type: %d", sizeof(double));
	printf("\nSize of long long type: %d", sizeof(long long));
	return 0;
}