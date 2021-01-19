package com.ps.샘플코드.조합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 재귀를이용한_브루트포스 {


    private static int solution(int curN, int limitN, int[] makeNumber) {
        if(curN == limitN){
            System.out.println(Arrays.toString(makeNumber));
            return 1;
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            makeNumber[curN] = i;
            result += solution(curN + 1, limitN, makeNumber);
        }

        return result;
    }

    public static void main(String[] args) {
        재귀를이용한_브루트포스 proposal = new 재귀를이용한_브루트포스();

        int limit = 110;
        String s = String.valueOf(limit);
        int makeNumber[] = new int[s.length()];
        int result = solution(0, s.length(), makeNumber);

    }

}
