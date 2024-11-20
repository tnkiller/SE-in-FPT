#include <stdio.h>
#include <math.h>
#include <stdlib.h>


//int main(){
//	/*
//	Menu: display the options --> select
//	switch ... cases,
//	*/
//	//generate the menu
//	
//	
//	int option;
//	do{
//	printf("/-LIST-/");
//	printf("\nThe menu is: \n");
//	printf("1. This is the first job\n");
//	printf("2. This is the second job\n");
//	printf("3. Exit\n");
//	printf("Please select an option\n");
//	scanf("%d", &option);
//		switch(option){
//			case 1:{
//				printf("The first job is done here\n");
//				break;
//			}
//			case 2:{
//				printf("The second job is done here\n");
//				break;
//			}
//			case 3:{
//				continue;
//			}
//			default:{
//				printf("Others will be done here\n");
//				break;
//			}
//		}
//	}while (option!=3);
//	return 0;
//}





////build function
//float sum(float a, float b){
//	float rs;
//	rs = a + b;
//	return rs;
//}
//
//float abs(float a, float b){
//	float rs;
//	rs = a - b;
//	return rs;
//}
//int main(){
//	int option;
//	do{
//		printf("---LIST---");
//		printf("\n");
//		printf("1. Sum of two real numbers\n");
//		printf("2. Abstraction of two real numbers\n");
//		printf("3. Exit\n");
//		scanf("%d", &option);
//		switch (option){
//			case 1:{
//				float x,y,rs;
//				printf("-Sum of two real number-\n");
//				printf("Please input a and b from your keyboard");
//				printf("\na = "); scanf("%f", &x);
//				printf("\nb = "); scanf("%f", &y);
//				printf("Sum = %f", sum(x,y));
//				break;
//			}
//			case 2:{
//				float x,y,rs;
//				printf("-Abs of two real number-\n");
//				printf("Please input a and b from your keyboard");
//				printf("\na = "); scanf("%f", &x);
//				printf("\nb = "); scanf("%f", &y);
//				printf("Abs = %f", abs(x,y));
//				break;
//			}
//			case 3:{
//				continue;
//			}
//			default:{
//				printf("Please reinput!!");
//				break;
//			}
//		}
//	}while (option!=3);
//	return 0;
//}



float triangle(float b, float h);
float circle(float r);
float sumar(float eps);
void ran(int n, int a, int b, int rs[]);
int main(){
	int option;
	do{
		printf("-----MENU-----");
		printf("\n1. Calculate area of triangle");
		printf("\n2. Calculate area of circle");
		printf("\n3. Call the function 1");
		printf("\n4. Call the function 2");
		printf("\n5. Exit\n");
		printf("Your option: ");scanf("%d",&option);
		printf("-----------------------------");
		printf("\nYou choose   %d\n", option);
		switch (option){
			case 1:{
				float base, height, rs;
				printf("Input base & height of triangle: \n");
				printf("Base = "); scanf("%f", &base);
				printf("Height = "); scanf("%f", &height);
				rs = triangle(base,height);
				if (rs == -1){
					printf("Inconsistent!!\n");
				}else {
					printf("Area of triangle is: %.1f\n", rs);
				}
				break;
			}
			case 2:{
				float rad, rs;
				printf("Input radius of circle: \n");
				printf("Radius = "); scanf("%f", &rad);
				rs = circle(rad);
				if (rs == -1){
					printf("Inconsistent!!\n");
				}else {
					printf("Area of circle is: %.1f\n", rs);
				}
				break;
			}
			case 3:{
				float e, rs;
				printf("Function 1: \n");
				printf("Input a small positive number: ");scanf("%f", &e);
				rs = sumar(e);
				if (rs==-1){
					printf("error!");
				}else{
					printf("Sum = %f\n", rs);
				}
				break;
			}
			case 4:{
				int ele, min, max, result[1000];
				printf("Function 2: \n");
				printf("Input number of element of array: "); scanf("%d", &ele);
				printf("Input Min & Max: ");scanf("%d%d", &min, &max);
				ran(ele,min,max,result);
				for (int i=0;i<ele;i++){
					printf("%d    ", result[i]);
				}
				break;
			}
			case 5:{
				printf("Exited program!!");
				break;
			}
			default:{
				printf("reinput");
				break;
			}
		}	
	}while(option!=5);
	return 0;
}
//build function
float triangle(float b, float h){
	float area;
	if (b > 0 && h > 0){
		area = (b*h)/2.0;
	}else{
		area = -1;
	}
	return area;
}

float circle(float r){
	float const pi = 3.14;
	float area;
	if (r > 0){
		area = pi*r*r;
	}else{
		area = -1;
	}
	return area;
}

//function 1
float sumar(float eps){
	float sum = 0.0;
	if (eps > 0.0){
		for (int i=1;(1.0/i)>eps;i++){  
			if (i%2==0){
				sum -= 1.0/i;
			}else{
				sum += 1.0/i;
			}
		}
	}else{
		sum = -1;
	}
	return sum;
}

//function 2
void ran(int n, int a, int b, int rs[]){
	for (int i=0;i<n;i++){
		rs[i] = rand()%(b-a+1)+a;
	}
}















