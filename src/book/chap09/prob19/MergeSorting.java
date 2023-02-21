package book.chap09.prob19;

public class MergeSorting {
    int[] A, B;

    public MergeSorting(int n) {
        A = new int[n];
        B = new int[n];
    }

    public void mergeSort() {
        int[] B = new int[A.length];
        mSort(0, A.length - 1, B);
    }

    private void mSort(int p, int r, int[] B) {
        if (p < r) {
            int q = (p + r) / 2;
            mSort(p, q, B);
            mSort(q + 1, r, B);
            merge(p, q, r, B);
        }
    }

    private void merge(int p, int q, int r, int[] B) {
        int i = p, j = q + 1, t = 0;
        while (i <= q && j <= r) {
            if (A[i] <= A[j]) B[t++] = A[i++];
            else B[t++] = A[j++];
        }
        while (i <= q)        // 왼쪽 부분 배열이 남은 경우
            B[t++] = A[i++];
        while (j <= r)        // 오른쪽 부분 배열이 남은 경우
            B[t++] = A[j++];
        i = p;
        t = 0;
        while (i <= r)        // 결과를 A[p...r]에 저장
            A[i++] = B[t++];
    }

    public void switchingMergeSort() {
        int [] B = new int[A.length];
        System.arraycopy(A, 0, B, 0, A.length);
        switchingMSort(0, A.length - 1, A, B);
    }

    private void switchingMSort(int p, int r, int[] A, int[] B) {
        if (p < r) {
            int q = (p + r) / 2;
            switchingMSort(p, q, B, A);
            switchingMSort(q + 1, r, B, A);
            switchingMerge(p, q, r, B, A);
        }
    }

    private void switchingMerge(int p, int q, int r, int[] C, int[] D) {
        int i = p, j = q + 1, t = p;
        while (i <= q && j <= r) {
            if (C[i] <= C[j]) D[t++] = C[i++];
            else D[t++] = C[j++];
        }
        while (i <= q)        // 왼쪽 부분 배열이 남은 경우
            D[t++] = C[i++];
        while (j <= r)        // 오른쪽 부분 배열이 남은 경우
            D[t++] = C[j++];
    }


    public void prepare() {
        for (int i = 0; i < A.length; i++)
            B[i] = (int) (1000 * Math.random()); // Math.random(): 0과 1 사이의 실수 생성
    }

    public void copy() {
        System.arraycopy(B, 0, A, 0, A.length);
    }
}
