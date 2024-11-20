#include<stdio.h>
int main(){
	/*
	File
	*/
	//read data from file "data.txt"
	FILE *file;
	file=fopen("data.txt","r");
	int letter=fgetc(file);
    while(letter!=EOF){
    	printf("%c",letter);
    	letter=fgetc(file);
	}
	rewind(file); //move the poiter to beginning of the file
	printf("\n========================== read string to variable=======================\n");
	//read a string of file to a string variable 
	char s[1000];
	while(fgets(s,50,file)!=NULL){
		printf("read string :%s\n",s);
	}
	rewind(file);
	char name[30],major[30];
	int age;
	float score;
	printf("---->%d\n",fscanf(file,"%[^;] ; %d ;%[^;] ;%f",name,&age,major,&score));
//	int fs=fscanf(file,"%[^;] ; %d ;%[^;] ;%f%*c",name,&age,major,&score);
//	printf("name is :%s, age : %d , major : %s , score: %f",name,age,major,score);
//read file as format using loop
int fsc=4;
while(fscanf(file,"%[^;] ; %d ;%[^;] ;%f%*c",name,&age,major,&score)==4){
	printf("name is :%s, age : %d , major : %s , score: %f\n",name,age,major,score);
}
    int check= fclose(file);
    printf("\nther is file to close :%d\n",check);
    return 0;
	}