package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 정수_내림차순으로_배치하기 {

    public long solution(long n) {
        char[] fixedInput = String.valueOf(n).toCharArray();
        Arrays.sort(fixedInput);

        String sortedInput = String.valueOf(fixedInput);
        StringBuilder sm = new StringBuilder(sortedInput);
        sm.reverse();

        long result = Long.parseLong(sm.toString());
        return result;
    }

    public static void main(String[] args) {
        정수_내림차순으로_배치하기 proposal = new 정수_내림차순으로_배치하기();

        long result = proposal.solution(118372);
        System.out.println(result);
    }

}
