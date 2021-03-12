package com.ps.백준.그래프.최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


/*
* 가중치가 다르고
* 시작점에서 모든 정점으로의 최단 경로 비용을 구해야한다.
* 방향이 있는 그래프
*
* 플로이드 알고리즘
* -> 이라고 생각했지만 메모리 초과, 다익스트라로 풀어야하는듯
* */

class Main {

    static class Vertex{
        int place;
        int cost;

        public Vertex(int place, int cost) {
            this.place = place;
            this.cost = cost;
        }
    }

    static List<Vertex> board[];
    static boolean visitCheck[];
    static int finalyCost[];
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/최단경로/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        board = new List[v + 1];
        for (int i = 0; i < board.length; i++) {
            board[i] = new ArrayList<>();
        }

        visitCheck = new boolean[v + 1];
        finalyCost = new int[v + 1];
        Arrays.fill(finalyCost, INF);


        int startVertex = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            board[v1].add(new Vertex(v2, cost));
        }


        Queue<Vertex> nextPlaceQueue = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.cost));
        nextPlaceQueue.add(new Vertex(startVertex, 0));
        finalyCost[startVertex] = 0;


        while(!nextPlaceQueue.isEmpty()){
            Vertex visitPlace = nextPlaceQueue.poll();

            for (Vertex connectedPlace : board[visitPlace.place]) {
                if(finalyCost[connectedPlace.place] > finalyCost[visitPlace.place] + connectedPlace.cost){
                    finalyCost[connectedPlace.place] = finalyCost[visitPlace.place] + connectedPlace.cost;
                    nextPlaceQueue.add(new Vertex(connectedPlace.place, finalyCost[connectedPlace.place]));
                }
            }

        }

        for (int i = 1; i < finalyCost.length; i++) {
            if(i == startVertex){
                System.out.println(0);
                continue;
            }

            if(finalyCost[i] == INF){
                System.out.println("INF");
                continue;
            }

            System.out.println(finalyCost[i]);
        }

    }

}
