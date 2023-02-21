package source.list;

@SuppressWarnings({"StatementWithEmptyBody", "unused", "unchecked", "rawtypes"})
public class LinkedList<E> implements ListInterface<E> {
    private Node<E> head;
    private int numItems;

    public LinkedList() {            // 생성자
        numItems = 0;
        head = new Node<>(null, null);    // 더미 헤드
    }

    public Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems - 1) {
            Node<E> currNode = head;    // 더미 노드
            for (int i = 0; i <= index; i++) {
                currNode = currNode.next;
            }
            return currNode;
        } else {
            return null;
        }
    }

    // [알고리즘 5-10] 구현: 연결 리스트에 원소 x 삽입하기
    @Override
    public void add(int index, E item) {
        if (index >= 0 && index <= numItems) {
            Node<E> prevNode = getNode(index - 1);
            prevNode.next = new Node<>(item, prevNode.next);
            numItems++;
        }
    }

    @Override
    public void append(E item) {
        Node<E> prevNode = head;        // 더미 노드
        while (prevNode.next != null) {
            prevNode = prevNode.next;
        }
        prevNode.next = new Node<>(item, null);
        numItems++;
    }

    // [알고리즘 5-12] 구현: 리스트의 원소 삭제하기
    @Override
    public E remove(int index) {
        if (index >= 0 && index < numItems) {
            Node<E> prevNode = getNode(index - 1);
            Node<E> currNode = prevNode.next;
            prevNode.next = currNode.next;
            numItems--;
            return currNode.item;
        } else {
            return null;
        }
    }

    // [연습문제 5-7] 구현: 리스트의 원소 k개 삭제하기
    public void remove(int index, int k) {
        if (index >= 0 && index <= numItems - 1) {
            if (k >= 1) {
                Node<E> prevNode = getNode(index - 1);
                Node<E> currNode = prevNode;
                while (k-- > 0 && currNode.next != null) {
                    currNode = currNode.next;
                    numItems--;
                }
                prevNode.next = currNode.next;
            } else { /* 에러 */ }
        } else { /* 에러 */ }
    }

    @Override
    public boolean removeItem(E x) {
        Node<E> currNode = head;    // 더미 헤드
        Node<E> prevNode;
        for (int i = 0; i < numItems; i++) {
            prevNode = currNode;
            currNode = currNode.next;
            if (((Comparable) (currNode.item)).compareTo(x) == 0) {
                prevNode.next = currNode.next;
                numItems--;
                return true;
            }
        }
        return false;            // not found
    }

    // [알고리즘 5-13] 구현: 연결 리스트의 k번째 원소 알려주기
    @Override
    public E get(int index) {
        if (index >= 0 && index <= numItems - 1) {
            return getNode(index).item;
        } else
            return null;        // 에러
    }

    // [알고리즘 5-14] 구현:연결 리스트의 k번째 원소를 x로 대체하기
    @Override
    public void set(int index, E x) {
        if (index >= 0 && index <= numItems - 1) {
            getNode(index).item = x;
        } else { /* 에러 처리 */ }
    }

    // [알고리즘 5-15] 구현: 원소 x가 연결 리스트의 몇 번째 원소인지 알려주기
    private final int NOT_FOUND = -12345;

    @Override
    public int indexOf(E x) {
        Node<E> currNode = head;   // 더미 노드
        for (int i = 0; i < numItems; i++) {
            currNode = currNode.next;
            if (((Comparable) (currNode.item)).compareTo(x) == 0)
                return i;
        }
        return NOT_FOUND;    // not found
    }

    // [연습문제 5-12] 구현: x값을 갖는 맨 마지막 원소가 배열 리스트의 몇 번째 원소인지 알려주기
    public int lastIndexOf(E x) {
        Node<E> currNode = head;    // 더비 노드
        int index = NOT_FOUND;
        for (int i = 0; i < numItems; i++) {
            currNode = currNode.next;
            if (((Comparable) (currNode.item)).compareTo(x) == 0)
                index = i;
        }
        return index;
    }

    // [연습문제 5-2] 구현: 원소 x가 존재하는지 알려주기
    @Override
    public boolean contains(E x) {
        return indexOf(x) != NOT_FOUND;
    }

    // [알고리즘 5-16(1)] 구현: 리스트의 총 원소 수 알려주기
    @Override
    public int len() {
        return numItems;
    }

    // [알고리즘 5-16(2)] 구현: 리스트가 비었는지 알려주기
    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    // [알고리즘 5-16(3)] 구현: 리스트 깨끗이 청소하기
    @Override
    public void clear() {
        numItems = 0;
        head = new Node<>(null, null);
    }

    ///////////////////////////////////////////////////////////////////////
    public void printAll() {
        Node<E> t;
        System.out.print("Print source.list (#items=" + numItems + ") ");
        for (t = head.next; t != null; t = t.next) {
            System.out.print(t.item + " ");
        }
        System.out.println();
    }

    // [연습문제 5-5] 구현: i~j번째 원소 프린트하기
    public void printInterval(int i, int j) {
        if (i >= 0 && i < numItems && j >= 0 && j < numItems) {
            Node<E> t;
            Node<E> startNode = getNode(i), endNode = getNode(j).next;
            boolean startPrinting = false;
            System.out.print("Print source.list (item " + i + "~" + j + ") ");
            for (t = head.next; t != endNode; t = t.next) {
                if (t == startNode) startPrinting = true;
                if (startPrinting)
                    System.out.print(t.item + " ");
            }
            System.out.println();
        }
    }
} // 코드 5-9
