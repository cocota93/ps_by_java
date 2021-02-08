package com.ps.백준.DP._2xN타일링;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/DP/_2xN타일링/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        long dp[] = new long[n + 1];
        dp[0] = 1;//0에 대해서는 그 의미가 애매해지기 떄문에 하고싶지는 않은데 점화식대로
        //// 깔끔하게 풀려면 1로 해줘야해서 어쩔수없이 넣음
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }


        System.out.println(dp[n]);


    }

}
