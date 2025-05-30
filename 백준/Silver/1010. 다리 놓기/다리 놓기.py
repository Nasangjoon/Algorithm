T = int(input())

for i in range(T):
    N,M=map(int,input().split())

    dp =[[ 0 for _ in range(M+1)] for _ in range(N+1)]
    for i in range(1,M+1):
        dp[1][i]=i

    for i in range(2,N+1):
        for j in range(2,M+1):
            if i>j:
                continue
            if i==j:
                dp[i][j]=1

            else:
                dp[i][j]=dp[i-1][j-1]+dp[i][j-1]

    print(dp[N][M])