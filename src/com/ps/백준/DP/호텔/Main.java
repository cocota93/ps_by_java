package com.ps.백준.DP.호텔;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/호텔/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int c = Integer.parseInt(st.nextToken());//늘려야하는 고객의 수
        int n = Integer.parseInt(st.nextToken());//도시 수

        //dp[고객수] = 최소비용
        int[] dp = new int[2000 + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cost = Integer.parseInt(st.nextToken());
            int customerCount = Integer.parseInt(st.nextToken());

//            dp[customerCount] = cost;
            for (int j = customerCount; j < dp.length; j += customerCount) {
                dp[j] = Math.min(dp[j], dp[j - customerCount] + cost);
            }

        }

        int answer = INF;
        for (int i = c; i < dp.length; i++) {
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);


    }

}
