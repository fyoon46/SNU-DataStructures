package book.chap07.prob03;

import source.list.ArrayList;
import source.list.ListInterface;
import source.queue.QueueInterface;

@SuppressWarnings("FieldMayBeFinal")
public class ListQueue<E> implements QueueInterface<E> {
    private ListInterface<E> list;

    public ListQueue() {
        list = new ArrayList<>();
    }

    @Override
    public void enqueue(E newItem) {
        list.add(0, newItem);
    }

    @Override
    public E dequeue() {
        return list.remove(list.len() - 1);
    }

    @Override
    public E front() {
        return list.get(list.len() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void dequeueAll() {
        list.clear();
    }

    public void printAll() {
        System.out.print("PrintAll: ");
        for (int i = list.len() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
