#include <stdio.h>
#include <math.h>
#include <stdlib.h>
/* 1. Write a function to square a number using pointer as an argument.*/

//void sqr(float *pointer, float *result);
//int main(){
//	float a;
//	float *ptr = &a; float *rs;
//	printf("Input a number from keyboard: \n");
//	scanf("%f", &a);
//	sqr(ptr, rs);
//	printf("%.1f", *rs);
//	return 0;
//}
////build function
//void sqr(float *pointer, float *result){
//	*result = *pointer * *pointer;
//}





/*2. Write a function to decompose a real number into integer part and fractional part. 
Example: number = -3.14; output will be integer part = -3 and fractional part = 0.14*/

//void decompose(float *f_pt, int *f_int, float *f_frac);
//int main(){
//	float real, frac_rs; 
//	int int_rs; 
//	float *ptr = &real;
//	int *int_pt = &int_rs;
//	float *frac_pt = &frac_rs;
//	printf("Input a real number: \n");
//	scanf("%f", &real);
//	decompose(ptr,int_pt,frac_pt);
//	printf("Integer part = %d\n", int_rs);
//	printf("Fractional part = %f\n", frac_rs);
//	return 0;
//}
////build function
//void decompose(float *f_pt, int *f_int, float *f_frac){
//	*f_int =  (int) *f_pt;
//	*f_frac = fabs(*f_pt - *f_int);
//}





/*3. Write a function to find the largest and smallest elements in an array. Example: array[5] = {1, 5,
6, 9, 3}. Outputs: largest = 9, smallest = 1*/

//void find_max_min(int n,float *ptr_main,float *ptr_max,int *ptr_max_pos,float *ptr_min,int *ptr_min_pos);
//int main(){
//	float *pointer, max, min;
//	int quantity, max_pos, min_pos;
//	float *pointer_max = &max; int *pointer_max_pos = &max_pos;
//	float *pointer_min = &min; int *pointer_min_pos = &min_pos; 
//	printf("Input quantity of elements in array: \n");
//	scanf("%d", &quantity);
//	pointer = (float*)malloc(quantity*sizeof(float));
//	if (quantity > 0){
//		for (int i=0;i<quantity;i++){
//			printf("A[%d] = ", i); 
//			scanf("%f", (pointer+i));	
//		}
//		printf("Array:   ");
//		for (int i=0;i<quantity;i++){
//			printf("%.1f   ", *(pointer+i));
//		}
//		printf("\n");
//		find_max_min(quantity,pointer,pointer_max,pointer_max_pos,pointer_min,pointer_min_pos);
//		printf("Largest = %.1f",max); printf("\t Position: %d", max_pos);
//		printf("\nSmallest = %.1f", min); printf("\t Position: %d",min_pos);
//	}else{
//		printf("please reinput!!");
//	}
//	free(pointer);
//	return 0;
//}
////build function
//void find_max_min(int n,float *ptr_main,float *ptr_max,int *ptr_max_pos,float *ptr_min,int *ptr_min_pos){
//		*ptr_max  = *(ptr_main);
//		*ptr_min = *(ptr_main);
//		*ptr_max_pos = 0;
//		*ptr_min_pos = 0;
//			for (int i=0;i<n;i++){
//				if(*(ptr_main+i) <= *ptr_min){
//					*ptr_min = *(ptr_main+i);
//					*ptr_min_pos = i;
//				}
//			}
//			for (int i=0;i<n;i++){
//				if (*(ptr_main+i) >= *ptr_max){
//				 	*ptr_max = *(ptr_main+i);
//					*ptr_max_pos = i;
//				}
//			}
//}





/*4. Write a function to calculate the sum and the average of the elements in an array.*/

//void sum_avr(int n, float *ptr_main, float *ptr_sum, float *ptr_avr);
//int main(){
//	float sum_rs, avr_rs;
//	int quantity;
//	float *pointer_main;
//	float *pointer_sum = &sum_rs;
//	float *pointer_avr = &avr_rs;	
//	printf("Input quantity of element in array: \n");
//	scanf("%d", &quantity);
//	pointer_main = (float*)calloc(quantity,sizeof(float));
//	if (quantity>0){
//		for (int i=0;i<quantity;i++){
//			printf("A[%d] = ", i); scanf("%f", (pointer_main+i));
//		}
//		//check pointer_main
//		printf("Array: \t");
//		for (int i=0;i<quantity;i++){
//			printf("%.1f   ", *(pointer_main+i));
//		}
//		sum_avr(quantity,pointer_main,pointer_sum,pointer_avr);
//		printf("\nSum = %.1f", sum_rs);
//		printf("\nAverage = %.1f", avr_rs);
//	}else{
//		printf("error input!!");
//	}
//	return 0;
//}
////build function
//void sum_avr(int n, float *ptr_main, float *ptr_sum, float *ptr_avr){
//	*ptr_sum = 0;
//	*ptr_avr = 0;
//	for (int i=0;i<n;i++){
//		*ptr_sum += *(ptr_main+i);
//		*ptr_avr += (*(ptr_main+i))/n;
//	}
//}





/*5. Write a function to swap two variables.*/

//void swap(float *ptr_a, float *ptr_b);
//int main(){
//	float a, b;
//	float *pointer_a = &a;
//	float *pointer_b = &b;
//	printf("Input a = "); scanf("%f", &a);
//	printf("Input b = "); scanf("%f", &b);
//	if (a != b){
//		printf("Before swapping\n");
//		printf("a = %.1f     b = %.1f", a, b); 
//		printf("\nAfter swapping\n");
//		swap(pointer_a,pointer_b);
//		printf("a = %.1f       b = %.1f", *pointer_a, *pointer_b);
//	}else{
//		printf("Giong nhau swap lam me gi!!");
//	}
//	return 0;
//}
////build function
//void swap(float *ptr_a, float *ptr_b){
//	float temp;
//	temp = *ptr_a;
//	*ptr_a = *ptr_b;
//	*ptr_b = temp;
//}





/*6. Write a function to find two largest elements in an array*/

void two_largest(int n, float *ptr_main, float *ptr_max1, float *ptr_max2);
int main(){
	float m1, m2;
	int quantity;
	float *pointer_main;
	float *pointer_max1 = &m1;
	float *pointer_max2 = &m2;
	printf("Input quantity of elements in array: \n");
	scanf("%d", &quantity);
	pointer_main = (float*)calloc(quantity,sizeof(float));
	if (quantity > 0){
		for (int i=0;i<quantity;i++){
			printf("A[%d] = ", i); 
			scanf("%f", (pointer_main+i));	
		}
		printf("Array:   ");
		for (int i=0;i<quantity;i++){
			printf("%.1f   ", *(pointer_main+i));
		}
		two_largest(quantity,pointer_main,pointer_max1,pointer_max2);
		printf("\nTwo largest elements in array are %.1f and %.1f", m1, m2);
	}
	return 0;
}
//build function;
void two_largest(int n, float *ptr_main, float *ptr_max1, float *ptr_max2){
	*ptr_max1 = *ptr_main;
	*ptr_max2 = *(ptr_main+n);
	for (int i=0;i<n;i++){
		if (*(ptr_main+i) > *ptr_max1){
			*ptr_max1 = *(ptr_main+i);
		}
	}
	for (int i=n;i>=0;i--){
		if (*(ptr_main+i) < *ptr_max1 && *(ptr_main+i) > *ptr_max2){
			*ptr_max2 = *(ptr_main+i);
		}
	}	
}




