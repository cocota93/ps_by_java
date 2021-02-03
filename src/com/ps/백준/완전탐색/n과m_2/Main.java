package com.ps.백준.완전탐색.n과m_2;

import java.beans.DefaultPersistenceDelegate;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {
    static int m;
    static int n;

    static boolean useNumber[];
    static int makeNumber[];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/n과m_2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        useNumber = new boolean[n];
        makeNumber = new int[m];

        int depth = 0;
        Recur(depth);
    }

    private static void Recur(int depth) {
        if(depth == makeNumber.length){

            for (int i = 0; i < makeNumber.length; i++) {
                System.out.print(makeNumber[i] + " ");
            }
            System.out.println();
            return;
        }


        for (int i = 0; i < n; i++) {
            if(useNumber[i]) continue;
            int makingNum = i + 1;
            if(depth != 0 && makeNumber[depth - 1] > makingNum) continue;

            useNumber[i] = true;
            makeNumber[depth] = makingNum;
            Recur(depth + 1);
            useNumber[i] = false;
        }

    }

}
