package com.ps.백준.DP.포도주시식;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/포도주시식/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] juice = new int[n];

        //dp[마실지 결정된수] = 최대양
        int[] dp = new int[n];
        for (int i = 0; i < juice.length; i++) {
            juice[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = juice[0];

        if(n >= 2){
            dp[1] = dp[0] + juice[1];
        }

        if(n >= 3){
            dp[2] = Math.max(dp[1], Math.max(juice[0] + juice[2], juice[1] + juice[2]));
        }

        for (int i = 3; i < dp.length; i++) {
                            //안마시는경우,       연속해서 마시는경우,             그 전에 한번 쉬고 마시는경우
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + juice[i - 1] + juice[i], dp[i - 2] + juice[i]));
//            dp[i] = Math.max(dp[i - 2] + juice[i], dp[i - 1] + juice[i]);
        }

//        for (int i : dp) {
//            System.out.println(i);
//        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

    }

}
