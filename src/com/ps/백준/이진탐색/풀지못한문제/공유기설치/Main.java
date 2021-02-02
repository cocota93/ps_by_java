package com.ps.백준.이진탐색.풀지못한문제.공유기설치;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.FileInputStream;
import java.util.StringTokenizer;


/*
* 잘이해안감.
* */

class Main {

    static int housePosContainer[];

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/이진탐색/공유기설치/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        int houseCount = Integer.parseInt(st.nextToken());
        int hubCount = Integer.parseInt(st.nextToken());
        housePosContainer = new int[houseCount];
        for (int i = 0; i < houseCount; i++) {
            int housePos = Integer.parseInt(br.readLine());
            housePosContainer[i] = housePos;
        }
        Arrays.sort(housePosContainer);

        int left = housePosContainer[0];
        int right = housePosContainer[housePosContainer.length - 1];

        while(left <= right){
            int mid = (left + right) / 2;


        }



    }

}

