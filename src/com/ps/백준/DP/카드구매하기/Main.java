package com.ps.백준.DP.카드구매하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


/*
* 카드 n개를 가장 가성비 구리게 구매할떄의 가격
* 여러종류의 팩 섞어서 살수있음.
* 구매한 팩안에 들어있는 카드의 수가 n개를 초과하는건 안됨.
*
* */

class Main {



    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/카드구매하기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int packMetaInfo[] = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < packMetaInfo.length; i++) {
            packMetaInfo[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[n + 1];
        dp[0] = packMetaInfo[0];
        dp[1] = packMetaInfo[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = packMetaInfo[i];

            for (int j = 0; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
            }

        }

        System.out.println(dp[n]);

    }

}
