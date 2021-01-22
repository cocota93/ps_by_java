package com.ps.백준.완전탐색.암호만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 정답 패스워드는 최소 모음 1개 자음 2개 로 구성
* */

class Main {

    static int L;
    static int C;

    static char container[];
    static boolean visited[];
    static char assembleAnswer[];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/암호만들기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());//정답 비밀번호 길이
        C = Integer.parseInt(st.nextToken());//알파벳 개수


        container = new char[C];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < C; i++) {
            container[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(container);

        assembleAnswer = new char[L];

        int depth = 0;
        Recur(depth, 0);
    }

    private static void Recur(int depth, int next) {
        if(depth == L) {
            StringBuilder sb = new StringBuilder();
            for (char c : assembleAnswer) {
                sb.append(c);
            }

//            if("cstw".equals(sb.toString())){
//                System.out.println("debug");
//            }

            //모음 개수
            int moCount = 0;
            for (char c : assembleAnswer) {
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                    moCount++;
                }
            }

            if(moCount >= 1 && assembleAnswer.length - moCount >= 2){
                System.out.println(assembleAnswer);
            }

            return;
        }

        for (int i = next; i < C; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            assembleAnswer[depth] = container[i];
            Recur(depth + 1, i + 1);
            visited[i] = false;
        }
    }

}
