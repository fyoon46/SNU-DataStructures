package book.chap09.prob17;

public class QuickSorting {
    int [] A, B;

    public QuickSorting(int n) {
        A = new int[n];
        B = new int[n];
    }

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
            if (A[j] < x) {
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

    public void quickSort3Way() {
        qSort3Way(0, A.length - 1);
    }

    private void qSort3Way(int p, int q) {
        if (p < q) {
            int x = A[q];
            int tmp;
            int i = p - 1, j = p, k = q;
            while (j <= k) {
                if (A[j] < x) {
                    i++;
                    tmp = A[i];
                    A[i] = A[j];
                    A[j] = tmp;
                    j++;
                } else if (A[j] > x) {
                    tmp = A[j];
                    A[j] = A[k];
                    A[k] = tmp;
                    k--;
                } else j++;
            }
            qSort3Way(p, i);
            qSort3Way(k + 1, q);
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
