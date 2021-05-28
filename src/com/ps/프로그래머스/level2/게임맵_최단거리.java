package com.ps.프로그래머스.level2;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//단순bfs인데?

public class 게임맵_최단거리 {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] distance;

    public int solution(int[][] maps) {
        int answer = 0;

        visited = new boolean[maps.length][maps[0].length];
        distance = new int[maps.length][maps[0].length];
        int destY = maps.length - 1;
        int destX = maps[0].length - 1;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        distance[0][0] = 1;

        answer = -1;
        while(!queue.isEmpty()){
            Point visitPlace = queue.poll();

            if(visitPlace.y == destY && visitPlace.x == destX){
                answer = distance[destY][destX];
                break;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nextY = visitPlace.y + dy[dir];
                int nextX = visitPlace.x + dx[dir];

                if(nextY < 0 || nextY >= maps.length) continue;
                if(nextX < 0 || nextX >= maps[0].length) continue;
                if(maps[nextY][nextX] == 0) continue;
                if(visited[nextY][nextX]) continue;

                queue.add(new Point(nextX, nextY));
                visited[nextY][nextX] = true;
                distance[nextY][nextX] = distance[visitPlace.y][visitPlace.x] + 1;

            }
        }


        return answer;
    }

    public static void main(String[] args) throws Exception {
        게임맵_최단거리 proposal = new 게임맵_최단거리();

        /*디버깅용 입출력 */
//        System.setIn(new FileInputStream("src/com/ps/프로그래머스/level2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");
//        int a = Integer.parseInt(st.nextToken());
//        System.out.println(a);

        proposal.solution(new int[][] {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}});
//        proposal.solution(new int[][] { { }});
    }

}
