package book.chap07.prob04;

import source.queue.LinkedQueue;

public class CheckInSetDemo {
    public static boolean isInSet(String A) {
        if (A.length() % 2 == 1) {
            LinkedQueue<Character> s = new LinkedQueue<>();
            int i;
            for (i = 0; i < A.length() / 2; i++) {
                s.enqueue(A.charAt(i));
            }
            if (A.charAt(i++) != '$')
                return false;
            for (; i < A.length(); i++) {
                if (s.dequeue() != A.charAt(i))
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("w$w Check!");
        String str = "lion$lion";
        boolean t = isInSet(str);
        System.out.println(str + " is w$w?: " + t);
    }
}
