package book.chap06.prob03;

import source.list.Node;
import source.stack.StackInterface;

@SuppressWarnings({"ConstantValue", "FieldMayBeFinal"})
public class LinkedStack<E> implements StackInterface<E> {
    private Node<E> topNode;
    private final E ERROR = null;   // 임의의 에러 값

    public LinkedStack() {
        topNode = new Node<>(null, null);
    }

    // [알고리즘 6-7] 구현: 스택에 원소 x 삽입하기
    @Override
    public void push(E newItem) {
        topNode.next = new Node<>(newItem, topNode.next);
    }

    // [알고리즘 6-8] 구현: 스택에서 원소 삭제하기
    @Override
    public E pop() {
        if (isEmpty()) return ERROR;
        else {
            Node<E> tmp = topNode.next;
            topNode.next = tmp.next;
            return tmp.item;
        }
    }

    // [알고리즘 6-9] 구현: 스택 탑 원소 알려주기
    @Override
    public E top() {
        if (isEmpty()) return ERROR;
        else return topNode.next.item;
    }

    // [알고리즘 6-10] 구현: 스택이 비었는지 확인하기
    @Override
    public boolean isEmpty() {
        return topNode.next == null;
    }

    // [알고리즘 6-11] 구현: 스택 비우기
    @Override
    public void popAll() {
        topNode.next = null;
    }

    //////////////////////////////////////////////
    public void printAll() {
        Node<E> t;
        System.out.print("Stack from top: ");
        for (t = topNode.next; t != null; t = t.next) {
            System.out.print(t.item + " ");
        }
        System.out.println();
    }
} // 코드 6-4
