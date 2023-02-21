package book.chap06.prob04;

import source.stack.LinkedStack;

public class CheckInSetDemo {
    public static boolean isInSet(String A) {
        if (A.length() % 2 == 1) {
            LinkedStack<Character> s = new LinkedStack<>();
            int i;
            for (i = 0; i < A.length() / 2; i++) {
                s.push(A.charAt(i));
            }
            if (A.charAt(i++) != '$')
                return false;
            for (; i < A.length(); i++) {
                if (s.pop() != A.charAt(i))
                    return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("w$wᴿ Check!");
        String str = "lion$noil";
        boolean t = isInSet(str);
        System.out.println(str + " is w$wᴿ?: " + t);
    }
}
