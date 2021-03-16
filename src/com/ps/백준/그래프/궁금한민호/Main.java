package com.ps.백준.그래프.궁금한민호;

import sun.security.provider.certpath.Vertex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


/*
* 어떤 도시로 이동하는데 필요한 최단시간이 인풋으로 주어지는데 이러한 값들을 이용하여
* 필요한 도로의 수와 도로의 비용에 대한 합을 구해야함.
*
* 음. 최소스패닝알고리즘(프림 알고리즘, 크루스칼 알고리즘)이 생각난다. 기존 트리형태의 입력에서 일부 간선을 지워
* 특정 형태의 그래프를 만드는 알고리즘. 해당 문제와 비슷한것 같음.
*
* 프림알고리즘이랑 크루스칼 알고리즘이랑 약간 헷갈렸었는데 다시한번 정리해보면
* 프림알고리즘은 bfs + 우선순위큐 로 구현해서 일부 간선들을 선택해가는 느낌
* 크루스칼 알고리즘은 유니온파인드를 이용하여 하나로 만들어가는 느낌
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


    static List<Vertex> optimalDist[];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/그래프/궁금한민호/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        optimalDist = new List[n + 1];
        for (int i = 0; i < optimalDist.length; i++) {
            optimalDist[i] = new ArrayList<>();
        }

        for (int i = 1; i < optimalDist.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < optimalDist.length; j++) {
                int cost = Integer.parseInt(st.nextToken());
                optimalDist[i].add(new Vertex(j,cost));
            }
        }


        /*
        * 방문한 지점에서 연결된 지점으로...
        * 음 모르겠다.
        * */
        Queue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(vertex -> vertex.cost));
        while(!pq.isEmpty()){
            Vertex visitPlace = pq.poll();

            for (Vertex connectedPlace : optimalDist[visitPlace.end]) {
            }

        }

    }

}
