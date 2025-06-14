import java.io.*;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][2];

        for (int i = 0; i< N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = st.nextToken();
            arr[i][1] = st.nextToken();
        }

       Arrays.sort(arr, new Comparator<String[]>() {
           @Override
           public int compare(String[] o1, String[] o2) {
               if(Integer.parseInt(o1[0]) > Integer.parseInt(o2[0])) {
                   return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);

               } else if(Integer.parseInt(o1[0]) < Integer.parseInt(o2[0])) {
                   return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
               }
               return 0;
           }
       });

        for (int i = 0; i< N; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}