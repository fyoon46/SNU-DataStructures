package source.queue;

import source.stack.LinkedStack;

@SuppressWarnings("StatementWithEmptyBody")
public class Palindrome {
    public static boolean isPalindrome(String A) {
        LinkedStack<Character> s = new LinkedStack<>();
        LinkedQueue<Character> q = new LinkedQueue<>();
        for (int i = 0; i < A.length(); i++) {
            s.push(A.charAt(i));   // 문자열 A의 i번째 문자
            q.enqueue(A.charAt(i));
        }
        while (!s.isEmpty() && s.pop() == q.dequeue()) {
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Palindrome Check!");
        String str = "lioninoil";   // 테스트 문자열
        boolean t = isPalindrome(str);
        System.out.println(str + " is Palindrome?: " + t);
    }
} // 코드 7-9
