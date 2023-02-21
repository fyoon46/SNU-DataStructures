package book.chap06.prob08;

import source.stack.LinkedStack;

@SuppressWarnings({"rawtypes", "unchecked"})
public class CopyLinkedStackDemo {
    public static void copyLinkedStack(LinkedStack a, LinkedStack b) {
        b.popAll();
        LinkedStack temp = new LinkedStack();
        while (!a.isEmpty()) {
            temp.push(a.pop());
        }
        while (!temp.isEmpty()) {
            a.push(temp.top());
            b.push(temp.pop());
        }
    }

    public static void main(String[] args) {
        System.out.println("Copy Linked Stack Demo!");
        LinkedStack<Integer> stack1 = new LinkedStack<>();
        LinkedStack<Integer> stack2 = new LinkedStack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.print("printAll(): ");
        stack1.printAll();
        stack2.push(10);
        stack2.push(20);
        stack2.push(30);
        stack2.pop();
        stack2.push(40);
        System.out.print("printAll(): ");
        stack2.printAll();
        copyLinkedStack(stack1, stack2);
        stack1.printAll();
        stack2.printAll();
    }
}
