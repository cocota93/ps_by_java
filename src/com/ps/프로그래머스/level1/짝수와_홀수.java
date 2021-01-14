package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 짝수와_홀수 {

    public String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }

    public static void main(String[] args) {
        짝수와_홀수 proposal = new 짝수와_홀수();

        proposal.solution(3);
    }

}
