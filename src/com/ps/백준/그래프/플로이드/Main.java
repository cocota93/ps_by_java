package com.ps.백준.그래프.플로이드;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static int INF = 1000000000;
    static int dist[][];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/플로이드/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int cityCount = Integer.parseInt(br.readLine());
        int busCount = Integer.parseInt(br.readLine());

        dist = new int[cityCount + 1][cityCount + 1];
        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist[0].length; j++) {
                if(i == j ) continue;

                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < busCount; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[start][end] = Math.min(dist[start][end], cost);
//            dist[start][end] = cost;
        }

        for (int k = 1; k <= cityCount; k++) {
            for (int i = 1; i <= cityCount; i++) {
                for (int j = 1; j <= cityCount; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist.length; j++) {
                if(dist[i][j] == INF) System.out.print(0 + " ");
                else System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

    }

}
