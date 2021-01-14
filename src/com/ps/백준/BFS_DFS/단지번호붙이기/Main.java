package com.ps.백준.BFS_DFS.단지번호붙이기;

import sun.security.provider.certpath.Vertex;

import java.util.*;
import java.io.FileInputStream;


class Main {

    static int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static int DFS(int i, int j, int[][] board, boolean[][] visitCheck) {

        if(board[i][j] == 0) return 0;//간선없음
        if(visitCheck[i][j] == true) return 0;//이미방문

        int result = 1;
        visitCheck[i][j] = true;

        for (int k = 0; k < dir.length; k++) {
            int dy = i + dir[k][0];
            int dx = j + dir[k][1];

            result += DFS(dy, dx, board, visitCheck);
        }

        return result;
    }

    static class Vertex {
        public int y;
        public int x;

        public Vertex(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static int BFS(int i, int j, int[][] board, boolean[][] visitCheck) {
        if(board[i][j] == 0) return 0;//간선없음
        if(visitCheck[i][j] == true) return 0;//이미방문


        int result = 0;

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(new Vertex(i,j));
        visitCheck[i][j] = true;
        result++;

        for (;!queue.isEmpty();){
            Vertex vertex = queue.poll();

            for (int k = 0; k < dir.length; k++) {
                int dy = vertex.y + dir[k][0];
                int dx = vertex.x + dir[k][1];

                if(visitCheck[dy][dx] == false && board[dy][dx] == 1){
                    queue.offer(new Vertex(dy,dx));
                    visitCheck[dy][dx] = true;
                    result++;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/BFS_DFS/단지번호붙이기/input.txt"));
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        int board[][] = new int[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            String s = sc.nextLine();
            for (int j = 1; j <= N; j++) {
                board[i][j] = s.charAt(j - 1) - '0';
            }
        }

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.printf("%d ", board[i][j]);
//            }
//            System.out.println("");
//        }



        List<Integer> result = new ArrayList<>();
        boolean visitCheck[][] = new boolean[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int count = DFS(i, j, board, visitCheck);
//                int count = BFS(i, j, board, visitCheck);
                if(count > 0) result.add(count);
            }
        }

        result.sort(Comparator.comparingInt(Integer::intValue));
        System.out.println(result.size());
        result.forEach(System.out::println);
    }

}
