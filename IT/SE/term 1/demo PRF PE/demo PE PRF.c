#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <time.h>

/*1. Write a function to calculate the area of a circle. The function returns -1 if the radius is invalid.
(with PI = 3.14159).*/
//function 1
float area_circle(float r) {
	const float pi = 3.14159;
	float result;
	if (r>0) {
		result = pi*r*r;
	} else {
		result = -1;
	}
	return result;
}




/*2. A square number or perfect square is an integer that is the square of an integer. For example, 9
is a square number, since it equals 3^2 and can be written as 3 × 3.
Write a function that checks for a perfect square? (1 marks)*/
//function 2
int check_perfect(int n) {
	int a = sqrt(n);
	if (a*a == n) return 1;
	else return 0;
}




/*3. Write a function to Count the number of words in string. (2 marks)
Ex: I love you -> return 3*/
//function 3
int count_word(char mess[]) {
	int count = 0;
	for (int i=0; i<=strlen(mess); i++) {
		if (isalpha(mess[i]) && mess[i+1] == ' ') count++;
		else if (isdigit(mess[i] && mess[i+1] == ' ')) count++;
		else if (isalpha(mess[i]) != 1 && mess[i] != ' ' && mess[i+1] == ' ') count++;
	}
	if (mess[strlen(mess)-1] != ' ') count++;
	return count;
}





/*4. Write a function to square all the elements of an array.
For example, if the input array is {1,4,5,8} then the function returns {1,16,25,84}. (2 marks)*/
//function 4
int *square_array(int n, int *p) {
	int *p_rs;
	if (n>0) {
		for (int i=0; i<n; i++) {
			*(p_rs+i) = *(p+i) * *(p+i);
		}
	} else {
		*(p_rs) = -1;
	}
	return p_rs;
}



//main
int main() {
	int option;
	do {
		printf("            ----       ");
		printf("\n");
		printf("     ~~~~~M.E.N.U~~~~~  ");
		printf("\n");
		printf("            ----       ");
		printf("\n1. Calculate area of circle");
		printf("\n2. Check perfect number");
		printf("\n3. Count number of word");
		printf("\n4. Square array");
		printf("\nYou choose: ");
		scanf("%d",&option);
		printf("\n");
		switch (option) {
			case 1: {
				float radius, rs;
				printf("---Calculate area of circle---");
				printf("\nRadius = ");
				scanf("%f",&radius);
				rs = area_circle(radius);
				if (rs == -1) {
					printf("Invalid!!\n");
				} else {
					printf("Area of circle is %f\n",rs);
				}
				printf("\n");
				break;
			}
			case 2: {
				int num,rs;
				printf("---Check perfect number---");
				printf("\nYour number: ");
				scanf("%d",&num);
				rs = check_perfect(num);
				if (rs == 1) printf("Yes!");
				else printf("No!");
				printf("\n");
				break;
			}
			case 3: {
				char s[50];
				int rs;
				printf("---Count number of word---");
				printf("\nYour message: ");
				getchar();
				gets(s);
				rs = count_word(s);
				printf("\t-> %d word(s) <-\n",rs);
				printf("\n");
				break;
			}
			case 4: {
				int quan;
				int *ptr, *ptr_rs;
				printf("---Square array---");
				printf("\nInput quantity of element in array: ");
				scanf("%d",&quan);
				ptr = (int*)calloc(quan,sizeof(int));
				ptr_rs = (int*)calloc(quan,sizeof(int));
				for (int i=0; i<quan; i++) {
					printf("A[%d] = ",i);
					scanf("%d",(ptr+i));
				}
				printf("Original array: ");
				for (int i=0; i<quan; i++) {
					printf("%d   ",*(ptr+i));
				}
				printf("\nSquare array: ");
				ptr_rs = square_array(quan,ptr);
				if (*(ptr_rs) == -1) {
					printf("Invalid!!");
				} else {
					for (int i=0; i<quan; i++) {
						printf("%d   ",*(ptr_rs+i));
					}
				}
				printf("\n");
				break;
			}
		}
	} while (option!= 5);//to end program
	return 0;
}







