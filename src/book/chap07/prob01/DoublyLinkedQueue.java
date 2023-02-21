package book.chap07.prob01;

import source.queue.QueueInterface;

@SuppressWarnings("FieldMayBeFinal")
public class DoublyLinkedQueue<E> implements QueueInterface<E> {
    private DNode<E> head;

    public DoublyLinkedQueue() {
        head = new DNode<>(null);
        head.prev = head;
        head.next = head;
    }

    @Override
    public void enqueue(E newItem) {
        DNode<E> prevNode = head.prev;
        DNode<E> newNode = new DNode<>(newItem, prevNode, head);
        prevNode.next = newNode;
        head.prev = newNode;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        else {
            DNode<E> front = head.next;
            head.next = front.next;
            front.next.prev = head;
            return front.item;
        }
    }

    @Override
    public E front() {
        return head.next.item;
    }

    @Override
    public boolean isEmpty() {
        return head.next == head;
    }

    @Override
    public void dequeueAll() {
        head.prev = head;
        head.next = head;
    }

    public void printAll() {
        DNode<E> t;
        System.out.print("PrintAll: ");
        for (t = head.next; t != head; t = t.next)
            System.out.print(t.item + " ");
        System.out.println();
    }
}
