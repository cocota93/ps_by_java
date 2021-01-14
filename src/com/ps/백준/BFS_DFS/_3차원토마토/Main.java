package com.ps.백준.BFS_DFS._3차원토마토;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static int dir[][] = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1},  {0, 0, 1}};

    static class Vertex{
        int y;
        int z;
        int x;

        public Vertex(int y, int z, int x) {
            this.y = y;
            this.z = z;
            this.x = x;
        }
    }

    private static void BFS(int[][][] board, boolean[][][] visitCheck) {
        Queue<Vertex> firstDayQueue = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (int k = 0; k < board[0][0].length; k++) {
                    if(board[i][j][k] == 1){
                        firstDayQueue.offer(new Vertex(i, j, k));
                        visitCheck[i][j][k] = true;
                    }
                }
            }
        }

        Queue<Queue<Vertex>> allDayQueue = new LinkedList<>();
        allDayQueue.offer(firstDayQueue);
        int day = 0;
        for (;!allDayQueue.isEmpty();){
            Queue<Vertex> perDayQueue = allDayQueue.poll();
            Queue<Vertex> nextDayQueue = new LinkedList<>();

            for (;!perDayQueue.isEmpty();){
                Vertex poll = perDayQueue.poll();

                for (int i = 0; i < dir.length; i++) {
                    int dy = poll.y + dir[i][0];
                    int dz = poll.z + dir[i][1];
                    int dx = poll.x + dir[i][2];

                    if(dy < 0 || dy >= board.length ) continue;
                    if(dz < 0 || dz >= board[0].length ) continue;
                    if(dx < 0 || dx >= board[0][0].length ) continue;
                    if(visitCheck[dy][dz][dx] == true) continue;
                    if(board[dy][dz][dx] == -1) continue;
                    if(board[dy][dz][dx] == 1) continue;

                    nextDayQueue.offer(new Vertex(dy, dz, dx));
                    visitCheck[dy][dz][dx] = true;
                    board[dy][dz][dx] = 1;
                }
            }

            if(!nextDayQueue.isEmpty()){
                allDayQueue.offer(nextDayQueue);
                day++;
            }
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (int k = 0; k < board[0][0].length; k++) {
                    if(board[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }


        System.out.println(day);
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/BFS_DFS/_3차원토마토/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int horizonLength = Integer.parseInt(st.nextToken());
        int depthLength = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int board[][][] = new int[height][depthLength][horizonLength];
        boolean visitCheck[][][] = new boolean[height][depthLength][horizonLength];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < depthLength; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < horizonLength; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

//
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < verticalLength; j++) {
//                for (int k = 0; k < horizonLength; k++) {
//                    System.out.printf("%d ", board[i][j][k]);
//                }
//                System.out.println("");
//            }
//        }


        BFS(board, visitCheck);

    }

}
