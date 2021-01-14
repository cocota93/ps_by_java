package com.ps.swea.level2.중간평균값구하기;

import java.util.*;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/swea/level2/중간평균값구하기/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        sc.nextLine();

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...

            List<Integer> input = new ArrayList<>();
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            for (String s2 : s1) {
                input.add(Integer.valueOf(s2));
            }

            Integer max = input.stream().max(Comparator.comparingInt(Integer::intValue)).get();
            Integer min = input.stream().min(Comparator.comparingInt(Integer::intValue)).get();
            Double avg = input.stream().filter(obj -> obj != max && obj != min).mapToInt(Integer::intValue).average().getAsDouble();


            System.out.println(avg);


            System.out.printf("#%d ", test_case);
            System.out.printf("%d", Math.round(avg * 1));
            System.out.printf("\n");
        }
    }

}
