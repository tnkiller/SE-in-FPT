#include <stdio.h>
#include <stdlib.h>


int *selection(int a, int *arr) {
	int temp;
	for (int i=0; i<a; i++) {
		int min = *(arr+i);
		for (int j=i+1; j<a; j++) {
			if (*(arr+j) < min) {
				temp = *(arr+j);
				*(arr+j) = min;
				min = temp;
			}
		}
		*(arr+i) = min;
	}
	return arr;
}
int main() {
	int quan;
	int *array;
	printf("Input quantity of element: ");
	scanf("%d", &quan);
	array = (int*)calloc(quan,sizeof(int));
	for (int i=0; i<quan; i++) {
		scanf("%d",array+i);
	}
	printf("Original array: ");
	for (int i=0; i<quan; i++) {
		printf("%d   ",*(array+i));
	}
	printf("\n");
	array = selection(quan,array);
	printf("Sorted array: ");
	for (int i=0; i<quan; i++) {
		printf("%d   ",*(array+i));
	}

	return 0;
}