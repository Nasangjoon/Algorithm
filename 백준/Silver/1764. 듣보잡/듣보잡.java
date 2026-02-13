import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위해 BufferedReader와 BufferedWriter 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 듣도 못한 사람 수
        int m = Integer.parseInt(st.nextToken()); // 보도 못한 사람 수

        // 1. 듣도 못한 사람을 HashSet에 저장 (검색 최적화)
        HashSet<String> neverHeard = new HashSet<>();
        for (int i = 0; i < n; i++) {
            neverHeard.add(br.readLine());
        }

        // 2. 보도 못한 사람을 입력받으며 HashSet에 있는지 확인
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if (neverHeard.contains(name)) {
                result.add(name);
            }
        }

        // 3. 사전순 정렬
        Collections.sort(result);

        // 4. 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for (String name : result) {
            sb.append(name).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}