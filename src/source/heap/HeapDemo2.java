package source.heap;

public class HeapDemo2 {
    public static void main(String[] args) {
        System.out.println("Heap w/ Exception!");
        Integer[] A = new Integer[10];
        A[0] = 3;
        A[1] = 5;
        A[2] = 2;
        A[3] = 8;
        A[4] = 1;
        Heap<Integer> h = new Heap<>(A, 5);
        h.heapPrint();
        try {
            h.insert(4);
            h.insert(6);
            h.insert(7);
            h.insert(9);
            h.heapPrint();
            h.deleteMax();
            h.heapPrint();
            h.insert(10);
            h.heapPrint();
            h.insert(11); // 여기서 PQException
        } catch (PQException e) {
            String msg = e.getMessage();
            System.out.println(msg);
        }
    }
}
