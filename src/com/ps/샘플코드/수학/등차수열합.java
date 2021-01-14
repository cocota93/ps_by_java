package com.ps.샘플코드.수학;

import java.util.Arrays;

public class 등차수열합 {


    public int solution(int a, int d, int n){
        int last = a + (n - 1) * d;
        int result = n * (a + last) / 2;

        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        등차수열합 proposal = new 등차수열합();

        proposal.solution(1, 1, 1);
        proposal.solution(1, 1, 2);
        proposal.solution(1, 1, 3);
        proposal.solution(1, 1, 4);
        proposal.solution(1, 1, 5);
        proposal.solution(1, 1, 6);
        proposal.solution(1, 1, 7);
        proposal.solution(1, 1, 8);
        proposal.solution(1, 1, 9);
        proposal.solution(1, 1, 10);
    }

}
