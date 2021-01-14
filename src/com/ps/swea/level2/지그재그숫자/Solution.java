package com.ps.swea.level2.지그재그숫자;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level2/지그재그숫자/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            int target = sc.nextInt();
            int result = 0;
            for (int i = 1; i <= target; i++) {
                if(i % 2 != 0){
                    result += i;
                }else{
                    result -= i;
                }
            }


            System.out.printf("#%d ", test_case);
            System.out.printf("%d", result);
            System.out.printf("\n");
        }
    }

}
