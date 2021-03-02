package com.ps.백준.그래프.네트워크연결;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileInputStream;
import java.util.StringTokenizer;


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

    static int edgeCost[][];
    static List<Integer> edgeGraph[];

    static int resultCost[];
    static boolean visited[];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/그래프/네트워크연결/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        edgeGraph = new List[n + 1];
        for (int i = 1; i < edgeGraph.length; i++) {
            edgeGraph[i] = new ArrayList<>();
        }
        edgeCost = new int[n + 1][n + 1];

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());


            if(v1 == v2) continue;
            //v1과 v2가 같을수 있다고하는데 만약에 같을경우 간선이 없다고 처리하거나 cost를 0으로 처리하고 넘어가면 안되나??

            if(edgeCost[v1][v2] > 0){
                edgeCost[v1][v2] = edgeCost[v2][v1] = Math.min(edgeCost[v1][v2], cost);
            } else{
                edgeCost[v1][v2] = edgeCost[v2][v1] = cost;
                edgeGraph[v1].add(v2);
                edgeGraph[v2].add(v1);
            }
        }


        resultCost = new int[n + 1];
        Arrays.fill(resultCost, Integer.MAX_VALUE);
        visited = new boolean[n + 1];

        //시작지점을 어떻게 잡지?

        for (int v1 = 1; v1 < resultCost.length; v1++) {

            visited[v1] = true;
//            resultCost[v1] = 0;

            for (Integer v2 : edgeGraph[v1]) {
//                resultCost[v2] = Math.min(resultCost[v2], edgeCost[v1][v2]);

            }

        }





    }

}
