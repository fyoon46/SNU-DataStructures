package book.chap07.prob09;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("Queue Stack Demo!");
        ArrayQueue<Integer> queue1 = new ArrayQueue<>(3);
        queue1.enqueue(1);
        queue1.enqueue(2);
        queue1.enqueue(3);
        System.out.print("printAll() (#capacity=" + queue1.getCapacity() + ") ");
        queue1.printAll();
        queue1.dequeue();
        queue1.enqueue(4);
        queue1.enqueue(5);
        queue1.enqueue(6);
        queue1.enqueue(7);
        System.out.print("printAll() (#capacity=" + queue1.getCapacity() + ") ");
        queue1.printAll();
        queue1.dequeue();
        queue1.dequeue();
        queue1.enqueue(8);
        queue1.enqueue(9);
        queue1.enqueue(10);
        queue1.enqueue(11);
        queue1.enqueue(12);
        System.out.print("printAll() (#capacity=" + queue1.getCapacity() + ") ");
        queue1.printAll();
    }
}
