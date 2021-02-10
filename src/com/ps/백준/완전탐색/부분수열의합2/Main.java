package com.ps.백준.완전탐색.부분수열의합2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 부분수열의 합이 s가 되는 경우의 수를 구하는 문제.
* 이것도 투포인터로 풀면 될듯한데??
* -> 투포인터로 제출하니까 틀렸다나옴=_= 왜지?
* -> s가 0일떄 아무것도 안더한상태로 카운팅해버림.
* -> 그외에도 여러가지문제
*
* */

class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/부분수열의합2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        int greateMin = Math.abs(Arrays.stream(arr).min().getAsInt());
//        s = s + greateMin + 1;
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] += greateMin + 1;
//        }

//        Arrays.sort(arr, Comparator.reverseOrder);
//        Comparator.reverseOrder


        int sumStartIdx = 0;
        int sumEndIdx = 0;
        long sum = 0;
        int answer = 0;


        sum += arr[sumEndIdx];
        sumEndIdx++;
        while(sumStartIdx <= sumEndIdx){
            if(sum == s){

                answer++;
                sum -= arr[sumStartIdx];
                sumStartIdx++;
            } else if(sum < s){
                if(sumEndIdx >= arr.length) break;

                sum += arr[sumEndIdx];
                sumEndIdx++;
            } else if(sum > s){

                sum -= arr[sumStartIdx];
                sumStartIdx++;
            }
        }


        System.out.println(answer);

    }

}
