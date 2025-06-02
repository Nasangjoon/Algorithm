import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 과목 수
        double[] scores = new double[N];

        // 점수 입력받기
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextDouble();
        }

        // 최댓값 찾기
        double max = 0;
        for (int i = 0; i < N; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        // 점수 조작 및 합계 계산
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (scores[i] / max) * 100;
        }

        // 평균 출력
        System.out.println(sum / N);
    }
}
