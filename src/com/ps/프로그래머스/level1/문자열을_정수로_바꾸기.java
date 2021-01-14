package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 문자열을_정수로_바꾸기 {

    public int solution(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        문자열을_정수로_바꾸기 proposal = new 문자열을_정수로_바꾸기();

        String s = "-1234";
        proposal.solution(s);
    }

}
