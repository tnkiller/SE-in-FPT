#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <ctype.h>

//function 1
float taxi_fee(float n) {
	float fee;
	if (n<=0) fee = -1;
	else if (0<n && n<=1) fee = 15000;
	else if(n>1) fee = 15000+(n-1)*12000;
	return fee;
}

//function 2
int sum(int a) {
	int sum;
	int unit;
	if (a==0) sum=0;
	else {
		sum = 0;
		while (a!=0) {
			unit = a%10;
			sum += unit;
			a /=10;
		}
	}
	if (sum<0) sum *=-1;
	return sum;
}
//function 3
int count(char s[100]) {
	int count = 0;
	for (int i=0; i<strlen(s); i++) {
		if (isdigit(s[i])  && !isdigit(s[i+1])) count++;
	}
	if (isalnum(s[strlen(s)-1]) == 1) count++;
	return count;
}
//function 4
int isPrime(int num) {
	int res = 0;
	if (num == 2 || num%2!=0) res = 1;
	return res;
}
int *prime(int max, int *count) {
	int *p_prime = (int*)calloc(1,sizeof(int));
	int j = 0;
	if (max<=2) p_prime = NULL;
	else {
		for (int i=2; i<max; i++) {
			if (isPrime(i) == 1) {
				j++;
				p_prime = (int*)realloc(p_prime,j);
				*(p_prime+j-1) = i;
			}
		}
	}
	*count = j;
	return p_prime;
}

//main
int main() {
	int option;
	do {
		printf("          ----       ");
		printf("\n");
		printf("     ~~~~~MENU~~~~~  ");
		printf("\n");
		printf("          ----       ");
		printf("\n1. Calculate taxi fee ");
		printf("\n2. Sum of all digits");
		printf("\n3. Count the number of integer in string");
		printf("\n4. Check prime");
		printf("\nYou choose: ");
		scanf("%d",&option);
		switch (option) {
			case 1: {
				float km, res;
				printf("---Taxi fee---");
				printf("\nInput km: ");
				scanf("%f",&km);
				res = taxi_fee(km);
				if (res == -1) printf("Invalid!\n");
				else printf("%.1f", res);
				printf("\n");
				break;
			}
			case 2: {
				int num, res;
				printf("---Sum of digit---");
				printf("\nInput a digit: ");
				scanf("%d", &num);
				res = sum(num);
				printf("Sum = %d\n",res);
				break;
			}
			case 3: {
				char mess[100];
				int res;
				printf("---Count number of interger in string---");
				printf("\nInput your string: ");
				getchar();
				gets(mess);
				res = count(mess);
				printf("\t->%d integer(s) in string<-",res);
				printf("\n");
				break;
			}
			case 4: {
				int n;
				int dem = 0;
				int *rs;
				printf("---Prime---");
				printf("\nInput n: ");
				scanf("%d",&n);
				rs = prime(n,&dem);
				if (rs == NULL) printf("INVALID!!");
				else {
					for (int i=0; i<dem; i++) {
						printf("%d   ",*(rs+i));
					}
				}
				printf("\n");
				break;
			}
		}
	} while (option!= 5);//to end program
	return 0;
}