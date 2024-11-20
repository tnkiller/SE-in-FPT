#include <stdio.h>
#include <math.h>
#include <string.h>
#include <ctype.h>
//
//int cw(char *word){
//	int count = 1;
//	for (int i=0;i<strlen(word);i++){
//		if (*(word+i) == ' ' && *(word+i+1) == ' '){
//			count++;
//		}
//	}
//	return count;
//}
//int main(){
//
//
//	/*
//	string: array of characters
//	*/
//
////	char uniName[50] = "FPT University";
////	printf("%s\n", uniName);
////	//length of string
////	int length = strlen(uniName);
////	printf("The number of characters in name: %d\n", length);
////	//assign
////	char name1[20] = "Nguyen Van D";
////	char name2[20];
////	strcpy(name2, "Nguyen Van A"); //assign Nguyen Van A to name2
////	printf("%s\n", name2);
////	//compare(name1, name2);
////	int check = strcmp(name1, name2);
////	printf("%d\n", check); //1
////	check = strcmp(name2, name1);
////	printf("%d\n", check); //-1
////	check = strcmp(name2, "Nguyen Van A");
////	printf("%d\n", check); //0
////
////	//uppercase
////	strupr(uniName);
////	printf("%s\n", uniName);
////	strlwr(uniName);
////	printf("%s", uniName);
////	//find substring
	char sentence[100] = "This is a golden fish in a bottle.";
	char *subs = strstr(sentence, "is");
	printf("\nThe value of substring: %u\n", subs);
	printf("The address of sentence[2]: %u\n", &sentence[2]);
	subs = strstr(sentence, "uni");
	printf("The value of subs: %u\n", subs);
//
//	/*
//	Write the line of code to count the number of word in a sentence
//	*/
//	int rs;
//	char FPT[100] = "Toi yeu FPT";
//	char *ptr = &FPT;
//	printf("%d\n", strlen(FPT));
//	rs = cw(ptr);
//	printf("%d", rs);
//
//
//
//
//
//
//
//
//	return 0;
//}













/*
write a function to count the number in a sentence
"The address is 87/2 Nui Thanh, Hoa Cuong 1, Da Nang" --> 3 number
*/
//int count(char sen);
//int main() {
//	int numInt = 0;
//	char sentence[] = {"The address is 97/2 Nui Thanh, Hoa Cuong 1, Da Nang 50500"};
//	for (int i=0; i<strlen(sentence); i++) {
//		if (isdigit(sentence[i]) && !isdigit(sentence[i+1])) {
//			numInt++;
//		}
//	}
//	printf("%d", numInt);
//	return 0;
//}





/*
write a function to check the strength of a password
+1 if it contains any special, characters
+1 if it contains uppercase of any alphabets
+1 if it contains lowercase of any alphabets
+1 it it contains any digits
"123FPT_uni@" --> strength = 4;
"123FPT" --> strength =2;
*/
//int main() {
//	char password[] = "FPT_university@123";
//	int strength, len = 0,upr=0,lwr=0,dgt=0,spec=0;
//	if (strlen(password)>10)len=1;
//	for (int i=0; i<strlen(password); i++) {
//		if(isupper(password[i])) upr=1;
//		if(islower(password[i]))lwr=1;
//		if(isdigit(password[i])) dgt=1;
//		if(ispunct(password[i])) spec=1;
//	}
//	strength = len+upr+lwr+dgt+spec;
//	printf("the strength of the password is: %d\n", strength);
//	return 0;
//}




/*
Write a function to convert an integer to string of binary form
n =25 => bin = "11001"
*/

int main(){
	int n=25;
	char temp[50], binForm[50];
	for (int i=0;n>0;i++){
		temp[i] = n%2 + '0';	//3 + '0' = '3'
		n/=2;
	}
	for (int i=0;i<strlen(temp);i++) binForm[i] = temp[strlen(temp)-1-i];
	printf("Binary form: %s\n", binForm);
	
	return 0;
}