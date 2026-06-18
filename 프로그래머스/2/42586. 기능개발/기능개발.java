import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        int[] deployDays = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
            deployDays[i] = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
        }
        
        int maxDay = deployDays[0];
        int count = 1;
        
        for (int i = 1; i < deployDays.length; i++) {
            if (deployDays[i] <= maxDay) {
                count++;
            } else {
                answerList.add(count);
                count = 1;
                maxDay = deployDays[i];
            }
        }
        answerList.add(count);
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}