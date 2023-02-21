package book.chap07.prob01;

public class DNode<E> {
    public E item;
    public DNode<E> prev;
    public DNode<E> next;

    public DNode(E newItem) {
        item = newItem;
        prev = next = null;
    }

    public DNode(E newItem, DNode<E> prevNode, DNode<E> nextNode) {
        item = newItem;
        prev = prevNode;
        next = nextNode;
    }
}
