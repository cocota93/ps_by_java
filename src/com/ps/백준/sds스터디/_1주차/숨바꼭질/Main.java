package com.ps.백준.sds스터디._1주차.숨바꼭질;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 재귀를 통해 풀었더니 스택오버플로우가 발생한다.
* bfs로 풀어도 비슷한 문제가 발생할것 같다.
* */

/*
* 수빈이의 위치에서부터 계산하는게 아니라 동생의 위치에서부터 계산을 해보는건 어떨까?
* 음...크게 차이 없을것 같은데
* */

/*
* 두배씩 점프해서 최대한 멀리 갈수있는데까지 가보고...흠 ㅡㅡ
* */

/*
* 똑같은 장소에 대한 방문횟수를 최대 3회로 제한하면 되지 않을까?
* */

/*
* 우선순위큐 이용해서 subinPos - broPos 기준으로 정렬하면 되지않을까?
* */

/*
* 풀이보니까 다들 bfs로 풀었네? 만약 bfs로 본다면 점프때문에 가중치가 다른 그래프로 봐야 되서
* 다익스트라로 풀어야 할것같은데 다들 단순bfs로 풀었다. 단순bfs여도 메모리초과
* 발생할것 같은데 어디서 bfs로 판단 했어야 했을까? 일단 보류해놓고 나중에 다시 풀어보자
* */

class Main {

    static int timeTable[];//timeTable[위치] = 최소시간
    static boolean visited[];
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/sds스터디/_1주차/숨바꼭질/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int subinPos = Integer.parseInt(st.nextToken());
        int broPos = Integer.parseInt(st.nextToken());

        int limitPos = 10000;
        int curTime = 0;
        timeTable = new int[limitPos + 1];
        Arrays.fill(timeTable, INF);

        visited = new boolean[limitPos + 1];
        timeTable[0] = curTime;

        recur(curTime, subinPos, broPos, limitPos);
//        bfs(curTime, subinPos, broPos, limitPos);

        System.out.println(timeTable[broPos]);
    }

    private static void bfs(int curTime, int subinPos, int broPos, int limitPos) {


    }

    private static void recur(int curTime, int subinPos, int broPos, int limitPos) {
         if(subinPos > limitPos) return;
         if(subinPos < 0) return;
         if(visited[subinPos]) return;

        timeTable[subinPos] = Math.min(curTime, timeTable[subinPos]);
        visited[subinPos] = true;

        if(subinPos == broPos) return;

        recur(curTime + 1, subinPos - 1, broPos, limitPos);
        recur(curTime + 1, subinPos + 1, broPos, limitPos);
        if(subinPos != 0) recur(curTime + 1, subinPos * 2, broPos, limitPos);
    }

}
