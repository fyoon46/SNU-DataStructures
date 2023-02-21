package source.sorting;

public class intLinkedList {
    private final intNode head;
    private int numItems;

    public intLinkedList() {
        numItems = 0;
        head = new intNode(-1, null);
    }

    public intNode getNode(int index) {
        intNode curr = head;  // dummy head
        for (int i = 0; i <= index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void add(int index, int item) {
        intNode prev = getNode(index - 1);
        prev.next = new intNode(item, prev.next);
        numItems++;
    }

    public int len() {
        return numItems;
    }

    @SuppressWarnings("unused")
    public static class intNode {
        public int item;
        public intNode next;

        public intNode(int newItem) {
            item = newItem;
            next = null;
        }

        public intNode(int newItem, intNode nextNode) {
            item = newItem;
            next = nextNode;
        }
    }
}
