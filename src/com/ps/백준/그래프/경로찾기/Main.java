package com.ps.백준.그래프.경로찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 한창 bfs관련 문제를 풀다가 이 문제를 만났더니 bfs가 떠올랐다.
* 문제에서는 경로만 찾으면 된다고 했지만 인풋이 인접행렬로 주어지니
* dfs로 푸는걸 의도한게 아닐까 싶다.
*
*
* 방향그래프였네?
* */


class Main {

    static boolean board[][];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/그래프/경로찾기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        board = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < n; j++) {
                boolean isVertex = Integer.parseInt(st.nextToken()) == 1;
                board[i][j] = isVertex;
            }
        }

        int depth = 0;
        dfs(depth);
    }

    private static void dfs(int depth) {

        if(depth == board.length){

            return;
        }

        for (int i = 0; i < board.length; i++) {

        }

//        for (boolean b : board[depth]) {
//
//        }

    }

}
