import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        long A = sc.nextLong();
        long B = sc.nextLong();
        
        // 넓이 계산 및 출력
        System.out.println(A * B);
        
        sc.close();
    }
}