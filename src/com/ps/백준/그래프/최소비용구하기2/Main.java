package com.ps.백준.그래프.최소비용구하기2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


/*
* 가중치가 다르니 다익스트라
* bfs + 우선순위 큐
*
* 방향존재
*
*
* */

class Main {

    static class Vertex{
        int end;
        int cost;

        public Vertex(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    static List<Vertex> board[];
    static boolean visitCheck[];
    static Vertex shortestPath[];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/최소비용구하기2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int cityCount = Integer.parseInt(br.readLine());
        int busCount = Integer.parseInt(br.readLine());

        board = new List[cityCount + 1];
        for (int i = 0; i < board.length; i++) {
            board[i] = new ArrayList<>();
        }
        visitCheck = new boolean[cityCount + 1];

        shortestPath = new Vertex[cityCount + 1];
        for (int i = 0; i < shortestPath.length; i++) {
            shortestPath[i] = new Vertex(0, Integer.MAX_VALUE);
        }

        for (int i = 0; i < busCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            board[start].add(new Vertex(end,cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        PriorityQueue<Vertex> nextPlaceQueue = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.cost));
        visitCheck[startCity] = true;
        nextPlaceQueue.add(new Vertex(startCity, 0));
        shortestPath[startCity] = new Vertex(-1, 0);


        while(!nextPlaceQueue.isEmpty()){
            Vertex visitPlace = nextPlaceQueue.poll();

            for (Vertex connectedSomething : board[visitPlace.end]) {

                if(shortestPath[connectedSomething.end].cost > visitPlace.cost + connectedSomething.cost){
                    shortestPath[connectedSomething.end] = new Vertex(visitPlace.end, visitPlace.cost + connectedSomething.cost);
                    nextPlaceQueue.add(new Vertex(connectedSomething.end, visitPlace.cost + connectedSomething.cost));
                }


                //목적지까지 가는데 비용이 작은 길이 여러번 모여서 결국 누적된 비용이 큰걸로 한번에 가는길보다 커질수 있다.
                //때문에 D(s, e) = D(s, c) + W(c, e) 라는 수식을 적용해야 할것 같다.
                // 큐에 넣을때 cost는 해당 지점까지의 누적비용을 넣어야됨.
                //그래야 더 적은비용으로 갈수 있는 경로를 발견했을때 단편적으로 빠른길인지 정말로 빠른길인지 알수 있게됨.
                //가장 작은 비용을 먼저 계산하는지, 큰걸먼저 하든지 어차피 답은 나온다. 모든 간선에 대해서 계산해보게 되기 떄문.
                //어쩃든 그렇게해서 계산해서 도착지점에 도착했을때 누적된 코스트 비용이 가장 작은 간선을 따라가다 보면 시작지점
                //알수있게됨.

            }
        }


        {
            Vertex cur = shortestPath[endCity];
            List<Integer> pathHistory = new ArrayList<>();
            pathHistory.add(endCity);
            while(cur.end != -1){
                pathHistory.add(cur.end);
                cur = shortestPath[cur.end];
            }
            Collections.reverse(pathHistory);

            System.out.println(shortestPath[endCity].cost);
            System.out.println(pathHistory.size());
            for (Integer integer : pathHistory) {
                System.out.print(integer + " ");
            }
        }

    }

}