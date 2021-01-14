package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 문자열_다루기_기본 {

    public boolean solution(String s) {
        int length = s.length();
        if(length != 4 && length != 6){
            return false;
        }

        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(Character.isLetter(c)){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        문자열_다루기_기본 proposal = new 문자열_다루기_기본();

        String input = "a234";
        proposal.solution(input);
    }

}
