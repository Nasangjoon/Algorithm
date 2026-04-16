import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        bfs(N);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1;

        while (!q.isEmpty()) {
            int current = q.poll();

            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                if (next == K) {
                    System.out.println(visited[current]);
                    return;
                }

                if (next >= 0 && next <= 100000 && visited[next] == 0) {
                    visited[next] = visited[current] + 1;
                    q.offer(next);
                }
            }
        }
    }
}