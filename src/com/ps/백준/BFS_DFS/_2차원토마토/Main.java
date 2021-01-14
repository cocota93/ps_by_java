package com.ps.백준.BFS_DFS._2차원토마토;


import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static void BFS(int[][] board, boolean[][] visitCheck) {
        Queue<Point> firstDayQueue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1){
                    firstDayQueue.offer(new Point(j, i));
                    visitCheck[i][j] = true;
                }
            }
        }


        Queue<Queue<Point>> allQueue = new LinkedList<>();
        allQueue.offer(firstDayQueue);

        int day = 0;
        for(;!allQueue.isEmpty();){
            Queue<Point> dayQueue = allQueue.poll();
            Queue<Point> nextDayQueue = new LinkedList<>();

            for(;!dayQueue.isEmpty();){
                Point point = dayQueue.poll();

                for (int i = 0; i < dir.length; i++) {
                    int dy = point.y + dir[i][0];
                    int dx = point.x + dir[i][1];

                    if(dy < 0 || dy >= board.length) continue;
                    if(dx < 0 || dx >= board[0].length) continue;
                    if(visitCheck[dy][dx] == true) continue;
                    if(board[dy][dx] != 0) continue;

                    nextDayQueue.offer(new Point(dx, dy));
                    visitCheck[dy][dx] = true;
                    board[dy][dx] = 1;
                }
            }

            if(!nextDayQueue.isEmpty()){
                allQueue.offer(nextDayQueue);
                day++;
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 0){
                    day = -1;
                    break;
                }
            }

            if(day == -1) break;
        }

        System.out.println(day);
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/BFS_DFS/_2차원토마토/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int board[][] = new int[height][width];
        boolean visitCheck[][] = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < width; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                System.out.printf("%d ", board[i][j]);
//            }
//            System.out.println("");
//        }

        BFS(board, visitCheck);

    }

}
