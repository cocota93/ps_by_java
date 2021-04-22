package com.ps.백준.DP.가장_큰_증가_부분_수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 이전에 풀었던 문제랑 비슷. 이번엔 더 정방향으로만 진행해서 더 쉽게 풀어봐야겠다.
* */

class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/가장_큰_증가_부분_수열/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int board[] = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[n];
//        dp[0] = board[0];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = board[i];
        }

        for (int basisIdx = 0; basisIdx < board.length; basisIdx++) {
            int basisNumber = board[basisIdx];

            for (int compareIdx = 0; compareIdx < basisIdx; compareIdx++) {
                int compareNumber = board[compareIdx];

                if(basisNumber > compareNumber){
                    dp[basisIdx] = Math.max(dp[basisIdx], dp[compareIdx] + basisNumber);
                }
            }
        }


        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

}
