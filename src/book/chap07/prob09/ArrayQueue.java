package book.chap07.prob09;

import source.queue.QueueInterface;

@SuppressWarnings({"unchecked", "ConstantValue", "unused"})
public class ArrayQueue<E> implements QueueInterface<E> {
    private E[] queue;
    private int front, tail, numItems;
    private static final int DEFAULT_CAPACITY = 64;
    private final E ERROR = null;  // 임의의 에러 값

    public ArrayQueue() { // 생성자 1
        queue = (E[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        tail = DEFAULT_CAPACITY - 1;
        numItems = 0;
    }

    public ArrayQueue(int n) { // 생성자 2
        queue = (E[]) new Object[n];
        front = 0;
        tail = n - 1;
        numItems = 0;
    }

    // [연습문제 7-9][알고리즘 7-1] 구현: 큐에 원소 삽입하기
    @Override
    public void enqueue(E newItem) {
        if (isFull()) {
            E[] extendedQueue = (E[]) new Object[queue.length * 2];
            int j = front;
            front = 0;
            tail = extendedQueue.length - 1;
            for (int i = 0; i < numItems; i++) {
                extendedQueue[i] = queue[j];
                j = (j + 1) % queue.length;
                tail = (tail + 1) % extendedQueue.length;
            }
            queue = extendedQueue;
        }
        tail = (tail + 1) % queue.length;
        queue[tail] = newItem;
        numItems++;
    }

    // [알고리즘 7-2] 구현: 큐가 꽉 찼는지 확인하기
    public boolean isFull() {
        return (numItems == queue.length);
    }

    // [알고리즘 7-3] 구현: 큐에서 원소 삭제하기
    @Override
    public E dequeue() {
        if (isEmpty()) return ERROR;
        else {
            E queueFront = queue[front];
            front = (front + 1) % queue.length;
            numItems--;
            return queueFront;
        }
    }

    // [알고리즘 7-5] 구현: 큐의 맨 앞 원소 알려주기
    @Override
    public E front() {
        if (isEmpty()) return ERROR;
        else return queue[front];
    }

    // [알고리즘 7-4] 구현: 큐가 비었는지 확인하기
    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    // [알고리즘 7-6] 구현: 큐 비우기
    @Override
    public void dequeueAll() {
        queue = (E[]) new Object[queue.length];
        front = 0;
        tail = queue.length - 1;
        numItems = 0;
    }

    //////////////////////////////////////////////////////////////////
    // 연습문제 [7-5] 구현: 큐의 모든 원소 프린트하기
    public void printAll() {
        int j = front;
        System.out.print("PrintAll: ");
        for (int i = 0; i < numItems; i++) {
            System.out.print(queue[j] + " ");
            j = (j + 1) % queue.length;
        }
        System.out.println();
    }

    public int getCapacity() {
        return queue.length;
    }
} // 코드 7-2
