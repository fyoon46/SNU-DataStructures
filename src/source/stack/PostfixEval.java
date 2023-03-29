package source.stack;

public class PostfixEval {
    private static int evaluate(String postfix) {
        int A, B;
        LinkedStack<Integer> s = new LinkedStack<>();
        boolean digitPreviously = false;
        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);    // postfix의 i번 문자. 번호는 0번부터.
            if (Character.isDigit(ch)) {    // ch가 숫자
                if (digitPreviously) {
                    int tmp = s.pop();
                    tmp = 10 * tmp + (ch - '0');
                    s.push(tmp);
                } else s.push(ch - '0');
                digitPreviously = true;
            } else if (isOperator(ch)) {    // ch가 연산자
                A = s.pop();
                B = s.pop();
                int val = operation(A, B, ch);
                s.push(val);
                digitPreviously = false;
            } else digitPreviously = false; // ch가 공백
        }
        return s.pop();
    }

    private static int operation(int a, int b, char ch) {   // 연산하기
        return switch (ch) {
            case '*' -> b * a;
            case '/' -> b / a;
            case '+' -> b + a;
            case '-' -> b - a;
            default -> 0;
        };
    }

    private static boolean isOperator(char ch) {    // 연산자인가?
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static void main(String[] args) {
        String postfix = "700 3 47 + 6 * - 4 /";    // 테스트 샘플 입력(후위 표현식)
        System.out.println("Input string: " + postfix);
        int answer = evaluate(postfix);
        System.out.println("Answer: " + answer);
    }
}
