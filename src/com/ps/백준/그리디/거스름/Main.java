package com.ps.백준.그리디.거스름;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 완탐으로 풀고 제출했더니 시간초과 발생
* */



class Main {

    static int n;//거슬러줘야하는 돈
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그리디/거스름/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(br.readLine());

        int curMoney = 0;
        int coinValue2Count = 0;
        int coinValue5Count = 0;
        recur(curMoney, coinValue2Count, coinValue5Count);


        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }

    private static void recur(int curMoney, int coinValue2Count, int coinValue5Count) {
        if(answer <= coinValue2Count + coinValue5Count) return;
//        if(answer != Integer.MAX_VALUE) return;

        if (curMoney >= n) {
            if(curMoney == n){
                if(answer > coinValue2Count + coinValue5Count){
                    answer = coinValue2Count + coinValue5Count;
                }
            }
            return;
        }


        recur(curMoney + 2, coinValue2Count + 1, coinValue5Count);
        recur(curMoney + 5, coinValue2Count, coinValue5Count + 1);
    }

}
