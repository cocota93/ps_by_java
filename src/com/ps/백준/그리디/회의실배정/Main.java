package com.ps.백준.그리디.회의실배정;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


/*
* 예전에 풀어본적 있는 문제인데 그당시엔 어떻게 정렬해서 풀었던거 같은데 잘 기억은 안난다.
* 지금 시점에선 완전탐색으로 풀면되지않나? 싶은데 음;;아직 그리디에 대해서 잘 모르겠다
* */

/*
* 지금은 다음날이다. 끝나는 시간을 기준으로 오름차순 정렬후 시간의 흐름에 따라 처리하면 될듯하다.
* */

class Main {

    static class Reserve{
        int startTime;
        int endTime;

        public Reserve(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그리디/회의실배정/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int reserveCount = Integer.parseInt(br.readLine());
        List<Reserve> reserveReqList = new ArrayList<>();

        for (int i = 0; i < reserveCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            reserveReqList.add(new Reserve(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
//        reserveReqList.sort(Comparator.comparingInt(reserve -> reserve.endTime));
        reserveReqList.sort((reserve1, reserve2) -> {
            if(reserve1.endTime == reserve2.endTime){
                return reserve1.startTime - reserve2.startTime;
            }else{
                return reserve1.endTime - reserve2.endTime;
            }
        });


        int curTime = 0;
        int priorCheckIndex = 0;
        int count = 0;
        while( priorCheckIndex < reserveReqList.size()){
            Reserve reserve = reserveReqList.get(priorCheckIndex);
            if(reserve.startTime == curTime){
                count++;
                priorCheckIndex++;
                curTime = reserve.endTime;
            } else if(reserve.startTime < curTime){
                priorCheckIndex++;
            } else{
                curTime = reserve.startTime;
            }
        }


        System.out.println(count);
    }

}
