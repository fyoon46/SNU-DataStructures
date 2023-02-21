package book.chap05.prob03;

public class IntegerArrayListDemo {
    public static void main(String[] args) {
        IntegerArrayList list = new IntegerArrayList();
        System.out.println("Integer Array List Demo!");
        list.add(1, 300);  // 오토 박싱
        list.add(1, 200);
        list.add(1, 100);
        list.printAll();
        list.append(500);
        list.append(600);
        list.remove(4);
        list.printAll();
        list.add(4, 250);
        list.add(2, 50);
        list.add(1, 10);
        list.append(700);
        list.printAll();
        list.remove(2);
        list.removeItem(600);
        list.printAll();
        list.add(4, 250);
        list.printAll();
        System.out.println(list.indexOf(250));
        System.out.println(list.lastIndexOf(250));
    }
} // 코드 5-3
