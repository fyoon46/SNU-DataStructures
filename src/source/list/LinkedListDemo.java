package source.list;

public class LinkedListDemo {
    public static void main(String[] args) {
        System.out.println("Linked List Demo!");
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0, 300); // 오토 박싱
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
        list.printInterval(1, 4);
        list.remove(1, 3);
        list.printAll();
        list.add(1, 50);
        list.add(2, 200);
        list.add(3, 300);
        list.add(3, 250);
        list.printAll();
        System.out.println(list.indexOf(250));
        System.out.println(list.lastIndexOf(250));
        System.out.println(list.contains(300));
        System.out.println(list.contains(600));
    }
} // 코드 5-10
