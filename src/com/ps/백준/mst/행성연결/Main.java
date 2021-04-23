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
        int firstStart = -1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != 0){
                    firstStart = i;
                    break;
                }
            }

            if(firstStart != -1) break;
        }

        if(firstStart == -1) {
            System.out.println("첫스타트 시작 이상");
            System.out.println("첫스타트 시작 이상");
            System.out.println("첫스타트 시작 이상");
            System.out.println("첫스타트 시작 이상");
            System.out.println("첫스타트 시작 이상");
            System.out.println("첫스타트 시작 이상");
            System.out.println("첫스타트 시작 이상");
            System.out.println("첫스타트 시작 이상");
            System.out.println("첫스타트 시작 이상");
            System.out.println("첫스타트 시작 이상");
            return;
        }


//        visited[firstStart] = true;
//        for (int to = 0; to < board[0].length; to++) {
//            if(firstStart == to) continue;
//
//            if(board[firstStart][to] != 0){
//                pq.add(new Point(to, board[firstStart][to]));
//            }
//        }

        pq.add(new Point(firstStart,0));

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
