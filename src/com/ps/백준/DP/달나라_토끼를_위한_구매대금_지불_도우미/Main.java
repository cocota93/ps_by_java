package com.ps.백준.DP.달나라_토끼를_위한_구매대금_지불_도우미;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


//dp[금액] = 해당금액을 만드는데 필요한 최소 동전 수

class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/달나라_토끼를_위한_구매대금_지불_도우미/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] board = new int[4];
        board[0] = 1;
        board[1] = 2;
        board[2] = 5;
        board[3] = 7;

        long[] dp = new long[100000 + 7 + 1];
        Arrays.fill(dp, 9999999);
        dp[0] = 0;
//        dp[1] = 1;
//        dp[2] = 1;
//        dp[5] = 1;
//        dp[7] = 1;

        for (int i = 0; i <= n; i++) {
            for (int addCoin : board) {
                dp[(i + addCoin)] = Math.min(dp[(i + addCoin)], dp[i] + 1);
            }
        }

        System.out.println(dp[n]);
    }

}
