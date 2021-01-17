package com.ps.샘플코드.브루트포스.for문.날짜계산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/샘플코드/브루트포스/for문/날짜계산/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int destE = Integer.parseInt(st.nextToken());
        int destS = Integer.parseInt(st.nextToken());
        int destM = Integer.parseInt(st.nextToken());

        int e = 1;
        int s = 1;
        int m = 1;
        int day = 1;
        while(true){

            if(e == destE && s == destS && m == destM) break;

            e += 1;
            if(e == 16) e = 1;

            s += 1;
            if(s == 29) s = 1;

            m += 1;
            if(m == 20) m = 1;

            day++;
        }

        System.out.println(day);
    }

}
