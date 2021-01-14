package com.ps.swea.level1.거꾸로출력해보아요;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level1/거꾸로출력해보아요/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int i = T; i >= 0; i--) {
            System.out.printf("%d " , i);
        }

    }

}
