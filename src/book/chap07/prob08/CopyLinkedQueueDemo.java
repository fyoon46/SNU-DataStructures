package book.chap07.prob08;

import source.queue.LinkedQueue;

@SuppressWarnings({"rawtypes", "unchecked"})
public class CopyLinkedQueueDemo {
    public static void copyLinkedQueue(LinkedQueue a, LinkedQueue b) {
        b.dequeueAll();
        LinkedQueue temp = new LinkedQueue();
        while (!a.isEmpty()) {
            temp.enqueue(a.dequeue());
        }
        while (!temp.isEmpty()) {
            a.enqueue(temp.front());
            b.enqueue(temp.dequeue());
        }
    }

    public static void main(String[] args) {
        System.out.println("Copy Linked Stack Demo!");
        LinkedQueue<Integer> queue1 = new LinkedQueue<>();
        LinkedQueue<Integer> queue2 = new LinkedQueue<>();
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        System.out.print("printAll(): ");
        queue1.printAll();
        queue2.enqueue(10);
        queue2.enqueue(20);
        queue2.enqueue(30);
        queue2.dequeue();
        queue2.enqueue(40);
        System.out.print("printAll(): ");
        queue2.printAll();
        copyLinkedQueue(queue1, queue2);
        queue1.printAll();
        queue2.printAll();
    }
}
