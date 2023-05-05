package book.chap05.prob03;

import source.list.IntegerListInterface;

@SuppressWarnings({"StatementWithEmptyBody", "unused"})
public class IntegerArrayList implements IntegerListInterface {
    private Integer[] item;
    private int numItems;
    private static final int DEFAULT_CAPACITY = 64;

    public IntegerArrayList() {     // 생성자 1
        item = new Integer[DEFAULT_CAPACITY];
        numItems = 0;
    }

    public IntegerArrayList(int n) {    // 생성자 2
        item = new Integer[n];
        numItems = 0;
    }

    // [연습문제 5-3][알고리즘 5-1] 구현: 배열 리스트의 k번째 자리에 원소 x 삽입하기
    @Override
    public void add(int index, Integer x) {
        if (numItems >= item.length || index < 1 || index > numItems + 1) {
            /* 에러 처리 */
        } else {
            for (int i = numItems - 1; i >= index - 1; i--)
                item[i + 1] = item[i];    // 우시프트
            item[index - 1] = x;
            numItems++;
        }
    }

    // [알고리즘 5-2] 구현: 배열 리스트의 맨 뒤에 원소 추가하기
    @Override
    public void append(Integer x) {
        if (numItems >= item.length) {
            /* 에러 처리 */
        } else {
            item[numItems++] = x;
        }
    }

    // [연습문제 5-3][알고리즘 5-3] 구현: 배열 리스트의 k번째 원소 삭제하기
    @Override
    public Integer remove(int index) {
        if (isEmpty() || index < 1 || index > numItems)
            return null;
        else {
            Integer tmp = item[index - 1];
            for (int i = index - 1; i <= numItems - 2; i++)
                item[i] = item[i + 1];    // 좌시프트
            numItems--;
            return tmp;
        }
    }

    // [알고리즘 5-4] 구현: 배열 리스트에서 원소 x 삭제하기
    @Override
    public boolean removeItem(Integer x) {
        int k = 0;
        while (k < numItems && item[k].compareTo(x) != 0)
            k++;
        if (k == numItems)
            return false;
        else {
            for (int i = k; i <= numItems - 2; i++)
                item[i] = item[i + 1];    // 좌시프트
            numItems--;
            return true;
        }
    }

    // [연습문제 5-3][알고리즘 5-5] 구현: 배열 리스트의 i번째 원소 알려주기
    @Override
    public Integer get(int index) {    // 첫 번째 원소를 0번째 원소로 표기
        if (index >= 1 && index <= numItems)
            return item[index - 1];
        else
            return null;
    }

    // [연습문제 5-3][알고리즘 5-6] 구현: 배열 리스트의 i번째 원소를 x로 대체하기
    @Override
    public void set(int index, Integer x) {
        if (index >= 1 && index <= numItems)
            item[index - 1] = x;
        else { /* 에러 처리 */ }
    }

    // [연습문제 5-3][알고리즘 5-7] 구현: 원소 x가 배열 리스트의 몇 번째 원소인지 알려주기
    public static final int NOT_FOUND = -12345;

    @Override
    public int indexOf(Integer x) {
        for (int i = 0; i < numItems; i++) {
            if (item[i].compareTo(x) == 0)
                return i + 1;
        }
        return NOT_FOUND; // not exist
    }

    // [연습문제 5-3][연습문제 5-11] 구현: x값을 갖는 맨 마지막 원소가 배열 리스트의 몇 번째 원소인지 알려주기
    public int lastIndexOf(Integer x) {
        for (int i = numItems - 1; i >= 0; i--) {
            if ((item[i]).compareTo(x) == 0)
                return i + 1;
        }
        return NOT_FOUND; // not exist
    }

    // [알고리즘 5-8(2)] 구현: 배열 리스트가 비었는지 알려주기
    @Override
    public int len() {
        return numItems;
    }

    // [알고리즘 5-8(2)] 구현: 배열 리스트가 비었는지 알려주기
    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    // [알고리즘 5-8(3)] 구현: 배열 리스트 깨끗이 청소하기
    @Override
    public void clear() {
        item = new Integer[item.length];
        numItems = 0;
    }

    ///////////////////////////////////////////////////////////////////////
    @Override
    public void printAll() {
        System.out.print("Print source.list (#items=" + numItems + ") ");
        for (int i = 0; i < numItems; i++)
            System.out.print(item[i] + " ");
        System.out.println();
    }
} // 코드 5-2
