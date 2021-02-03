package com.ps.백준.완전탐색.n과m_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {

    static int m;
    static int n;
    static boolean useNumber[];
    static int makedNumber[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/n과m_4/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
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
            }
            sb.append("\n");

            return;
        }


        for (int i = 0; i < useNumber.length; i++) {
            if(depth != 0 && makedNumber[depth - 1] > i + 1) continue;

            makedNumber[depth] = i + 1;
            Recur(depth + 1);
        }

    }

}
