import java.util.Arrays;
import static java.util.stream.Collectors.*;

class Solution {
    public int solution(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(cloth -> cloth[1], counting())) 
                .values().stream()
                .mapToInt(Long::intValue)
                .reduce(1, (ans, count) -> ans * (count + 1)) 
                - 1;
    }
}