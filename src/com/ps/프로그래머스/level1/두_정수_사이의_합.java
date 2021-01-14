package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 두_정수_사이의_합 {


    public long solution(int a, int b) {
        long answer = 0;

        int n = Math.max(a, b) - Math.min(a, b) + 1;
        answer = n * (a + b) / 2;

        return answer;
    }

    public static void main(String[] args) {
        두_정수_사이의_합 proposal = new 두_정수_사이의_합();


        proposal.solution(3, 5);
    }

}
