#include <stdio.h>
#include <stdlib.h>
int *bubble(int a, int *arr) {
	int temp;
	for (int i=a-1; i>=0; i--) {
		for (int j=0; j<=i-1; j++) {
			if (*(arr+j) > *(arr+j+1)) {
				temp = *(arr+j);
				*(arr+j) = *(arr+j+1);
				*(arr+j+1) = temp;
			}
		}
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
	array = bubble(quan,array);
	printf("Sorted array: ");
	for (int i=0; i<quan; i++) {
		printf("%d   ",*(array+i));
	}

	return 0;
}