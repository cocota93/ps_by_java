package com.ps.백준.DP.연속부분최대곱;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* 분류는 dp던데 이건 투포인터 문제 아닌가?
*
* dp[연속으로 곱한 개수] = 최대값
* */

class Main {

    static int n;
    static double[] board;
    static double[] dp;

//    public static void main(String[] args) throws Exception {
////        System.setIn(new FileInputStream("src/com/ps/백준/DP/연속부분최대곱/input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;
//
//        n = Integer.parseInt(br.readLine());
//        board = new double[n + 1];
//        dp = new double[n + 1];
//        for (int i = 1; i < board.length; i++) {
//            board[i] = Double.parseDouble(br.readLine());
//        }
//
//        for (int i = 1; i < board.length; i++) {
//            dp[i] = Math.max(board[i], dp[i - 1] * board[i]);
//        }
//
//        double maxAnswer = Arrays.stream(dp).max().getAsDouble();
////        System.out.println(Math.round(maxAnswer * 1000) / 1000.0);
//
//        System.out.printf("%.3f", maxAnswer);
//    }


    //왜 오답처리 뜨는지 잘 모르겠네
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/연속부분최대곱/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        board = new double[n + 1];
        dp = new double[n + 1];
        for (int i = 1; i < board.length; i++) {
            board[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 1; i < board.length; i++) {
            dp[1] = Math.max(dp[1], board[i]);
        }

        for (int startIdx = 1; startIdx < board.length; startIdx++) {

            double calSequenceResult = board[startIdx];
            for (int sequenceIdx = startIdx + 1; sequenceIdx < board.length; sequenceIdx++) {
                int sequenceCount = sequenceIdx - startIdx + 1;
                calSequenceResult *= board[sequenceIdx];

                dp[sequenceCount] = Math.max(dp[sequenceCount], calSequenceResult);
            }
        }

        double maxAnswer = Arrays.stream(dp).max().getAsDouble();
//        System.out.println(Math.round(maxAnswer * 1000) / 1000.0);
        System.out.printf("%.3f", maxAnswer);

//        for (double v : dp) {
//            System.out.println(v);
//        }
    }

}
