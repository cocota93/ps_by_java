package com.ps.백준.BFS_DFS.벽부수고이동하기;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {

    static int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static void BFS(int[][] board, boolean[][] visitCheck, int[][] distanceBoard) {
        /*
        * 일반적인 bfs가 아니라 벽을 한개까지 부술수 있다.
        * 각 블록까지 가는 비용을 계산을 먼저 해놓고
        * 벽들을 순회하면서 해당 벽이 없어졌을때 절대값(위 - 아래), 절대값(왼쪽 - 오른쪽)
        * 들의 값들을 계산하여 가장 큰 차이가 있는걸 제거하면 되지않을까?
        *
        * 근데 생각해보니 12 - 3시, 3시 - 6시, 6시 - 9시, 9시 - 12시 방향으로 새로운 경로가 생길수도  있는데
        * 이건 어떠카지?
        *
        * 각 칸마다 이동 비용이 1 이기 때문에 먼저도착하면 무조건 더 빠른 경로. 비용이 똑같은경로가 여러개일수는 있음.
        * */

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1));
        visitCheck[1][1] = true;
        distanceBoard[1][1] = 1;


        for(;!queue.isEmpty();){
            Point vertex = queue.poll();
            for (int i = 0; i < dir.length; i++) {
                int dy = vertex.y + dir[i][0];
                int dx = vertex.x + dir[i][1];

                if(visitCheck[dy][dx] == true) continue;
                if(board[dy][dx] != 0) continue;

                visitCheck[dy][dx] = true;
                queue.add(new Point(dx, dy));
                distanceBoard[dy][dx] = distanceBoard[vertex.y][vertex.x] + 1;
            }
        }

        Point selectPoint = null;
        int maxDiff = 0;
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if(board[i][j] != 1) continue;

                if(board[i -1][j] == 0 && board[i + 1][j] == 0){
                    int diff = Math.abs(distanceBoard[i - 1][j] - distanceBoard[i + 1][j]);
                    if(maxDiff < diff){
                        maxDiff = diff;
                        selectPoint = new Point(j, i);
                    }
                }
                if(board[i][j - 1] == 0 && board[i][j + 1] == 0){
                    int diff = Math.abs(distanceBoard[i][j - 1] - distanceBoard[i][j + 1]);
                    if(maxDiff < diff){
                        maxDiff = diff;
                        selectPoint = new Point(j, i);
                    }
                }
            }
        }
        if(selectPoint != null)
            board[selectPoint.y][selectPoint.x] = 0;



        queue.clear();
        queue.add(new Point(1, 1));
        visitCheck = new boolean[visitCheck.length][visitCheck[0].length];
        visitCheck[1][1] = true;
        distanceBoard = new int[distanceBoard.length][distanceBoard[0].length];
        distanceBoard[1][1] = 1;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
//                visitCheck[0][j] = visitCheck[visitCheck.length - 1][j] = true;
                board[0][j] = board[board.length - 1][j] = -1;
            }

            board[i][0] = board[i][board[0].length - 1] = -1;
        }



        for(;!queue.isEmpty();){
            Point vertex = queue.poll();
            for (int i = 0; i < dir.length; i++) {
                int dy = vertex.y + dir[i][0];
                int dx = vertex.x + dir[i][1];

                if(visitCheck[dy][dx] == true) continue;
                if(board[dy][dx] != 0) continue;

                visitCheck[dy][dx] = true;
                queue.add(new Point(dx, dy));
                distanceBoard[dy][dx] = distanceBoard[vertex.y][vertex.x] + 1;
            }
        }


        System.out.println(distanceBoard[distanceBoard.length - 2][distanceBoard[0].length - 2]);
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/BFS_DFS/벽부수고이동하기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int board[][] = new int[height + 2][width + 2];
        boolean visitCheck[][] = new boolean[height + 2][width + 2];
        int distanceBoard[][] = new int[height + 2][width + 2];

        for (int i = 1; i <= height; i++) {
            String line = br.readLine();
            for (int j = 1; j <= width; j++) {
                int block = line.charAt(j - 1) - '0';
                board[i][j] = block;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
//                visitCheck[0][j] = visitCheck[visitCheck.length - 1][j] = true;
                board[0][j] = board[board.length - 1][j] = -1;
            }

            board[i][0] = board[i][board[0].length - 1] = -1;
        }




        BFS(board, visitCheck, distanceBoard);


    }

}
