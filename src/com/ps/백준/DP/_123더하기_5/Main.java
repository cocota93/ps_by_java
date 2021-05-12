package com.ps.백준.DP._123더하기_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 문제를 보고서 떠오른건 재귀를 활용한 완탐인데
* 이건 dp문제임. 여기서 어떻게 dp를 떠올려야하지?
* */

/*
* https://suhyeokeee.tistory.com/25
* 마지막 자릿수가 뭔지를 가정하고 경우의수를 계산하네
* */


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/_123더하기_5/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //dp[자릿수][마지막 자리 번호] = 카운트
        long dp[][] = new long[100001][4];
//            dp[0] = ??
        dp[1][1] = 1; //확정
        dp[2][2] = 1; // 2 확정

        dp[3][1] = 1; // 2 + 1
        dp[3][2] = 1; // 1 + 2
        dp[3][3] = 1; // 3

        for (int i = 4; i < dp.length; i++) {
            //마지막 자릿수가 뭔지에 따라 그만큼 앞에가서 마지막자릿수 다른 경우들 들고와서 합산
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % 1000000009;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3])  % 1000000009;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2])  % 1000000009;
        }



        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T ; t++) {
            int n = Integer.parseInt(br.readLine());

            long answer = 0;
            for (int i = 1; i <= 3; i++) {
                answer = (answer + dp[n][i]) % 1000000009;
            }
            System.out.println(answer);
        }

    }

}
