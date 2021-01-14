package com.ps.백준.BFS_DFS.나이트의이동;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {

    static int dir[][] = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

    private static void BFS(Point startPos, Point destPos, int[][] board, int[][] visitDistance) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(startPos);
        visitDistance[startPos.y][startPos.x] = 1;

        for(;!queue.isEmpty();){
            Point prevPoint = queue.poll();

            for (int i = 0; i < dir.length; i++) {
                int dy = prevPoint.y + dir[i][0];
                int dx = prevPoint.x + dir[i][1];

                if(dy < 0 || dy >= visitDistance.length) continue;
                if(dx < 0 || dx >= visitDistance[0].length) continue;
                if(visitDistance[dy][dx] != 0) continue;

                Point nextPoint = new Point();
                nextPoint.y = dy;
                nextPoint.x = dx;
                queue.add(nextPoint);
                visitDistance[dy][dx] = visitDistance[prevPoint.y][prevPoint.x] + 1;
            }


        }

        System.out.println(visitDistance[destPos.y][destPos.x] - 1);
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/BFS_DFS/나이트의이동/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            int boardLength = Integer.parseInt(br.readLine());

            int board[][] = new int[boardLength][boardLength];
            int visitDistance[][] = new int[boardLength][boardLength];

            Point startPos = new Point();
            {
                st = new StringTokenizer(br.readLine(), " ");
                startPos.y = Integer.parseInt(st.nextToken());
                startPos.x = Integer.parseInt(st.nextToken());
            }

            Point destPos = new Point();
            {
                st = new StringTokenizer(br.readLine(), " ");
                destPos.y = Integer.parseInt(st.nextToken());
                destPos.x = Integer.parseInt(st.nextToken());
            }

            /*
            * 예전에 풀었던 숨바꼭질 문제랑 비슷한것 같다.
            * 정점과 간선을 명확하게 주지않고 상황에 맞게 만들어서 넣어야 하는부분이 상당히 비슷핟.
            * 최단거리 구해야하니까 bfs로 풀면될듯
            * */

            BFS(startPos, destPos, board, visitDistance);

        }


    }

}
