package source.list;

public class CircularDoublyLinkedListDemo {

    public static void main(String[] args) {
        System.out.println("Circular Doubly Linked List Demo!");
        CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<>();
        list.add(0, 300); // 오토박싱
        list.add(0, 200);
        list.add(0, 100);
        list.printAll();
        list.append(500);
        list.append(600);
        list.printAll();
        list.remove(3);
        list.printAll();
        list.add(3, 250);
        list.add(1, 50);
        list.add(0, 10);
        list.printAll();
        list.append(700);
        list.printAll();
        list.remove(1);
        list.removeItem(600);
        list.printAll();
        System.out.println(list.contains(300));
        System.out.println(list.contains(600));
    }
} // 코드 5-15
