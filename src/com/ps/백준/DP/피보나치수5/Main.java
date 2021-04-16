package com.ps.백준.DP.피보나치수5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {



    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/피보나치수5/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");

        int n  = Integer.parseInt(br.readLine());

        int[] board = new int[20 + 1];
        board[0] = 0;
        board[1] = 1;
        for (int i = 2; i < board.length; i++) {
            board[i] = board[i - 1] + board[i - 2];
        }

        System.out.println(board[n]);

    }

}
