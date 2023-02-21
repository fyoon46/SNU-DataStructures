package book.chap09.prob17;

@SuppressWarnings({"unused", "UnnecessaryLocalVariable"})
public class QuickSortingDemo {
    public static void printA(int[] A) {
        for (int j : A) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) {
        int N = 10000000;
        QuickSorting s = new QuickSorting(N);
        long start, finish, elapsedTime;
        final long FOR_MICRO = 1000, FOR_MILI = 1000000, FOR_SEC = 1000000000;
        long scale = FOR_MILI;
        s.prepare(); // 정수 배열 생성

        // quickSort()
        s.copy();
        start = System.nanoTime();
        s.quickSort();
        finish = System.nanoTime(); elapsedTime = (finish - start) / scale;
        System.out.println("Elapsed Time = " + elapsedTime);

        // quickSort3Way()
        s.copy();
        start = System.nanoTime();
        s.quickSort3Way();
        finish = System.nanoTime(); elapsedTime = (finish - start) / scale;
//        printA(s.A);
        System.out.println("Elapsed Time = " + elapsedTime);
    }
}
