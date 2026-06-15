 import java.util.ArrayList;
    import java.util.List;

    public class Solution {
        public int[] solution(int[] arr) {
            List<Integer> tempList = new ArrayList<>();

            int lastNum = -1;

            for (int num : arr) {
  		if (num != lastNum) {
                    tempList.add(num);
                    lastNum = num; 
  		}
            }
            int[] answer = new int[tempList.size()];
            for (int i = 0; i < tempList.size(); i++) {
                answer[i] = tempList.get(i);
            }

            return answer;
        }
    }