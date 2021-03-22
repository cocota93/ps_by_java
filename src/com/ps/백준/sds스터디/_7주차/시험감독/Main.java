package com.ps.백준.sds스터디._7주차.시험감독;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/sds스터디/_7주차/시험감독/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());//시험장의 수


        int playerCount[] = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            playerCount[i] = Integer.parseInt(st.nextToken());//각 시험장 응시자수
        }

        st = new StringTokenizer(br.readLine(), " ");
        int masterCount = Integer.parseInt(st.nextToken());//감독관 한명이 맡을수 있는 수
        int subMasterCount = Integer.parseInt(st.nextToken());//부감독관 한명이 맡을수 있는 수


        long answer = n;//감독관 한명씩은 필수
        for (int i = 0; i < playerCount.length; i++) {
            long needSubMasterCount = cal(playerCount[i] - masterCount, subMasterCount);
            answer += needSubMasterCount;
        }

        System.out.println(answer);
    }

    private static int cal(int assignPlayerCount, int subMasterCount) {
        if(assignPlayerCount <= 0) return 0;

        int answer = assignPlayerCount / subMasterCount;
        if(assignPlayerCount % subMasterCount != 0) answer += 1;

        return answer;
    }

}
