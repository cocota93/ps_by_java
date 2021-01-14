package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class x만큼_간격이_있는_n개의_숫자 {

    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        long old = 0;
        for (int i = 0; i < n; i++) {
            answer[i] = old + x;
            old = answer[i];
        }


//아래처럼 짠사람도 있는데 참 깔끔한것같다.
//        for(int i = 0; i < n; i++){
//            answer[i] = x * (i + 1);
//        }

        return answer;
    }

    public static void main(String[] args) {
        x만큼_간격이_있는_n개의_숫자 proposal = new x만큼_간격이_있는_n개의_숫자();

        long[] result = proposal.solution(2, 5);
        System.out.println(Arrays.toString(result));
    }

}
