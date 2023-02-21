package book.chap05.prob08;

public class BidirectionalNode {
    public Integer item;
    public BidirectionalNode prev;
    public BidirectionalNode next;

    public BidirectionalNode(Integer newItem) {
        item = newItem;
        prev = next = null;
    }

    public BidirectionalNode(Integer newItem, BidirectionalNode prevNode, BidirectionalNode nextNode) {
        item = newItem;
        prev = prevNode;
        next = nextNode;
    }
}
