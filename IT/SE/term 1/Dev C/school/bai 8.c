#include <stdio.h>
	/*
	generate a function to generate an array containing first n odd elements where n is given
	*/
//void odd(int n, int result[]){
//	for (int i=0;i<=n;i++){
//		result[i] = 2*i+1;
//	}
//}
//int main(){
//	int a, rs[1000];
//	printf("Nhap a tu ban phim: ");
//	scanf("%d", &a);
//	odd(a, rs);
//	for (int i=0;i<=a;i++){
//		printf("element[%d] = %d\n", i, rs[i]);
//	}
//	return 0;
//}







/*
data smooth: the data can be smoothes by calculate the average of a segment of data. Write a function to 
generate the smoothed data where segment and data are given
data = {2.3, 4.5, 5.6, 3.4, 7.2, 9.1, 8.6, 6.7, 7.2, 5.5}
segment = 2-->
smoothed_data = {3.4, 5.05, 4.5, 5.3, 8.15, 8.85, 7.65, 6.95, 6.35}
*/
void data_sm(float data[], int a, int seg, float result[]){
	for (int i=0;i<a;i++){
		avr = 0;
		for (int j=0;j<seg;j++){
			avr += data[j]/1.0*seg; 
		}
		result[i] = avr;	
	}
}
void data_sm(float data[], int a, int seg, float result[]);
int main(){
	float seq[100], rs[100];
	int n, segment;
	printf("Input n_th elements of array: \n");
	scanf("%d", &n);
	printf("Input segment: \n");
	scanf("%d", &segment);
	printf("Input value for array: \n");
	for (int i=0;i<=n;i++){
		printf("seq[%d] = ", i); scanf("%f", &seq[i]);
	}
	data_sm(seq, n, rs);
	for (int i=0;i<=10;i++){
		printf("%.3f   ", rs[i]);
	}
	
	
	
	return 0;
}












/*
Sort an array: sap xep
*/
//int main(){
//	float data[9] = {3.4, 5.05, 4.5, 5.3, 8.15, 8.85, 7.65, 6.95, 6.35}
//	for (int i=0;i<9;i++){
//		for(int j=i+1;j<9;j++){
//			if (data[i]>data[j]){
//				float temp;
//				temp = data[i];
//				data[i] = data[j];
//				temp = data[j];
//			}
//		}
//	}
//	printf("the sort is : \n");
//	for (int i=0;i<10;i++){
//		printf("%f", data[i]);
//	}
//	return 0;
//}

/*
2d ARRAY
declaration: datatype array_name[number_of_rows][number_of_columns];
*/
//int main(){
//	int twoD_array[3][2];
//	//traverse the addresses of the array elements
//	for (int r=0;r<3;r++){
//		for (int c=0;c<2;c++){
//			printf("%u\n", &twoD_array[r][c]);
//		}
//	}
//	return 0;
//}


/*
access the elements of an array
*/
//int main(){
//float Images[2][3] = {{6,9,4},{5,7,8}};
//printf("the value of Images[0][1]: %f\n", Images[0][1]);
//for (int r = 0;r<2;r++){
//	for (int c=0;c<3;c++){
//		printf("%.2f	", Images[r][c]);
//	}
//	printf("\n");
//}
//	return 0;
//}


/*
write the lines of code to calculate the average of the array Images
*/
//int main(){
//	float Images[2][3] = {{6,9,4},{5,7,8}};
//	float sum;
//	for (int r = 0;r<2;r++){
//		for (int c=0;c<3;c++){
//			sum = sum + Images[r][c];
//		}
//	}
//	float avr = sum/6.0;
//	printf("avr = %f", avr);	
//	
//	return 0;
//}

/*
write the lines of code to calculate the average of the array Images respect to rows and columns
*/
//int main(){
//	float rowAvg[2], colAvg[3];
//	float Images[2][3] = {{6,9,4},{5,7,8}};
//	float sum;
//	for (int r = 0;r<2;r++){
//		sum = 0;
//		for (int c=0;c<3;c++){
//			sum +=Images[r][c];
//		}
//		printf("Average cua hang %d: %f\n", r, sum/3);
//	}
//	printf("\n");
//	for (int r=0;r<3;r++){
//		sum = 0;
//		for (int c=0;c<2;c++){
//			sum += Images[c][r];
//		}
//		printf("Average cua cot %d: %f\n", r, sum/2);
//	}
//	return 0;
//}

	//another way:
	
	
//int main(){	
//	float rowAvg[2] = {0.0, 0.0}, colAvg[3] = {0.0, 0.0, 0.0};
//	float Images[2][3] = {{6,9,4},{5,7,8}};
//	for (int r = 0;r<2;r++){
//		for (int c=0;c<3;c++){
//			rowAvg[r] += Images[r][c] / 3.0;
//			colAvg[c] += Images[r][c] / 2.0;
//		}
//	}
//	printf("The average respect to rows: \n");
//	for (int i=0;i<2;i++){
//		printf("%f\n", rowAvg[i]);
//	}
//	printf("The average respect to  column: \n");
//	for (int i=0;i<3;i++){
//		printf("%f\n", colAvg[i]);
//	}
//	return 0;
//}





