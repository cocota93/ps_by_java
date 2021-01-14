package com.ps.swea.level2.간단한369게임;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level2/간단한369게임/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            String result = "" + test_case;

            boolean isClap = result.chars().anyMatch(obj -> obj == '3' || obj == '6' || obj == '9');
            if(isClap){
                int clapCount = 0;
                {
                    int targetNum = test_case;
                    for(;targetNum != 0;){
                        int targetNumEtc = targetNum % 10;
                        if(targetNumEtc == 3 || targetNumEtc == 6 || targetNumEtc == 9 ){
                            clapCount++;
                        }
                        targetNum /= 10;
                    }
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < clapCount; i++) {
                    sb.append("-");
                }

                result = sb.toString();
            }

            System.out.printf("%s ", result);
        }
    }

}
