package book.chap06.prob10;

public class LinkedListDemo {
    public static void main(String[] args) {
        System.out.println("Linked List Demo!");
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0, 300); // 오토 박싱
        list.add(0, 200);
        list.add(0, 100);
        list.printReverse();
        list.add(3, 500);
        list.add(4, 600);
        list.printReverse();
        list.remove(3);
        list.printReverse();
        list.add(3, 250);
        list.add(1, 50);
        list.add(0, 10);
        list.printReverse();
        list.add(7, 700);
        list.printReverse();
        list.remove(1);
        list.remove(5);
        list.printReverse();
    }
}
