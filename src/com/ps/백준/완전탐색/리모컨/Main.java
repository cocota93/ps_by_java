package com.ps.백준.완전탐색.리모컨;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;
import java.util.stream.Collectors;

/*
* 수빈이의 초기 채널번호는 100번
* 원하는 채널까지 가기위한 최소 버튼 클릭수 구하는 문제
*
* 일단 번호를 이용해서 최대한 가까이 간뒤에 목표채널 - 현재채널 하면 되지않나?
* -> 마지막줄 치면서 현재 코드의 반례가 생각나버렸다.ㅜㅜ 목표숫자 1001, 금지숫자 1, 0 이면 최근접숫자가 2222로 나와버린다...정상적이라면 999가 나와야한다....
* */

/*
* 만들수 있는 숫자 만들어서 최근접 숫자를 알아내되 음..자릿수가 너무 커지면 일부는 제외시킬수 있을것 같은데 어떤 조건으로 제외시켜야 할지 모르겠음.
* */

/*
* 만약 재귀로 구현한다고 하면 깊이를 어느정도까지 해야되는거지??
* -> https://dundung.tistory.com/44 여기서 그냥 999999까지 한다는거 보고 너무 어렵게 생각했구나 느낌
* */


class Main {
    static List<Integer> buttonList;
    static List<Integer> brokenButtonList;
    static int targetChannel;
    static String targetChannelString;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/리모컨/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        targetChannel = Integer.parseInt(br.readLine());
        targetChannelString = String.valueOf(targetChannel);
        int brokenCount = Integer.parseInt(br.readLine());

        buttonList = new ArrayList<>();
        brokenButtonList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buttonList.add(i);
        }

        if(brokenCount > 0){
            st = new StringTokenizer(br.readLine()," ");
            for (int i = 0; i < brokenCount; i++) {
                int brokenNumber = Integer.parseInt(st.nextToken());
                brokenButtonList.add(brokenNumber);
                buttonList.removeIf(number -> number == brokenNumber);
            }
        }


        int minDiff = Integer.MAX_VALUE;
        int jumpChannel = Integer.MAX_VALUE;

        for (int makeNumber = 0; makeNumber <= 1000000; makeNumber++) {

//            if(makeNumber == 111111){
//                System.out.println("debug");
//            }

            char[] eachCharacter = String.valueOf(makeNumber).toCharArray();
            boolean isContainBrokenButton = false;
            for (int j = 0; j < eachCharacter.length; j++) {
                int finalJ = j;
                isContainBrokenButton = brokenButtonList.stream().anyMatch(value -> value == eachCharacter[finalJ] - '0');
                if(isContainBrokenButton) break;
            }
            if(isContainBrokenButton) continue;


            int newDiff = Math.abs(targetChannel - makeNumber);
            if(minDiff > newDiff){
                minDiff = newDiff;
                jumpChannel = makeNumber;
            }
        }

        String jumpChannelString = String.valueOf(jumpChannel);

        //점프를 했을때
        int countWhenJump = Math.abs(jumpChannelString.length() + Math.abs(targetChannel - jumpChannel));

        //점프할 필요가 없거나 점플할수 있는 숫자가 없을때
        int countWhenNoJump = Math.abs(targetChannel - 100);

        int result = Math.min(countWhenJump,countWhenNoJump);
        System.out.println(result);
    }


}
