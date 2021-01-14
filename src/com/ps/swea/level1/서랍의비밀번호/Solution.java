package com.ps.swea.level1.서랍의비밀번호;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level1/서랍의비밀번호/input.txt"));
        Scanner sc = new Scanner(System.in);
        int target;
        target = sc.nextInt();
        int initNumber = sc.nextInt();


        System.out.println(target - initNumber + 1);
    }

}
