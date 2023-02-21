package book.chap02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class prob01 {
    public static int seq(int n) {
        if (n == 1) return 0;
        else return 5 * seq(n - 1) + 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println("seq(" + n + ") = " + seq(n));
    }
}
