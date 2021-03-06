package com.ps.백준.그래프.특정한최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;



//다익스트라를 이용한 최단경로는 구하겠는데
//중간에 다른 지점을 경유할려면 어떻게 해야할지 모르겠음.

class Main {

    static class Vertex{
        int end;
        int cost;

        public Vertex(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }


    static List<Vertex> pathCost[];
    static int optimalDist[];//D(s, e) = D(s, c) + W(c, e)
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/특정한최단경로/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());//정점의수
        int e = Integer.parseInt(st.nextToken());//간선의수

        pathCost = new List[n + 1];
        for (int i = 0; i < pathCost.length; i++) {
            pathCost[i] = new ArrayList<>();
        }

        optimalDist = new int[n + 1];
        Arrays.fill(optimalDist, INF);

        //양방향그래프
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pathCost[p1].add(new Vertex(p2, cost));
            pathCost[p2].add(new Vertex(p1, cost));
        }


        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());//반드시 거쳐야 하는 정점1
        int v2 = Integer.parseInt(st.nextToken());//반드시 거쳐야 하는 정점2

        //1번 정점에서 가장 마지막 정점인 n번 정점으로의 최단경로를 구하는 문제.
        //단 v1, v2를 반드시 거쳐야함.


        int answer = INF;

        {
            int start = 1;
            int goal = n;
            int cost = 0;

            {
                int calResult = Dikstra(start, v1);
                if(calResult != INF){
                    cost += calResult;
                    calResult = Dikstra(v1, v2);

                    if(calResult != INF){
                        cost += calResult;
                        calResult = Dikstra(v2, goal);

                        if(calResult != INF){
                            cost += calResult;

                            answer = cost;
                        }
                    }
                }
            }
        }

        {
            int start = 1;
            int goal = n;
            int cost = 0;

            {
                int calResult = Dikstra(start, v2);
                if(calResult != INF){
                    cost += calResult;
                    calResult = Dikstra(v2, v1);

                    if(calResult != INF){
                        cost += calResult;
                        calResult = Dikstra(v1, goal);

                        if(calResult != INF){
                            cost += calResult;

                            answer = Math.min(cost, answer);
                        }
                    }
                }
            }
        }

        if(answer == INF) System.out.println(-1);
        else System.out.println(answer);
    }

    private static int Dikstra(int start, int end) {
        Arrays.fill(optimalDist, INF);
        boolean visitCheck[] = new boolean[optimalDist.length];

        Queue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.cost));
        optimalDist[start] = 0;
        pq.add(new Vertex(start, 0));

        while(!pq.isEmpty()){
            Vertex visitPlace = pq.poll();
            if(visitCheck[visitPlace.end]) continue;
            visitCheck[visitPlace.end] = true;


            for (Vertex connectedPlace : pathCost[visitPlace.end]) {
                optimalDist[connectedPlace.end] = Math.min(optimalDist[visitPlace.end] + connectedPlace.cost, optimalDist[connectedPlace.end]);
                pq.add(new Vertex(connectedPlace.end, optimalDist[connectedPlace.end]));
            }
        }

        return optimalDist[end];
    }

}
