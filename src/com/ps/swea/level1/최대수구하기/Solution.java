package com.ps.swea.level1.최대수구하기;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("src/com/ps/swea/level1/최대수구하기/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            int max = 0;
            for (int i = 0; i < 10; i++) {
                int temp = sc.nextInt();
                max = Math.max(max,temp);
            }

            System.out.printf("#%d ", test_case);
            System.out.printf("%d", max);
            System.out.printf("\n");
        }
    }

}
