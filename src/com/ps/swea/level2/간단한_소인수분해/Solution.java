package com.ps.swea.level2.간단한_소인수분해;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level2/간단한_소인수분해/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            int n = sc.nextInt();
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            int e = 0;

            for(;n % 2 == 0; n /= 2) a++;
            for(;n % 3 == 0; n /= 3) b++;
            for(;n % 5 == 0; n /= 5) c++;
            for(;n % 7 == 0; n /= 7) d++;
            for(;n % 11 == 0; n /= 11) e++;


            System.out.printf("#%d ", test_case);
            System.out.printf("%d %d %d %d %d", a, b, c, d, e);
            System.out.printf("\n");
        }
    }

}
