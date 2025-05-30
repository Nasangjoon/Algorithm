import java.io.IOException;
import java.util.Scanner;
 
public class Main {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        
		sc.close();

        int answer = A * B * C;

        int[] count = new int[10];

        while (answer > 0) {
            count[answer % 10]++;
            answer /= 10;
        }

        for(int i = 0; i < count.length; i++){
            System.out.println(count[i]);
        }
 	
		
	}
 
}