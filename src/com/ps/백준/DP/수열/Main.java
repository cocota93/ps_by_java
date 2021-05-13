package com.ps.백준.DP.수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static int n;
    static int board[];
    static int incDP[];
    static int decDP[];


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/수열/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        board = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < board.length; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        incDP = new int[n];
        decDP = new int[n];
        incDP[0] = 1;
        decDP[0] = 1;

        for (int i = 1; i < board.length; i++) {
            if(board[i - 1] < board[i]){
                //증가할경우
                incDP[i] = incDP[i - 1] + 1;
                decDP[i] = 1;
            }else if(board[i - 1] > board[i]){
                //감소할경우
                decDP[i] = decDP[i - 1] + 1;
                incDP[i] = 1;
            }else {
                //같으면
                decDP[i] = decDP[i - 1] + 1;
                incDP[i] = incDP[i - 1] + 1;
            }
        }


        int answer = Math.max(Arrays.stream(incDP).max().getAsInt(), Arrays.stream(decDP).max().getAsInt());
        System.out.println(answer);
    }

}
