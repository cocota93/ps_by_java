package com.ps.백준.DP.징검다리건너기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {



    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/징검다리건너기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        if(n <= 1){
            System.out.println(0);
            return;
        }

        int[][] jumpCost = new int[n + 1][2];

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int smallJump = Integer.parseInt(st.nextToken());
            int midJump = Integer.parseInt(st.nextToken());
            jumpCost[i][0] = smallJump;
            jumpCost[i][1] = midJump;
        }

        int superJump = Integer.parseInt(br.readLine());
        //[도착한 돌의 번호][슈점 사용시] = 사용한 에너지
        int[][] dp = new int[n + 1][2];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = 999999;
            }
        }

//        dp[2][0] = Math.min(dp[2 - 1][0] + jumpCost[2 - 1][0], dp[2 - 2][0] + jumpCost[2 - 1][1]);
        dp[1][0] = 0;
        dp[2][0] = jumpCost[1][0];
//        dp[2][1] = Math.min(jumpCost[1][0], superJump);

        for (int i = 3; i < dp.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + jumpCost[i - 1][0], dp[i - 2][0] + jumpCost[i - 2][1]);
            if(i >= 4){
                dp[i][1] = Math.min(dp[i - 3][0] + superJump/*슈점을 이번에 처음쓴다는 가정*/, Math.min(dp[i - 1][1] + jumpCost[i - 1][0], dp[i - 2][1] + jumpCost[i - 2][1])/*기존에 슈점을 썼다는 가정*/);
            }
        }

//        for (int i = 0; i < dp[0].length; i++) {
//            for (int j = 0; j < dp.length; j++) {
//                System.out.print(dp[j][i] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("----------------");

        System.out.println(Math.min(dp[n][0], dp[n][1]));
    }

}
