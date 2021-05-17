package com.ps.백준.문자열.밀비급일;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/문자열/밀비급일/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true){
            String inputString = br.readLine();
            if(inputString.equals("END")) break;

            StringBuilder sb = new StringBuilder(inputString);
            sb.reverse();
            System.out.println(sb);
        }
    }

}
