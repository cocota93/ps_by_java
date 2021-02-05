package com.ps.백준.DP._1로만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;




class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/_1로만들기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        while(n > 1){
            answer++;

            if(n % 3 == 0){
                n = n / 3;
                continue;
            }

            if(n % 2 == 0 ){
                n = n / 2;
                continue;
            }

            n--;
        }

        System.out.println(answer);
    }

}
