package source.queue;

import source.list.LinkedList;

// 연결 리스트 클래스 LinkedList<E> 상속받기
public class InheritedQueue<E> extends LinkedList<E> implements QueueInterface<E> {
    public InheritedQueue() {
        super();
    }

    @Override
    public void enqueue(E newItem) {
        append(newItem);
    }

    @Override
    public E dequeue() {
        return remove(0);
    }

    @Override
    public E front() {
        return get(0);
    }

    @Override
    public void dequeueAll() {
        clear();
    }

    // [연습문제 7-7] 구현: 큐의 모든 원소 프린트하기
    public void printAll() {
        super.printAll();
    }
} // 코드 7-6
