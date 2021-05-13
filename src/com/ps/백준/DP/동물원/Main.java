package com.ps.백준.DP.동물원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 한칸만 건너뛰면 똑같은 상황이 반복되므로 그부분을 잘 생각해보면 될듯
* 사자가 한마리도 없는경우도 경우의 수로 치기 때문에 무조건 홀수로 나오게 됨
* dp[0] = 1;
* dp[1] = 3;
* dp[2] = 7;
*
* dp[3] = 1 + 6 + 4 + 2 + 4 = 17;
* dp[3] = 6 + 8 + 2 = 16;
* dp[4] = 41;
*
* 막상 해보니 잘 안되네
*
* https://sundries-in-myidea.tistory.com/78
* 풀었어야 하는문제인데...아쉽
*
* dp[세로n칸][사자의 위치... 0 : 없음, 1 : 왼쪽, 2 : 오른쪽] = 경우의수
* */

class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/동물원/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

//        dp[2][0] = dp[1][0] + dp[1][1] + dp[1][2];
//        dp[2][1] = dp[1][0] + dp[1][2];
//        dp[2][2] = dp[1][0] + dp[1][1];

        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }

        int answer = 0;
        for (int i = 0; i < dp[0].length; i++) {
            answer = (answer + dp[n][i]) % 9901;
        }

        System.out.println(answer);
    }

}
