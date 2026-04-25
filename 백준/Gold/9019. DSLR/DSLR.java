import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(bfs(a, b)).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static String bfs(int start, int target) {
        boolean[] visited = new boolean[10000];
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(start, ""));
        visited[start] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.num == target) {
                return curr.cmd;
            }

            // D 연산
            int d = (curr.num * 2) % 10000;
            if (!visited[d]) {
                visited[d] = true;
                q.add(new Node(d, curr.cmd + "D"));
            }

            // S 연산
            int s = curr.num == 0 ? 9999 : curr.num - 1;
            if (!visited[s]) {
                visited[s] = true;
                q.add(new Node(s, curr.cmd + "S"));
            }

            // L 연산
            int l = (curr.num % 1000) * 10 + (curr.num / 1000);
            if (!visited[l]) {
                visited[l] = true;
                q.add(new Node(l, curr.cmd + "L"));
            }

            // R 연산
            int r = (curr.num % 10) * 1000 + (curr.num / 10);
            if (!visited[r]) {
                visited[r] = true;
                q.add(new Node(r, curr.cmd + "R"));
            }
        }
        return "";
    }

    static class Node {
        int num;
        String cmd;

        Node(int num, String cmd) {
            this.num = num;
            this.cmd = cmd;
        }
    }
}