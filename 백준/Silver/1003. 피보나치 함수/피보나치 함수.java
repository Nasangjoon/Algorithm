import java.util.Scanner;

public class Main {
    // 0과 1의 호출 횟수를 저장할 배열 (N은 최대 40)
    static int[][] dp = new int[41][2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 초기값 설정
        dp[0][0] = 1; // N=0일 때 0 출력 횟수
        dp[0][1] = 0; // N=0일 때 1 출력 횟수
        dp[1][0] = 0; // N=1일 때 0 출력 횟수
        dp[1][1] = 1; // N=1일 때 1 출력 횟수

        // 미리 40까지의 0, 1 발생 횟수를 계산해둠 (DP)
        for (int i = 2; i <= 40; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        int T = sc.nextInt(); // 테스트 케이스 개수

        while (T-- > 0) {
            int N = sc.nextInt();
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
        
        sc.close();
    }
}