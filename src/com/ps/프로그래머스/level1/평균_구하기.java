package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 평균_구하기 {

    public double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }

    public static void main(String[] args) {
        평균_구하기 proposal = new 평균_구하기();

        int input[] = {1, 2, 3, 4};
        proposal.solution(input);
    }

}
