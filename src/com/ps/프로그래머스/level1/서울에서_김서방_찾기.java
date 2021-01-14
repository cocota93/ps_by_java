package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 서울에서_김서방_찾기 {

    public String solution(String[] seoul) {
        String answer = "";

        for (int i = 0; i < seoul.length; i++) {
            if("Kim".equals(seoul[i])){
                answer = "김서방은 " + i + "에 있다";
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        서울에서_김서방_찾기 proposal = new 서울에서_김서방_찾기();

        String input[] = {"Jane", "Kim"};
        proposal.solution(input);
    }

}
