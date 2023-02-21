package book.chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class prob02 {
    public static int count = 0;

    public static int seq(int n) {
        count++;
        if (n == 1) return 1;
        else return seq(n - 1) + 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println("seq(" + n + ") = " + seq(n));
        System.out.println("count = " + count);
    }
}
