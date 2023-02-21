package book.chap09.prob18;

@SuppressWarnings({"unused", "UnnecessaryLocalVariable"})
public class BucketSortingDemo {
    public static void printA(int[] A) {
        for (int j : A) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) {
        int N = 10000000;
        BucketSorting s = new BucketSorting(N);
        long start, finish, elapsedTime;
        final long FOR_MICRO = 1000, FOR_MILI = 1000000, FOR_SEC = 1000000000;
        long scale = FOR_MILI;
        s.prepare(); // 정수 배열 생성

        // bucketSort1()
        s.copy();
        start = System.nanoTime();
        s.bucketSort1();
        finish = System.nanoTime();
        elapsedTime = (finish - start) / scale;
        System.out.println("Elapsed Time = " + elapsedTime);

        // bucketSort2()
        s.copy();
        start = System.nanoTime();
        s.bucketSort2();
        finish = System.nanoTime();
        elapsedTime = (finish - start) / scale;
        System.out.println("Elapsed Time = " + elapsedTime);

        // quickSort()
        s.copy();
        start = System.nanoTime();
        s.quickSort();
        finish = System.nanoTime();
        elapsedTime = (finish - start) / scale;
        System.out.println("Elapsed Time = " + elapsedTime);
    }
}
