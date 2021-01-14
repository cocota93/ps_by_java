package com.ps.swea.level1.홀수만더하기;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/swea/level1/홀수만더하기/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 0; test_case < T; ++test_case){
            int sum = 0;
            int input[] = new int[10];
            for (int j = 0; j < input.length; j++) {
                input[j] = sc.nextInt();
                if(input[j] % 2 == 1){
                    sum += input[j];
                }
            }

            System.out.println("#" + (test_case + 1) + " " + sum);
        }
    }

}
