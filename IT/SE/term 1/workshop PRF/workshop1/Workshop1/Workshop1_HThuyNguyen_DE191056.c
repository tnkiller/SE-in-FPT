#include <stdio.h>

/*1. Check prime number */
int prime(int a);
int main (){
	int n, rs;
	printf("Input any number from keyboard: \t");
	scanf("%d", &n);
	if (n>1){
		for (int i=2;i<=n;i++){
			rs = prime(i);
			if (rs == 1){
				printf("%d\n", i);
			}
		}	
	}else{
		printf("There is no prime!");
	}
	return 0;
}
//build function
int prime(int a){
	int result;
	if (a>=2){
		if (a==2){
			result = 1;
		}else if (a>2 && a % 2 != 0){
			result = 1;
		}else{
		result = -1;
		}
	}else{
		result = -1;
	}
	return result;
}

/*----------------------------------------------------------------------------------------------------*/

/*2. Calculate sequence n*/
float sum_of_fac(int n);
int main(){
	float rs;
	int a; 
	printf("Input a positive integer from keyboard: ");
	scanf("%d", &a);
	rs = sum_of_fac(a);
	if (rs==-1){
		printf("Non-existent!");
	}else{
		printf("Sum of sequence is: %f", rs);
	}
	return 0;
}
//build function
float sum_of_fac(int n){
	float sum;
	if (n>=0){
		sum = 1.0;
		for (int i=1;i<=n;i++){
			float gt = 1.0;
			for (int j=1;j<=i;j++){  //tinh giai thua
				gt *= j;
			}
			sum += 1.0/gt;	
		}
	}else {
		sum = -1;
	}
	float result = sum;
	return result;
}

/*----------------------------------------------------------------------------------------------------*/

/*3. Check triangle Equilateral*/
int equi(float a, float b, float c);
int main(){
	float a1, a2, a3;
	int rs;
	printf("Input 3 sides of triangle from keyboard: \n");
	scanf("%f%f%f", &a1, &a2, &a3);
	rs = equi(a1,a2,a3);
	if (rs == 1){
		printf("This is Equilateral!");
	}else if(rs==-1){
		printf("This is not Equilateral!");
	}
	else{
		printf("This is not triangle!");
	}
	return 0;
}
//build function
int equi(float a, float b, float c){
	int result;
	if (a>0 && b>0 && c>0){ //dk cần
		if ( a+b>c && a+c>b && b+c>a){   //dk đủ
			if (a == b && a == c){
				result = 1;	
			}else{
				result = -1;
			}
		}else{
			result = -2;
		}
	}else{
		result = -2;
	}
	return result;
}





















