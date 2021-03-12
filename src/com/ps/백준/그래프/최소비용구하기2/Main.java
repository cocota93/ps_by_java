package com.ps.백준.그래프.최소비용구하기2;

import java.io.BufferedReader;
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

                if(!visitCheck[connectedSomething.end])
                    shortestPath[connectedSomething.end] = new Vertex(visitPlace.end, connectedSomething.cost + visitPlace.cost);
                else if(shortestPath[connectedSomething.end].cost > connectedSomething.cost + visitPlace.cost)
                    shortestPath[connectedSomething.end] = new Vertex(visitPlace.end, connectedSomething.cost + visitPlace.cost);
                //shortestPath사용시 shortestPath[visitPlace.end]로 안하고 shortestPath[visitPlace.end] 로 구현한 이유는
                //더 빠른길을 알게 되었을때 shortestPath[visitPlace.end] 는 한번만 변경하면 된다.

                nextPlaceQueue.add(new Vertex(connectedSomething.end, connectedSomething.cost));
                visitCheck[connectedSomething.end] = true;

                //목적지까지 가는데 비용이 작은 길이 여러번 모여서 결국 누적된 비용이 큰걸로 한번에 가는길보다 커질수 있다.
                //때문에 D(s, e) = D(s, c) + W(c, e) 라는 수식을 적용해야 할것 같다.

            }
        }


        {
            Vertex cur = shortestPath[endCity];
            List<Integer> pathHistory = new ArrayList<>();
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