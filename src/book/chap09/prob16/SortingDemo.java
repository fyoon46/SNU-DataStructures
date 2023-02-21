package book.chap09.prob16;

@SuppressWarnings({"UnnecessaryLocalVariable", "unused"})
public class SortingDemo {
    public static void main(String[] args) {
        int N = 10000000;
        Sorting s = new Sorting(N);
        long start, finish, elapsedTime;
        final long FOR_MICRO = 1000, FOR_MILI = 1000000, FOR_SEC = 1000000000;
        long scale = FOR_MILI;
        s.prepare(); // 정수 배열 생성

        // heapSort()
        s.copy();
        start = System.nanoTime();
        s.heapSort();
        finish = System.nanoTime(); elapsedTime = (finish - start) / scale;
        System.out.println("Elapsed Time = " + elapsedTime);

        // 첫 번째 quickSort()
        s.copy();
        start = System.nanoTime();
        s.quickSort();
        finish = System.nanoTime(); elapsedTime = (finish - start) / scale;
        System.out.println("Elapsed Time = " + elapsedTime);

        // 두 번째 quickSort(). copy() 없이 시작함!
        start = System.nanoTime();
        s.quickSort();
        finish = System.nanoTime(); elapsedTime = (finish - start) / scale;
        System.out.println("Elapsed Time = " + elapsedTime);
    }
}
