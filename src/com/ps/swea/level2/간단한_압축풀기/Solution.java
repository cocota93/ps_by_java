package com.ps.swea.level2.간단한_압축풀기;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level2/간단한_압축풀기/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            int n = sc.nextInt();
            System.out.printf("#%d ", test_case);
            System.out.println("");


            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                String packChar = sc.next();
                int packCount = sc.nextInt();

                for (int j = 0; j < packCount; j++) {
                    sb.append(packChar);
                }
            }

            String fullString = sb.toString();
            for (int i = 0; i < fullString.length(); i += 10) {
                String line = fullString.substring(i, Math.min(i + 10, fullString.length()));
                System.out.println(line);
            }


//            System.out.printf("\n");
        }
    }

}
