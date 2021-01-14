package com.ps.백준.BFS_DFS.이분그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    /*
    * 이분그래프가 잘 이해가 안됨.
    *
    * */
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/BFS_DFS/이분그래프/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int vertexCount = Integer.parseInt(st.nextToken());
            int edgeCount = Integer.parseInt(st.nextToken());

            for (int j = 0; j < edgeCount; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
            }

        }

    }

}
