package book.chap09.prob16;

@SuppressWarnings("unused")
public class Sorting {
    int[] A, B;

    public Sorting(int n) {
        A = new int[n];
        B = new int[n];
    }

    // [알고리즘 9-8] 구현: 퀵 정렬
    public void quickSort() {
        qSort(0, A.length - 1);
    }

    private void qSort(int p, int r) {
        if (p < r) {
            int q = partition(p, r);
            qSort(p, q - 1);
            qSort(q + 1, r);
        }
    }

    private int partition(int p, int r) {
        int x = A[r];
        int i = p - 1;
        int tmp;
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= x) {
                i++;
                tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        tmp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = tmp;
        return i + 1;
    }

    // [알고리즘 9-10] 구현: 힙 정렬
    public void heapSort() {
        buildHeap();
        int tmp;
        for (int i = A.length - 1; i >= 0; i--) {
            tmp = A[0];
            A[0] = A[i];
            A[i] = tmp;
            percolateDown(0, i - 1);
        }
    }

    public void buildHeap() {
        if (A.length >= 2) {
            for (int i = (A.length - 2) / 2; i >= 0; i--) {
                percolateDown(i, A.length - 1);
            }
        }
    }

    private void percolateDown(int i, int n) {
        int child = 2 * i + 1;          // left child
        int rightChild = 2 * i + 2;     // right child
        if (child <= n) {
            if (rightChild <= n && A[child] < A[rightChild])
                child = rightChild;   // 더 큰 자식의 인덱스
            if (A[i] < A[child]) {
                int tmp = A[i];
                A[i] = A[child];
                A[child] = tmp;
                percolateDown(child, n);
            }
        }
    }

    public void prepare() {
        for (int i = 0; i < A.length; i++)
            B[i] = (int) (1000 * Math.random()); // Math.random(): 0과 1 사이의 실수 생성
    }

    public void copy() {
        System.arraycopy(B, 0, A, 0, A.length);
    }
}
