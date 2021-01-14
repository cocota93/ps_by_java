package com.ps.swea.level2.초심자의회문검사;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/swea/level2/초심자의회문검사/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            String input = sc.next();

            int result = 1;
            char[] fixedInput = input.toCharArray();
            for (int i = 0; i < fixedInput.length; i++) {
                if(fixedInput[i] != fixedInput[(fixedInput.length - 1) - i]){
                    result = 0;
                    break;
                }
            }


            System.out.printf("#%d ", test_case);
            System.out.printf("%d ", result);
            System.out.printf("\n");
        }
    }

}
