package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 정수_제곱근_판별 {


    public long solution(long n) {
        Double sqrt = Math.sqrt(n);
        if(n == sqrt.longValue() * sqrt.longValue()){
            Double result = Math.pow(sqrt.longValue() + 1, 2);
            return result.longValue();
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        정수_제곱근_판별 proposal = new 정수_제곱근_판별();

        long result = proposal.solution(121);
        System.out.println(result);
    }

}
