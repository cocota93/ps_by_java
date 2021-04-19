package com.ps.백준.투포인터.두용액;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


/*
* 어떻게 풀어야할지 고민하다가 카테고리를 생각하고서야 느낌이왔다.
* 하지만 카테고리를 안다는것 자체가 정답을 반쯤 봐버린 것이기 떄문에
* 카테고리를 알기전에 알아챘어야 한다.
* 일단 처음에 했던 고민은 가장 큰값끼리 계산해도 큰값간에 차이가 클수 있고
* 가장 작은값 끼리 계산해도 그 값끼리 차이가 클수 있어서 애매했다.
* 그래서 처음엔 완탐으로 해결해야되나? 생각했다.
* */

/*
* 어제 늦게자서 그런지 머리가 제대로 안굴러간다 ㅡㅡ
* 결국 해설보고 해결.
* */

class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/투포인터/두용액/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        Integer board[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(board);
//        Arrays.sort(board, (o1, o2) -> {
//            return Math.abs(o1) - Math.abs(o2);
//        });
//        Arrays.sort(board, (o1, o2) -> {
//            return Math.abs(o2) - Math.abs(o1);
//        });

        int left = 0;
        int right = n -1;
        long diff = Integer.MAX_VALUE;
        long answer1 = 0;
        long answer2 = 0;

        while(left < right){
            long sum = board[left] + board[right];

            if(Math.abs(sum) < diff){
                diff = Math.abs(sum);
                answer1 = board[left];
                answer2 = board[right];
            }

            if(sum <= 0){
                left++;
            }else {
                right--;
            }
        }


        System.out.print("" + answer1 + " " + answer2);
    }

}
