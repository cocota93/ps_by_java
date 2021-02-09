package com.ps.백준.DP.카드구매하2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/카드구매하2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        long packMetaInfo[] = new long[n + 1];
        packMetaInfo[0] = 0;
        for (int i = 1; i < packMetaInfo.length; i++) {
            packMetaInfo[i] = Long.parseLong(st.nextToken());
        }

        long dp[] = new long[n + 1];
        dp[0] = packMetaInfo[0];
        dp[1] = packMetaInfo[1];
        for (int i = 2; i < packMetaInfo.length; i++) {
            dp[i] = packMetaInfo[i];

            for (int j = 0; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
            }
        }

        System.out.println(dp[n]);
    }

}
