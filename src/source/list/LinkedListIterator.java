package source.list;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class LinkedListIterator implements Iterator<Node> {
    private Node current;

    public LinkedListIterator(LinkedList list) {
        current = list.getNode(-1); // 더미 헤드
    }

    @Override
    public boolean hasNext() {
        return current.next != null;
    }

    @Override
    public Node next() {
        return current = current.next;
    }
}
