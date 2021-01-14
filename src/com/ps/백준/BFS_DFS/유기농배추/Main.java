package com.ps.백준.BFS_DFS.유기농배추;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
import java.io.FileInputStream;


class Main {

    static int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static int DFS(int y, int x, int[][] board, boolean[][] visitCheck) {

        if(board[y][x] == 0) return 0;
        if(visitCheck[y][x] == true) return 0;

        int result = 1;
        visitCheck[y][x] = true;

        for (int i = 0; i < dir.length; i++) {
            int dy = y + dir[i][0];
            int dx = x + dir[i][1];

            if(dy < 0 || dy >= board.length) continue;
            if(dx < 0 || dx >= board[0].length) continue;
            if(visitCheck[dy][dx] == true) continue;
            if(board[dy][dx] == 0) continue;

            BFS(dy, dx, board, visitCheck);
        }

        return result;
    }

    static class Vertex {
        int y;
        int x;

        public Vertex(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int BFS(int y, int x, int[][] board, boolean[][] visitCheck) {
        if(board[y][x] == 0) return 0;
        if(visitCheck[y][x] == true) return 0;



        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(new Vertex(y,x));
        visitCheck[y][x] = true;

        for (;!queue.isEmpty();){
            Vertex vertex = queue.poll();


            for (int i = 0; i < dir.length; i++) {

                int dy = vertex.y + dir[i][0];
                int dx = vertex.x + dir[i][1];

                if(dy < 0 || dy >= board.length) continue;
                if(dx < 0 || dx >= board[0].length) continue;
                if(visitCheck[dy][dx] == true)  continue;
                if(board[dy][dx] == 0) continue;

                queue.offer(new Vertex(dy,dx));
                visitCheck[dy][dx] = true;
            }
        }

        return 1;
    }

        public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/BFS_DFS/유기농배추/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int m = Integer.parseInt(st.nextToken());//가로
            int n = Integer.parseInt(st.nextToken());//세로
            int k = Integer.parseInt(st.nextToken());//배추가 심어진 위치의 수..배추의 수 말하는듯

            int board[][] = new int[n][m];
            boolean visitCheck[][] = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                board[y][x] = 1;
            }

            int result = 0;
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    result += DFS(y, x, board, visitCheck);
//                    result += BFS(y, x, board, visitCheck);
                }
            }

            System.out.println(result);
        }


    }

}
