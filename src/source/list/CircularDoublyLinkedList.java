package source.list;

@SuppressWarnings({"StatementWithEmptyBody", "unused", "unchecked", "rawtypes", "FieldMayBeFinal"})
public class CircularDoublyLinkedList<E> implements ListInterface<E> {
    private BidirectionalNode<E> head;
    private int numItems;

    public CircularDoublyLinkedList() {            // 생성자
        head = new BidirectionalNode<>(null);
        head.next = head.prev = head;
    }

    public BidirectionalNode<E> getNode(int index) {  // 첫 번째 원소는 0번 원소
        if (index >= -1 && index <= numItems - 1) {
            BidirectionalNode<E> currNode = head;
            if (index < numItems / 2)
                for (int i = 0; i <= index; i++)
                    currNode = currNode.next;
            else
                for (int i = numItems - 1; i >= index; i--)
                    currNode = currNode.prev;
            return currNode;
        } else
            return null; // 에러
    }

    @Override
    public void add(int index, E x) {                    // 첫 번째 원소는 0번 원소
        if (index >= 0 && index <= numItems) {
            BidirectionalNode<E> prevNode = getNode(index - 1);
            BidirectionalNode<E> newNode = new BidirectionalNode<>(prevNode, x, prevNode.next);
            newNode.next.prev = newNode;
            prevNode.next = newNode;
            numItems++;
        } else { /* 에러 처리 */ }
    }

    @Override
    public void append(E x) {
        BidirectionalNode<E> prevNode = head.prev;
        BidirectionalNode<E> newNode = new BidirectionalNode<>(prevNode, x, head);
        prevNode.next = newNode;
        head.prev = newNode;
        numItems++;
    }

    @Override
    public E remove(int index) {
        if (index >= 0 && index <= numItems - 1) {
            BidirectionalNode<E> currNode = getNode(index);
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            numItems--;
            return currNode.item;
        } else
            return null;
    }

    @Override
    public boolean removeItem(E x) {
        BidirectionalNode<E> currNode = head; // 더미 헤드
        for (int i = 0; i <= numItems - 1; i++) {
            currNode = currNode.next;
            if (((Comparable) (currNode.item)).compareTo(x) == 0) {
                currNode.prev.next = currNode.next;
                currNode.next.prev = currNode.prev;
                numItems--;
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index <= numItems - 1) {
            return getNode(index).item;
        } else
            return null; // 에러
    }

    @Override
    public void set(int index, E x) {
        if (index >= 0 && index <= numItems - 1) {
            getNode(index).item = x;
        } else { /* 에러 처리 */ }
    }

    private final int NOT_FOUND = -12345;

    @Override
    public int indexOf(E x) {
        BidirectionalNode<E> currNode = head;
        for (int i = 0; i <= numItems - 1; i++) {
            currNode = currNode.next;
            if (((Comparable) (currNode.item)).compareTo(x) == 0)
                return i;
        }
        return NOT_FOUND;
    }

    // [연습문제 5-2] 구현: 원소 x가 존재하는지 알려주기
    @Override
    public boolean contains(E x) {
        return indexOf(x) != NOT_FOUND;
    }

    @Override
    public int len() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        numItems = 0;
        head.next = head.prev = head;
    }

    ///////////////////////////////////////////////////////////////////////
    @Override
    public void printAll() {
        BidirectionalNode<E> t;
        System.out.print("Print source.list (#items=" + numItems + ") ");
        for (t = head.next; t != head; t = t.next)
            System.out.print(t.item + " ");
        System.out.println();
    }
} // 코드 5-14
