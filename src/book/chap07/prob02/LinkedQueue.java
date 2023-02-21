package book.chap07.prob02;

import source.list.Node;
import source.queue.QueueInterface;

@SuppressWarnings("ConstantValue")
public class LinkedQueue<E> implements QueueInterface<E> {
    private Node<E> tail;
    private final E ERROR = null; // 임의의 에러 값

    // [연습문제 7-2] 구현
    public LinkedQueue() {
        tail = new Node<>(null);
        tail.next = tail;
    }

    // [연습문제 7-2][알고리즘 7-7] 구현: 큐에 원소 삽입하기
    @Override
    public void enqueue(E newItem) {
        Node<E> newNode = new Node<>(newItem, tail.next);
        tail.next = newNode;
        tail = newNode;
    }

    // [연습문제 7-2][알고리즘 7-8] 구현: 큐에서 원소 삭제하기
    @Override
    public E dequeue() {
        if (isEmpty()) return ERROR;
        else {
            Node<E> head = tail.next;
            E rItem = head.next.item;
            head.next = head.next.next;
            if (head.next == head)
                tail = head;
            return rItem;
        }
    }

    // [연습문제 7-2][알고리즘 7-9] 구현: 큐의 맨 앞 원소 알려주기
    @Override
    public E front() {
        if (isEmpty()) return ERROR;
        else return tail.next.next.item;    // tail.next.next: front
    }

    // [연습문제 7-2][알고리즘 7-10] 구현: 큐가 비었는지 확인하기
    @Override
    public boolean isEmpty() {
        return tail.next == tail;
    }

    // [연습문제 7-2][알고리즘 7-11] 구현: 큐 비우기
    @Override
    public void dequeueAll() {
        tail = new Node<>(null);
        tail.next = tail;
    }

    /////////////////////////////////////////////////////
    public void printAll() {
        Node<E> t = tail.next;
        System.out.println("Queue from front to tail");
        if (!isEmpty()) {
            do {
                t = t.next;
                System.out.print(t.item + " ");
            } while (t != tail);
            System.out.println();
        } else System.out.println("Empty Queue!");
    }
}
