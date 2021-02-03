package com.ps.백준.완전탐색.n과m_1;

import java.io.*;
import java.util.StringTokenizer;

/*
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
* */

class Main {
    static int n;
    static int m;
    static int arr[];
    static boolean visit[];


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/n과m_1/input.txt"));
        StringTokenizer st;

//    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new boolean[n];

        int depth = 0;
        Recur(depth);
//        dfs(0);
    }

    private static void Recur(int depth) {
        if(depth == m){
            for (int val : arr) {
                System.out.print(val + " ");
//                System.out.printf(val + " ");//printf쓰면 시간초과발생. 생각보다 차이가 엄청 큰가봄.
            }
            System.out.println("");
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            arr[depth] = i + 1;
            Recur(depth + 1);
            visit[i] = false;
        }
    }

    public static void dfs(int depth) {
        if (depth == m) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println("");
            return;
        }

        for (int i = 0; i < n; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            arr[depth] = i + 1;
            dfs(depth + 1);
            visit[i] = false;
        }
    }

    private static boolean isInclude(int[] makedNumber, int target) {
        for (int j = 0; j < makedNumber.length; j++) {
            if(makedNumber[j] == target){
                return true;
            }
        }

        return false;
    }

}
