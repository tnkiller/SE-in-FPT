#include <stdio.h>
//assignment1
//int main(){
//	float a, b;
//	
//	printf("Input a and b from keyboard: \n");
//	printf("a = ");
//	scanf("%f", &a);
//	printf("b = ");
//	scanf("%f", &b);
//	
//	printf("Sum = %.2f\n", a + b);
//	printf("Subtract = %.2f\n", a - b);
//	printf("Product = %.2f\n", a * b);
//	printf("Division = %.2f\n", a/b);
//}




//assignment2
//int main(){
//	
//	int a;
//	printf("Input any integer from keyboard: \t");
//	scanf("%d", &a);
//	if ((a % 2) == 0){
//		printf("Your number is even!");	
//	}
//	else{
//		printf("Your number is odd!");
//	}
//	
//	return 0;
//}




//assignment3
//int main(){
//	
//	float base, height, area;
//	
//	printf("Input the base and height of triangle from keyboard: \n");
//	printf("Base = \t");
//	scanf("%f", &base);
//	printf("Height = \t");
//	scanf("%f", &height);
//	area = (base * height)/2;
//	printf("Area of your triangle is: %.2f\t", area);
//	
//	
//	return 0;
//}



//assignment4
int main(){
	
	float fee, km, total_fee;
	
	printf("How many kilometers did you go?: \t");
	scanf("%f", &km);
	
	if (km >= 0){
		if (0 < km <= 1){
			fee = 20000;
			total_fee = fee * km;
			printf("Your fee is: %.1f", total_fee);
		}
		else if (km <=3){
			fee = 30000;
			total_fee = 20000 + fee * (km-1);
			printf("Your fee is: %.1f", total_fee);
		}
		else if (km <= 10){
			fee = 15000;
			total_fee = 20000 + 30000 * 2 + (km - 3);
			printf("Your fee is: %.1f", total_fee);
		}
		else {
			fee = 10000;
			total_fee = 20000 + 30000 * 2 + 15000 * 7 + 10000 * (km - 10);
			printf("Your fee is: %.1f", total_fee);
		}
	}
	else {
		printf("Wrong input!");
	}
	
return 0;	
}



//assignment5
//int main (){
//	float a, b, c;
//	
//	printf("Input 3 numbers from keyboard: \n");
//	
//	scanf("%f %f %f", &a, &b, &c);
//	if (a>b && a>c){
//		printf("Max: %.2f\t", a);
//	}
//	else if (b>a && b>c){
//		printf("Max: %.2f\t", b);
//	}
//	else if (c>a && c>b){
//		printf("Max: %.2f\t", c);
//	}
//	
//	return 0;
//}



//assignment6
//int main(){
//	int a, b;
//	printf("Input 2 integer from keyboard: \n");
//	scanf("%d %d", &a, &b);
//	
//	if (a==b){
//		printf("They are equal");
//	}
//	else {
//		printf("They are not equal");
//	}
//	
//	return 0;
//}




//assignment7
//int main(){
//	int a;
//	printf("Input any number from keyboard: \t");
//	scanf("%d", &a);
//	if (a * -1 < 0){
//		printf("positive");
//	}
//	if (a * -1 > 0){
//		printf("negative");
//	}
//	return 0;
//}




//assignment8
//int main(){
//	
//	int year;
//	printf("Input any year from keyboard \n");
//	scanf("%d", &year);
//	
//	if (year % 4 == 0 && year % 100 > 0){
//		printf("Leap year!");
//	}
//	else{
//		printf("Not leap year!");
//	}
//	
//	return 0;
//}




//assignment9
//int main(){
//	
//	int a;
//	printf("Input a number need to be encoded from keyboard! \n");
//	scanf("%d", &a);
//	
//	if ( a > 0){
//		a = 1;
//		printf("%d", a);
//	}
//	else {
//		a = -1;
//		printf("%d", a);
//	}
//		
//return 0;
//}




//assignment10
//int main(){
//	
//	int a, b, c;
//	float delta, x1, x2, x;
//	
//	printf("Input parameter from keyboard: \n ");
//	printf("a = \t"); scanf("%d", &a);
//	printf("b = \t"); scanf("%d", &b);
//	printf("c = \t"); scanf("%d", &c);
//	
//	delta = pow(b,2) - 4*a*c;
//		printf("Delta = %.2f\n", delta);
//		if (delta > 0){
//			printf("2 different solutions \n");
//			x1 = (-b + sqrt(delta))/(2*a);
//			x2 = (-b - sqrt(delta))/(2*a);
//			printf("x1 = %.2f\t\n", x1);
//			printf("x2 = %.2f\t", x2);
//		}
//		else if (delta == 0){
//			printf("dual solution \n");
//			x = (-b)/2*a;
//			printf("x1 = x2 = %.2f\t", x);	
//		}
//		else if (delta < 0){
//			printf("No solution!");
//		}
//	return 0;
//}



//assignment 11
//int main(){
//	float a, b, c; 
//	printf("Input 3 sides of triangle \n");
//	scanf("%f %f %f", &a, &b, &c);
//	float sqr_a = a*a, sqr_b = b*b, sqr_c = c*c;
//	
//	if (sqr_c == sqr_b + sqr_a){
//		printf("This is right-angled triangle");
//	}
//	else if (sqr_a == sqr_b + sqr_c){
//		printf("This is right-angled triangle");
//	}
//	else if (sqr_b == sqr_a + sqr_c){
//		printf("This is right-angled triangle");
//	}
//	else if ( (a == c && a != b ) || (b == c && b != a) || (a == b && a != c) ){
//		printf("This is Isosceles triangle");
//	}
//	else if ( a == b && a == c){
//		printf("This is Equilateral triangle");
//	}
//	else{
//		printf("This is Scalene triangle!");
//	}
//	
//	return 0;
//}



//assignment 12
//int main(){

//	int cost;
//	const freeShip = 100000;

//	printf("Your purchase amount: \t");
//	scanf("%d", &cost);
//	
//	if (cost >= freeShip){
//		printf("You got a freeship voucher!");
//	}
//	else{
//		printf("Please pay your shipping cost!");
//	}
//	
//	return 0;
//}



//assignment 13
//int main(){
//	int month;
//	printf("Input month from keyboard! \n");
//	scanf("%d", &month);
//	
//	switch (month){
//		case 1:{
//			printf("January");
//			break;
//		}
//		case 2:{
//			printf("February");
//			break;
//		}
//		case 3:{
//			printf("March");
//			break;
//		}
//		case 4:{
//			printf("April");
//			break;
//		}
//		case 5:{
//			printf("May");
//			break;
//		}
//		case 6:{
//			printf("June");
//			break;
//		}
//		case 7:{
//			printf("July");
//			break;
//		}
//		case 8:{
//			printf("August");
//			break;
//		}
//		case 9:{
//			printf("September");
//			break;
//		}
//		case 10:{
//			printf("October");
//			break;
//		}
//		case 11:{
//			printf("November");
//			break;
//		}
//		case 12:{
//			printf("December");
//			break;
//		}
//		default:{
//			printf("error!");
//			break;
//		}
//	}	
//	return 0;
//}


//assignment14
//int main(){
//	int numday;
//	printf("Input day \t");
//	scanf("%d", &numday);
//	switch (numday){
//		case 2:{
//			printf("Monday");
//			break;
//		}
//		case 3:{
//			printf("Tuesday");
//			break;
//		}
//		case 4:{
//			printf("Wednesday");
//			break;
//		}
//		case 5:{
//			printf("Thursday");
//			break;
//		}
//		case 6:{
//			printf("Friday");
//			break;
//		}
//		case 7:{
//			printf("Saturday");
//			break;
//		}
//		case 8:{
//			printf("Sunday");
//			break;
//		}
//		default:{
//			printf("reinput");
//			break;
//		}
//	}		
//	
//	return 0;
//}


//assignment15
//int main(){
//	int month;
//	printf("Input month \t");
//	scanf("%d", &month);
//	
//	switch (month){
//		case 1:{
//			printf("31 days");
//			break;
//		}
//		case 2:{
//			printf("28 or 29 days");
//			break;
//		}
//		case 3:{
//			printf("31 days");
//			break;
//		}
//		case 4:{
//			printf("30 days");
//			break;
//		}
//		case 5:{
//			printf("31 days");
//			break;
//		}
//		case 6:{
//			printf("30 days");
//			break;
//		}
//		case 7:{
//			printf("31 days");
//			break;
//		}
//		case 8:{
//			printf("31 days");
//			break;
//		}
//		case 9:{
//			printf("30 days");
//			break;
//		}
//		case 10:{
//			printf("31 days");
//			break;
//		}
//		case 11:{
//			printf("30 days");
//			break;
//		}
//		case 12:{
//			printf("31 days");
//			break;
//		}
//		default:{
//			printf("error!");
//			break;
//		}
//			
//	}
//	return 0;
//}



//assignment16
//int main(){
//	
//	float a, b, i;
//	int oper;
//	for (i=1;i<=50;i++){
//		printf("=");
//	}
//	printf("\n");
//	printf("\n\n\n");
//	printf("\n");
//	printf("\n");
//	for (i=1;i<=50;i++){
//		printf("=");
//	}
//	printf("\n");
//	printf("\tInput two number from keyboard! \n");
//	printf("\n");
//	scanf("%f %f", &a, &b);
//	printf("\n");
//	printf("-----Choose operator----- \n\n");
//	printf("\t1.\" + \" \n ");
//	printf("\t2.\" - \" \n ");
//	printf("\t3.\" * \" \n ");
//	printf("\t4.\" / \" \n ");
//	scanf("%d", &oper);
//	
//	switch (oper){
//		case 1:{
//			printf("Result: %.1f\t", a + b);
//			break;
//		}
//		case 2:{
//			printf("Result: %.1f\t", a - b);
//			break;
//		}
//		case 3:{
//			printf("Result: %.1f\t", a * b);
//			break;
//		}
//		case 4:{
//			printf("Result: %.1f\t", a / b);
//			break;
//		}
//		default:{
//			printf("error!");
//			break;
//		}
//	}
//	
//	return 0;
//}











