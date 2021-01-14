package com.ps.swea.level1.더블더블;

import java.util.Scanner;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level1/더블더블/input.txt"));
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();

        for (int i = 0; i <= num1; i++) {

            System.out.printf("%d ", Math.round(Math.pow(2, i)));
        }

    }

}
