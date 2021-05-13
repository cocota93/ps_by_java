package com.ps.백준.DP.maximum_subarray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/maximum_subarray/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int[] board = new int[n];
            int[] dp = new int[n];
            for (int i = 0; i < board.length; i++) {
                board[i] = Integer.parseInt(st.nextToken());
            }


            dp[0] = board[0];
            for (int i = 1; i < dp.length; i++) {
                dp[i] = Math.max(dp[i - 1] + board[i], board[i]);
            }

            int answer = Arrays.stream(dp).max().getAsInt();
            System.out.println(answer);
        }
    }

}
