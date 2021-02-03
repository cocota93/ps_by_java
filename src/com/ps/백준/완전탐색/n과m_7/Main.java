package com.ps.백준.완전탐색.n과m_7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {

    static int n;
    static int m;
    static int numberCard[];

    static int makedNumber[];
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/n과m_7/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numberCard = new int[n];
        makedNumber = new int[m];

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            numberCard[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numberCard);


        int depth = 0;
        Recur(depth);

        System.out.println(sb.toString());

    }

    private static void Recur(int depth) {
        if (depth == makedNumber.length) {
            for (int i = 0; i < makedNumber.length; i++) {
                sb.append(makedNumber[i] + " ");
            }
            sb.append("\n");

            return;
        }


        for (int i = 0; i < numberCard.length; i++) {
            makedNumber[depth] = numberCard[i];
            Recur(depth + 1);
        }

    }
}
