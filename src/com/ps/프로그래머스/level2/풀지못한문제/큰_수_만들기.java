package com.ps.프로그래머스.level2.풀지못한문제;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class 큰_수_만들기 {


    public String solution(String number, int k) {
        String[] split = number.split("");
        Map<String, Long> collect = Arrays.stream(split).collect(Collectors.groupingBy(o -> o, Collectors.counting()));


        String answer = "";
        return answer;
    }

    public static void main(String[] args) {
        큰_수_만들기 proposal = new 큰_수_만들기();

        proposal.solution("1924", 2);
    }

}
