package com.ps.백준.그래프.케빈베이컨의6단계;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static int dist[][];
    static int INF = 110;


    static int sum[];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/케빈베이컨의6단계/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());//유저의수
        int m = Integer.parseInt(st.nextToken());//관계의수

        dist = new int[n + 1][n + 1];
        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist.length; j++) {
                if(i == j) continue;

                dist[i][j] = INF;
            }
        }

        sum = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = 1;

            dist[start][end] = cost;
            dist[end][start] = cost;
        }

        for (int k = 1; k < dist.length; k++) {
            for (int i = 1; i < dist.length; i++) {
                for (int j = 1; j < dist.length; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
//                        dist[j][i] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }


        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist.length; j++) {
//                int renderValue = 0;
//                if(dist[i][j] != INF) renderValue = dist[i][j];
//                System.out.print(renderValue + " ");

                sum[i] += dist[i][j];
            }

//            System.out.println();
        }


        int minestIdx = 1;
        int minestVal = sum[1];
        for (int i = 1; i < sum.length; i++) {
            if(minestVal > sum[i]){
                minestIdx = i;
                minestVal = sum[i];
            }
        }


        System.out.println(minestIdx);
    }

}
