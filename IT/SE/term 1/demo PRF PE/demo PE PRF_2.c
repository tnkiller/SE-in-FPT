#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <math.h>
//build function
/*function 1*/
float find_max(float a, float b, float c) {
	float max;
	if (a >= b && a >= c) max = a;
	else if (b >= a && b >= c) max = b;
	else if (c >= a && c >= b) max = c;
	return max;
}
/*funtion 2*/
int countword(char s[50]) {
	int count = 0;
	for (int i=0; i<strlen(s); i++) {
		if (isalpha(s[i]) && s[i+1] == ' ') count++;
		else if(isdigit(s[i]) && s[i+1] == ' ') count++;
		else if (isalpha(s[i]) != 1 && s[i] != ' ' && s[i+1] == ' ') count ++;
	}
	if ((s[strlen(s)]) != ' ') {
		count++;
	}
	return count;
}
/*function 3*/
int reverse(int a) {
	int reverse=0;
	while (a != 0) {
		reverse = reverse*10 + a%10;
		a /= 10;
	}
	return reverse;
}
/*function 4*/
int *del_dup(int *n, int *p) {
	int *p_rs; //con tro chua cac phan tu duy nhat
	int check;
	int a = 0; //so phan tu trung
	p_rs = (int*)calloc(*n,sizeof(int));
	int count = 0; //so luong phan tu duy nhat
	for (int i=0; i<*n; i++) {
		check = 0;
		for (int j=0; j<count; j++) {
			if (*(p_rs+j) == *(p+i)) {
				check = 1;
				a++;
				break;
			}
		}
		if (check == 0) {
			*(p_rs+count)= *(p+i);
			count++;
		}
	}
	*n-=a;
	return p_rs;
}
//main
int main() {
	int option;
	do {
		printf("---MENU---");
		printf("\n1. Find maximum between three numbers");
		printf("\n2. Count number of word");
		printf("\n3. Reverse number");
		printf("\n4. Delete duplicate values");
		printf("\n5. Exit!");
		printf("\nYou choose: ");
		scanf("%d", &option);
		switch (option) {
			case 1: {
				float x,y,z,rs;
				printf("---Find max number---");
				printf("\nInput three numbers: ");
				scanf("%f%f%f", &x, &y, &z);
				rs = find_max(x,y,z);
				printf("Max = %.1f\n",rs);
				break;
			}
			case 2: {
				char word[50];
				int rs;
				printf("---Count word---\n");
				printf("Input string: ");
				getchar();
				gets(word);
				rs = countword(word);
				printf("Number of words: %d\n", rs);
				break;
			}
			case 3: {
				int num, res;
				printf("---Reverse number---\n");
				printf("Input a number: ");
				scanf("%d", &num);
				res = reverse(num);
				printf("Reverse number is %d\n",res);
				break;
			}
			case 4: {
				int *ptr, *ptr_rs;
				int quan;
				printf("---Delete duplicate values---\n");
				printf("Input quantity of element in array: ");
				scanf("%d", &quan);
				ptr = (int*)calloc(quan,sizeof(int));
				ptr_rs = (int*)calloc(quan,sizeof(int));
				for (int i=0; i<quan; i++) {
					printf("A[%d] = ",i);
					scanf("%d",ptr+i);
				}
				printf("User array: ");
				for (int i=0; i<quan; i++) {
					printf("%d   ",*(ptr+i));
				}
				printf("\nAfter delelting dulpicate values: ");
				ptr_rs = del_dup(&quan,ptr);
				for (int i=0; i<quan; i++) {
					printf("%d   ",*(ptr_rs+i));
				}
				printf("\n");
				break;
			}
			case 5: {
				printf("Exit!!");
				break;
			}
			default: {
				printf("Please input again!\n");
				break;
			}
		}

	} while (option!=5);
	return 0;
}