package com.ps.백준.mst.행성연결;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Main {

    static class Point {
        int to;
        long cost;

        public Point(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int n;
    static long board[][];
    static boolean visited[];
    static long answer;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/mst/행성연결/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        board = new long[n][n];
        visited = new boolean[n];
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.cost));
        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < board.length; j++) {
                board[i][j] = Long.parseLong(st.nextToken());
            }
        }

        prim(pq);

        System.out.println(answer);
    }

    private static void prim(PriorityQueue<Point> pq) {
        //어차피 다 방문해야되니 출발위치는 아무데나 해도됨. 걍 0으로 정하고 처리
        //-> n이 최소 1부터 시작이라 무조건 0부터 해야됨.
        pq.add(new Point(0,0));

        while(!pq.isEmpty()){
            Point visitPlace = pq.poll();
            if(visited[visitPlace.to]) continue;
            visited[visitPlace.to] = true;
            answer += visitPlace.cost;

            for (int nextTo = 0; nextTo < board[0].length; nextTo++) {
                if(board[visitPlace.to][nextTo] != 0 && !visited[nextTo]){
                    pq.add(new Point(nextTo, board[visitPlace.to][nextTo]));
                }
            }
        }
    }

}
