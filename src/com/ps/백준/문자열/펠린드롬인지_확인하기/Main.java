package com.ps.백준.문자열.펠린드롬인지_확인하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/문자열/펠린드롬인지_확인하기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine(), " ");

        String s = br.readLine();
        char[] originCharArray = s.toCharArray();

        boolean isFelindrome = true;
        for (int i = 0; i < originCharArray.length; i++) {
            if(originCharArray[i] != originCharArray[originCharArray.length - 1 - i]){
                isFelindrome = false;
                break;
            }
        }

        System.out.println(isFelindrome ? 1 : 0);
    }


}
