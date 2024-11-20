#include <stdio.h>

/*1. Write a function to calculate the total pay of a waitress where the rate of pay (thousand VND / hour)
and the number of hours. It is supposed that the number of hours is up 40, the waitress is paid at basic
rate, and above 40 at double rate. Test your code in main function */

/*analysis:
	argument: the rate of pay, number of hour
	return: total pay
*/

//float salary(float basic, float hour);
//int main(){
//	float bs, time, rs;
//	printf("Input the rate of pay: \n");
//	scanf("%f", &bs);
//	printf("Input working time: \n");
//	scanf("%f", &time);
//	printf("Your basic is %f VND per hour\n", bs);
//	printf("Working time is %f hour\n", time);
//
//	rs = salary(bs,time);
//	if (rs == -1){
//		printf("error!!");
//	}else{
//		printf("Total pay:   %f", rs);
//	}
//	return 0;
//}
////build function
//float salary(float basic, float hour){
//	float total_pay, result;
//	if (basic > 0){
//		if ( 0 < hour && hour <= 40){
//			total_pay = basic * hour;
//		}else if (hour > 40){
//			total_pay = basic * 40 + (hour - 40) * basic * 2;
//		}else{
//			total_pay = -1;
//		}
//	}else{
//		total_pay = -1;
//	}
//	result = total_pay;
//	return result;
//}








/*2. Write a function to generate an array containing square numbers given the number of elements. Test
your code in main function*/

/*analysis:
	argument: number of elements
	return: an array containing square number
*/

//void sqr_num(int n, int result[]);
//int main(){
//	int a, rs[1000];
//	printf("Input number of element: \n");
//	scanf("%d", &a);
//	sqr_num(a,rs);
//	printf("\n");
//	if (a>0){
//		printf("Square numbers:   ");
//		for (int i=0;i<=a-1;i++){
//			printf("%d   ", rs[i]);
//		}
//	}
//	return 0;
//}
////build function
//void sqr_num(int n, int result[]){
//	if (n>0){
//		for (int i = 0;i<=n-1;i++){
//			result[i] = i * i;
//		}
//	}else{
//		printf("please reinput!!");
//	}
//}









/*3. Write a function to generate a new array containing the element of a given array where two elements
k and k+1 in a given array are swapped. Test your code in main function.*/

/*analysis:
	argument: array[], position k
	return: new array with swapped elements
*/

void swap_array(int k, float array[], float result[]);
int main() {
	float arr[5] = {1.1, 2.2, 3.3, 4.4, 5.5}, rs[5];
	int a;
	printf("Input k for swapping (0<=k<4): \n");
	scanf("%d", &a);
	if (0 <= a && a < 4) {
		printf("Old array: ");
		for (int i=0; i<5; i++) {
			printf("%.1f   ", arr[i]);
		}
		swap_array(a, arr, rs);
		printf("\n");
		printf("Swap position %d and position %d\n", a, a+1);
		printf("New array: ");
		for (int i=0; i<5; i++) {
			printf("%.1f   ", rs[i]);
		}
	}
	return 0;
}
//build function
void swap_array(int k, float array[], float result[]) {
	float temp;
	if (0 <= k && k < 4) {
		for (int i=0; i<5; i++) {
			if (i == k) {
				temp = array[i];
				array[i] = array[i+1];
				array[i+1] = temp;
			}
			result[i] = array[i];
		}
	} else {
		printf("please reinput!");
	}
}














