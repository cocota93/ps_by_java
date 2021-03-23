package com.ps.백준.sds스터디._8주차.퇴사;

import javax.swing.plaf.synth.SynthCheckBoxUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


/*
* 단순 반복문으로도 풀수 있을것같고
* 재귀로도 가능할것 같고
* 인풋을 적절히 변환하면 그래프형태로도 만들어서 bfs로도 풀수 있을것 같다.
*
* 하지만 굳이 어렵게 돌아갈 필요는 없을것 같다. 단순 반복문으로 해결해보자.
* -> 해보니까 단순 반보긍로는 안될것 같다. 일정이 최대 2개 선택될수있으면 반복문 2개가 필요하고
* 일정이 최대 3개 선택될수 있으면 반복문 3개가 필요한데 이 문제에서는 최대 선택 가능한 수가 정해지지 않았고 n이 가변적이다.
* 때문에 재귀로 풀어야 할것 같다.
* */

class Main {

    static class Schedule{
        int timeCost;
        int pay;

        public Schedule(int timeCost, int pay) {
            this.timeCost = timeCost;
            this.pay = pay;
        }
    }

    static Schedule schedule[];
    static int answer;
    static int n;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/sds스터디/_8주차/퇴사/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        schedule = new Schedule[n + 1];
        for (int i = 1; i < schedule.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            schedule[i] = new Schedule(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int curDay = 1;
        int takeMoney = 0;
        recur(curDay, takeMoney);

        System.out.println(answer);
    }

    private static void recur(int curDay, int takeMoney) {
        if(curDay >= schedule.length){
            if(curDay == schedule.length){
                answer = Math.max(answer, takeMoney);
            }

            return;
        }



        //해당 스케쥴을 소화하는 경우
        recur(curDay + schedule[curDay].timeCost, takeMoney + schedule[curDay].pay);

        //해당 스케쥴을 건너뛰는 경우
        recur(curDay + 1, takeMoney);
    }

}
