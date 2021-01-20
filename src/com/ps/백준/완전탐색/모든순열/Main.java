package com.ps.백준.완전탐색.모든순열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
* ??? 시간초과 뜨네??
*
* */

class Main {
    static int board[];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/모든순열/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        board = new int[n];
        for (int i = 0; i < n; i++) {
            board[i] = i + 1;
        }

        do{
            for (int i = 0; i < board.length; i++) {
//                System.out.printf("%d ", board[i]);
                bw.write(board[i] + " ");
            }
            bw.newLine();
//            System.out.printf("\n");
        }while(NextPermutation());

        bw.flush();
        bw.close();
    }

    private static boolean NextPermutation() {
        //내림차순되면 끝

        int i = board.length - 1;
        while(i > 0 && board[i] <= board[i - 1]) --i;

        if(i <= 0) return false;

        int j = board.length - 1;
        while(board[i - 1] >= board[j]) --j;

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
