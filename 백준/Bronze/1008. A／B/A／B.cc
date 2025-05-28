#include <stdio.h>

int main(void) {
    int A, B;
    scanf("%d %d", &A, &B);

    
    if (A <= 0 || B <= 0 || A >= 10 || B >= 10) {
        return 1; 
    }

   
    double result = (double)A / B;


    printf("%.10f\n", result);

    return 0;
}
