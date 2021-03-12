package com.ps.백준.그래프.최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


/*
* 가중치가 다르고
* 시작점에서 모든 정점으로의 최단 경로 비용을 구해야한다.
* 방향이 있는 그래프
*
* 플로이드 알고리즘
* -> 이라고 생각했지만 메모리 초과
* */

class Main {

    static int dist[][];
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/최단경로/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dist = new int[v + 1][v + 1];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                dist[i][j] = INF;
            }
        }

        int startVertex = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[v1][v2] = Math.min(dist[v1][v2], cost);
        }
        
        

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            if(i == startVertex) {
                System.out.println(0);
                continue;
            }

            if(dist[startVertex][i] == INF){
                System.out.println("INF");
                continue;
            }

            System.out.println(dist[startVertex][i]);
        }




    }

}
