#include <stdio.h>
//bai1
//int main(){
//	int num, count;
//	printf("Input integer: \n");
//	scanf("%d", &num);
//	count = 0;
//	do{
//		num /=10;
//		count++;
//	}
//	while (num != 0);
//	printf("The number of digit is: %d \n", count);
//	return 0;
//}




//bai2
//int main(){
//	int n, i, j;
//	scanf("%d", &n);
//	for (i = 1; i <= n; i++){
//		for (j = 1; j <= i; j++){
//			printf("*");
//		}
//		printf(" \n");
//	}
//	
//	return 0;
//}




//bai3
//int main(){
//	int i, j;
//	for (i = 1; i <= 10; i++){
//		for (j = 1; j <= 10; j++){
//			int num = 10* (j-1) + i;
//			printf("%d \t", num);
//		}
//		printf("\n");
//	}
//	return 0;
//}




//bai4
//int main(){
//	int pm, dis;
//	float dm;
//	printf("Your paid money: \t");
//	scanf("%d", &pm);
//	if (pm >0){
//		if (1000000 < pm && pm <= 2000000){
//			dis = pm - 1000000;
//			dm = (float)dis * 0.03;	
//		}
//		else{
//			dis = pm - 2000000;
//			dm = 1000000*0.03 + (float)dis*0.05;
//		}
//		if (dm > 300000){ 	
//		dm = 300000;
//		}	
//		printf("Your discount: %.1f", dm);
//	}
//	return 0;
//}




//int main(){
//	int n, n_gt;
//	float bt, x, e;
//	printf("Nhap x va epsilon \n ");
//	scanf("%f %f", &x, &e);
//	
//	n_gt = 1;
//	for (n=1;n<=100;n++){
//		n_gt = n_gt*n;
//		bt = pow(x,n)/n_gt;
//		if (bt<e){
//			break;
//		}
//	}
//	printf("%d", n);
//	printf("%f", bt);
//	
//	return 0;
//}







