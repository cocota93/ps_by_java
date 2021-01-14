package com.ps.swea.level2.두개의_숫자열;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level2/두개의_숫자열/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<Integer> shortedList = new ArrayList<>();
            List<Integer> longList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                if(n < m){
                    shortedList.add(val);
                } else{
                    longList.add(val);
                }
            }

            for (int i = 0; i < m; i++) {
                int val = sc.nextInt();
                if(n > m){
                    shortedList.add(val);
                } else{
                    longList.add(val);
                }
            }


            int result = 0;
            int maxLength = Math.max(n, m);
            int minLength = Math.min(n, m);
            for (int i = 0; i < maxLength - minLength + 1; i++) {
                int sum = 0;
                for (int j = 0; j < minLength; j++) {
                    sum += longList.get(i + j) * shortedList.get(j);
                }

                result = Math.max(result, sum);
            }





            System.out.printf("#%d ", test_case);
            System.out.printf("%d", result);
            System.out.printf("\n");
        }
    }

}
