#include <stdio.h>
#include <string.h>


int main() {

	int t, R;
	char s[21];

	scanf("%d", &t);

	while (t--) {
		scanf("%d", &R);
		scanf("%s", s);

		for (int i = 0; i < strlen(s); i++) {
			for (int k = 0; k < R; k++) {
				printf("%c", s[i]);
			}
		}
		printf("\n");
	}


	return 0;
}