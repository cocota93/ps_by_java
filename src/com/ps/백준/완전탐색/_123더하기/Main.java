package com.ps.백준.완전탐색._123더하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 이전에 풀었던 문제랑 비슷한거 같다.
*
* */

class Main {
    static int resultCount;
    static int board[];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/_123더하기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        board = new int[3];
        for (int i = 0; i < board.length; i++) {
            board[i] = i + 1;
        }

        for (int i = 0; i < T; i++) {
            resultCount = 0;
            int n = Integer.parseInt(br.readLine());
            Recur(n, 0);
            System.out.println(resultCount);
        }
    }

    private static void Recur(int n, int sum) {
        if(sum > n) return;

        if(sum == n){
            resultCount++;
            return;
        }


        for (int i = 0; i < board.length; i++) {
            Recur(n,sum + board[i]);
        }
    }

}
