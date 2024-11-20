#include<stdio.h>
#include<ctype.h> //thu vien kiem tra digit hoac alphabet
#define epsilon 0.001 //

//float addition(float num1, float num2);
//int main(){
	/*
	global variable and local variable
	- global variable:used inside the whole program
	it exists while the program is being executed
	- local variable: used inside a code block
	it exist while that code block is being executed
	it will be freed right after the code block finishes
	*/
//	int integer = 4;
//	printf("integer = %d\n", integer);
//	int i = 2;
//	for (int i=0; i<integer; i++){  //i:local variable
//		printf("i = %d\n", i);
//	}
//	printf("i = %d\n", i);
//	int num1=5, num2=7, result;
//	printf("%d", result);
//	printf("address of num1 outside of the function: %u\n", &num1);

//	float addition(float num1, float num2){
//		/*
//		num1,num2: local variable 
//		result: local variable
//		*/
//		float result;
//		result = num1 + num2;
//		printf("address of num1 inside of the function: %u\n", &num1); //print out address
//		return result;
//	}
	
	
	
	/*
	constant
	*/
//	cons float PI = 3.14145;
	
	
	
	/*
	datatypes: int, float, double, char
	int: bit length = 2-4 bytes
	float: 4 bytes
	double: 8 bytes
	char: 1 byte
	ASCII: 
	- 127, extended ASCII: 2^8 (256)
	- character types: digits, alphabets, special characters
	*/
	
//	char d ='9';
//	printf("d = %c\n", d);
//	printf("d = %d\n", d);
//	
//	int b = d - '0';
//	printf("b= %d\n",b);
//	return 0;
	
	/*
	how to check a character either digit or alphabet
	*/
	
//	char character = 'i';
//	if ('0' <= character && character <='9'){
//		printf("it is a digit\n");
//	}else if(('a'<=character && character<='z') || ('Z'<=character && character<='A')){
//		printf("it is an alphabet\n");
//	}
//	//use ctype library
//	if (isdigit(character)){
//		printf("it is a digit\n");
//	}
//	if (isalpha(character)){
//		printf("it is an alphabet\n");
//	}
	
	
	/*
	ARRAY: data structure, sequence of continuous memomy locations which have same datatype
	*/
	
	//declare an array: datatype array_name[num_elements];
//	int int_array[3];
	//declare and initialize;
	
	
	//access the elements of an array: use indices
	//access the first element
//	printf("the first element is: %f\n", mark[0]);
//	
//	
//	//traverse an array using loop: forward & backward
//	for(int i=0;i<3;i++){
//		printf("the element %d is %f\n", i, mark[i]);
//	}
//	float mark[3] = {9.2,8.5,9.3};
//	float sum = 0.0;
//	int count = 0;
//	for(int i=0;i<3;i++){
//		sum = sum+mark[i];
//		count++;
//	}
//	float avr = sum/count;
//	printf("%f\n", avr);




int main(){
	int n, max, min;
	printf("Input number of element!\n");
	scanf("%d", &n);
	float arr[n];
	for (int i=0;i<=n-1;i++){
		printf("array[%d] = ", i);scanf("%f", &arr[i]);
	}
	arr[0] = max;
	arr[0] = min;
	for (int i=0;i<=n-1;i++){
		if (min>arr[i]){
			min = arr[i];
		}else if(max<arr[i]){
			max = arr[i];
		}
	}
	printf("Max = %d\n", max);
	printf("Min = %d", min);
	
	
	float max;
	int position;
	float score[10] = {7.2,5.2,4.9,8.1,2.3,9.0,5.7,4.5,7.5,8.3};
	max = score[0];
	for (int i=0;i<=10;i++){
		if (score[i] > max){
			max = score[i];
			position = i;
		}
	}
	printf("Position: %d", position);
	
	
//	float score[10] = {7.2,5.2,4.9,8.1,2.3,9.0,5.7,4.5,7.5,8.3};
//	for (int i=0;i<=10;i++){
//		if (score[i]<5.0){
//			score[i] = 0.0;
//		}
//	}
//	for (int i=0;i<10;i++){
//		printf("%.1f\n", score[i]);
//	}

	
	int pixels[] = {2,3,5,3,6,8,3,6,6,2,5,5,8,6}
	for 
	
	
	
	
	
	
	return 0;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	