package com.ps.백준.DP.퇴사2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    //dp[상담시작날짜][상담끝날짜] = 누적 수익
    //아니다 상담 끝날짜만 관리하면 됨. 상담끝난날에 누적수익이 더 많기만 하면 되니까


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/퇴사2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] timeBoard = new int[n + 1];
        int[] payBoard = new int[n + 1];
        int[] dp = new int[n + 1 + 1];//마지막날 일할경우 다음날 돈들어와서 + 1 해줘야됨

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int needDay = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            timeBoard[i] = needDay;
            payBoard[i] = cost;
        }

        for (int curDay = 1; curDay < timeBoard.length; curDay++) {
            int endDay = curDay + timeBoard[curDay];
            int pay = payBoard[curDay];

            //그 전날 상담 안하고 넘긴경우
            dp[curDay] = Math.max(dp[curDay], dp[curDay - 1]);

            if(endDay < dp.length){
                dp[endDay] = Math.max(dp[endDay], dp[curDay] + pay);
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

}
