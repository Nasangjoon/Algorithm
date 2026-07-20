import java.util.Arrays;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int[] dp = new int[m];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;

        for (int[] item : info) {
            int aTrace = item[0];
            int bTrace = item[1];
            int[] nextDp = new int[m];
            Arrays.fill(nextDp, 1000000);

            for (int b = 0; b < m; b++) {
                if (dp[b] == 1000000) continue;

                if (dp[b] + aTrace < n) {
                    nextDp[b] = Math.min(nextDp[b], dp[b] + aTrace);
                }

                if (b + bTrace < m) {
                    nextDp[b + bTrace] = Math.min(nextDp[b + bTrace], dp[b]);
                }
            }
            dp = nextDp;
        }

        int minA = 1000000;
        for (int b = 0; b < m; b++) {
            minA = Math.min(minA, dp[b]);
        }

        return minA == 1000000 ? -1 : minA;
    }
}