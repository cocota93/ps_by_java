package com.ps.백준.DP.스티커;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 문제도 어렵고 해설 이해도 어려웠음
* */

class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/스티커/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < t; testCase++) {
            int n = Integer.parseInt(br.readLine());
            //board[위뽑 0, 아래뽑 1][몇번째 열인지]
            int board[][] = new int[2][n];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //dp[뽑았는지 안뽑 0, 위뽑1, 아래뽑2][몇번쨰 열인지] = 스티커의 합;
            //뒤쪽이 몇번쨰열인지로 한이유는 board랑 형태 비슷하게 하기 위해서
            int dp[][] = new int[3][n];
            dp[0][0] = 0;
            dp[1][0] = board[0][0];
            dp[2][0] = board[1][0];
            for (int col = 1; col < dp[0].length; col++) {
                dp[0][col] = Math.max(dp[0][col - 1], Math.max(dp[1][col - 1], dp[2][col - 1]));
                dp[1][col] = Math.max(dp[0][col - 1] + board[0][col], dp[2][col - 1] + board[0][col]);
                dp[2][col] = Math.max(dp[0][col - 1] + board[1][col], dp[1][col - 1] + board[1][col]);
            }


            System.out.println(Math.max(dp[0][dp[0].length -1], Math.max(dp[1][dp[0].length -1], dp[2][dp[0].length -1])));
        }


    }

}
