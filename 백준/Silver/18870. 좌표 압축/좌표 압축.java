import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] origin = new int[N];   
        int[] sorted = new int[N];    
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }
        
 
        Arrays.sort(sorted);
        
    
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int value : sorted) {
        
            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank);
                rank++;
            }
        }
        
     
        StringBuilder sb = new StringBuilder();
        for (int value : origin) {
            sb.append(rankMap.get(value)).append(" ");
        }
        
        System.out.println(sb);
    }
}