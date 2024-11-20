#include <stdio.h>
void h_m(int *min, int *hour){
	*hour = *min / 60;
	*min = *min % 60;
}
//void triple(float * f_ptr){
//	*f_ptr *= 3.0;
//}
//
//float * square(float * f_ptr2){
//	float *result;
//	*result = *f_ptr2 * *f_ptr2;
//	return result;
//}
int main(){
	
	/*
	pointer
	Memory address:
	each byte of memory has a specific address 
	it does not chage during the program is being executed
	--> each variable has a specific address
	--> array? each element has an address
	address difference of two adjacent elements equals to 
	the length of the datatye
	
	
	pointer: a variable whose value is an address of another variable
	(point to the address of another variable)
	
	Declare a pointer: datatype * pointer_name;
	*/
	
//	int * ptr;
	//declare the pointer named ptr pointing to the address of a variable which has the datatype of int
	//In this case, pointer point to NULL
	
//	int a = 2;
//	//assign a variable address to a pointer
//	ptr = &a; //pointer ptr points to the address of the variable a
//	printf("The address of a: %u\n", &a);
//	printf("The address the pointer point to: %u\n", ptr);
//	
//	
//	//access the value of a variable using pointer
//	printf("The value of a: %d\n", a);
//	printf("The value of a using pointer: %d\n", *ptr);
//	a = a + 5;
//	printf("The value of a using pointer: %d\n", *ptr);
//	// *ptr: access the value of a variable to which ptr points
//	*ptr = *ptr + 3;
//	printf("The address of a: %d\n", a);
	
	
	/*
	relation between pointer and array
	*/
	
//	int *ptr2;
//	int array[5] = {5,8,3,7,9};
//	ptr2 = array;
//	printf("the value of the ptr2: %u\n", ptr2);
//	printf("print out the array: %u\n", array);
//	printf("the address of the first element: %d\n", &array[0]);
//	
//	//access the first element using pointer
//	printf("the first element of array is: %d\n", *ptr2);
//	printf("the second element of array is: %d\n", ptr2[2]);
//	printf("the second element of array is: %d\n", *(ptr+2));
//	
//	printf("the address of the first element: %d\n", &array[0]);
//	printf("the address of the second element: %d\n", &array[1]);
//	printf("the value of the increased ptr2: %u\n", ptr2+1);
//	
	
	/*
	increase a pointer 1 unit, the value of pointer will be added the length of the datatype
	*/
	
	//traverse the array using pointer
//	for(int i=0;i<5;i++){
//		printf("%d   ", ptr2[i]);
//	}
//	for (int i=0;i<5;i++){
//		printf("%d   ", *(ptr2+i));
//	}
//	
//	
//	float realNum1 = 3.5, realNum2 = 2.7;
//	float *pt3, *pt4;
//	pt3 = &realNum1;
//	pt4 = &realNum2;
//	
//	*pt3 = 2*realNum2 + *pt3 + *pt4;
//	*pt4 = realNum1 + *pt3 - 2.0;
//	printf("\nrealNum1 = %f, realNum2 = %f\n", realNum1, realNum2);
	
	/*
	pass a pointer to a function via argument
	*/
	
	/*
	write a function to triple a variable
	a = 3 --> func() -->a = 9	
	*/
	
//	float realNum3 = 5.3;
//	float *pt5 = &realNum3;
//	triple(pt5);
//	printf("realNum3 = %f\n", realNum3);
//	
//	realNum3 = 4.0;
//	//call the function with return is pointer
//	pt5 = &realNum3;
//	float *pt6 = square(pt5);
//	printf("realNum3 = %f\n", realNum3);
//	printf("*pt6 = %d\n", *pt6);
	
	
	/*
	write the function to convert the number of minutes to corresponding hours and minutes
	minutes --> 75 hours =1, minutes = 15
	*/
	int *ptr1, *ptr2;
	int h,m;
	printf("Input minutes: \n");
	scanf("%d", &m);
	ptr1 = &m;
	ptr2 = &h;
	h_m(ptr1,ptr2);
	printf("hour = %d  ,   minute = %d   ", *ptr2, *ptr1);
	
	

	
	
	return 0;
}