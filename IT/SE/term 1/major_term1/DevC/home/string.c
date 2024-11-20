#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

/*1. Write a function to calculate the number of times that a character appears
in a string. Example: sentence = “These are the pencils” character = ‘e’,
result = 3*/
int countLetter(char sentence[], char letter) {
	int count;
	for (int i=0; i<strlen(sentence); ++i) {
		if (sentence[i] == letter) count++;
	}
	return count;
}


/*2. Write a function to count the number of words in a sentence
Example: sentence = “These are the pencils” --> the number of words = 4*/
int countWord(char sentence[]) {
	int count = 0;
	for (int i=0; i<strlen(sentence); ++i) {
		if (sentence[i] != ' ' && sentence[i+1] == ' ') count++;
	}
	if (sentence[strlen(sentence) - 1] != ' ') count++;
	return count;
}



int main() {
	char s[100];
	
	gets(s);
	getchar;
	
	int res = countWord(s);
	printf("%d word(s)",res);


	return 0;
}