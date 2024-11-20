#include <stdio.h>
#include <math.h>
#include <stdlib.h>

/*1. Declare a 5-element array storing the following integers: 1, 5, 7, 4, 2. Then access the third element
and print out its value on screen.*/

//int main(){
//	int array[5] = {1,5,7,4,2};
//	int *pointer;
//	pointer = array;
//	printf("The third element of array is %d ", *(pointer+3));
//	return 0;
//}






/*2. You are required to process an image. One of the task is, you must replace the value of the elements
which are smaller than or equal to 5 by 0. Write a program to do this task where the threshold and the
values of the elements are inputted from keyboard.
*/

//void replace(int n, float *p_main, float *ptr_thres);
//int main(){
//	int a;
//	float *pointer_main, *pointer_threshold;
//	float threshold;
//	pointer_threshold = &threshold;
//	printf("Input quantity of element in array: \n");
//	scanf("%d", &a);
//	printf("Input threshold: \n");
//	scanf("%f", pointer_threshold);
//	pointer_main = (float*)calloc(a,sizeof(float));
//	for (int i=0;i<a;i++){
//		printf("array[%d] = ",i); scanf("%f", (pointer_main+i));
//	}
//	replace (a,pointer_main,pointer_threshold);
//	for (int i=0;i<a;i++){
//		printf("%.1f   ", *(pointer_main+i));
//	}
//	return 0;
//}
////build function
//void replace(int n, float *ptr_main, float *ptr_thres){
//	for (int i=0;i<n;i++){
//		if (*(ptr_main+i) <= *ptr_thres){
//			*(ptr_main+i) = 0;
//		}
//	}
//}







/*3. You are required to smooth a segment of data. The way to smooth is you replace three consecutive
elements by a new one. The value of every new one is equal to the average of those three elements.
{1.2, 7.2, 9.0, 2.1, 4.2, 6.0, 23.1, 5.1, 2.4, 10.2}: 10 elements
output should be: {5.8, 6.1, 5.1, 4.1, 11.1, 11.4, 10.2, 5.9}: 8 elements
*/

////build function
//void smooth(int quan, int avr_n, float *pt_arr, float *pt_rs) {
//	*pt_rs = 0.0;
//	for (int i=0; i<quan-avr_n+1; i++) {
//		for (int j=i; j<i+avr_n; j++) {
//			*(pt_rs+i) += *(pt_arr+j)/avr_n;
//		}
//	}
//}
////main
//int main() {
//	int numcs, n;
//	float *ptr_array, *ptr_rs;
//	printf("Input quantity:  ");
//	scanf("%d", &n);
//	ptr_array = (float*)calloc(n,sizeof(float));
//	ptr_rs = (float*)calloc(n-numcs+1,sizeof(float));
//	for (int i=0; i<n; i++) {
//		printf("Array[%d] = ", i);
//		scanf("%f", ptr_array+i);
//	}
//	printf("Input smooth number: ");
//	scanf("%d", &numcs);
//	smooth(n,numcs,ptr_array,ptr_rs);
//	printf("Smoothed array: ");
//	for (int i=0; i<n-numcs+1; i++) {
//		printf("%.1f   ", *(ptr_rs+i));
//	}
//	return 0;
//}







/*4. You are supporting a university to select the highest scores of a competition. The mark table shows
that {7.2, 5.2, 4.9, 8.1, 2.3, 9.0, 5.7, 4.5, 7.5, 8.3}. Now you have to sort the array to increasing order to
see the result.
Output: {2.3, 4.5, 4.9, 5.2, 5.7, 7.2, 7.5, 8.1, 8.3, 9.0}*/

//build function
//---bubble sort
/*Increase*/
void sort1_1(int a, float *p_main, float *p_rs) {
	float temp;
	for (int i=a-1; i>0; i--) {
		for (int j=0; j<=i-1; j++) {
			if (*(p_main+j+1) < *(p_main+j)) {
				temp = *(p_main+j+1);
				*(p_main+j+1) = *(p_main+j);
				*(p_main+j) = temp;
			}
		}
	}
	for (int i=0; i<a; i++) {
		*(p_rs+i) = *(p_main+i);
	}
}
///*Decrease*/
//void sort1_2(int a, float *p_main, float *p_rs) {
//	float temp;
//	for (int i=a-1; i>0; i--) {
//		for (int j=0; j<=i-1; j++) {
//			if (*(p_main+j+1) > *(p_main+j)) {
//				temp = *(p_main+j+1);
//				*(p_main+j+1) = *(p_main+j);
//				*(p_main+j) = temp;
//			}
//		}
//	}
//	for (int i=0; i<a; i++) {
//		*(p_rs+i) = *(p_main+i);
//	}
//}
//
//
//
//
////---selection sort
/*Increase*/
void sort2_1(int a, float *p_main, float *p_rs) {
	float min;
	float temp;
	for (int i=0; i<a; i++) {
		min = *(p_main+i);
		for (int j=i+1; j<a; j++) {
			if (*(p_main+j) < min) {
				temp = *(p_main+j);
				*(p_main+j) = min;
				min = temp;
			}
		}
		*(p_rs+i) = min;
	}
}
/*Decrease*/
void sort2_2(int a, float *p_main, float *p_rs) {
	float max;
	float temp;
	for (int i=0; i<a; i++) {
		max = *(p_main+i);
		for (int j=i+1; j<a; j++) {
			if (*(p_main+j) > max) {
				temp = *(p_main+j);
				*(p_main+j) = max;
				max = temp;
			}
		}
		*(p_rs+i) = max;
	}
}
//int main() {
//	int quan, option;
//	float *ptr_main, *ptr_rs;
//	printf("Input quantity of element: ");
//	scanf("%d", &quan);
//	ptr_main = (float*)calloc(quan,sizeof(float));
//	ptr_rs = (float*)calloc(quan,sizeof(float));
//	for (int i=0; i<quan; i++) {
//		printf("A[%d] = ", i);
//		scanf("%f", ptr_main+i);
//	}
//	//check array
//	for (int i=0; i<quan; i++) {
//		printf("%.1f   ", *(ptr_main+i));
//	}
//	do {
//		printf("\n");
//		printf("Choose a way to sort: \n");
//		printf("1. Bubble\n");
//		printf("2. Selection\n");
//		printf("3. Exit\n");
//		printf("Your option:  ");
//		scanf("%d", &option);
//		switch(option) {
//			case 1: {
//				printf("...Using bubble sort...");
//				printf("\n");
//				printf("Increase or Decrease?\n");
//				printf("1. Increase\n");
//				printf("2. Decrease\n");
//				printf("You choose:  ");
//				scanf("%d", &option);
//				printf("\n");
//				switch(option) {
//					case 1: {
//						printf("Increased array: ");
//						sort1_1(quan,ptr_main,ptr_rs);
//						for (int i=0; i<quan; i++) {
//							printf("%.1f   ", *(ptr_rs+i));
//						}
//						break;
//					}
//					case 2: {
//						printf("Decreased array: ");
//						sort1_2(quan,ptr_main,ptr_rs);
//						for (int i=0; i<quan; i++) {
//							printf("%.1f   ", *(ptr_rs+i));
//						}
//						break;
//					}
//					break;
//				}
//				break;
//			}
//			case 2: {
//				printf("...Using selection sort...");
//				printf("\n");
//				printf("Increase or Decrease?\n");
//				printf("1. Increase\n");
//				printf("2. Decrease\n");
//				printf("You choose:  ");
//				scanf("%d", &option);
//				printf("\n");
//				switch (option) {
//					case 1: {
//						printf("Increased array: ");
//						sort2_1(quan,ptr_main,ptr_rs);
//						for (int i=0; i<quan; i++) {
//							printf("%.1f   ", *(ptr_rs+i));
//						}
//						break;
//					}
//					case 2: {
//						printf("Decreased array: ");
//						sort2_2(quan,ptr_main,ptr_rs);
//						for (int i=0; i<quan; i++) {
//							printf("%.1f   ", *(ptr_rs+i));
//						}
//						break;
//					}
//				}
//				break;
//			}
//			case 3: {
//				printf("Exit!!");
//				break;
//			}
//		}
//	} while(option!=3);
//	return 0;
//}







/*5. Calculate the average of the array mentioned in Exercise 4.*/
//build function


//{2.3, 4.5, 4.9, 5.2, 5.7, 7.2, 7.5, 8.1, 8.3, 9.0}
//build function
//float tbc(float arr[]){
//	float tbc = 0.0;
//	for (int i=0;i<10;i++){
//		tbc += arr[i]/10;
//	}
//	return tbc;
//}
////main
//int main() {
//	float result;
//	float array[10] = {2.3, 4.5, 4.9, 5.2, 5.7, 7.2, 7.5, 8.1, 8.3, 9.0};
//	result = tbc(array);
//	printf("%f", result);
//	return 0;
//}






/*6. Find the position of the minimum element in an array.
Input: {7.2, 5.2, 4.9, 8.1, 2.3, 9.0, 5.7, 4.5, 7.5, 8.3}
Output: 4*/

//build function
//void findmin(int a, float *p_main, float rs[]){
//	float min = *(p_main);
//	for (int i=0;i<a;i++){
//		if (*(p_main+i)<min){
//			min = *(p_main+i);
//			rs[0] = min;
//			rs[1] = i;
//		}
//	}
//}
////main
//int main(){
//	int n =10;
//	float array[10] = {7.2, 5.2, 4.9, 8.1, 2.3, 9.0, 5.7, 4.5, 7.5, 8.3};
//	float *ptr_main;
//	float result[2];
//	ptr_main = array;
//	findmin(n,ptr_main,result);
//	printf("Min:  %.1f\n", result[0]);
//	printf("Position:  %.1f", result[1]);
//	return 0;
//}








/*7. Input an integer array, print out all the odd numbers in the array.*/
//build function
//void odd_array(int a, int *p_main, int *p_rs) {
//	for (int i=0; i<a; i++) {
//		if (*(p_main+i)%2 !=0) {
//			*(p_rs+i) = *(p_main+i);
//		}
//	}
//}
//
////main
//int main() {
//	int quan, *ptr_main, *ptr_rs;
//	printf("Quantity:  ");
//	scanf("%d", &quan);
//	ptr_main = (int*)calloc(quan,sizeof(int));
//	ptr_rs = (int*)calloc(quan,sizeof(int));
//	for (int i=0; i<quan; i++) {
//		scanf("%d",(ptr_main+i));
//	}
//	odd_array(quan,ptr_main,ptr_rs);
//	printf("Odd array:  ");
//	for (int i=0; i<quan; i++) {
//		if (*(ptr_rs+i) != 0) {
//			printf("%d   ", *(ptr_rs+i));
//		}
//	}
//	return 0;
//}








/*8. Declare 2D 3x3 array, then
a. Access the element (2,1) and print out on screen.
b. Print out on screen as a matrix.
c. Calculate the average of each row/column.*/

//int main() {
//	int array[3][3] = {
//		{1,2,3},
//		{4,5,6},
//		{7,8,9}
//	};
//	float avr_row[3] = {0.0,0.0,0.0};
//	float avr_col[3] = {0.0,0.0,0.0};
//	printf ("a. (2,1) =  %d  \n", array[2][1]);
//	printf ("b. \n");
//	for (int i=0; i<=2; i++) {
//		for (int j=0; j<=2; j++) {
//			printf ("%d ", array[i][j]);
//		}
//		printf ("\n");
//	}
//	printf("c. \n");
//	for (int i=0; i<3; i++) {
//		for (int j=0; j<3; j++) {
//			avr_row[i] += array[i][j]/3.0;
//			avr_col[j] += array[i][j]/3.0;
//		}
//	}
//	for (int i=0; i<3; i++) {
//		printf("Average of row %d = %.1f",i, avr_row[i]);
//		printf("\n");
//	}
//	printf ("-------------\n");
//	for (int i=0; i<3; i++) {
//		printf("Average of column %d = %.1f",i, avr_col[i]);
//		printf("\n");
//	}
//	return 0;
//}







/*9. Take input from the user in a two-dimensional array and print the row-wise and column-wise sum of
numbers stored in a two-dimensional array.*/

//int main() {
//	int col, row;
//	printf("Input number of rows and columns: ");
//	printf("Row = ");
//	scanf ("%d", &row);
//	printf("Column = ");
//	scanf("%d", &col);
//	float **p;
//	float *ptr_row, *ptr_col;
//	//dynamic mem allocation
//	p = calloc(row,sizeof(float));
//	ptr_row = calloc(row, sizeof(float));
//	ptr_col = calloc(col, sizeof(float));
//	for (int i=0; i<row; i++) {
//		for (int j=0; j<col; j++) {
//			*(ptr_row+i) = 0.0;
//			*(ptr_col+j) = 0.0;
//		}
//	}
//	for (int i=0; i<row; i++) {
//		p[i] = calloc(col,sizeof(float));
//	}
//	for (int i=0; i<row; i++) {
//		for (int j=0; j<col; j++) {
//			printf("A[%d][%d] = ", i, j);
//			scanf("%f", &p[i][j]);
//		}
//	}
//	for (int i=0; i<row; i++) {
//		for (int j=0; j<col; j++) {
//			printf("%.1f   ", p[i][j]);
//		}
//		printf("\n");
//	}
//	for (int i=0; i<row; i++) {
//		for (int j=0; j<col; j++) {
//			*(ptr_row+i) += p[i][j];
//			*(ptr_col+j) += p[i][j];
//		}
//	}
//	for (int i=0; i<row; i++) {
//		printf("Sum of row %d = %.1f\n",i,*(ptr_row+i));
//	}
//	printf("------------------\n");
//	for (int i=0; i<col; i++) {
//		printf("Sum of column %d = %.1f\n",i,*(ptr_col+i));
//	}
//	for (int i=0; i<row; i++) {
//		free(p[i]);
//	}
//	free(p);
//	return 0;
//}







/*10. You are required to build histogram of an integer-stored array. It is assumed that the integers are
greater than 0 and less than or equal to 5. Histogram of an integer is the number of times of an integer
appearing in the array.
a. Write a part of the program to count how many different numbers there are in the array.
b. Write a part of the program to count histogram of all integers.
Input: {3, 2, 5, 2, 2, 3, 4, 5, 4, 3, 5, 2, 3, 4, 1, 1}
Output: {2, 4, 4, 3, 2}*/

//build function
//void count_dif(int a, int *p, int result[]) {
//	int check;
//	result[0] = 0;
//	for (int i=0; i<a; i++) {
//		check = 1;
//		while(check!=0) {
//			for (int j=0; j<=i; j++) {
//				if(*(p+i) == result[i]) {
//					check = 0;
//				}
//			}
//		}
//		if (check=1) {
//			result[i] = *(p+i);
//		}
//	}
//}
////main
//int main() {
//	int array[16] = {3, 2, 5, 2, 2, 3, 4, 5, 4, 3, 5, 2, 3, 4, 1, 1};
//	int *ptr, result[10];
//	int n=16;
//	ptr = array;
//	printf("Input number of element: ");
//	scanf("%d", &n);
//	ptr = (int*)calloc(n,sizeof(int));
////	ptr_rs = (int*)calloc(n,sizeof(int));
//	printf("Input value of each element (<=5):\n");
//	for (int i=0; i<n; i++) {
//		printf("A[%d] = ",i);
//		scanf("%d", ptr+i);
//	}
//	printf("User array: ");	
//	for (int i=0; i<n; i++) {
//		printf("%d   ",*(ptr+i));
//	}
//	count_dif(n,ptr,result);
//	for (int i=0;i<5;i++){
//		printf("%d   ", result[i]);
//	}
//	return 0;
//}










