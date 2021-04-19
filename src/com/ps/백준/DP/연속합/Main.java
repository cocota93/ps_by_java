package com.ps.백준.DP.연속합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static int n;
    static int board[];
    static int sumBoard[];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/연속합/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        board = new int[n];
        sumBoard = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < board.length; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        sumBoard[0] = board[0];
        int answer = sumBoard[0];

        for (int i = 1; i < sumBoard.length; i++) {
            sumBoard[i] = Math.max(board[i], sumBoard[i - 1] + board[i]);
            if(answer < sumBoard[i]){
                answer = sumBoard[i];
            }
        }


        System.out.println(answer);
    }

}
