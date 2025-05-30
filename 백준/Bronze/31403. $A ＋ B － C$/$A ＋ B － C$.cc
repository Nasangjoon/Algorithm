#include <stdio.h>
#include <stdlib.h>

int main() {
    char a[1000], b[1000], c[1000];
    scanf("%s", a);
    scanf("%s", b);
    scanf("%s", c);
    int A = atoi(a);
    int B = atoi(b);
    int C = atoi(c);

    printf("%d\n", A+B-C);
    if(B<10) printf("%d", (10*A+B)-C);
    else if(B<100) printf("%d", (100*A+B)-C);
    else if(B<1000) printf("%d", (1000*A+B)-C);
    else printf("%d", (10000*A+B)-C);
    return 0;
}