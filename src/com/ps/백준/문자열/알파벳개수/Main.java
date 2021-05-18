package com.ps.백준.문자열.알파벳개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/문자열/알파벳개수/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] alphaCount = new int['z' - 'a' + 1];
        String s = br.readLine();
        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            alphaCount[aChar - 'a']++;
        }

        for (int i : alphaCount) {
            System.out.print(i + " ");
        }
    }

}
