package com.ps.샘플코드.진법변환;

import java.util.Arrays;

public class 진법변환 {


    public void solution() {
        //10진수 -> n진수
        int n = 3;
        int target = 17;
        String toN_Number = Integer.toString(target, n);
        System.out.println(target + "(10) -> " + toN_Number + "(" + n + ")");

        //10진수 -> 2진수
        String to2_Number = Integer.toBinaryString(target);
        System.out.println(target + "(10) -> " + to2_Number + "(2)");

        //10진수 -> 8진수
        String to8_Number = Integer.toOctalString(target);
        System.out.println(target + "(10) -> " + to8_Number + "(8)");

        //10진수 -> 16진수
        String to16_Number = Integer.toHexString(target);
        System.out.println(target + "(10) -> " + to16_Number + "(16)");



        //n진수 -> 10진수
        int fromN_Number = Integer.parseInt(toN_Number, n);
        System.out.println(target + "(10) -> " + toN_Number + "(" + n + ")");
    }

    public static void main(String[] args) {
        진법변환 proposal = new 진법변환();

        proposal.solution();
    }

}
