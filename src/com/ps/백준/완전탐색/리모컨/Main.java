package com.ps.백준.완전탐색.리모컨;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 수빈이의 초기 채널번호는 100번
* 원하는 채널까지 가기위한 최소 버튼 클릭수 구하는 문제
*
* 일단 번호를 이용해서 최대한 가까이 간뒤에 목표채널 - 현재채널 하면 되지않나?
* -> 마지막줄 치면서 현재 코드의 반례가 생각나버렸다.ㅜㅜ 목표숫자 1001, 금지숫자 1, 0 이면 최근접숫자가 2222로 나와버린다...정상적이라면 999가 나와야한다....
* */

class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/리모컨/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int targetChannel = Integer.parseInt(br.readLine());
        String targetChannelString = String.valueOf(targetChannel);
        int brokenCount = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");

        List<Integer> buttonList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buttonList.add(i);
        }

        for (int i = 0; i < brokenCount; i++) {
            int brokenNumber = Integer.parseInt(st.nextToken());
            buttonList.removeIf(number -> number == brokenNumber);
        }


//        buttonList.forEach(number -> System.out.printf("%d, ", number));
//        System.out.println("");

        StringBuilder sb = new StringBuilder();
        for (int orderDigit = 0; orderDigit < targetChannelString.length(); orderDigit++) {
            int eachNumber = targetChannelString.charAt(orderDigit) - '0';
            int minDistance = Integer.MAX_VALUE;
            int minDistanceNumber = eachNumber;

            for (int i = 0; i < buttonList.size(); i++) {
                int temp = Math.abs(eachNumber - buttonList.get(i));
                if(minDistance > temp){
                    minDistance = temp;
                    minDistanceNumber = buttonList.get(i);
                }
            }

            sb.append(minDistanceNumber);
        }

        int result = 0;
        int defaultChannel = 100;
        int jumpChannel = Integer.parseInt(sb.toString());
        if( Math.abs(targetChannel - defaultChannel) < Math.abs(targetChannel - jumpChannel)){
            result = Math.abs(targetChannel - defaultChannel);
        }else{
            result = sb.length();
            result += Math.abs(targetChannel - jumpChannel);
        }

        System.out.println(result);
    }

}
