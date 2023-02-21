package source.stack;

import source.list.LinkedList;

public class InheritedStack<E> extends LinkedList<E> implements StackInterface<E> {
    public InheritedStack() {
        super();
    }

    @Override
    public void push(E newItem) {
        add(0, newItem);
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            return remove(0);
        } else return null;
    }

    @Override
    public E top() {
        return get(0);
    }

    @Override
    public void popAll() {
        clear();
    }

    /////////////////////////////////////////////
    // [연습문제 6-7] 구현: 스택의 모든 원소를 프린트하기
    public void printAll() {
        super.printAll();
    }
} // 코드 6-6
