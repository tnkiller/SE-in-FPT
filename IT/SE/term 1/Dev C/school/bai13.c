#include <stdio.h>
#include <string.h>

int main() {
	/*
	parallel arrays
	set of the arrays that has the same number of elements
	where the elements have the same index will be related together
	example: you are managing the students of a class
	Name		|Age	|Gender		|Address	|Score
	Nguyen Van A 18		Male		FPT Uni		9.2
	Tran Thi B	19		Female		DT Uni		9.1
	*/

	//use 2D array to contain the student names
	char Names[10][30] = {"Tran Thi A","Nguyen Van P", "Doan Quoc C"};
	int Ages[10] = {17,18,19};
	char Genders[10][7] = {"Female","Male", "Male"};

//	input data
	int n =3;
//	for(int  i=0; i<n; i++) {
//		printf("Name %d: ",i+1);
//		scanf("%[^\n]%*c",Names[i]);
//		gets(Names[i]);
//	}

	//traverse the "Name"
	for(int i=0; i<n; i++) {
		printf("name %d: %s\n",i+1, Names[i]);
	}
	printf("----------------------\n\n");

	//Traverse the parallel arrays
	printf("Name\t\tAge\tGender\n");
	for (int i=0; i<n; i++) {
		printf("%s\t%d\t%s\n", Names[i], Ages[i], Genders[i]);
	}

	printf("----------SORT------------\n\n");
	//sort the parallel arrays
	//according to names
	for(int i=0; i<n; i++) {
		for(int j=i+1; j<n-1; j++) {
			if(strcmp(Names[i], Names[j]) > 0) {
				//swap two names
				char temp[30];
				strcpy(temp,Names[i]);
				strcpy(Names[i],Names[j]);
				strcpy(Names[j],temp);

				int temp_age = Ages[i];
				Ages[i] = Ages[j];
				Ages[j] = temp_age;

				char temp_gender[7];
				strcpy(temp_gender,Genders[i]);
				strcpy(Genders[i],Genders[j]);
				strcpy(Genders[j],temp_gender);
			}
		}
	}
	//traverse the "Name"
	printf("Name\t\tAge\tGender\n");
	for (int i=0; i<n; i++) {
		printf("%s\t%d\t%s\n", Names[i], Ages[i], Genders[i]);
	}

	//add a new object
	printf("---add new object---\n");

	printf("input name: ");
	gets(Names[n]);
	printf("input age: ");
	scanf("%d", &Ages[n]);
	getchar();
	printf("input gender: ");
	gets(Genders[n]);
	n++;
	printf("Name\t\tAge\tGender\n");
	for (int i=0; i<n; i++) {
		printf("%s\t%d\t%s\n", Names[i], Ages[i], Genders[i]);
	}

	//delete an instance
	printf("---delete an instance---\n");
	int del_idx = 2;
	for(int i=del_idx; i<n; i++) {
		strcpy(Names[i],Names[i+1]);
		Ages[i] = Ages[i+1];
		strcpy(Genders[i],Genders[i+1]);
	}
	n -=1;
	printf("Name\t\tAge\tGender\n");
	for (int i=0; i<n; i++) {
		printf("%s\t%d\t%s\n", Names[i], Ages[i], Genders[i]);
	}
	return 0;
}