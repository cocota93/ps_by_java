package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 가운데_글자_가져오기 {


    public String solution(String s) {
        int beginIndex = (s.length() - 1) / 2;
        int cutSize = (s.length() / 2) + 1;
        String result = s.substring(beginIndex, cutSize);
        return result;
    }

    public static void main(String[] args) {
        가운데_글자_가져오기 proposal = new 가운데_글자_가져오기();

        String s = "abcde";
//        String s = "qwer";
        String result = proposal.solution(s);
        System.out.println(result);
    }

}
