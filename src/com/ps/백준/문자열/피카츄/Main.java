package com.ps.백준.문자열.피카츄;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static String pi = "pi";
    static String ka = "ka";
    static String chu = "chu";

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/문자열/피카츄/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");

        String s = br.readLine();
        char[] chars = s.toCharArray();
        boolean answer = true;
        for (int i = 0; i < chars.length; ) {
            if(pi.compareTo(new String(chars, i, Math.min(pi.length(), chars.length - i))) == 0){
                i += pi.length();
            }else if(ka.compareTo(new String(chars, i, Math.min(ka.length(), chars.length - i))) == 0){
                i += ka.length();
            }else if(chu.compareTo(new String(chars, i, Math.min(chu.length(), chars.length - i))) == 0){
                i += chu.length();
            }else {
                answer = false;
                break;
            }
        }


        if(answer){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

}
