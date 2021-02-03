package com.ps.백준.완전탐색.n과m_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {
    static int n;
    static int m;
    static boolean useNumber[];
    static int makedNumber[];

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/n과m_3/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());//n까지의 자연수
        m = Integer.parseInt(st.nextToken());//길이가m인 수열
        useNumber = new boolean[n];
        makedNumber = new int[m];

        int depth = 0;
        Recur(depth);

        System.out.println(sb.toString());
    }

    private static void Recur(int depth) {
        if (depth == makedNumber.length) {

            for (int i = 0; i < makedNumber.length; i++) {
                sb.append(makedNumber[i] + " ");
//                System.out.print(makedNumber[i] + " ");
            }
            sb.append("\n");
//            System.out.println();
            return;
        }

        for (int i = 0; i < useNumber.length; i++) {

            makedNumber[depth] = i + 1;
            Recur(depth + 1);
        }

    }

}
