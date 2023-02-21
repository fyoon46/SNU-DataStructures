package book.chap06.prob09;

public class ArrayStackDemo {
    public static void main(String[] args) {
        System.out.println("Array Stack Demo!");
        ArrayStack<Integer> stack1 = new ArrayStack<>(3);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.print("printAll() (#capacity=" + stack1.getCapacity() + ") ");
        stack1.printAll();
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);
        System.out.print("printAll() (#capacity=" + stack1.getCapacity() + ") ");
        stack1.printAll();
        stack1.push(7);
        stack1.push(8);
        stack1.push(9);
        System.out.print("printAll() (#capacity=" + stack1.getCapacity() + ") ");
        stack1.printAll();
    }
} // 코드 6-3
