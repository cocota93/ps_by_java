package com.ps.swea.level1.자릿수더하기;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level1/자릿수더하기/input.txt"));
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum  = 0;
        for(;num != 0;){
            int etc = num % 10;
            num /= 10;
            sum += etc;
        }
        System.out.println(sum);
    }

}
