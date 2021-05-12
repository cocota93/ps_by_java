package com.ps.백준.DP.점화식;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static int n;
    static long[] dp;


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/점화식/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                    dp[i] += dp[j] * dp[i - (1 + j)];
            }
        }

//        for (int i : dp) {
//            System.out.println(i);
//        }

        System.out.println(dp[n]);
    }

}
