package book.chap05.prob09;

import source.list.LinkedList;
import source.list.Node;

@SuppressWarnings({"rawtypes", "unused"})
public class ConcatDemo {
    public static void concat(LinkedList list1, LinkedList list2) {
        Node endNode = list1.getNode(list1.len() - 1);
        endNode.next = list2.getNode(0);
        list2.clear();
    }

    public static void main(String[] args) {
        System.out.println("Concat Demo!");
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list1.append(0);
        list1.append(1);
        list1.append(2);
        list1.printAll();
        list2.append(3);
        list2.append(4);
        list2.append(5);
        list2.printAll();

        concat(list1, list2);
        list1.printAll();
        list2.printAll();
    }
}
