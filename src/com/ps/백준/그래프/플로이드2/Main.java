package com.ps.백준.그래프.플로이드2;

import java.awt.image.renderable.RenderableImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static int dist[][];
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/그래프/플로이드2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dist = new int[n + 1][n + 1];
        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist[0].length; j++) {
                dist[i][j] = INF;
            }
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[start][end] = Math.min(dist[start][end], cost);
        }

        for (int k = 1; k < dist.length; k++) {
            for (int i = 1; i < dist.length; i++) {
                for (int j = 1; j < dist.length; j++) {

                    if(i == j) continue;//출발지와 도착지가 같은경우는 없다고 했으니까.

                    if(dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist.length; j++) {
                int renderValue = 0;
                if(dist[i][j] != INF) renderValue = dist[i][j];
                System.out.print(renderValue + " ");
            }

            System.out.println();
        }


        //문제에서 주는 출력예제가 잘 이해가 안됨.

    }

}
