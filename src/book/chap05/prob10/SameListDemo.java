package book.chap05.prob10;

import source.list.LinkedList;
import source.list.Node;

@SuppressWarnings("rawtypes")
public class SameListDemo {
    public static boolean sameList(Node node1, Node node2) {
        Node currNode = node1;
        for (; currNode != null; currNode = currNode.next) {
            if (currNode == node2) return true;
        }

        currNode = node2;
        for (; currNode != null; currNode = currNode.next) {
            if (currNode == node1) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("Same List Demo!");
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        list1.append(0);
        list1.append(1);
        list1.append(2);
        list1.append(3);
        list1.printAll();
        list2.append(4);
        list2.append(5);
        list2.append(6);
        list2.append(7);
        list2.printAll();

        System.out.println(sameList(list1.getNode(1), list1.getNode(3)));
        System.out.println(sameList(list1.getNode(3), list1.getNode(1)));
        System.out.println(sameList(list1.getNode(1), list2.getNode(1)));
    }
}
