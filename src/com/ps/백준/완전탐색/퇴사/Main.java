package com.ps.백준.완전탐색.퇴사;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static class ConsultTableData{

        int needDay;
        int rewardAmount;
        public ConsultTableData(int needDay, int rewardAmount) {
            this.needDay = needDay;
            this.rewardAmount = rewardAmount;
        }

    }

    static int resultReward;
    static ConsultTableData consultTable[];
    static int N;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/퇴사/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        consultTable = new ConsultTableData[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            consultTable[i] = new ConsultTableData(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int curDay = 0;
        int rewardSum = 0;
        Recur(curDay, rewardSum);

        System.out.println(resultReward);
    }

    private static void Recur(int curDay, int rewardSum) {
        if(curDay == N){
            resultReward = Math.max(resultReward, rewardSum);
            return;
        }

        if(curDay > N){
            return;
        }


        Recur(curDay + consultTable[curDay].needDay, rewardSum + consultTable[curDay].rewardAmount);
        Recur(curDay + 1, rewardSum);
    }

}
