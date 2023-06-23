package book.chap09.prob18;

import source.sorting.intLinkedList;

public class BucketSorting {
    int[] A, B;

    public BucketSorting(int n) {
        A = new int[n];
        B = new int[n];
    }

    public void bucketSort1() {
        // A[0...]: 음이 아닌 정수 범위에서 균등 분포 배열
        intLinkedList[] B;
        int numLists = A.length;
        B = new intLinkedList[numLists];
        for (int i = 0; i < numLists; i++)
            B[i] = new intLinkedList();
        int max = 0;
        for (int i = 1; i < numLists; i++)
            if (A[i] > A[max]) max = i;
        int band = A[max] + 1;
        int bucketId;
        for (int j : A) {
            bucketId = (int) ((float) j / band * numLists);
            B[bucketId].add(0, j);
        }
        int finger = 0, p, r = -1;
        for (int i = 0; i < numLists; i++) {
            for (int j = 0; j < B[i].len(); j++) {
                A[finger++] = B[i].getNode(j).item;
            }
            p = r + 1;
            r = finger - 1;
            rangeInsertionSort(p, r);
        }
    }

    public void bucketSort2() {
        // A[0...]: 음이 아닌 정수 범위에서 균등 분포 배열int
        int numLists = A.length;
        int[] cnt = new int[numLists];
        for (int i = 0; i < numLists; i++)
            cnt[i] = 0;
        int max = 0;
        for (int i = 1; i < numLists; i++)
            if (A[i] > A[max]) max = i;
        int band = A[max] + 1;
        int bucketId;
        for (int j : A) {
            bucketId = (int) ((float) j / band * numLists);
            cnt[bucketId]++;
        }
        cnt[0]--;
        for (int i = 1; i < numLists; i++)
            cnt[i] += cnt[i - 1];
        int[] B = new int[A.length];
        System.arraycopy(A, 0, B, 0, A.length);
        for (int i = numLists - 1; i >= 0; i--) {
            bucketId = (int) ((float) B[i] / band * numLists);
            A[cnt[bucketId]] = B[i];
            cnt[bucketId]--;
        }
        rangeInsertionSort(0, A.length - 1);
    }

    private void rangeInsertionSort(int p, int r) {
        for (int i = p + 1; i <= r; i++) {
            int loc = i - 1;
            int x = A[i];
            while (loc >= p && x < A[loc]) {
                A[loc + 1] = A[loc];
                loc--;
            }
            A[loc + 1] = x;
        }
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

    public void prepare() {
        for (int i = 0; i < A.length; i++)
            B[i] = (int) (10000 * Math.random()); // Math.random(): 0과 1 사이의 실수 생성
    }

    public void copy() {
        System.arraycopy(B, 0, A, 0, A.length);
    }
}
