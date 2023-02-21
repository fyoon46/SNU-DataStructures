package source.heap;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class Heap<E extends Comparable> implements PQInterface<E> {
    private E[] A;
    private int numItems;

    public Heap(int arraySize) {
        A = (E[]) new Comparable[arraySize];
        numItems = 0;
    }

    public Heap(E[] B, int numElements) {
        A = B; // 배열 레퍼런스 복사
        numItems = numElements;
        buildHeap();
    }

    // [알고리즘 8-2] 구현: 힙에 원소 삽입하기(재귀 알고리즘 버전)
    @Override
    public void insert(E newItem) throws PQException {
        // 힙 A[0...numItems-1]에 원소 newItem을 삽입한다(추가한다)
        if (numItems < A.length) {
            A[numItems] = newItem;
            percolateUp(numItems);
            numItems++;
        } else throw new PQException("HeapErr: Insert()-Overflow!");
    }

    // 스며오르기 percolateUp()
    private void percolateUp(int i) {
        // A[i]에서 시작해서 힙 성질을 만족하도록 수선한다
        // A[0...i-1]은 힙 성질을 만족하고 있음
        int parent = (i - 1) / 2;
        if (parent >= 0 && A[i].compareTo(A[parent]) > 0) {
            E tmp = A[i];
            A[i] = A[parent];
            A[parent] = tmp;
            percolateUp(parent);
        }
    }

    // [알고리즘 8-3] 구현: 힙에서 원소 삭제하기
    @Override
    public E deleteMax() throws PQException {
        // 힙 A[0...numItems-1]에서 최댓값을 삭제하면서 리턴한다
        if (!isEmpty()) {
            E max = A[0];
            A[0] = A[numItems - 1];
            numItems--;
            percolateDown(0);
            return max;
        } else throw new PQException("HeapErr: DeleteMax()-Underflow");
    }

    // 스며내리기 percolateDown()
    private void percolateDown(int i) {
        // A[0...numItems-1]에서 A[i]를 루트로 스며내리기
        int child = 2 * i + 1;        // 왼쪽 자식
        int rightChild = 2 * i + 2;  // 오른쪽 자식
        if (child <= numItems - 1) {
            if (rightChild <= numItems - 1 && A[child].compareTo(A[rightChild]) < 0)
                child = rightChild; // 더 큰 자식의 인덱스
            if (A[i].compareTo(A[child]) < 0) {
                E tmp = A[i];
                A[i] = A[child];
                A[child] = tmp;
                percolateDown(child);
            }
        }
    }

    public void buildHeap() {
        if (numItems >= 2)
            for (int i = (numItems - 2) / 2; i >= 0; i--)
                percolateDown(i);
    }

    // [알고리즘 8-5] 구현: 힙의 최댓값 구하기
    @Override
    public E max() throws PQException {
        if (!isEmpty()) {
            return A[0];
        } else throw new PQException("HeapErr: Max()-Empty!");
    }

    // [알고리즘 8-6] 구현: 힙이 비었는지 확인하기
    @Override
    public boolean isEmpty() { // 힙이 비어있는지 알려준다
        return numItems == 0;
    }

    // [알고리즘 8-7] 구현: 힙 비우기
    @Override
    public void clear() {
        A = (E[]) new Comparable[A.length];
        numItems = 0;
    }

    //////////////////////////////////////////////////
    public void heapPrint() {
        System.out.println("heapPrint()");
        for (int i = 0; i <= numItems - 1; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }
} // 코드 8-2
