package com.ps.백준.그래프.네트워크연결;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


/*
* 모든 정점 최소비용으로 순회하는 문제.
*
* 무슨 알고리즘인지는 모르겠지만 이전에 비슷한 문제를 풀어본적 있었던것 같다.
* 그냥 정점방문에해서 해당 정점에서 다른 정점으로 갈떄 비용이 기존보다 더 작으면 최신화 해주면 될듯?
*
* */

/*
* 모르겠다 ㅡㅡ
* 찾아보니 크루스칼 알고리즘이라고 한다 ㅡㅡ모르는거 진짜 개많네 후ㅡㅡ
*
* */


class Main {

    //cost를 기준으로 우선순위큐를 사용할거고
    //cost만 알고있다면 어디로부터 연결되었는지는 알 필요 없기 떄문에
    //from이 없어도 됨.
    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static List<Edge> edgeGraph[];
    static boolean visited[];


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/네트워크연결/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        edgeGraph = new List[n + 1];
        for (int i = 1; i < edgeGraph.length; i++) {
            edgeGraph[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edgeGraph[v1].add(new Edge(v2, cost));
            edgeGraph[v2].add(new Edge(v1, cost));
        }




        visited = new boolean[n + 1];
        Queue<Edge> openList = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.cost));
        //시작지점을 어떻게 잡지?
        //-> 모든컴퓨터는 반드시 연결된다고 했으니까 그냥 첫번쨰부터 시작했으면 됬었음.
//         첫번쨰가 아니여도 풀수는 있겠지만 컴퓨터의 수가 최소 1개 이므로 첫번째부터 하는게 깔끔.
        visited[1] = true;
        for (Edge nextEdge : edgeGraph[1]) {
            openList.add(nextEdge);
        }


        long answer = 0;
        while(!openList.isEmpty()){
            Edge edge = openList.poll();
            if(visited[edge.to]) continue;

            visited[edge.to] = true;
            for (Edge nextEdge : edgeGraph[edge.to]) {

                openList.add(nextEdge);
            }

            answer += edge.cost;
        }

        System.out.println(answer);

    }

}
