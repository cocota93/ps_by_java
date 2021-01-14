package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 자릿수_더하기 {

    public int solution(int n) {
        String fixedInput = Integer.toString(n);
        String[] split = fixedInput.split("");
        int result = 0;
        for (String s : split) {
            int value = Integer.parseInt(s);
            result += value;
        }

        return result;
    }

    public static void main(String[] args) {
        자릿수_더하기 proposal = new 자릿수_더하기();


        int result = proposal.solution(123);
        System.out.println(result);
    }

}
