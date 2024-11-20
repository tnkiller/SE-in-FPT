#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//float arrayAvg(float array[], int n){
//	float result = 0.0;
//	for (int i = 0;i<n;i++){
//		result+=array[i];
//	}
//	result /= n;
//	return result;
//}
//void changeArray(float threshold, float array[]){
//	for (int i = 0;i<3;i++){
//		if (array[i]<threshold){
//			array[i] = threshold;
//		}
//	}
//}

//void find_max(float array[], int n, float result[]){
	/*
	the function needs array and n to find the maximum and its position
	then the results are saved in result and returned
	return an array because we want to return more than 1 value
	*/
	float max = array[0], position = 0.0;
	for (int i=1;i<n;i++){
		if (array[i]>max){
			max = array[i];
			position = 1.0*i;
			//save the result to return
			result[0] = max;
			result[1] = position;
		}
	}
}

void randomGen(int n, int array[]){
	for (int i=0;i<n;i++){
		int check = 1;
		while (check){
			check = 0;
			array[i] = rand() % 21;
			for (int j=0;j<i;j++){
				if (array[i] == array[j]) check = 1;
			}
		}
	}
}
int main(){
	  
	
//	float scores[3] = {9.2,8.5,9.6};
	   
		
	/*write the function to calculate the average of the array scores
	Analysis:
	- argument: scores array (float)
	- return: average (float)
	*/
	
	//call the function whose argument is an array
//	float avg;
//	int nElements = 3;
//	avg = arrayAvg(scores,nElements);
//	printf("AVG = %f", avg);
	
	/*
	write a function to replace the scores less than 9.0(threshold) by 9.0
	Analysis:
	- argument: threshold
	- return: scores array with changes
	*/
//	float thres = 9.0;
//	printf("scores array before calling the function changeArray: \n");
//	for (int i=0;i<3;i++){
//		printf("%f   ", scores[i]);
//	}
//	changeArray(thres, scores);
//	printf("\nscores array after calling the function changeArray: \n");
//	for (int i=0;i<3;i++){
//		printf("%f   ", scores[i]);
//	}
	
	/*
	the example illustrates that 
	passing an array to a function via argument
	the array's address will be passed to that function
	*/
//	int n;
//	float studentHeight[5] = {1.80,1.75,1.85,1.82,1.79};
	/*
	write a function to find the maximum height and its position in data
	analysis:
	- argument: studentHeight array
	- return: max and position (2-elements array)
	*/
	
//	float max_pos[2];
//	find_max(studentHeight, n, max_pos);
//	printf("Maximum value and its position: ");
//	for(int i=0;i<2;i++){
//		printf("%.2f  ", max_pos[i]);
//	}
//	
	
	
	/*
	write a function to generate an array containing random integer from 0 and 10 (random function)
	where n is given
	Analysis:
	- argument: n
	- return: arrau of n integers
	*/
	
	srand(time(NULL));
	int n, randomArray[20];
	printf("please input n: ");
	scanf("%d", &n);
	randomGen(n, randomArray);
	//traverse
	printf("the random array is:  ");
	for (int i=0;i<n;i++){
		printf("%d   ", randomArray[i]);
	}
	return 0;
}







