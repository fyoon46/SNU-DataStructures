package book.chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class prob07 {
    public static int count = 0;

    public static int getIndexOfLargest(int[] A, int n) {
        int largest = 0;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[largest]) largest = i;
        }
        return largest;
    }

    public static void selectionSort(int[] A, int n) {
        count++;
        if (n > 1) {
            int k = getIndexOfLargest(A, n);

            int t = A[k];
            A[k] = A[n - 1];
            A[n - 1] = t;

            selectionSort(A, n - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        selectionSort(A, n);

        String end = " ";
        for (int i = 0; i < n; i++) {
            if (i == n - 1) end = "\n";
            System.out.print(A[i] + end);
        }
        System.out.println("count = " + count);
    }
}
