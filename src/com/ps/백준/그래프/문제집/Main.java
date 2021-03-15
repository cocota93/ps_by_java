package com.ps.백준.그래프.문제집;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


//어떻게 풀어야하는지 감 못잡고 있었는데 찾아보니
// 위상정렬로 푸는 문제네;;일단 보류

class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/그래프/문제집/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());//문제의수
        int m = Integer.parseInt(st.nextToken());//먼저 푸는게 좋은 문제의 정보수

        //먼저 푸는게 좋은 문제는 반드시 먼저 풀어야 한다.
        //위 규칙은 지키면서 가능한 쉬운문제부터 푼다.

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());//먼저 풀어야 하는 문제 번호
            int after = Integer.parseInt(st.nextToken());//이후에 풀어야 하는 문제 번호.




        }

    }

}
