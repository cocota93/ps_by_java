package com.ps.백준.완전탐색.차이를최대로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 인풋으로 주어진 배열의 순서를 바꿔서 어떤 식에 대입했을때 최대값을 구하는 문제
* n이 8밖에 안되고 배열에 들어있는 정수도 -100 ~ 100이라서 int로 충분할듯.
*
* 음...그냥 다 방문 하는게 아니라 기존 배열의 순서를 적절히 바꿔야 한다는게 어렵네 어카지;;
* */

class Main {

    static int board[];
    static boolean useCheck[];
    static int resultMax = 0;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/차이를최대로/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        board = new int[n];
        for (int i = 0; i < board.length; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }
        useCheck = new boolean[n];

        int depth = 0;
        int sum = 0;
        Recur(depth, sum);

        System.out.println(resultMax);
    }

    private static void Recur(int depth, int prevSum) {
        if(board.length == depth){
            resultMax = Math.max(prevSum, resultMax);
            return;
        }

        for(int i = 0; i < board.length; i++){
            if(useCheck[i] == true) continue;
            useCheck[i] = true;

            for (int j = i + 1; j < board.length; j++) {
                if(useCheck[j] == true) continue;

                useCheck[j] = true;
                Recur(depth + 1, prevSum + Math.abs(board[i] - board[j]));
                Recur(depth + 1, prevSum + Math.abs(board[j] - board[i]));
                useCheck[j] = false;
            }

            useCheck[i] = false;
        }
    }

}
