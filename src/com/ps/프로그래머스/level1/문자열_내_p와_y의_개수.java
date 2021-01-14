package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 문자열_내_p와_y의_개수 {


    boolean solution(String s) {
        String fixedInput = s.toUpperCase();

        int pCounter = 0;
        int yCounter = 0;
        for (Character o : fixedInput.toCharArray()) {
            if(o == 'P'){
                pCounter++;
            }else if(o == 'Y'){
                yCounter++;
            }
        }


        return pCounter == yCounter;
    }

    public static void main(String[] args) {
        문자열_내_p와_y의_개수 proposal = new 문자열_내_p와_y의_개수();

        String input = "pPoooyY";
        proposal.solution(input);
    }

}
