package com.ps.백준.문자열.염색체;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/문자열/염색체/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");

//        [A-F]?A+F+C+[A-F]?

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            String s = br.readLine();
            boolean matches = s.matches("[A-F]?A+F+C+[A-F]?");
            if(matches){
                System.out.println("Infected!");
            }else {
                System.out.println("Good");
            }
        }
    }

}
