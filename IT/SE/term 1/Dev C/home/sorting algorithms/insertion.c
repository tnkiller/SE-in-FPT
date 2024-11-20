#include <stdio.h>
#include <stdlib.h>


int *insertion(int a, int *arr) {
	for (int i=1; i<a; i++) {
		int key = *(arr+i);
		int j = i-1;
		while (j>=0 && *(arr+j)>key){
			*(arr+i) = *(arr+j);
			--j;
		}
		*(arr+j+1) = key;
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
	array = insertion(quan,array);
	printf("Sorted array: ");
	for (int i=0; i<quan; i++) {
		printf("%d   ",*(array+i));
	}
	free(array);
	return 0;
}

