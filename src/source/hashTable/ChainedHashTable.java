package source.hashTable;

import source.BST.IndexInterface;
import source.list.LinkedList;
import source.list.Node;

@SuppressWarnings({"FieldMayBeFinal", "unchecked", "StatementWithEmptyBody", "rawtypes"})
public class ChainedHashTable implements IndexInterface<Node<Integer>> {
    private LinkedList<Integer>[] table;
    int numItems;

    public ChainedHashTable(int n) {
        table = (LinkedList<Integer>[]) new LinkedList[n];
        for (int i = 0; i < n; i++)
            table[i] = new LinkedList<>();
        numItems = 0;
    }

    private int hash(Integer x) {
        return x % table.length;    // 간단한 예
    }

    // [알고리즘 12-1] 구현: 검색, 삽입, 삭제
    @Override
    public void insert(Comparable x) {
        int slot = hash((Integer) x);
        table[slot].add(0, (Integer) x);
        numItems++;
    }

    @Override
    public Node<Integer> search(Comparable x) {
        int slot = hash((Integer) x);
        if (table[slot].isEmpty()) return null; // null list
        else {
            int i = table[slot].indexOf((Integer) x);
            if (i == LinkedList.NOT_FOUND) return null; // not exist
            else return table[slot].getNode(i);
        }
    }

    @Override
    public void delete(Comparable x) {
        if (isEmpty()) { /* 에러처리 */ }
        else {
            int slot = hash((Integer) x);
            table[slot].removeItem((Integer) x);
            numItems--;
        }
    }

    // 기타
    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++)
            table[i] = new LinkedList<>();
        numItems = 0;
    }
}
