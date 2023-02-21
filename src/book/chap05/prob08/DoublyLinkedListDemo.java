package book.chap05.prob08;

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("Doubly Linked List Demo!");
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(300); // 오토박싱
        list.add(200);
        list.add(100);
        list.printAll();
        list.add(500);
        list.add(600);
        list.printAll();
        list.remove(3);
        list.printAll();
        list.add(250);
        list.add(50);
        list.add(10);
        list.printAll();
        list.add(700);
        list.printAll();
        list.remove(1);
        list.removeItem(600);
        list.printAll();
    }
}
