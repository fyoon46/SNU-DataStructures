package exam.ds2016;

import source.sorting.intLinkedList;

@SuppressWarnings("unused")
public class Sorting {
    int[] A;

    public Sorting(int[] B) {
        A = B;
    }

    // [알고리즘 9-13] 구현: 기수 정렬
    public void radixSort() {  // A[0...n-1]은 최대 numDigits 자릿수의 양의 정수
        int[] cnt = new int[10], start = new int[10];
        int[] B = new int[A.length];
        int max = -1;
        for (int j : A) {
            if (j > max) max = j;
        }
        int numDigits = (int) Math.log10(max) + 1;  // 최대 자릿수 계산
        for (int digit = 1; digit <= numDigits; digit++) {
            for (int d = 0; d <= 9; d++)
                cnt[d] = 0;
            for (int j : A) cnt[(int) (j / Math.pow(10, digit - 1)) % 10]++;
            start[0] = 0;
            for (int d = 1; d <= 9; d++)
                start[d] = start[d - 1] + cnt[d - 1];
            for (int j : A) B[start[(int) (j / Math.pow(10, digit - 1)) % 10]++] = j;
            System.arraycopy(B, 0, A, 0, A.length);
        }
    }

    public static void startRadixSort(int[] A, int n) {
        int max = -1;
        for (int j : A) {
            if (j > max) max = j;
        }
        int numDigits = (int) Math.log10(max) + 1;
        recursiveRadixSort(A, n, numDigits);
    }

    private static void recursiveRadixSort(int[] A, int n, int d) {
        if (d == 0) return;

        recursiveRadixSort(A, n, d - 1);

        int[] cnt = new int[10], start = new int[10];
        int[] B = new int[A.length];
        for (int i = 0; i <= 9; i++)
            cnt[i] = 0;
        for (int i = 0; i < n; i++)
            cnt[(int) (A[i] / Math.pow(10, d - 1)) % 10]++;
        start[0] = 0;
        for (int i = 1; i <= 9; i++)
            start[i] = start[i - 1] + cnt[i - 1];
        for (int i = 0; i < n; i++) B[start[(int) (A[i] / Math.pow(10, d - 1)) % 10]++] = A[i];
        System.arraycopy(B, 0, A, 0, A.length);
    }
} // 코드 9-1
