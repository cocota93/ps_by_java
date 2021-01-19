package com.ps.백준.완전탐색.이전순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static int board[];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/이전순열/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");

        board = new int[n];
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        boolean moreExistPrev = PrevPermutation();
        if(!moreExistPrev){
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            System.out.printf("%d ", board[i]);
        }
    }

    private static boolean PrevPermutation() {
        //prevPermutation false조건은 오름차순 정렬. 1234

        int i = board.length - 1;
        while(i > 0 && board[i - 1] <= board[i]) --i;

        if(i <= 0) return false;

        int j = board.length - 1;
        while(board[i - 1] <= board[j]) --j;

        {
            int temp = board[i - 1];
            board[i - 1] = board[j];
            board[j] = temp;
        }

        int k = board.length - 1;
        while(i < k){
            int temp = board[i];
            board[i] = board[k];
            board[k] = temp;

            i++;
            k--;
        }

        return true;
    }

}
