package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 자연수_뒤집어_배열로_만들기 {

    public int[] solution(long n) {
        StringBuilder sm = new StringBuilder(String.valueOf(n));
        int[] result = sm.reverse().toString().chars().map(Character::getNumericValue).toArray();//Numeric...잘기억해두면 나중에 두고두고 써먹을듯
        return result;
    }

    public static void main(String[] args) {
        자연수_뒤집어_배열로_만들기 proposal = new 자연수_뒤집어_배열로_만들기();

        int[] result = proposal.solution(12345);
        System.out.println(Arrays.toString(result));
    }

}
