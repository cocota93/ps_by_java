package com.ps.백준.완전탐색.다음순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    //fail
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/다음순열/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int board[] = new int[T];
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(st.nextToken());
            board[i] = num;
        }

        if(CheckSorted(board)){
            System.out.println("-1");
            return;
        }
        int curDepth = 0;
        int curN = 0;
        BruteForce(board, curN, curDepth);

    }

    private static void BruteForce(int[] board, int curN, int curDepth) {
        for (int i = board.length - 1; i >= 1; i++) {
            if(board[i - 1] < board[i]){
                Swap(board, i - 1, i);
                break;
            }
        }

        System.out.println(Arrays.toString(board));
    }

    private static void Swap(int[] board, int i, int j) {
        int temp = board[i];
        board[i] = board[j];
        board[j] = temp;
    }

    private static boolean CheckSorted(int[] board) {
        int prev = board[0];
        for (int i = 1; i < board.length; i++) {
            if(prev < board[i]) return false;
        }

        return true;
    }

}
