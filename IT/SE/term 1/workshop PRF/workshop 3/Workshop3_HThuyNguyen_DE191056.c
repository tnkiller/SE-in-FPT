#include <stdio.h>
#include <math.h>
//function 1 -->Calculate personal income tax
/*In Viet Nam, each people has to pay for yearly personal income tax. The general rule is if your
income per month is less than or equal to 9 million VND, you will not pay. Otherwise you will
pay. Specifically, if the income is from 9 000 001 VND to 15 000 000 VND, you must pay 10% of
the amount of income that over 9 million VND. If the income is over 15 million VND, you must
pay 20% of the amount of income that over 15 million VND. Write a program to calculate the
tax that a person must pay, given that the her/his income is inputted from the keyboard.*/
float cal_tax(float income) {
	float tax;
	if (income > 0) {
		if (income <= 9000000) {
			tax = 0;
		} else if(income > 9000000 && income <= 15000000) {
			tax = (income-9000000)*10.0/100.0;
		} else {
			tax = (income-15000000)*20.0/100.0;
		}
	} else {
		tax = -1;
	}
	return tax;
}

/*----------------------------------------------------------*/

//function 2 -->Check whether a number is power of 2
/*Input a number from the keyboard, then check whether the number is power of 2.*/
void check_num(int a, int rs[]) {
	int mu = 0;
	while (a > 0 && a%2==0) {
		a /= 2;
		mu++;
	}
	if (a == 1) {
		rs[0] = 1; //yes
		rs[1] = mu;
	} else {
		rs[0] = 0; //no
	}
}





/*----------------------------------------------------------*/

//function 3 -->Calculate the sum of the following series
/*Given the sum as follows. Here, x and n are inputted from the keyboard*/
float sum_of(float x, int n) {
	float sum = 0.0;
	int gt;
	if (n > 0) {
		for (int i=1; i<=n; i=i+4) {
			gt = 1;
			for (int j=1; j<=i; j++) {
				gt *=j;
			}
			sum += pow(x,i)/gt;
		}
		for (int i=3; i<=n; i=i+4) {
			gt = 1;
			for (int j=1; j<=i; j++) {
				gt *=j;
			}
			sum -= pow(x,i)/gt;
		}
	} else {
		sum = -1;
	}
	return sum;
}






//main
int main() {
	int opt;
	do {
		printf("-----MENU-----");
		printf("\n1. Calculate income tax\n");
		printf("2. Check whether a number is power of 2\n");
		printf("3. Calculate the sum of the following series\n");
		printf("4. Exit program\n");
		printf("\nPlease choose (1,2,3,4):\n");
		printf("Your option is\t");
		scanf("%d", &opt);
		switch (opt) {
			case 1: {
				//income tax
				float ic, result;
				printf("---Calculating income tax program---\n");
				printf("Input your income per month: ");
				scanf("%f", &ic);
				result = cal_tax(ic);
				if (result == -1) {
					printf("error!\n");
				} else {
					printf("Your tax is %.1f\n", result);
				}
				break;
			}
			case 2: {
				//power of 2
				int num, res[2];
				printf("---Check a number is power of 2---\n");
				printf("Input your number(integer) from keyboard: \t");
				scanf("%d", &num);
				check_num(num, res);
				if (res[0] == 1) {
					printf("YES!! %d is power of 2\n", num);
					printf("Because 2^%d = %d\n", res[1], num );
				} else {
					printf("NO!! %d is NOT power of 2\n", num);
				}
				break;
			}
			case 3: {
				//sum of series
				float result, a;
				int b;
				printf("---Calculate sum of series---\n");
				printf("Input x & n from keyboard: \t\n");
				scanf("%f%d", &a, &b);
				result = sum_of(a,b);
				if (result != -1) {
					printf("Sum of series:  %f\n", result);
				} else {
					printf("Error!!\n");
				}
				break;
			}
			case 4: {
				printf("Exit program!!");
				break;
			}
			default: {
				printf("PLEASE CHOOSE AGAIN!!\n");
				break;
			}
		}
	} while(opt!=4);
	return 0;
}