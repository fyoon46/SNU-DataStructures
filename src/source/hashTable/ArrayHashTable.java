package source.hashTable;

import source.BST.IndexInterface;

import java.util.Arrays;

@SuppressWarnings({"FieldMayBeFinal", "rawtypes", "StatementWithEmptyBody"})
public class ArrayHashTable implements IndexInterface<Integer> {
    private Integer[] table;
    int numItems;
    static final Integer DELETED = -12345, NOT_FOUND = -1;

    public ArrayHashTable(int n) {
        table = new Integer[n];
        numItems = 0;
        for (int i = 0; i < n; i++) table[i] = null;
    }

    private int hash(int i, Integer x) {
        return (x + i) % table.length;
    }

    @Override
    public void insert(Comparable x) {
        int slot;
        if (numItems == table.length) { /* 에러 처리 */ }
        else {
            for (int i = 0; i < table.length; i++) {
                slot = hash(i, (Integer) x);
                if (table[slot] == null || table[slot].equals(DELETED)) {
                    table[slot] = (Integer) x;
                    numItems++;
                    break;
                }
            }
        }
    }

    @Override
    public Integer search(Comparable x) {
        int slot;
        for (int i = 0; i < table.length; i++) {
            slot = hash(i, (Integer) x);
            if (table[slot] == null) return NOT_FOUND;  // search failed
            if (table[slot].compareTo((Integer) x) == 0)
                return slot;
        }
        return NOT_FOUND;
    }

    @Override
    public void delete(Comparable x) {
        int slot;
        for (int i = 0; i < table.length; i++) {
            slot = hash(i, (Integer) x);
            if (table[slot] == null) break; // 필요 시 에러 처리
            if (table[slot].compareTo((Integer) x) == 0) {
                table[slot] = DELETED;
                numItems--;
                break;
            }
        }
    }

    public Integer getItem(Integer i) {
        return table[i];
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
        numItems = 0;
    }

    //////////////////////////////////////////////////
    public void printAll() {
        System.out.println("Slots:");
        for (int i = 0; i < table.length; i++) {
            System.out.println("   " + i + ": " + table[i]);
        }
    }
}
