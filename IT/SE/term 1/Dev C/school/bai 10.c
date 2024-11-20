#include <stdio.h>
#include <stdlib.h>
//int main(){
	/*
	dynamic allocation
	*/
	
//	int n = 1000;
////	scanf n
////	int array[n]; -->DO NOT USE THIS METHOD
////	n = 6;
//	
//	
//	/*
//	dynamically allocated memory
//	- malloc: malloc(size_of_memory) --> (void*);
//	- calloc: calloc(numberElements, size_of_each_element); --> (void*)
//	- realloc: realloc(pointer, size_of_memory); -->(void*)
//	*/
//	
//	
//	int *pt1;
//	pt1 = (int*)malloc(n*sizeof(int));
//	printf("initialization of the array pt1: ");
//	for (int i=0;i<n;i++) printf("%d   ", *(pt1+i));
//	float *pt2 = (float*)calloc(n, sizeof(float));
//	
//	return 0;
//}
//	float *pt2 = (float*)calloc(n, sizeof(float));
//	printf("\ninitialization of the array pt2: ");
//	for (int i=0;i<n;i++) printf("%.2f   ", *(pt2+i));
	
	
	/*
	use dynamically allocated memory for return in a function
	*/
	
	/*
	write a function to generate n-element array containing odd numbers from 1
	*/
//	int *oddGen(int n);
//	int main(){
//		int a;
//		int *rs;
//		printf("input n: \n");
//		scanf("%d", &a);
//		for (int i=0;i<a;i++){
//			 *(rs+i) = oddGen(a);
//		}
//		for (int i=0;i<a;i++){
//			printf("%d   ",*(rs+i));
//		}
//		return 0;
//	}
//	//build function
//	int *oddGen(int n){
//		int *pto = (int*)malloc(n*sizeof(int));
//		for (int i=0;i<n;i++){
//			*(pto+i) = 2*i+1;
//		}
//		return pto;
//	}
	
	
	
	
	
//	int *random(int n);
//	int main(){
//		int a;
//		printf("input: ");
//		scanf("%d", &a);
//		int *rs = random(a);
//		for (int i=0;i<a;i++){
//			printf("%d   ", *(rs+i));
//		}
//		return 0;
//	}	
////build function
//int* random(int n){
//	int *ptr = (int*)calloc(n,sizeof(int));
//	for(int i=0;i<n;i++){
//		*(ptr+i) = rand() % (20-5+1)+5;
//	}
//	return ptr;
//}


/*-----------------------------------------------------------*/

/*
	Write a function that creates an n-element array containing 
	random integers sorted from smallest to largest and not repeated in the range from n to m, 
	n and m entered from the keyboard
	*/
	
int main(){
	
	
	
	return 0;
}








