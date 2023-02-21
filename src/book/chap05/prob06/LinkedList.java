package book.chap05.prob06;

import source.list.ListInterface;
import source.list.Node;

@SuppressWarnings({"StatementWithEmptyBody", "unused", "unchecked", "rawtypes"})
public class LinkedList<E> implements ListInterface<E> {
    private Node<E> head;

    public LinkedList() {            // 생성자
        head = new Node<>(null, null);    // 더미 헤드
    }

    // [연습문제 5-6] 구현: 리스트의 원소 수 확인
    public int numItems() {
        // 재귀를 사용하지 않는 알고리즘
        int numItems = 0;
        for (Node<E> t = head.next; t != null; t = t.next)
            numItems++;
        return numItems;
    }

    public int numItems(Node<E> prevNode) {
        // 재귀를 사용하는 알고리즘
        if (prevNode.next == null) return 0;
        else return 1 + numItems(prevNode.next);
    }

    public Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems(head) - 1) {
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
        if (index >= 0 && index <= numItems(head)) {
            Node<E> prevNode = getNode(index - 1);
            prevNode.next = new Node<>(item, prevNode.next);
        }
    }

    @Override
    public void append(E item) {
        Node<E> prevNode = head;        // 더미 노드
        while (prevNode.next != null) {
            prevNode = prevNode.next;
        }
        prevNode.next = new Node<>(item, null);
    }

    // [알고리즘 5-12] 구현: 리스트의 원소 삭제하기
    @Override
    public E remove(int index) {
        if (index >= 0 && index < numItems(head)) {
            Node<E> prevNode = getNode(index - 1);
            Node<E> currNode = prevNode.next;
            prevNode.next = currNode.next;
            return currNode.item;
        } else {
            return null;
        }
    }

    @Override
    public boolean removeItem(E x) {
        Node<E> currNode = head;    // 더미 헤드
        Node<E> prevNode;
        for (int i = 0; i < numItems(head); i++) {
            prevNode = currNode;
            currNode = currNode.next;
            if (((Comparable) (currNode.item)).compareTo(x) == 0) {
                prevNode.next = currNode.next;
                return true;
            }
        }
        return false;            // not found
    }

    // [알고리즘 5-13] 구현: 연결 리스트의 k번째 원소 알려주기
    @Override
    public E get(int index) {
        if (index >= 0 && index <= numItems(head) - 1) {
            return getNode(index).item;
        } else
            return null;        // 에러
    }

    // [알고리즘 5-14] 구현:연결 리스트의 k번째 원소를 x로 대체하기
    @Override
    public void set(int index, E x) {
        if (index >= 0 && index <= numItems(head) - 1) {
            getNode(index).item = x;
        } else { /* 에러 처리 */ }
    }

    // [알고리즘 5-15] 구현: 원소 x가 연결 리스트의 몇 번째 원소인지 알려주기
    private final int NOT_FOUND = -12345;

    @Override
    public int indexOf(E x) {
        Node<E> currNode = head;   // 더미 노드
        for (int i = 0; i < numItems(head); i++) {
            currNode = currNode.next;
            if (((Comparable) (currNode.item)).compareTo(x) == 0)
                return i;
        }
        return NOT_FOUND;    // not found
    }

    // [연습문제 5-2] 구현: 원소 x가 존재하는지 알려주기
    @Override
    public boolean contains(E x) {
        return indexOf(x) != NOT_FOUND;
    }

    // [알고리즘 5-16(1)] 구현: 리스트의 총 원소 수 알려주기
    @Override
    public int len() {
        return numItems(head);
    }

    // [알고리즘 5-16(2)] 구현: 리스트가 비었는지 알려주기
    @Override
    public boolean isEmpty() {
        return numItems(head) == 0;
    }

    // [알고리즘 5-16(3)] 구현: 리스트 깨끗이 청소하기
    @Override
    public void clear() {
        head = new Node<>(null, null);
    }

    ///////////////////////////////////////////////////////////////////////
    @Override
    public void printAll() {
        Node<E> t;
        System.out.print("Print source.list (#items=" + numItems(head) + ") ");
        for (t = head.next; t != null; t = t.next) {
            System.out.print(t.item + " ");
        }
        System.out.println();
    }
} // 연습문제 5-6
