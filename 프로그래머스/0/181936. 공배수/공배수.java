class Solution {
    public int solution(int number, int n, int m) {
        // number가 n으로 나누어 떨어지고(&&), m으로도 나누어 떨어지는지 확인
        // 삼항 연산자를 사용하여 코드를 한 줄로 최적화
        return (number % n == 0 && number % m == 0) ? 1 : 0;
    }
}