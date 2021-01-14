package com.ps.백준.BFS_DFS.미로탐색;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    /*
    * 실패...나중에 다시 해보자
    * */

    static class Vertex{

        Vertex prevVertex;

        int y;
        int x;

        public Vertex(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public Vertex(int y, int x, Vertex prevVertex) {
            this.y = y;
            this.x = x;
            this.prevVertex = prevVertex;
        }
    }

    static int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static int BFS(int y, int x, int[][] board, boolean[][] visitCheck, int[][] visitDistance) {
        if(board[y][x] == 0) return 0;
        if(visitCheck[y][x] == true) return 0;

        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(new Vertex(y, x));
        visitCheck[y][x] = true;
        visitDistance[y][x] = 1;

        for(;!queue.isEmpty();){
            Vertex vertex = queue.poll();

            for (int i = 0; i < dir.length; i++) {
                int dy = vertex.y + dir[i][0];
                int dx = vertex.x + dir[i][1];

                if(board[dy][dx] == 0) continue;
                if(visitCheck[dy][dx] == true) continue;

                queue.offer(new Vertex(dy,dx));
                visitCheck[dy][dx] = true;
                visitDistance[dy][dx] = visitDistance[vertex.y][vertex.x] + 1;
            }
        }

        return visitDistance[visitDistance.length - 2][visitDistance[0].length - 2];
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/BFS_DFS/미로탐색/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int board[][] = new int[n + 2][m + 2];
        boolean visitCheck[][] = new boolean[n + 2][m + 2];
        int visitDistance[][] = new int[n + 2][m + 2];

        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 1; j <= m; j++) {
                board[i][j] =  line.charAt(j - 1) - '0';
            }
        }

//        for (int i = 0; i < n + 2; i++) {
//            for (int j = 0; j < m + 2; j++) {
//                System.out.printf("%d", board[i][j]);
//            }
//            System.out.println("");
//        }

        int distance = BFS(1, 1, board, visitCheck, visitDistance);
        System.out.println(distance);

    }

}
