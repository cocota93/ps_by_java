package com.ps.프로그래머스.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 문제_3진법뒤집기 {


    public int solution(int n) {
        String third = Integer.toString(n, 3);
        System.out.println(third);
        StringBuilder sb = new StringBuilder(third);
        String reverse = sb.reverse().toString();
        int result = 0;
        int exp = 0;
        for (int i = reverse.length() - 1; i >= 0; i--) {
            result += Integer.parseInt(String.valueOf(reverse.charAt(i))) * Math.pow(3, exp);
            exp++;
        }


        return result;
    }

    public static void main(String[] args) {
        문제_3진법뒤집기 proposal = new 문제_3진법뒤집기();

        int input = 45;
        int result = proposal.solution(input);
        System.out.println(result);
    }

}
