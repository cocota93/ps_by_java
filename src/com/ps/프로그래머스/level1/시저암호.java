package com.ps.프로그래머스.level1;

import java.util.stream.Stream;

public class 시저암호 {

    public String solution(String s, int n) {
        char[] fixedInput = s.toCharArray();
        for(int i = 0; i < fixedInput.length; ++i){
            if(fixedInput[i] == ' ')
                continue;

            if(Character.isUpperCase(fixedInput[i])){
                fixedInput[i] = (char) (fixedInput[i] + n);
                if(fixedInput[i] > 'Z'){
                    int etc = fixedInput[i] % 'Z';
                    fixedInput[i] = (char) ('A' -1 + etc);
                }
            }else{
                fixedInput[i] = (char) (fixedInput[i] + n);
                if(fixedInput[i] > 'z'){
                    int etc = fixedInput[i] % 'z';
                    fixedInput[i] = (char) ('a' -1 + etc);
                }
            }
        }

        String result = Stream.of(fixedInput)
                .map(String::valueOf)
                .reduce((old, cur) -> old + cur)
                .orElse("");
        return result;
    }

    public static void main(String[] args) {
        시저암호 proposal = new 시저암호();

        String s = "AB";
        int n = 1;
        String result = proposal.solution(s, n);
        System.out.println(result);
    }

}
