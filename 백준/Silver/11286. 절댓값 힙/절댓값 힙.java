import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위한 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐 선언 및 정렬 기준 커스텀
        PriorityQueue<Integer> absHeap = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) {
                // 절댓값이 같으면 실제 값이 작은 것을 우선 (음수 > 양수)
                return o1 > o2 ? 1 : -1;
            }
            // 절댓값이 작은 것을 우선
            return abs1 - abs2;
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (absHeap.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(absHeap.poll()).append("\n");
                }
            } else {
                absHeap.add(x);
            }
        }

        // 결과 일괄 출력
        System.out.println(sb);
    }
}