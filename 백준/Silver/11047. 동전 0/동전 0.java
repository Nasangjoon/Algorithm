import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 동전 종류 수
        int K = sc.nextInt(); // 목표 금액
        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        int count = 0;

        // 가장 큰 가치의 동전부터 거꾸로 계산
        for (int i = N - 1; i >= 0; i--) {
            if (coins[i] <= K) {
                // 현재 동전으로 만들 수 있는 최대 개수를 더함
                count += (K / coins[i]);
                // 남은 금액 업데이트
                K %= coins[i];
            }
        }

        System.out.println(count);
    }
}