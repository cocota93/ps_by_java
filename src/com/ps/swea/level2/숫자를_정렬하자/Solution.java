package com.ps.swea.level2.숫자를_정렬하자;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level2/숫자를_정렬하자/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            List<Integer> list = new ArrayList<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
            list.sort(Comparator.comparingInt(Integer::intValue));

            System.out.printf("#%d ", test_case);
            list.stream().forEach(obj -> System.out.printf("%d ", obj));
            System.out.printf("\n");
        }
    }

}
