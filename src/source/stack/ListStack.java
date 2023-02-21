package source.stack;

import source.list.LinkedList;
import source.list.ListInterface;

@SuppressWarnings("FieldMayBeFinal")
public class ListStack<E> implements StackInterface<E> {
    private ListInterface<E> list;

    public ListStack() {
        list = new LinkedList<>();
    }

    @Override
    public void push(E newItem) {
        list.add(0, newItem);
    }

    @Override
    public E pop() {
        return list.remove(0);
    }

    @Override
    public E top() {
        return list.get(0);
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
    // [연습문제 6-7] 구현: 스택의 모든 원소를 프린트하기
    public void printAll() {
        list.printAll();
    }
} // 코드 6-7
