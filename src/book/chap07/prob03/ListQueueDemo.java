package book.chap07.prob03;

public class ListQueueDemo {
    public static void main(String[] args) {
        System.out.println("List Queue Demo!");
        ListQueue<Integer> queue1 = new ListQueue<>();
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
