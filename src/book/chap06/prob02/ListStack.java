package book.chap06.prob02;

import source.list.LinkedList;
import source.list.ListInterface;
import source.stack.StackInterface;

public class ListStack<E> implements StackInterface<E> {
    private final ListInterface<E> list;

    public ListStack() {
        list = new LinkedList<>();
    }

    @Override
    public void push(E newItem) {
        list.append(newItem);
    }

    @Override
    public E pop() {
        return list.remove(list.len() - 1);
    }

    @Override
    public E top() {
        return list.get(list.len() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void popAll() {
        list.clear();
    }

    ////////////////////////////////
    public void printAll() {
        list.printAll();
    }
}
