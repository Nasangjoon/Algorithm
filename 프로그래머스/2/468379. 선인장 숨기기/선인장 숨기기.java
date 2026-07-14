import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[] grid = new int[m * n];
        int INF = drops.length + 1;
        Arrays.fill(grid, INF);
        
        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            grid[r * n + c] = i + 1;
        }
        
        int[] tempGrid = new int[(m - h + 1) * n];
        int[] mq = new int[m];
        
        for (int j = 0; j < n; j++) {
            int head = 0, tail = 0;
            for (int i = 0; i < m; i++) {
                if (head < tail && mq[head] <= i - h) {
                    head++;
                }
                int curVal = grid[i * n + j];
                while (head < tail && grid[mq[tail - 1] * n + j] >= curVal) {
                    tail--;
                }
                mq[tail++] = i;
                
                if (i >= h - 1) {
                    tempGrid[(i - h + 1) * n + j] = grid[mq[head] * n + j];
                }
            }
        }
        
        int maxTime = -1;
        int bestR = 0;
        int bestC = 0;
        
        int limitR = m - h + 1;
        int[] mq2 = new int[n];
        
        for (int i = 0; i < limitR; i++) {
            int head = 0, tail = 0;
            for (int j = 0; j < n; j++) {
                if (head < tail && mq2[head] <= j - w) {
                    head++;
                }
                int curVal = tempGrid[i * n + j];
                while (head < tail && tempGrid[i * n + mq2[tail - 1]] >= curVal) {
                    tail--;
                }
                mq2[tail++] = j;
                
                if (j >= w - 1) {
                    int c = j - w + 1;
                    int minTime = tempGrid[i * n + mq2[head]];
                    
                    if (minTime > maxTime) {
                        maxTime = minTime;
                        bestR = i;
                        bestC = c;
                    }
                }
            }
        }
        
        return new int[]{bestR, bestC};
    }
}