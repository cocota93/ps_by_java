package com.ps.백준.그리디.동전0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그리디/동전0/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int coinTypeCount = Integer.parseInt(st.nextToken());
        int goalCost = Integer.parseInt(st.nextToken());
        List<Integer> coinTypeList = new ArrayList<>();

        for (int i = 0; i < coinTypeCount; i++) {
            coinTypeList.add(Integer.parseInt(br.readLine()));
        }
        coinTypeList.sort((c1, c2) -> c2 - c1);

        int needCoinCount = 0;
        for (Integer coin : coinTypeList) {
            if(goalCost / coin >= 1){
                needCoinCount += goalCost / coin;
                goalCost = goalCost % coin;
            }
        }

        System.out.println(needCoinCount);
    }

}
