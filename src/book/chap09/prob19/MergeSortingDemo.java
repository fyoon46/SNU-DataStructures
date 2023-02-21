package book.chap09.prob19;

@SuppressWarnings({"unused", "UnnecessaryLocalVariable"})
public class MergeSortingDemo {
    public static void printA(int[] A) {
        for (int j : A) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) {
        int N = 100000000;
        MergeSorting s = new MergeSorting(N);
        long start, finish, elapsedTime;
        final long FOR_MICRO = 1000, FOR_MILI = 1000000, FOR_SEC = 1000000000;
        long scale = FOR_MILI;
        s.prepare(); // 정수 배열 생성

        // mergeSort()
        s.copy();
        start = System.nanoTime();
        s.mergeSort();
        finish = System.nanoTime(); elapsedTime = (finish - start) / scale;
        System.out.println("Elapsed Time = " + elapsedTime);

        // switchingMergeSort()
        s.copy();
        start = System.nanoTime();
        s.switchingMergeSort();
        finish = System.nanoTime(); elapsedTime = (finish - start) / scale;
        System.out.println("Elapsed Time = " + elapsedTime);
    }
}
