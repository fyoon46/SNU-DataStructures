package book.chap06.prob09;

import source.stack.StackInterface;

@SuppressWarnings({"unused", "unchecked", "ConstantValue"})
public class ArrayStack<E> implements StackInterface<E> {
    private E[] stack;
    private int topIndex;              // 스택의 탑 인덱스
    private static final int DEFAULT_CAPACITY = 64;
    private final E ERROR = null;     // 임의의 에러 값

    public ArrayStack() {    // 생성자 1
        stack = (E[]) new Object[DEFAULT_CAPACITY];
        topIndex = -1;
    }

    public ArrayStack(int n) {    // 생성자 2
        stack = (E[]) new Object[n];
        topIndex = -1;
    }

    // [연습문제 5-9][알고리즘 6-1] 구현: 스택에 원소 x 삽입하기
    @Override
    public void push(E newItem) {
        if (isFull()) {
            E[] extendedStack = (E[]) new Object[stack.length * 2];
            System.arraycopy(stack, 0, extendedStack, 0, topIndex + 1);
            stack = extendedStack;
        }
        stack[++topIndex] = newItem;
    }

    // [알고리즘 6-2] 구현: 스택에서 원소 삭제하기
    @Override
    public E pop() {
        if (isEmpty()) return ERROR;
        else return stack[topIndex--];
    }

    // [알고리즘 6-3] 구현: 스택 탑 원소 알려주기
    @Override
    public E top() {
        if (isEmpty()) return ERROR;
        else return stack[topIndex];
    }

    // [알고리즘 6-4] 구현: 스택이 꽉 찼는지 확인하기
    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    // [알고리즘 6-5] 구현: 스택이 비었는지 확인하기
    public boolean isFull() {
        return topIndex == stack.length - 1;
    }

    // [알고리즘 6-6] 구현: 스택 비우기
    @Override
    public void popAll() {
        stack = (E[]) new Object[stack.length];
        topIndex = -1;
    }

    ////////////////////////////////////////////
    // [연습문제 6-5] 구현: 스택의 모든 원소를 프린트하기
    public void printAll() {
        System.out.print("Stack from top:");
        for (int i = topIndex; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public int getTopIndex() {
        return topIndex;
    }

    public int getCapacity() {
        return stack.length;
    }
} // 코드 6-2
