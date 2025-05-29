#include <stdio.h>

int main()
{
    int N;

    scanf("%d", &N);

    if(N < 1 | N > 100 )
    {
        return 0;
    }
    for(int i = 0; i < N; i++)
    {
     for(int j = 0; j <= i; j++)
         {
             printf("*");
         }
        printf("\n");
    }

}