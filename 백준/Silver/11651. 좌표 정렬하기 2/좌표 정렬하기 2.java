import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken()); // x
            points[i][1] = Integer.parseInt(st.nextToken()); // y
        }

        // 정렬 로직
        Arrays.sort(points, (e1, e2) -> {
            if (e1[1] == e2[1]) { // y좌표가 같다면
                return e1[0] - e2[0]; // x좌표 비교
            } else {
                return e1[1] - e2[1]; // y좌표 비교
            }
        });

        // 출력 최적화
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(points[i][0] + " " + points[i][1]).append('\n');
        }
        System.out.println(sb);
    }
}