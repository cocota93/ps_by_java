package com.ps.백준.그리디.수묶기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


/*
* 정답과 계산과정은 long으로
* 0이랑 -는 묶지말고 단독으로 처리. 0이랑 - 둘다 있으면 서로 곱하기 시키면됨.
*
* 문제를 읽고 고민했던 부분은 어떻게 묶었을떄 그 합이 최대가 나오는지 모른다는것이다.
* 그냥 가장 큰수끼리 묶으면 될지 아니면 가장큰수랑 가장 작은수랑 묶는게 나은지 정확히 모른다.
* 그 다음 힌트를 모르겠다.
* */

class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/그리디/수묶기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int boardLength = Integer.parseInt(br.readLine());
        for (int i = 0; i < boardLength; i++) {

        }

    }

}
