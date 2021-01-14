package com.ps.swea.level1.큰놈_작은놈_같은놈;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/swea/level1/큰놈_작은놈_같은놈/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();


            System.out.printf("#%d ", test_case);
            if(num1 == num2){
                System.out.printf("=");
            }else if(num1 > num2){
                System.out.printf(">");
            }else{
                System.out.printf("<");
            }
            System.out.printf("\n");
        }
    }

}
