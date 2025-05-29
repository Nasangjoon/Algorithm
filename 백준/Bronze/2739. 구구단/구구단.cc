#include <stdio.h>

int main()
{
    int N;
    
    scanf("%d", &N);

    if(N < 0 | N > 9)
    {
        return 0;
    }

    for(int i = 1; i < 10; i++){
        printf("%d * %d = %d", N, i,N*i);
        printf("\n");
    }

}