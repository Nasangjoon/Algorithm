import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        long N = sc.nextLong();  // 참가자 수

        // 티셔츠 사이즈별 신청 인원
        long[] shirtCounts = new long[6]; // S, M, L, XL, XXL, XXXL
        for (int i = 0; i < 6; i++) {
            shirtCounts[i] = sc.nextLong();
        }

        long T = sc.nextLong();  // 티셔츠 묶음 수량
        long P = sc.nextLong();  // 펜 묶음 수량

        // 티셔츠 묶음 계산
        long totalBundles = 0;
        for (int i = 0; i < 6; i++) {
            totalBundles += (shirtCounts[i] + T - 1) / T; // 올림 계산
        }

        // 펜 묶음 계산
        long penBundle = N / P;
        long penSingle = N % P;

        // 출력
        System.out.println(totalBundles);
        System.out.println(penBundle + " " + penSingle);
    }
}
