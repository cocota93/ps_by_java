package com.ps.백준.DP._1로만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;




class Main {
    static int memo[];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/_1로만들기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 0;
        for (int i = 2; i < memo.length; i++) {
            memo[i] = memo[i - 1] + 1;

//            if(i % 6 == 0){
//                memo[i] = Math.min(memo[i], memo[i / 2] + 1);
//                memo[i] = Math.min(memo[i], memo[i / 3] + 1);
//            } else
//
            if(i % 2 == 0) {
                memo[i] = Math.min(memo[i], memo[i / 2] + 1);
            }

            if(i % 3 == 0) {
                memo[i] = Math.min(memo[i], memo[i / 3] + 1);
            }

//            System.out.println(Arrays.toString(memo));
        }



        System.out.println(memo[n]);
    }

}
