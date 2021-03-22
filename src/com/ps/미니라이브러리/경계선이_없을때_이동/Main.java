package com.ps.미니라이브러리.경계선이_없을때_이동;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/미니라이브러리/경계선이_없을때_이동/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;



        int n = Integer.parseInt(br.readLine());
        int board[][] = new int[n][n];

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int x = 0; x < n; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int dir = 0; dir < 4; dir++) {
            tilt(board, dir);

            boardPrint(board);
        }

    }

    private static void boardPrint(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("--------------------");
    }

    private static void tilt(int[][] instantBoard, int dir) {
        if(dir == 0){
            for (int y = 0; y < instantBoard.length; y++) {
                for (int x = 0; x < instantBoard[0].length; x++) {
                    if(instantBoard[y][x] == 0) continue;

                    move(instantBoard, dir, y, x);
                }
            }
        }else if(dir == 1){
            for (int y = 0; y < instantBoard.length; y++) {
                for (int x = instantBoard[0].length - 1; x >= 0; x--) {
                    if(instantBoard[y][x] == 0) continue;

                    move(instantBoard, dir, y, x);
                }
            }
        }else if(dir == 2){
            for (int y = instantBoard.length - 1; y >= 0; y--) {
                for (int x = 0; x < instantBoard[0].length; x++) {
                    if(instantBoard[y][x] == 0) continue;

                    move(instantBoard, dir, y, x);
                }
            }
        }else if(dir == 3){
            for (int y = 0; y < instantBoard.length; y++) {
                for (int x = 0; x < instantBoard[0].length; x++) {
                    if(instantBoard[y][x] == 0) continue;

                    move(instantBoard, dir, y, x);
                }
            }
        }
    }

    private static void move(int[][] board, int dir, int y, int x) {
        int nextY = y + dy[dir];
        int prevY = y;
        int nextX = x + dx[dir];
        int prevX = x;
        for (; 0 <= nextY && nextY < board.length && 0 <= nextX && nextX < board[0].length;
            nextY += dy[dir], prevY += dy[dir], nextX += dx[dir], prevX += dx[dir] ) {

//            if(board[nextY][nextX] == 3){
//                break;
//            }

            if(board[nextY][nextX] != 0){//다른거랑 겹치지 않도록 하는 조건
                break;
            }

            board[nextY][nextX] = board[prevY][prevX];
            board[prevY][prevX] = 0;
        }
    }


}
