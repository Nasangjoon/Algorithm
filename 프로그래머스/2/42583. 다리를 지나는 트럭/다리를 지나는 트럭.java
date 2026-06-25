import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        int current_weight = 0;
        int index = 0;
        
        while (index < truck_weights.length) {
            answer++;
            current_weight -= bridge.poll();
            
            if (current_weight + truck_weights[index] <= weight) {
                bridge.add(truck_weights[index]);
                current_weight += truck_weights[index];
                index++;
            } else {
                bridge.add(0);
            }
        }
        
        answer += bridge_length;
        
        return answer;
    }
}