#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>
/*----------------------------*/

/*SINGLE RETURN VALUE*/

/*----------------------------*/
//1. Write a FUNCTION to calculate the addition of two real numbers.
//float sum(float n1, float n2);
//int main() {
//	float a,b;
//	printf("Input a & b: \n");
//	scanf("%f%f", &a, &b);
//	printf("Sum: %f\t", sum(a,b));
//	return 0;
//}
////build function
//float sum(float n1, float n2) {
//	float sum = n1 + n2;
//	return sum;
//}


//2.Write a FUNCTION to calculate the subtraction of two real numbers.
//float sub(float n1, float n2);
//int main(){
//	float a,b;
//	printf("Input a & b: \n");
//	scanf("%f%f", &a, &b);
//	printf("Sub: %f\t", sub(a,b));
//	return 0;
//}
////build function
//float sub(float n1, float n2){
//	float sub = n1 - n2;
//	return sub;
//}




//3. Write a FUNCTION to calculate the product of two real numbers
//float pro(float n1, float n2);
//int main(){
//	float a,b;
//	printf("Input a & b: \n");
//	scanf("%f%f", &a, &b);
//	printf("Pro: %f\t", pro(a,b));
//	return 0;
//}
////build function
//float pro(float n1, float n2){
//	float pro = n1 * n2;
//	return pro;
//}




//4. Write a FUNCTION to calculate the division of two real numbers.
//float divi(float n1, float n2);
//int main(){
//	float a,b;
//	printf("Input a & b: \n");
//	scanf("%f%f", &a, &b);
//	printf("Divi: %f\t", divi(a,b));
//	return 0;
//}
////build function
//float divi(float n1, float n2){
//	float divi = n1 / n2;
//	return divi;
//}




//5.Write a FUNCTION to find the greater number between two real numbers.
//float max(float a, float b);
//int main(){
//	float n1, n2, Max;
//	printf("Input 2 numbers from keyboard: \n");
//	scanf("%f%f",&n1, &n2);
//	Max = max(n1,n2);
//	if (Max == -1){
//		printf("Equal!");
//	} else{
//	printf("Max = %f", max(n1,n2));
//	}
//}
////build function
//float max(float a, float b){
//	float result;
//	if (a>b){
//		return a;
//	} else if(a<b) {
//		return b;
//	} else{
//		result = -1;
//		return result;
//	}
//}




//6. Write a FUNCTION to find the number of number letters in an integer number. Example: input: -1234,output: 4
//int dem(int n);
//int main(){
//	int a;
//	printf("Input number from keyboard: \n");
//	scanf("%d", &a);
//	printf("The number of number letters is: %d\t", dem(a));
//	return 0;
//}
////build function
//int dem(int n){
//	int result;
//	int count = 0;
//	do{
//		n /=10;
//		count++;
//	}
//	while(n != 0);
//	result = count;
//	return result;
//}



//7. Write a FUNCTION to calculate the area of a circle, given its radius
//float area_c(float r);
//int main(){
//	float a;
//
//	printf("Input radius of circle from keyboard: \n");
//	scanf("%f", &a);
//	if (area_c(a) == -1){
//		printf("error!");
//	}else {
//	printf("Area of this circle is: %f\t", area_c(a));
//	}
//	return 0;
//}
////build function
//float area_c(float r){
//	const float pi = 3.14;
//	float result, area;
//	if (r>0){
//	area = pi*r*r;
//	result = area;
//	}else{
//		result = -1.0;
//	}
//	return result;
//}


//8. Write a FUNCTION to calculate the area of triangle, given its base and height.
//float area_tri(float base, float height);
//int main(){
//	float b, h;
//
//	printf("Input base and height of triangle from keyboard: \n");
//	scanf("%f%f", &b, &h);
//	if (area_tri(b,h) == -1.0){
//		printf("error!");
//	} else{
//	printf("Area of triangle = %f\t", area_tri(b,h));
//	}
//	return 0;
//}
////build function
//float area_tri(float base, float height){
//	float result, area;
//	if (base>0 && height>0){
//	area = (base*height)/2;
//	result = area;
//	}else{
//		result = -1.0;
//	}
//	return result;
//}


/* 9. Write a FUNCTION to combine two integer-based parts, including decimal part and base part,
to become a real number. Example: base = -23, decimal = 45 -> output: -23.45 */
//float combined_num(float base, float decimal);
//int main(){
//	float b,d;
//
//
//	printf("Input base: \t"); scanf("%f", &b);
//	printf("Input decimal: \t"); scanf("%f", &d);
//	printf("After combine: %f", combined_num(b,d));
//
//
//	return 0;
//}
////build function
//float combined_num(float base, float decimal){
//	float result, combined;
//	while (decimal >=1){
//		decimal *=pow(10,-1);
//	}
//	combined = base + decimal;
//	result = combined;
//	return result;
//}






//10. Write a FUNCTION to check whether an integer is zero, odd or even.
//int fin(int a);
//int main(){
//	int n;
//
//	printf("Input an integer from keyboard: \n");
//	scanf("%d", &n);
//
//	switch(fin(n)){
//		case 0:{
//			printf("Your number is 0");
//			break;
//		}
//		case 1:{
//			printf("Your number is even!");
//			break;
//		}
//		case -1:{
//			printf("Your number is odd!");
//			break;
//		}
//	}
//	return 0;
//}
////build function
//int fin(int a){
//	int result;
//	if (a==0){
//		result = 0;
//	}else if (a%2==0){
//		result = 1;
//	}else{
//		result = -1;
//	}
//	return result;
//}



/*11??*/


/*12. Write a FUNCTION to check whether a triangle is Equilateral(tam giac deu),
Isosceles(tam giac can) or Scalene(tam giac thuong, given its sides. */
//int kind(float a, float b, float c);
//int main(){
//	float s1,s2,s3;
//	printf("Input 3 sides of triangle: \n");
//	scanf("%f%f%f", &s1, &s2, &s3);
//	if (kind(s1,s2,s3)==1){
//		printf("Equilateral!");
//	}else if(kind(s1,s2,s3)==-1){
//		printf("Isosceles!");
//	}else if(kind(s1,s2,s3)==0){
//		printf("Scalene!");
//	}else if(kind(s1,s2,s3)==-2){
//		printf("error!");
//	}
//	return 0;
//}
////build function
//int kind(float a, float b, float c){
//	int result;
//	if (a>0 && b>0 && c>0){
//		if (a==b && b==c){
//			result = 1;   //tamgiacdeu
//		}else if(a==b || b==c || a==c){
//			result = -1;  //tamgiaccan
//		}else {
//			result = 0;   //tamgiacthuong
//		}
//	}else{
//		result = -2;		 //error
//	}
//	return result;
//}





/* 13.You are required to write a program to calculate the taxi fee. The fee for the first kilometer is
20.000VND. Next 2 kilometers, the fee is 30.000VND/km. Next 7km, the fee is 15.000VND/km. The fee
of the distance over 10km is 10.000VND/km. Please write a FUNCTION to calculate the taxi fee respect
to the distance.*/
//float taxi_fee(float km);
//int main(){
//	float cayso;
//	printf("Input km you went: \n");
//	scanf("%f", &cayso);
//	if (taxi_fee(cayso) == -1){
//		printf("error!");
//	}else{
//	printf("Your fee in %.1f km: %.1f VND", cayso, taxi_fee(cayso));
//	}
//	return 0;
//}
////build function
//float taxi_fee(float km){
//	float fee, result;
//	if (km>0){
//		if (km<=1){
//			fee = 20000;
//		}else if(km>1 && km<3){
//			fee = 20000 + (km-1)*30000;
//		}else if(km>3 && km<10){
//			fee = 20000 + 60000 + (km-3)*15000;
//		}else{
//			fee = 20000 + 60000 + 7*15000 + (km-10)*10000;
//		}
//	}else{
//		fee = -1;
//	}
//		result = fee;
//	return result;
//}



//14. Write a FUNCTION to calculate the sum of an array.
//float sum_array(float array[],float size);
//int main(){
//	int n;
//	printf("Input number of element!\n");
//	scanf("%d", &n);
//	float arr[n];
//	for (int i=0;i<=n-1;i++){
//		printf("array[%d] = ", i);scanf("%f", &arr[i]);
//	}
//	float result = sum_array(arr,n);
//	printf("Sum of array: %.1f\t", result);
//	return 0;
//}
////build function
//float sum_array(float array[], float size){
//	int i;
//	float sum = 0;
//	for (i=0;i<=size;i++){
//		sum +=array[i];
//	}
//	float result = sum;
//	return result;
//}





//15. Write a FUNCTION to find a maximum value in an array.
//float max(float array[], float n);
//int main(){
//	int length;
//	printf("Input number of element from keyboard!\n");
//	scanf("%d", &length);
//	float arr[length];
//	for (int i=0;i<=length-1;i++){
//		printf("array[%d] = ", i); scanf("%f", &arr[i]);
//	}
//	//nhập phần tử cho mảng từ bàn phím
//	float Max = max(arr,length);
//	printf("Maximum value in this array is: %.1f\t", Max);
//	return 0;
//}
////build function
//float max(float array[], float n){
//	float max = array[0];
//	for (int i=0;i<=n;i++){
//		if (array[i+1] >= max){
//			max = array[i+1];
//		}
//	}
//	float result = max;
//	return result;
//}





//16. Write a FUNCTION to find the position of an element having greatest value.
//int p_max(float array[], float n);
//int main(){
//	int length;
//	printf("Input number of element from keyboard!\n");
//	scanf("%d", &length);
//	float arr[length];
//	for (int i=0;i<=length-1;i++){
//		printf("array[%d] = ", i); scanf("%f", &arr[i]);
//	}
//	int p_Max = p_max(arr,length);
//	printf("The position of an element having greatest value is: %d\t", p_Max);
//	return 0;
//}
////build function
//int p_max(float array[], float n){
//	int p_max;
//	float max = array[0];
//	for (int i=0;i<=n;i++){
//		if (array[i+1] >= max){
//			p_max = i+1;
//		}
//	}
//	int result = p_max;
//	return result;
//}

/*----------------------------*/

/*MULTIPLE RETURN VALUE*/

/*----------------------------*/


//17. Write a FUNCTION to calculate the roots of a quadratic equation, given its parameters
//void root(float a, float b, float c);
//int main (){
//	float n1,n2,n3;
//	printf ("Input parameter for quadratic equation: \n ");
//	printf("a = "); scanf("%f", &n1);
//	printf("b = "); scanf("%f", &n2);
//	printf("c = "); scanf("%f", &n3);
//	printf("Equation form: %.1fx^2 + %.1fx + %.1f = 0\n", n1, n2, n3);
//	root(n1,n2,n3);
//	return 0;
//}
////build function
//void root(float a, float b, float c){
//	if (a!=0){
//		float delta = b*b - 4*a*c;
//		printf("Delta = %.1f\n", delta);
//		if (delta>0){
//			printf("PT co 2 nghiem phan biet!\n");
//			float x1 = (-b + sqrt(delta))/2*a;
//			float x2 = (-b - sqrt(delta))/2*a;
//			printf("x1 = %.1f\n",x1);
//			printf("x2 = %.1f",x2);
//		}else if(delta == 0){
//			printf("PT co nghiem kep\n");
//			float x = -b/(2*a);
//			printf("x1 = x2 = %f", x);
//		}else{
//			printf("PT vo nghiem");
//		}
//	}else{
//		printf("Ko xac dinh");
//	}
//}



//18. Write a FUNCTION to find the maximum value in array and its position.
//void find_max(int n, float array[], float result[]);
//int main(){
//	int numElement;
//	float arr[100], rs[2]; 
//	printf("Input number of element from keyboard!\n");
//	scanf("%d", &numElement);
//	for (int i=0;i<numElement;i++){
//		printf("array[%d] = ", i); scanf("%f", &arr[i]);
//	}
//	find_max(numElement,arr,rs);
//	printf("Max = %.1f", rs[0]);
//	printf("\nPosition = %.1f", rs[1]);
//	return 0;
//}
////build function
//void find_max(int n, float array[], float result[]){
//	float max = array[0], position = 0.0;
//	for (int i=0;i<n;i++){
//		if (array[i]>max){
//			max = array[i];
//			position = 1.0*i;
//		}	
//	}
//			result[0] = max;
//			result[1] = position;
//}




//19. Write a FUNCTION to generate an array containing random real numbers in a segment of m and n
//void rand_N(int m, int n, int limit, float result[]);
//int main(){
//	int a, b, lim;
//	float rs[100];
//	printf("Input segment of a and b and lim: \n");
//	scanf("%d%d%d", &a, &b, &lim);
//	rand_N(a,b,lim,rs);
//	for (int i=0;i<lim;i++){
//		printf("Phan tu thu %d cua mang: %.1f\n", i, rs[i]);
//	}
//	return 0;
//}
////build function
//void rand_N(int m, int n, int limit, float result[]){
//	srand((int)time(0));
//	for (int i=0;i<limit;i++){
//		int number = rand() % (n-m+1) + m;
//		result[i] = number;
//	}
//}







//20. Write a FUNCTION to change a value of an array’s elements which are less than 5 to 0.

//void change(int n, float array[], float result[]);
//int main(){
//	int a;
//	float arr[1000]; float rs[1000];
//	printf("Input quantity of element: \n");
//	scanf("%d", &a);
//	if (a>0){
//		for (int i=0;i<a;i++){
//			printf("A[%d] = ", i); scanf("%f", &arr[i]);
//		}
//		printf("Ori array:   ");
//		for (int i=0;i<a;i++){
//			printf("%.1f   ",arr[i]);
//		}
//		printf("\n");
//		change(a,arr,rs);
//		printf("Changed array: ");
//		for (int i=0;i<a;i++){
//			printf("%.1f   ", rs[i]);
//		}
//	}else{
//		printf("Please reinput!!");
//	}
//	return 0;
//}
////build function
//void change(int n, float array[], float result[]){
//	for (int i=0;i<n;i++){
//		if (array[i] < 5){
//			array[i] = 0;
//		}
//	}
//	for (int i=0;i<n;i++){
//		result[i] = array[i];
//	}	
//}











