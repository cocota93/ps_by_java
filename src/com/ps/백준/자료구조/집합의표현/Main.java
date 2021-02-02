package com.ps.백준.자료구조.집합의표현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 정확히 어떻게 풀어야할지는 모르겠지만
* dfs, bfs를 이용하는 문제 아닌가? 하는 생각이 스쳐지나간다.
* */


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/자료구조/집합의표현/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int maxVertexNumber = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());//0은 합집합으로 만들기, 1은 합집합인지 확인하기
            int startVertex = Integer.parseInt(st.nextToken());
            int endVertex = Integer.parseInt(st.nextToken());

            //어떤 점이 어디에 속해있는지 어떤식으로 표기하지??
            //합집합 된것끼리 문자열로 만들어서 합쳐버릴까?
        }

    }

}
