import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] P = new int[N];
        
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }
        
        Arrays.sort(P);
        
        int totalSum = 0;
        int accumulatedTime = 0;
        
        for (int i = 0; i < N; i++) {
            accumulatedTime += P[i];
            totalSum += accumulatedTime;
        }
        
        System.out.println(totalSum);
        
        sc.close();
    }
}