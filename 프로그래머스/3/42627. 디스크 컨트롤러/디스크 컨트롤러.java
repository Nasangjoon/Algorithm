import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0;
        int jobsIdx = 0;
        int currentTime = 0;

        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        while (count < jobs.length) {
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= currentTime) {
                pq.add(jobs[jobsIdx]);
                jobsIdx++;
            }

            if (pq.isEmpty()) {
                currentTime = jobs[jobsIdx][0];
            } else {
                int[] temp = pq.poll();
                answer += temp[1] + currentTime - temp[0];
                currentTime += temp[1];
                count++;
            }
        }

        return answer / jobs.length;
    }
}