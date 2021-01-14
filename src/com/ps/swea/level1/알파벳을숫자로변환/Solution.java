package com.ps.swea.level1.알파벳을숫자로변환;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level1/알파벳을숫자로변환/input.txt"));
        Scanner sc = new Scanner(System.in);
        String input;
        input = sc.next();

        char[] chars = input.toCharArray();

        for (char alpha : chars) {
            System.out.printf("%d ", alpha - 'A' + 1);
        }

    }

}
