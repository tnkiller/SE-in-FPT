#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <ctype.h>



int main() {
	int option;
	do {
		printf("          ----       ");
		printf("\n");
		printf("     ~~~~~MENU~~~~~  ");
		printf("\n");
		printf("          ----       ");
		printf("\n1. ");
		printf("\n2. ");
		printf("\n3. ");
		printf("\n4. ");
		printf("\nYou choose: ");
		scanf("%d",&option);
		switch (option) {
			case 1: {

				break;
			}
			case 2: {

				break;
			}
			case 3: {


				break;
			}
			case 4: {


				break;
			}
			case 5: {
				printf("Exit!\n");
				break;
			}
			default:{
				printf("Please choose again!!\n");
				break;
			}
		}
	} while (option!= 5);//to end program
	return 0;
}