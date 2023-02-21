package book.chap05.prob08;

@SuppressWarnings("FieldCanBeLocal")
public class DoublyLinkedList {
    private final BidirectionalNode head;
    private int numItems;

    public DoublyLinkedList() {
        numItems = 0;
        head = new BidirectionalNode(null);     // 더미 헤드
        head.next = head;
        head.prev = head;
    }

    public BidirectionalNode getNode(int index) {
        if (index >= -1 && index <= numItems - 1) {
            BidirectionalNode currNode = head;
            if (index < numItems / 2)
                for (int i = 0; i <= index; i++)
                    currNode = currNode.next;
            else
                for (int i = numItems - 1; i >= index; i--)
                    currNode = currNode.prev;
            return currNode;
        } else
            return null; // 에러
    }

    public void add(Integer x) {
        BidirectionalNode prevNode = head;
        while (prevNode.next != head) {
            if (prevNode.next.item.compareTo(x) >= 0)
                break;
            prevNode = prevNode.next;
        }
        BidirectionalNode newNode = new BidirectionalNode(x, prevNode, prevNode.next);
        newNode.next.prev = newNode;
        prevNode.next = newNode;
        numItems++;
    }

    public Integer remove(int index) {
        if (index >= 0 && index <= numItems - 1) {
            BidirectionalNode currNode = getNode(index);
            currNode.prev.next = currNode.next;
            currNode.next.prev = currNode.prev;
            numItems--;
            return currNode.item;
        } else
            return null;
    }

    public boolean removeItem(Integer x) {
        BidirectionalNode currNode = head; // 더미 헤드
        for (int i = 0; i <= numItems - 1; i++) {
            currNode = currNode.next;
            if ((currNode.item).compareTo(x) == 0) {
                currNode.prev.next = currNode.next;
                currNode.next.prev = currNode.prev;
                numItems--;
                return true;
            }
        }
        return false;
    }

    public Integer get(int index) {
        if (index >= 0 && index <= numItems - 1) {
            return getNode(index).item;
        } else
            return null;
    }

    private final int NOT_FOUND = -12345;

    public int indexOf(Integer x) {
        BidirectionalNode currNode = head;
        for (int i = 0; i <= numItems - 1; i++) {
            currNode = currNode.next;
            if ((currNode.item).compareTo(x) == 0)
                return i;
        }
        return NOT_FOUND;
    }

    public int len() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public void clear() {
        numItems = 0;
        head.next = head.prev = head;
    }

    ///////////////////////////////////////////////////////////////////////
    public void printAll() {
        BidirectionalNode t;
        System.out.print("Print source.list (#items=" + numItems + ") ");
        for (t = head.next; t != head; t = t.next)
            System.out.print(t.item + " ");
        System.out.println();
    }
}
