import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int M = Integer.parseInt(br.readLine());
        int bitset = 0; // 집합을 대신할 비트 변수

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int x;

            switch (op) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    bitset |= (1 << (x - 1));
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    bitset &= ~(1 << (x - 1));
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    sb.append((bitset & (1 << (x - 1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    bitset ^= (1 << (x - 1));
                    break;
                case "all":
                    bitset = (1 << 20) - 1;
                    break;
                case "empty":
                    bitset = 0;
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}