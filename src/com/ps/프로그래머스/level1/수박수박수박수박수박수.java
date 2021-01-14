package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 수박수박수박수박수박수 {


    public String solution(int n) {
        StringBuilder sm = new StringBuilder();

        for(int i = 1; i < n; i = i + 2){
            sm.append("수박");
        }

        if(n % 2 != 0){
            sm.append("수");
        }

        return sm.toString();
    }

    public static void main(String[] args) {
        수박수박수박수박수박수 proposal = new 수박수박수박수박수박수();

        proposal.solution(3);
    }

}
