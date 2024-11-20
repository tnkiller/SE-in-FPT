#include <stdio.h>

//example 1: declare of the function
//float cubic(float realNumber);	//prototype of the function


//example 2: declare of the function
//float sum(float n1, float n2); 
//float divide(float n1, float n2);    
//float multiply(float n1, float n2);
//float subtract(float n1, float n2);


//example 3:
//float area(float base, float height){
//	float result;
//	if (base > 0 && height > 0){
//	result = (base*height)/2.0;
//	}
//	else{
//		result = -1;
//	}
//	return result;
//}


//example 4:
//float sumSeq(float e){
//	float result = -1.0;
//	if (e>0){
//		result=0;
//		for(int i=1;1.0/i>e;i++){
//			result += 1.0/i;
//		}
//	}
//	return result;
//}


//dem chu so
int dem_n(int n);
int main (){
	//-----------------------------------------------------------------------------------------------//
	/* 
	function
	reasons: easy to debug, re-used
	there are 2 ways to implement a function
	1: declare and build the function before main function
	2: declare a function before main function then build it after the main function ends
	recommend 2.
	*/	
	
	
	/*
	FUNCTION: 
	parts: the beginning ,and the end of the function
	and command in body of the function
	declare a function:
	- datatype that the function returns
	- name of the function
	- arguments (data that the function uses to do its job, that values that the function returns)
	- return value: the value that the function returns
	- command in body: used to process the data passed from arguments
	*/
	
	/*
	function types:
	- no return values, no argument: -->procedure
	- return values, no argument:  -->rare to be used 
	- no return values, argument: -->used to return an array
	- return values, argument: -->often used
	*/
	
	//-----------------------------------------------------------------------------------------------//
	
	/*
	Example: write a function to calculate the cubic of real number
	arguments: real number(float)
	return: the cubic of real number(float)
	return datatype: float
	*/
	
	//use the built function
//	float n;
//	printf("input real number: \t");
//	scanf("%f", &n);
//	//call the function
//	float res;
//	res = cubic(n);
//	printf("cubic of n is: %.1f\t", res);
	
	

	/*
	write the function to calculate the sum of two real number. Test the function.
	*/
//	float a, b;
//	printf("Input two number: \n");
//	scanf("%f%f", &a, &b);
//	if (b!=0){
//		printf("Division: %.1f\n", divide(a,b));
//	}
//	else{
//		printf(" division error!\n");
//	}
//	printf("Sum:%.1f\n", sum(a,b));
//	printf("Subtraction:%.1f\n", subtract(a,b));
//	printf("Multiply:%.1f\n", multiply(a,b));



//	float base, height;
//	printf("Input base & height: ");
//	scanf("%f%f", &base, &height);
//	if (area(base,height) > 0){
//		printf("Area of triangle is: %.1f", area(base,height));
//	}
//	else if(area(base,height) == -1){
//		printf("error!");
//	}


//float eps;
//printf("Input epsilon: \t");
//scanf("%f", &eps);
//float sum = sumSeq(eps);
//if (sum == -1.0){
//	printf("error!");
//}
//else{
//	printf("Sum of sequence = %f\n", sum);
//}


//dem chu so
	int n, count;
	printf("input n:");
	scanf("%d", &n);
	count = dem_n(n);
	printf("The number of digit: %d\t", count);
	return 0;
}


//example 1: build the function
// float cubic(float realNumber){     //the beginning
//	float result;
//	result = realNumber*realNumber*realNumber;
//	return result; //the end
//}


//example2: 
//float sum(float n1, float n2){
//	float result;
//	result = n1+n2;
//	return result;
//}
//float divide(float n1, float n2){
//	float result;
//	result = n1/n2;
//	return result;
//}	
//float multiply(float n1, float n2){
//	float result;
//	result = n1*n2;
//	return result;
//}
//float subtract(float n1, float n2){
//	float result;
//	result = n1-n2;
//	return result;
//}



//dem chu so
int dem_n(int n){
	int count;
	count = 1;
	while (n/10 != 0){
		n /=10;
		count++;
	}
	return count;
}












