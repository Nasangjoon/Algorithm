import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        // 0부터 N까지의 소수 판별 배열 (false면 소수)
        boolean[] prime = new boolean[N + 1];
        prime[0] = prime[1] = true; // 0과 1은 소수가 아님

        // 에라토스테네스의 체를 사용함
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (prime[i]) continue; 
            
            for (int j = i * i; j <= N; j += i) {
                prime[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (!prime[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.print(sb);
    }
}