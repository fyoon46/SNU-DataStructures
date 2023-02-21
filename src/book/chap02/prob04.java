package book.chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob04 {
    public static int count = 0;

    public static void move(int n, int a, int b, int c) {
        count++;
        if (n > 0) {
            move(n - 1, a, c, b);
            System.out.println(a + " " + b);
            move(n - 1, c, b, a);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        move(n, 1, 2, 3);
        System.out.println("count = " + count);
    }
}
