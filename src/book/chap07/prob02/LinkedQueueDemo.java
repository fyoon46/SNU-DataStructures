package book.chap07.prob02;

public class LinkedQueueDemo {
    public static void main(String[] args) {
        System.out.println("Linked Queue Demo!");
        LinkedQueue<Integer> queue1 = new LinkedQueue<>();
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        System.out.print("printAll(): ");
        queue1.printAll();
        queue1.dequeueAll();
        System.out.println("isEmpty?: " + queue1.isEmpty());
        queue1.enqueue(10);
        queue1.enqueue(20);
        queue1.enqueue(30);
        queue1.dequeue();
        queue1.enqueue(40);
        System.out.print("printAll(): ");
        queue1.printAll();
        System.out.println("pop() " + queue1.dequeue());
        System.out.println("pop() " + queue1.dequeue());
        System.out.println("pop() " + queue1.dequeue());
        System.out.println("pop() " + queue1.dequeue()); // no effect
        System.out.println("isEmpty?: " + queue1.isEmpty());
    }
}
