package com.ps.백준.DP.조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/조합/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //nCm

        BigInteger[][] dp = new BigInteger[n + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = new BigInteger("0");
            }
        }
        dp[0][0] = BigInteger.valueOf(0);
        dp[1][1] = BigInteger.valueOf(1);
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = BigInteger.valueOf(i);
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 2; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
//                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[n][m]);
    }

}

