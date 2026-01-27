class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int targetCol = getCol(num, w);

        for (int i = num; i <= n; i++) {
            if (getCol(i, w) == targetCol) {
                answer++;
            }
        }

        return answer;
    }

    private int getCol(int val, int w) {
        int row = (val - 1) / w;
        int pos = (val - 1) % w;

        if (row % 2 == 0) {
            return pos;
        } else {
            return (w - 1) - pos;
        }
    }
}