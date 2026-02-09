import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] count = new int[8001]; // -4000 ~ 4000을 수용하는 카운팅 배열
        
        double sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
            count[nums[i] + 4000]++;
        }

        Arrays.sort(nums);

        // 1. 산술평균
        System.out.println(Math.round(sum / n));

        // 2. 중앙값
        System.out.println(nums[n / 2]);

        // 3. 최빈값
        int maxFreq = 0;
        for (int i = 0; i < 8001; i++) {
            if (count[i] > maxFreq) {
                maxFreq = count[i];
            }
        }

        ArrayList<Integer> modeList = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (count[i] == maxFreq) {
                modeList.add(i - 4000);
            }
        }

        if (modeList.size() > 1) {
            Collections.sort(modeList);
            System.out.println(modeList.get(1));
        } else {
            System.out.println(modeList.get(0));
        }

        // 4. 범위
        System.out.println(nums[n - 1] - nums[0]);
    }
}