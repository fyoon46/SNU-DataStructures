package source.stack;

public class ReverseString {
    private static String reverse(String s) {
        ArrayStack<Character> st = new ArrayStack<>(s.length());
        for (int i = 0; i < s.length(); i++)
            st.push(s.charAt(i));
        StringBuilder output = new StringBuilder();
        while (!st.isEmpty())
            output.append(st.pop());
        return output.toString();
    }

    public static void main(String[] args) {
        String input = "Test Seq 1234";    // 테스트 입력 문자열
        String t = reverse(input);
        System.out.println("Input string: " + input);
        System.out.println("Reversed string: " + t);
    }
}
