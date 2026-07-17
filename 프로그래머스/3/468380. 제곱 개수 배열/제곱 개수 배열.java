import java.util.Arrays;

class Solution {
    private int N;
    private int[] arr;
    private long[] blockSum;
    private long[] blockValueSum;

    public long[] solution(int[] arr, long l, long r) {
        this.N = arr.length;
        this.arr = arr;
        this.blockSum = new long[N + 1];
        this.blockValueSum = new long[N + 1];

        for (int i = 0; i < N; i++) {
            blockSum[i + 1] = blockSum[i] + arr[i];
            blockValueSum[i + 1] = blockValueSum[i] + (long) arr[i] * arr[i];
        }

        long K = getPrefixSum(r) - getPrefixSum(l - 1);
        long len = r - l + 1;
        long C = 0;
        long totalLen = blockSum[N];

        int j = 0;
        for (int i = 0; i < N; i++) {
            long s_min = blockSum[i] + 1;
            long s_max = blockSum[i + 1];
            
            if (s_min > totalLen - len + 1) break;
            if (s_max > totalLen - len + 1) {
                s_max = totalLen - len + 1;
            }
            if (s_min > s_max) continue;

            long e_min = s_min + len - 1;
            long e_max = s_max + len - 1;

            while (j < N && blockSum[j + 1] < e_min) {
                j++;
            }

            long curr_s = s_min;
            while (curr_s <= s_max) {
                long curr_e_start = curr_s + len - 1;
                long next_e_boundary = blockSum[j + 1];
                
                long limit_e = Math.min(e_max, next_e_boundary);
                long limit_s = limit_e - len + 1;

                long val_i = arr[i];
                long val_j = arr[j];
                long d = val_j - val_i;

                long currentSum = getPrefixSum(curr_s + len - 1) - getPrefixSum(curr_s - 1);
                long count = limit_s - curr_s + 1;

                if (d == 0) {
                    if (currentSum == K) {
                        C += count;
                    }
                } else {
                    long target = K - currentSum;
                    if (target % d == 0) {
                        long k = target / d;
                        if (k >= 0 && k < count) {
                            C++;
                        }
                    }
                }

                curr_s = limit_s + 1;
                if (limit_e == next_e_boundary) {
                    j++;
                }
            }
        }

        return new long[]{K, C};
    }

    private long getPrefixSum(long x) {
        if (x <= 0) return 0;
        int idx = findBlock(x);
        long prevSum = blockValueSum[idx];
        long remain = x - blockSum[idx];
        return prevSum + remain * arr[idx];
    }

    private int findBlock(long x) {
        int start = 0;
        int end = N - 1;
        int ans = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (blockSum[mid] < x) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}