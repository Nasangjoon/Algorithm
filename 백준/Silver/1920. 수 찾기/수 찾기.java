import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

       
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

           
            int in = Arrays.binarySearch(arr, num); // 배열 안에 찾는 함수

            if (in < 0) {
                sb.append(0 + "\n"); 
            } else {
                sb.append(1 + "\n"); 
            }
        }

     
        System.out.println(sb);
    }
}