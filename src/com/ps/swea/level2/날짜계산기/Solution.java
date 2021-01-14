package com.ps.swea.level2.날짜계산기;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level2/날짜계산기/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            int month1 = sc.nextInt();
            int day1 = sc.nextInt();

            int month2 = sc.nextInt();
            int day2 = sc.nextInt();

            LocalDate start = LocalDate.of(2019, month1, day1);
            LocalDate dest = LocalDate.of(2019, month2, day2);

            long between = ChronoUnit.DAYS.between(start, dest) + 1;

            System.out.printf("#%d ", test_case);
            System.out.printf("%d", between);
            System.out.printf("\n");
        }
    }

}
