package com.ps.프로그래머스.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 약수의합 {

    public int solution(int n) {
        int answer = 0;
        for(int i =1 ; i <= n; ++i){
            if(n % i == 0){
                answer += i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        약수의합 proposal = new 약수의합();

        int result = proposal.solution(12);
        System.out.println(result);
    }

}
