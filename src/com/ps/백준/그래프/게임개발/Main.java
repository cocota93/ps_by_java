package com.ps.백준.그래프.게임개발;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 잘 안풀린다 싶었더니 위상정렬 문제였네
* */

class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/그래프/게임개발/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());//건물 종류 수

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int costTime = Integer.parseInt(st.nextToken());

            int buildNum = Integer.parseInt(st.nextToken());
            if(buildNum == -1) continue;

            while(st.hasMoreTokens()){

            }

            //이 뒤로 오는 모든 숫자(-1제외)는 선행 건물 번호
        }
    }

}
