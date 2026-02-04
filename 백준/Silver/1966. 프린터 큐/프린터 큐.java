import java.util.Scanner;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            
            LinkedList<int[]> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                queue.add(new int[]{i, sc.nextInt()});
            }

            int count = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                boolean isMax = true;

                for (int i = 0; i < queue.size(); i++) {
                    if (queue.get(i)[1] > current[1]) {
                        isMax = false;
                        break;
                    }
                }

                if (isMax) {
                    count++;
                    if (current[0] == M) {
                        System.out.println(count);
                        break;
                    }
                } else {
                    queue.add(current);
                }
            }
        }
        sc.close();
    }
}