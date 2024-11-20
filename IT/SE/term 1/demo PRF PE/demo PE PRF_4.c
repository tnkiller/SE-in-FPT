#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <ctype.h>



//function 1
int per_check(int num) {
	int sum = 0;
	for (int i=1; i<num; i++) {
		if (num%i == 0) sum +=i;
	}
	if (sum == num) return 1;
	else return 0;
}





//function 2
int sum_odd(int a, int *p_arr) {
	int sum =0;
	for (int i=0; i<a; i++) {
		if (*(p_arr+i)%2 != 0) sum +=*(p_arr+i);
	}
	return sum;
}





//function 3
int *perfect(int x, int *count) {
	int *p_rs = (int*)calloc(1,sizeof(int));
	int j= 0;
	for (int i = 1; i<x; i++) {
		if (per_check(i) == 1) {
			j++;
			p_rs = (int*)realloc(p_rs,j);
			*(p_rs+j-1) = i;
		}
	}
	*count = j;
	return p_rs;
}





//function 4
int count_time(char str_ori[], char str_cmp[]) {
	int count = 0;
	for (int i=0; i<=strlen(str_ori)-strlen(str_cmp); i++) {
		if (strncmp(str_ori+i,str_cmp,strlen(str_cmp)) == 0) count++;
	}
	return count;
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
		printf("\n1. Perfect number");
		printf("\n2. Sum of odd");
		printf("\n3. Generate perfect number list");
		printf("\n4. Count occurrences");
		printf("\n5. Exit");
		printf("\nYou choose: ");
		scanf("%d",&option);
		switch (option) {
			case 1: {
				int a, res;
				printf("---Perfect number---");
				printf("\nInput a number: ");
				scanf("%d", &a);
				res = per_check(a);
				if (res == 1) printf("Perfect number!!\n");
				else printf("NOT perfect number!!\n");
				break;
			}
			case 2: {
				int quan, res;
				int *ptr_arr;
				printf("---Sum of odd---");
				printf("\nInput number of element: ");
				scanf("%d", &quan);
				ptr_arr = (int*)calloc(quan,sizeof(int));
				for (int i=0; i<quan; i++) {
					printf("A[%d] = ", i);
					scanf("%d",(ptr_arr+i));
				}
				res = sum_odd(quan,ptr_arr);
				printf("Sum of odd: %d\n", res);
				break;
			}
			case 3: {
				int n;
				int dem;
				printf("---Generate perfect---");
				printf("\nInput n: ");
				scanf("%d", &n);
				int *ptr_rs = perfect(n,&dem);
				for (int i=0; i<dem; i++) {
					printf("%d   ", *(ptr_rs+i));
				}
				printf("\n");
				break;
			}
			case 4: {
				char s[1000], ss[1000];
				printf("---Count occurences---");
				printf("\nInput original string: ");
				getchar();
				gets(s);
				printf("Input substring: ");
				gets(ss);
				int res = count_time(s,ss);
				printf("--->%d time(s) <---\n", res);
				break;
			}
			case 5: {
				printf("Exit!!\n");
				break;
			}
			default: {
				printf("Please choose again!!\n");
				break;
			}
		}
	} while (option!= 5);//to end program
	return 0;
}