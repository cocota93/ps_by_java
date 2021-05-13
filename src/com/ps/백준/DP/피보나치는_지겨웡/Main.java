package com.ps.백준.DP.피보나치는_지겨웡;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static int count;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/피보나치는_지겨웡/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[51];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1] + 1;
        }

        System.out.println(dp[n] % 1000000007);
//        fibonacci(4);
//        System.out.println(count);
    }


    static int fibonacci(int n) { // 호출
        count++;
        if (n < 2) {
            return n;
        }
        return fibonacci(n-2) + fibonacci(n-1);
    }
}
