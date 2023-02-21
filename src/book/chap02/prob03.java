package book.chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob03 {
    public static int count = 0;

    public static int fib(int n) {
        count++;
        if (n == 1 || n == 2) return 1;
        else return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println("fib(" + n + ") = " + fib(n));
        System.out.println("count = " + count);
    }
}
