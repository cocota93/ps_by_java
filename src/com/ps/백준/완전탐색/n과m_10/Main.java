package com.ps.백준.완전탐색.n과m_10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {
    static int n;
    static int m;

    static boolean useNumber[];
    static int numberCard[];

    static int makedNumber[];

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/n과m_10/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        useNumber = new boolean[n];
        numberCard = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            numberCard[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numberCard);

        makedNumber = new int[m];

        int depth = 0;
        int frontVal = -1;
        Recur(depth, frontVal);

        System.out.println(sb.toString());
    }

    private static void Recur(int depth, int frontVal) {
        if (depth == makedNumber.length) {
            for (int val : makedNumber) {
                sb.append(val + " ");
            }
            sb.append("\n");

            return;
        }

        int prevVal = -1;
        for (int i = 0; i < numberCard.length; i++) {
            if(useNumber[i]) continue;
            if(prevVal == numberCard[i]) continue;
            if(frontVal > numberCard[i]) continue;

            useNumber[i] = true;
            makedNumber[depth] = numberCard[i];
            Recur(depth + 1, numberCard[i]);
            useNumber[i] = false;
            prevVal = numberCard[i];
        }

    }

}
