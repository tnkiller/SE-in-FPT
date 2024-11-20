#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>
#include <ctype.h>

//function 1
float cylinder(float r, float h) {
	const float pi = 3.14;
	float res;
	if (r > 0 && h > 0) {
		res = (r*r*pi)*h;
	} else {
		res = -1;
	}
	return res;
}


//function 2
float cost(float a) {
	float res;
	if (a>0) {
		if (a < 70) res = 5*a;
		else if (a >= 70 && a<=150) res = 5*70+(a-70)*4.5;
		else if (a>150) res = 5*70 + 80*4.5 + (a-150)*4;
	} else {
		res = -1;
	}
	return res;
}


//function 3
int gt(int num) {
	int rs=1;
	for (int i=1; i<=num; i++) {
		rs *= i;
	}
	return rs;
}
//
float taylor(float eps, float angle) {
	float sum = 0.0;
	int a = 1;
	int i = 1;
	while(fabs(pow(angle,i)/gt(i)) > eps) {
		i = i+2;
	}
	for (int j=1; j<=i; j=j+2) {
		sum += a*pow(angle,j)/gt(j);
		a *= -1;
	}
	return sum;
}



//function 4
char *character(char str[],int *count) {
	char *p;
	p = (char*)calloc(1,sizeof(char));
	*p = str[0];
	int quan = 1;

	for (int i=1; i<strlen(str); i++) {
		int check = 1;
		for (int j=0; j<quan; j++) {
			if (p[j] == str[i]) {
				check = -1;
				break;
			}
		}
		if (check == 1) {
			quan++;
			p = (char*)realloc(p,quan);
			p[quan-1] = str[i];
		}
	}
	*count = quan;
	return p;
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
		printf("\n1. Calculate volume of cylinder");
		printf("\n2. Calculate cost estimation");
		printf("\n3. Taylor");
		printf("\n4. Characteristic");
		printf("\n5. Exit");
		printf("\nYou choose: ");
		scanf("%d",&option);
		switch (option) {
			case 1: {
				float radius, height, result;
				printf("---Cylinder---");
				printf("\nInput radius and height: ");
				scanf("%f%f", &radius, &height);
				result = cylinder(radius, height);
				if (result == -1) printf("Invalid\n");
				else printf("Volume of cylinder is %f\n", result);
				break;
			}
			case 2: {
				float n, result;
				printf("---Cost estimation---");
				printf("\nInput area of concrete floor: ");
				scanf("%f",&n);
				result = cost(n);
				if (result == -1) printf("Cost estimation = %.1f\n", result);
				else printf("Cost estimation = %.1f million VND\n", result);
				break;
			}
			case 3: {
				float e, a, res;
				printf("---Talor---");
				printf("\nInput epsilon and angle: ");
				scanf("%f%f", &e, &a);
				res = taylor(e,a);
				printf("Sine of angle = %f\n", res);
				break;
			}
			case 4: {
				char s[1000];
				char *p_rs;
				int dem = 0;
				printf("---Characteristic---");
				printf("\nInput string: ");
				getchar();
				gets(s);
				p_rs = character(s, &dem);
				for (int i=0; i<dem; i++) {
					printf("'%c',",p_rs[i]);
				}
				printf("\n");
				break;
			}
			case 5: {
				printf("Exit!\n");
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