package source.list;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class LinkedListItemIterator implements Iterator<Comparable> {
    private Node current;

    public LinkedListItemIterator(LinkedList list) {
        current = list.getNode(-1);  // 더미 헤드
    }

    @Override
    public boolean hasNext() {
        return current.next != null;
    }

    @Override
    public Comparable next() {
        current = current.next;
        return (Comparable) (current.item);
    }
}
