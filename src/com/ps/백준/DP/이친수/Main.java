package com.ps.백준.DP.이친수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


/*
* dp[자릿수] = 이친수의수
* dp[n] = 시그마(dp[n - i] + dp[i])
* */

class Main {

    static int n;
    static long[] dp;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/이친수/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dp = new long[100];
        dp[0] = 0;
        dp[1] = 1;//1
        dp[2] = 1;//10
        //dp[3] = 2... 100, 101
        //dp[4] = 3... 1001, 1010, 1000
        //dp[5] = 5... 10101, 10100, 10010, 10001, 10000
        //dp[6] = 8... 100000, 100001, 100010, 100100, 100101, 101000, 101010, 101001
        //dp[7] = 13... 1000000, 1000001, 1000010, 1000100, 1000101, 1001000, 1001010, 1001001, 1010000, 1010001, 1010010, 1010100, 1010101
        //

        for (int makeNumbering = 3; makeNumbering <= n; makeNumbering++) {
            dp[makeNumbering] = dp[makeNumbering - 1] + dp[makeNumbering - 2];
        }


//        for (int makeNumbering = 3; makeNumbering < dp.length; makeNumbering++) {
//
//            int count = 0;
//            for (int head = 1; head <= makeNumbering / 2; head++) {
//                int tail = makeNumbering - head;
//                count += dp[head] + dp[tail];
//                count -= 1;//1로 끝나고 1로 시작하는경우가 생길수 있으니까
///*
//* 5 2 ?
//* 8, 5, 3,
//* */
///*
//7
//
//* 16
//* 25
//* 34
//*
//* */
//            }
//
//            dp[makeNumbering] = count;
//        }


        System.out.println(dp[n]);
    }

}
