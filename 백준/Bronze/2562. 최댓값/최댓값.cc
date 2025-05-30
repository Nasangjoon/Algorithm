#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>


int main() {

	int a; 
	int idx, max = 0; 
	
	for (int i = 1; i <= 9; i++) {
		scanf("%d", &a);
		if (max < a) {
			max = a;
			idx = i;
		}
	}

	printf("%d \n%d", max, idx);
	

	return 0;
}