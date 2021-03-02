package com.ps.백준.그래프.최소스패닝트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


class Main {

    static class Edge{

        int v1;
        int v2;
        long cost;

        public Edge(int v1, int v2, long cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }

    static int unionContainer[];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/그래프/최소스패닝트리/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        unionContainer = new int[v + 1];
        for (int i = 0; i < unionContainer.length; i++) {
            unionContainer[i] = i;
        }

        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingLong(edge -> edge.cost));

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long cost = Long.parseLong(st.nextToken());

            queue.add(new Edge(start, end, cost));
        }

        long answer = 0;
        while(!queue.isEmpty()){
            Edge edge = queue.poll();

            if(doUnion(unionContainer, edge.v1, edge.v2)){
                answer += edge.cost;
            }
        }

        System.out.println(answer);
    }

    private static int findParent(int container[], int targetNode){
        int currentParent = container[targetNode];
        int topParent = container[currentParent];
        if(currentParent == topParent) return topParent;


        //부모노드와 타겟노드가 서로 가리키는 최상위 다르면 부모노드를 따라가도록.
        container[targetNode] = findParent(container, currentParent);
        return container[targetNode];
    }

    private static boolean doUnion(int container[], int node1, int node2){
        int node1Parent = findParent(container, node1);
        int node2Parent = findParent(container, node2);
        if(node1Parent == node2Parent){
            return false;
        }


        /*
        * parent를 기준으로 갱신해야 한다는것 주의.
        * */
        container[Math.max(node1Parent,node2Parent)] = Math.min(node1Parent,node2Parent);
        return true;
    }

    private static boolean isSameParent(int container[], int node1, int node2){
        int node1Parent = findParent(container, node1);
        int node2Parent = findParent(container, node2);

        return node1Parent == node2Parent;
    }


}
