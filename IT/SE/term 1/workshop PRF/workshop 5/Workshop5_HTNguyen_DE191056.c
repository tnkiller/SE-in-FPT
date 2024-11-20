#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <ctype.h>


/*1. The first function is called to read data from the txt file. Please find the attached txt file. The txt file
includes 3 fields. The first is the names of the students. The second is the classes of the students. And
the third is the score of the students. The function will store names, classes and marks in to three
corresponding arrays. Please do traversal all arrays after the function is called to show your result.*/
int file(FILE *p_file, char name[][50], char clas[][10], float mark[]) {
	int i = 0;
	while (i < 4 && fscanf(p_file, "%[^-] - %[^-] - %f\n", name[i], clas[i], &mark[i]) == 3) {
		i++;
	}
	return i;
}




/*2. The second function is called to calculate the length and width of a rectangle with given perimeter
and area.*/
float *cal(float peri, float area) {
	float S = (peri/2);
	float P = area;
	float *rs;
	rs = (float*)calloc(2,sizeof(float));
	//a = length   b = width
	if (peri > 0 && area > 0) {
		if (pow(S,2) - 4*P > 0) {
			float delta = pow(S,2) - 4*P;
			*(rs+1) = (S + sqrt(delta))/2.0;
			*(rs+2) = (S - sqrt(delta))/2.0;
		} else if((pow(S,2) - 4*P == 0)) {
			*(rs+1) = S/2.0;
			*(rs+2) = *(rs+1);
		} else {
			*(rs) = -1;
		}
	}else{
		*(rs) = -1;
	}
	return rs;
}





/*3. The third function is used to calculate the area of circle with given radius.*/
float area_cir(float r) {
	const float pi = 3.14;
	float rs;
	if (r<=0) rs = -1;
	else rs = pi*r*r;
	return rs;
}


//main
int main() {
	char option;
	do {
		printf("          ----       ");
		printf("\n");
		printf("     ~~~~~MENU~~~~~  ");
		printf("\n");
		printf("          ----       ");
		printf("\na. File");
		printf("\nb. Calculate width and length");
		printf("\nc. Calculate area of circle");
		printf("\nq. Exit");
		printf("\nYou choose: ");
		scanf(" %c",&option);
		switch (option) {
			case 'a': {
				char ten[10][50], lop[10][10];
				float diem[10];
				FILE *ptr_file = fopen("data_WS5.txt","r");
				printf("---Read from file---");
				printf("\n");
				printf("Name\t\t Class\t\t Mark");
				printf("\n");
				int temp = file(ptr_file,ten, lop, diem);
				for (int i = 0; i < temp; i++) {
					printf("%s\t %s\t %.1f\n", ten[i], lop[i], diem[i]);
				}
				printf("Closed file!");
				printf("\n");
				break;
			}
			case 'b': {
				float cv,dt;
				float *res;
				printf("---Calculate W and L of rectangle---");
				printf("\nInput perimeter & area: ");
				printf("\nPerimeter = ");
				scanf("%f",&cv);
				printf("Area = ");
				scanf("%f",&dt);
				res = cal(cv,dt);
				if (*res == -1) printf("Invalid!");
				else {
					printf("Length = %.1f", res[1]);
					printf("\nWidth = %.1f", res[2]);
				}
				printf("\n");
				break;
			}
			case 'c': {
				float rad, res;
				printf("---Area of circle---");
				printf("\nRadius = ");
				scanf("%f",&rad);
				res = area_cir(rad);
				if (res == -1) printf("Invalid!!");
				else printf("Result = %f",res);
				printf("\n");
				break;
			}
			case 'q': {
				printf("Exit!!");
				break;
			}
			default: {
				printf("Please choose again!!\n");
				break;
			}
		}
	} while (option!= 'q');//to end program
	return 0;
}