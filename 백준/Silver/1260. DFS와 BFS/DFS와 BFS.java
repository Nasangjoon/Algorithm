import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj; 
    static boolean[] visited;       
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt(); 
        int v = sc.nextInt();

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            adj[s].add(e);
            adj[e].add(s);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adj[i]);
        }

 
        visited = new boolean[n + 1];
        dfs(v);
        sb.append("\n");

        visited = new boolean[n + 1];
        bfs(v);

        System.out.println(sb.toString());
    }

 
    public static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");

        for (int next : adj[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

 
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");

            for (int next : adj[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}