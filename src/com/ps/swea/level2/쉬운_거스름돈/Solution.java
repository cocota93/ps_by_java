package com.ps.swea.level2.쉬운_거스름돈;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/swea/level2/쉬운_거스름돈/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            List<Integer> result = new ArrayList<>();
            int targetCost = sc.nextInt();

            result.add(targetCost / 50000);
            targetCost = targetCost % 50000;
            result.add(targetCost / 10000);
            targetCost = targetCost % 10000;
            result.add(targetCost / 5000);
            targetCost = targetCost % 5000;
            result.add(targetCost / 1000);
            targetCost = targetCost % 1000;
            result.add(targetCost / 500);
            targetCost = targetCost % 500;
            result.add(targetCost / 100);
            targetCost = targetCost % 100;
            result.add(targetCost / 50);
            targetCost = targetCost % 50;
            result.add(targetCost / 10);
            targetCost = targetCost % 10;

            System.out.printf("#%d ", test_case);
            System.out.println("");
            result.stream().forEach(obj -> System.out.printf("%d ", obj));
            System.out.printf("\n");
        }
    }

}
