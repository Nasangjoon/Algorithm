import java.util.*;

public class Main {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우 이동용
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트 케이스 개수
        int T = sc.nextInt();

        while (T-- > 0) {
            M = sc.nextInt(); // 가로
            N = sc.nextInt(); // 세로
            K = sc.nextInt(); // 배추 개수

            map = new int[M][N];
            visited = new boolean[M][N];
            int count = 0;

            // 배추 위치 입력
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
            }

            // 배추밭 전체를 돌며 탐색
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    // 배추가 있고 아직 방문하지 않았다면 새로운 지렁이 필요
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        sc.close();
    }

    // 인접한 배추를 찾는 DFS 함수
    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 밭 범위를 벗어나지 않고, 배추가 있으며, 방문하지 않은 경우
            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}