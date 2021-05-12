package com.ps.백준.DP.파도반수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 문제에서 주어진
* P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9
* 요부분 보면 규칙보임.
* dp[n] = dp[n - 2][n - 3];
* */

class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/파도반수열/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[101];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 1;
            dp[4] = 2;

            for (int i = 4; i <= n; i++) {
                dp[i] = dp[i - 2] + dp[i - 3];
            }

            System.out.println(dp[n]);
        }

    }

}
