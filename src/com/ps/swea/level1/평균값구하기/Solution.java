package com.ps.swea.level1.평균값구하기;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/swea/level1/평균값구하기/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 0; test_case < T; ++test_case) {
            int row[] = new int[10];
            for (int i = 0; i < row.length; i++) {
                row[i] = sc.nextInt();
            }

            double asDouble = Math.round(Arrays.stream(row).average().getAsDouble());
            System.out.println("#" + (test_case + 1) + " " + (int)asDouble);
        }

    }

}
