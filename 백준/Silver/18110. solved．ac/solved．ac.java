import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        if (input == null || input.isEmpty()) return;
        
        int n = Integer.parseInt(input);

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] opinions = new int[n];
        for (int i = 0; i < n; i++) {
            opinions[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(opinions);

        int cut = (int) Math.round(n * 0.15);

        double sum = 0;
        for (int i = cut; i < n - cut; i++) {
            sum += opinions[i];
        }

        int count = n - (2 * cut);
        int result = (int) Math.round(sum / count);

        System.out.println(result);
    }
}