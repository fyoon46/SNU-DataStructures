package source.sorting;

import java.util.Random;

@SuppressWarnings({"CommentedOutCode", "unused"})
public class SortingDemo {

    static final int NUM_SCALE = 10000;

    public static void prepare(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) (NUM_SCALE * Math.random());
        }
    }

    public void prepare_Gaussian(int[] A) {
        for (int i = 0; i < A.length; i++) {
            Random number = new Random();
            A[i] = (int) (NUM_SCALE * number.nextGaussian());
        }
    }

    public static void printA(int[] A) {
        for (int j : A) {
            System.out.println(j);
        }
    }

    static final int SIZE = 30;

    public static void main(String[] args) {
        int[] A = new int[SIZE];
        System.out.println("Sorting Demo!");
        prepare(A);
        Sorting s = new Sorting(A);
        //s.shellSort();
        //s.bubbleSort();
        //s.insertionSort();
        //s.shellSort();
        //s.mergeSort();
        //s.quickSort();
        //s.heapSort();
        //A = s.countingSort(NUM_SCALE);
        //s.radixSort();
        s.bucketSort();
        printA(A);
    }
} // 코드 9-2
