package com.ps.백준.완전탐색.나도재귀완탐풀줄아는데;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {
    static Integer[] board;
    static int limitDepth;

    static int maxLength;
    static Integer[] answerBoard;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/나도재귀완탐풀줄아는데/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String s = br.readLine();
        String[] split = s.split("");
        board = new Integer[split.length];
        answerBoard = new Integer[split.length];

        for (int i = 0; i < board.length; i++) {
            board[i] = Integer.parseInt(split[i]);
            answerBoard[i] = board[i];
        }
        limitDepth = Integer.parseInt(br.readLine());

        int depth = 0;
        recur(depth);


        System.out.println("answer : ");
        System.out.println(maxLength + " " + Arrays.toString(answerBoard));
    }

    private static void recur(int depth) {
        if(depth == limitDepth){
            int patternLength = checkPatternLength(board);
            if(maxLength < patternLength){
                maxLength = patternLength;
                answerBoard = Arrays.copyOf(board, board.length);
            }
            System.out.println(patternLength + " " + Arrays.toString(board));
            return;
        }

        for (int i = depth; i < board.length; i++) {
            recur(depth + 1);
            doInversion(board, i);
            recur(depth + 1);
            doInversion(board, i);
        }
    }

    private static int checkPatternLength(Integer[] board) {
        int maxLength = 0;

        int count = 0;
        for (int i = 1; i < board.length; ) {
            if(board[i - 1] == 0 && board[i] == 1){
                count += 2;
                i += 2;
            }else {
                maxLength = Math.max(maxLength, count);
                count = 0;
                i += 1;
            }
        }

        maxLength = Math.max(maxLength, count);
        return maxLength;
    }

    private static void doInversion(Integer[] board, int index) {
        if(board[index] == 1) board[index] = 0;
        else if(board[index] == 0) board[index] = 1;
    }

}
