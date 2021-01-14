package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 내적 {

    public int solution(int[] a, int[] b) {
        int length = a.length;
        int answer = 0;

        for(int i = 0; i < length; ++i){
            answer += a[i] * b[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        내적 proposal = new 내적();

        int a[] = {1,2,3,4};
        int b[] = {-3,-1,0,2};
        int result = proposal.solution(a, b);
        System.out.println(result);
    }

}
