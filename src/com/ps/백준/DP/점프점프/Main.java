package com.ps.백준.DP.점프점프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static int INF = 999999;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/점프점프/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] board = new int[n + 1];
        int[] dp = new int[n + 101];
        for (int i = 1; i < board.length; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, INF);
        dp[1] = 0;

        for (int i = 1; i < board.length; i++) {
            if(board[i] == 0) continue;

            int maxJumRange = i + board[i];
            for (int minJumpRange = i + 1; minJumpRange <= maxJumRange; minJumpRange++) {
                dp[minJumpRange] = Math.min(dp[minJumpRange], dp[i] + 1);
            }
        }

        if(dp[n] == INF){
            System.out.println(-1);
        }else{
            System.out.println(dp[n]);
        }
    }

}
