package com.ps.swea.level1.아주간단계산기;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level1/아주간단계산기/input.txt"));
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println(num1 + num2);
        System.out.println(num1 - num2);
        System.out.println(num1 * num2);
        System.out.println(num1 / num2);
    }

}
