package book.chap06.prob10;

import source.list.Node;
import source.stack.LinkedStack;

@SuppressWarnings({"StatementWithEmptyBody", "unused", "unchecked", "rawtypes", "FieldCanBeLocal"})
public class LinkedList<E> implements ListInterface<E> {
    private Node<E> head;
    private int numItems;

    public LinkedList() {
        numItems = 0;
        head = new Node<>(null, null);
    }

    public Node<E> getNode(int index) {
        if (index >= -1 && index <= numItems - 1) {
            Node<E> currNode = head;
            for (int i = 0; i <= index; i++) {
                currNode = currNode.next;
            }
            return currNode;
        } else {
            return null;
        }
    }

    @Override
    public void add(int index, E x) {
        if (index >= 0 && index <= numItems) {
            Node<E> prevNode = getNode(index - 1);
            prevNode.next = new Node<>(x, prevNode.next);
            numItems++;
        }
    }

    public static final int NOT_FOUND = -12345;

    @Override
    public int index(E x) {
        Node<E> currNode = head;
        for (int i = 0; i < numItems; i++) {
            currNode = currNode.next;
            if (((Comparable) (currNode.item)).compareTo(x) == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public E get(int index) {
        if (index >= 0 && index <= numItems - 1) {
            return getNode(index).item;
        } else
            return null;
    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < numItems) {
            Node<E> prevNode = getNode(index - 1);
            prevNode.next = prevNode.next.next;
            numItems--;
        } else { /* 예외 처리 */ }
    }

    @Override
    public void clear() {
        numItems = 0;
        head = new Node<>(null, null);
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
    public void printReverse() {
        LinkedStack<E> temp = new LinkedStack<>();
        Node<E> t;
        for (t = head.next; t != null; t = t.next) {
            temp.push(t.item);
        }
        temp.printAll();
    }
}
