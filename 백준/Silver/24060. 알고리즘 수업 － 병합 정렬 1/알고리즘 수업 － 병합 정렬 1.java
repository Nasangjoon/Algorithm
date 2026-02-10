import java.util.Scanner;

public class Main {
    int[] A;
    int[] tmp;
    int K;
    int count = 0;
    int result = -1;

    public static void main(String[] args) {
        new Main().solution();
    }

    public void solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        K = sc.nextInt();

        A = new int[N];
        tmp = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        mergeSort(0, N - 1);
        System.out.println(result);
    }

    private void mergeSort(int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }

    private void merge(int p, int q, int r) {
        int i = p;
        int j = q + 1;
        int t = 0;

        while (i <= q && j <= r) {
            if (A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }

        while (i <= q) {
            tmp[t++] = A[i++];
        }

        while (j <= r) {
            tmp[t++] = A[j++];
        }

        i = p;
        t = 0;
        while (i <= r) {
            count++;
            if (count == K) {
                result = tmp[t];
            }
            A[i++] = tmp[t++];
        }
    }
}