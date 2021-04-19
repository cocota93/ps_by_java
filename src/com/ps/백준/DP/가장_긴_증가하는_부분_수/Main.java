package com.ps.백준.DP.가장_긴_증가하는_부분_수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static int n;
    static int board[];
    static int countingBoard[];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/가장_긴_증가하는_부분_수/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //

        n = Integer.parseInt(br.readLine());
        board = new int[n];
        countingBoard = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        for (int checkIndex = 0; checkIndex < board.length; checkIndex++) {
            counting(checkIndex);
        }


//        for (int i = 0; i < countingBoard.length; i++) {
//            System.out.println(countingBoard[i]);
//        }

        int answer = Arrays.stream(countingBoard).max().getAsInt();
        System.out.println(answer);
    }

    private static void counting(int checkIndex) {

        countingBoard[checkIndex] = 1;
        for (int i = checkIndex - 1; i >= 0; i--) {
            if(board[checkIndex] > board[i]){
                if(countingBoard[checkIndex] < countingBoard[i] + 1){
                    countingBoard[checkIndex] = countingBoard[i] + 1;
                }
            }
        }

    }

}
