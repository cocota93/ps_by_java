package com.ps.swea.level2.시각덧셈;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/swea/level2/시각덧셈/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            int hour1 = sc.nextInt();
            int minute1 = sc.nextInt();

            int hour2 = sc.nextInt();
            int minute2 = sc.nextInt();

            int extraHour = (minute1 + minute2) / 60;
            int resultMinute = (minute1 + minute2) % 60;

            int sumHour = hour1 + hour2 + extraHour;
            int resultHour = sumHour <= 12?  (sumHour % 13) : (sumHour % 13) + 1;


            System.out.printf("#%d ", test_case);
            System.out.printf("%d %d", resultHour, resultMinute);
            System.out.printf("\n");
        }
    }

}
