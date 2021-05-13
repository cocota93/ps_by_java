package com.ps.백준.DP.이동하기;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 이게 왜 dp??
* 일단 지금 잠깐 봤을떄는 bfs이용한 완탐정도 인것같은데?

  해보니까 메모리초과됨.
* */

class Main {

    static int n;
    static int m;
    static int[][] board;
    static int[][] dp;

    //3시 5시 6시
    static int dy[] = {0, 1, 1};
    static int dx[] = {1, 1, 0};

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/이동하기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
//        dp = new int[n][m];
        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());


            }
        }

        for (int x = 1; x < board[0].length; x++) {
            board[0][x] = board[0][x - 1] + board[0][x];
        }

        for (int y = 1; y < board.length; y++) {
            board[y][0] = board[y - 1][0] + board[y][0];
        }

        for (int y = 1; y < board.length; y++) {
            for (int x = 1; x < board[0].length; x++) {
                int[] temp = new int[3];
                temp[0] = board[y - 1][x] + board[y][x];
                temp[1] = board[y][x - 1] + board[y][x];
                temp[2] = board[y - 1][x - 1] + board[y][x];

                board[y][x] = Math.max(temp[2], Math.max(temp[0], temp[1]));
            }
        }

        System.out.println(board[n - 1][m - 1]);


//        int startY = 0;
//        int startX = 0;
//        bfs(startY, startX);
//        System.out.println(dp[n - 1][m - 1]);
    }

    private static void bfs(int startY, int startX) {

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));
        dp[0][0] = board[0][0];

        while(!queue.isEmpty()){
            Point visitPlace = queue.poll();

            for (int dir = 0; dir < 3; dir++) {
                int nextY = dy[dir] + visitPlace.y;
                int nextX = dx[dir] + visitPlace.x;

                if(nextY >= board.length) continue;
                if(nextX >= board[0].length) continue;

                dp[nextY][nextX] = Math.max(dp[nextY][nextX], dp[visitPlace.y][visitPlace.x] + board[nextY][nextX]);
                queue.add(new Point(nextX, nextY));
            }
        }


//        for (int i = 0; i < dp.length; i++) {
//            for (int j = 0; j < dp[0].length; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

    }

}
