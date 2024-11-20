#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
//build function

/*function a(Fibonacci)*/
int *fibo(int a) {
	int *p;
	if (a>0) {
		*(p+1) = 1;
		*(p+2) = 1;
		for (int i=3; i<=a; i++) {
			*(p+i) = *(p+i-1) + *(p+i-2);
		}
		for (int i=0; i<a; i++) {
			*(p+i) = *(p+i+1);
		}
	} else {
		*(p) = -1;
	}
	return p;
}

/*Function b (Sort name)*/
//check name
int check_name(int a, char name[60][60], char temp_sen[60][60]) {
	//check apprearance of number
	int check = 1;
	for (int i=0; i<a; i++) {
		for (int j=0; j<=strlen(name[i]); j++) {
			if (isdigit(name[i][j])) {
				check = 0;
				break;
			}
		}
		if (check == 0) break;
	}
	return check;
}
//sort name according to increasing alphabet
void sort_name(int a, char name[60][60], char temp_sen[60][60]) {
	char *temp;
	char te_sen[60][60];
	temp = (char*)calloc(a,sizeof(char));
	//search the first letter element and save it to pointer "temp"
	for (int i=0; i<a; i++) {
		for (int j=strlen(name[i]); j>=0; j--) {
			if (name[i][j-1] == ' ') {
				*(temp+i) = name[i][j];
				strcpy(temp_sen[i],name[i]);
				break;
			}
		}
	}
	//swap
	for (int i=a-1; i>0; i--) {
		for (int j=0; j<=i-1; j++) {
			char te;
			if (*(temp+j) > *(temp+j+1)) {
				te = *(temp+j);
				*(temp+j) = *(temp+j+1);
				*(temp+j+1) = te;
				//swap name
				strcpy(te_sen[j],temp_sen[j]);
				strcpy(temp_sen[j],temp_sen[j+1]);
				strcpy(temp_sen[j+1],te_sen[j]);
			}
		}
	}
}

//menu main
int main() {
	char option;
	do {
		printf("\n-----MENU-----");
		printf("\na. Fibonacci sequence");
		printf("\nb. Sort name");
		printf("\nq. Quit");
		printf("\nYou choose: ");
		scanf(" %c", &option); //white-space used to consume any newline character
		switch (option) {
			case 'a': {
				int n;
				int *ptr;
				printf("---Fibonacci sequence---");
				printf("\nInput n: ");
				scanf("%d", &n);
				ptr = (int*)calloc(n,sizeof(int));
				ptr = fibo(n);
				if (*(ptr) == -1) {
					printf("Invalid!!");
				} else {
					printf("Result: ");
					for (int i=0; i<n; i++) {
						printf("%d   ", *(ptr+i));
					}
				}
				break;
			}
			case 'b': {
				int n, cek;
				char NAME[60][60];
				char RS[60][60];
				printf("---Sort name---\n");
				printf("Input number of name: ");
				scanf("%d",&n);
				getchar();
				for (int i=0; i<n; i++) {
					printf("Name %d: ",i+1);
					gets(NAME[i]);
				}
				cek = check_name(n,NAME,RS);
				if (cek == 1) {
					sort_name(n,NAME,RS);
					printf("Sorted name: \n");
					for (int i=0; i<n; i++) {
						printf("\t\t%s\n",RS[i]);
					}
				} else {
					printf("Invalid name!!");
				}
				break;
			}
			case 'q': {
				printf("Quit!");
				break;
			}
			default: {
				printf("Please choose again");
				break;
			}
		}
	} while (option != 'q');
	return 0;
}