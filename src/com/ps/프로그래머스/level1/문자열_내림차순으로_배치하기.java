package com.ps.프로그래머스.level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class 문자열_내림차순으로_배치하기 {

//    public String solution(String s) {
//        String[] fixedInput = s.split("");
//        String result = Arrays.stream(fixedInput)
//                .sorted(((o1, o2) -> o2.compareTo(o1)))
//                .collect(Collectors.joining());
//        return result;
//    }

    public String solution(String s) {
//        char[] fixedInput = s.toCharArray();
//        Arrays.sort(fixedInput);
//
//        StringBuilder sm = new StringBuilder(new String(fixedInput));
//        return sm.reverse().toString();

        String[] fixedInput = s.split("");
        String result = Arrays.stream(fixedInput)
                .sorted((Comparator.reverseOrder()))
                .collect(Collectors.joining());
        return result;
    }

    public static void main(String[] args) {
        문자열_내림차순으로_배치하기 proposal = new 문자열_내림차순으로_배치하기();

        String input = "ca";
        String result = proposal.solution(input);
        System.out.println(result);
    }

}
