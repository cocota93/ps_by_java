package com.ps.백준.mst.도시분할계획;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 일단 mst한번 돌리고 각 지점 방문하면서 해당 집과 연결된 길 부셔서  고립시켰을때 줄어드는 비용이
* 가장크면 그 집만 따로 다른마을에 두면 될듯?
*
* 아닌가?
* 크루스칼 알고리즘으로 돌리고 가장 마지막 유니온은 다른마을로 취급하는게 맞을려나?
* */


class Main {

    static class ConnectedInfo{
        int v1;
        int v2;
        int cost;

        public ConnectedInfo(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }

    static int n;//집의 개수
    static int m;//길의 개수

    static int unionInfo[];

    static int answer;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/mst/도시분할계획/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        unionInfo = new int[n];
        for (int i = 0; i < unionInfo.length; i++) {
            unionInfo[i] = i;
        }

        Queue<ConnectedInfo> connectedInfoQueue = new PriorityQueue<>(m, Comparator.comparingInt(connected -> connected.cost));
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            connectedInfoQueue.add(new ConnectedInfo(v1, v2, cost));
        }

        kruskal(connectedInfoQueue);

        System.out.println(answer);
    }

    private static void kruskal(Queue<ConnectedInfo> connectedInfoQueue) {


        int lastCost = 0;
        while(!connectedInfoQueue.isEmpty()){
            ConnectedInfo connectedInfo = connectedInfoQueue.poll();

            if(isSameParent(connectedInfo.v1, connectedInfo.v2)) continue;

            doUnion(connectedInfo.v1, connectedInfo.v2);
            answer += connectedInfo.cost;
            lastCost = connectedInfo.cost;
        }

        answer -= lastCost;
    }

    private static void doUnion(int v1, int v2) {
        int parent1 = findParent(v1);
        int parent2 = findParent(v2);

        //더 숫자가 작은녀석이 최상위 부모가 되도록.
        unionInfo[Math.max(parent1,parent2)] = Math.min(parent1,parent2);
    }

    private static boolean isSameParent(int v1, int v2) {
        return findParent(v1) == findParent(v2);
    }

    private static int findParent(int v) {
        int parent = unionInfo[v];
        if(parent == v) return v;//최상위 부모

        unionInfo[v] = findParent(parent);//최상위 부모를 넣어준다.
        return unionInfo[v];
    }


}
