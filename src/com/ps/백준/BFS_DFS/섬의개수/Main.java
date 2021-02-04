package com.ps.백준.BFS_DFS.섬의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 단순 DFS로 풀면될듯. 모든 정점을 시작으로 해서 시도해보고.
*
* */

class Main {
    //12시방향부터 시계방향으로
    static int dy[] = {-1, -1, 0, 1,    1, 1, 0, -1};
    static int dx[] = {0, 1, 1, 1,     0, -1, -1, -1};

    static int w;
    static int h;
    static int world[][];
    static boolean visited[][];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/BFS_DFS/섬의개수/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        while(true){
            int answer = 0;


            String readLine = br.readLine();
            if(readLine == null) break;
            st = new StringTokenizer(readLine, " ");

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 || h == 0) break;

            world = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < w; j++) {
                    world[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(visited[i][j]) continue;
                    if(world[i][j] == 0) continue;//바다

                    visited[i][j] = true;
                    DFS(i, j);
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }

    private static void DFS(int row, int col) {

        for (int i = 0; i < dy.length; i++) {
            int nextY = row + dy[i];
            int nextX = col + dx[i];

            if(nextY < 0 || nextY >= h) continue;
            if(nextX < 0 || nextX >= w) continue;
            if(visited[nextY][nextX]) continue;
            if(world[nextY][nextX] != 1) continue;

            visited[nextY][nextX] = true;
            DFS(nextY, nextX);
        }
    }

}
