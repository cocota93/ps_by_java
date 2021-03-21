package com.ps.백준.그래프.네트워크연결;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.AnnotatedWildcardType;
import java.util.*;


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

    static class Edge{
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }

    static int unionGroupNumList[];


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/네트워크연결/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        unionGroupNumList = new int[n + 1];
        PriorityQueue<Edge> openList = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.cost));

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            openList.add(new Edge(v1, v2, cost));
        }

        for (int i = 0; i < unionGroupNumList.length; i++) {
            unionGroupNumList[i] = i;
        }

        int answer = kruskal(openList);

        System.out.println(answer);
    }

    private static int kruskal(PriorityQueue<Edge> openList) {
        int answer = 0;
        while(!openList.isEmpty()){
            Edge edge = openList.poll();
            if(isSameParent(edge.v1, edge.v2)) continue;

            doUnion(edge.v1, edge.v2);
            answer += edge.cost;
        }
        return answer;
    }

    static int findParent(int targetNode){
        int curParent = unionGroupNumList[targetNode];
        int topParent = unionGroupNumList[curParent];
        if(curParent == topParent) return topParent;

        unionGroupNumList[targetNode] = findParent(curParent);

        return unionGroupNumList[targetNode];
    }

    static boolean doUnion(int targetNode1, int targetNode2){
        int parent1 = findParent(targetNode1);
        int parent2 = findParent(targetNode2);

        if(parent1 == parent2) return false;

        unionGroupNumList[Math.max(parent1, parent2)] = Math.min(parent1, parent2);
        return true;
    }

    static boolean isSameParent(int targetNode1, int targetNode2){
        int parent1 = findParent(targetNode1);
        int parent2 = findParent(targetNode2);

        return parent1 == parent2;
    }

}
