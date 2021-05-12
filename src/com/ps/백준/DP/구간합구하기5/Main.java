package com.ps.백준.DP.구간합구하기5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* https://algorithm-master.tistory.com/14
* */

class Main {
    static int n;
    static int m;

    static int board[][];
    static int dp[][];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/구간합구하기5/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n + 1][n + 1];
        dp = new int[n + 1][n + 1];
        for (int y = 1; y < board.length; y++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int x = 1; x < board[0].length; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = board[1][1];
        for (int y = 1; y < board.length; y++) {
            for (int x = 1; x < board[0].length; x++) {
                dp[x][y] = dp[x - 1][y] + dp[x][y - 1] - dp[x - 1][y - 1]/*중복되는 구간 한번 빼주기*/ + board[x][y];
            }
        }

//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());


            int answer = getArea(x1, y1, x2, y2);

            System.out.println(answer);
        }



    }

    /*
    * 1 8 27 64 ... n^3
    *
    * */

    private static int getArea(int x1, int y1, int x2, int y2) {

        int area = dp[x2][y2];
        area -= dp[x1 - 1][y2] + dp[x2][y1 - 1] - dp[x1 - 1][y1 - 1];

        return area;
    }

}
