package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 핸드폰_번호_가리기 {

    public String solution(String phone_number) {
        StringBuilder sm = new StringBuilder(phone_number.length());
        for (int i = 0; i < phone_number.length() - 4; i++) {
            sm.append("*");
        }
        sm.append(phone_number.substring(phone_number.length() - 4, phone_number.length()));
        return sm.toString();
    }

    public static void main(String[] args) {
        핸드폰_번호_가리기 proposal = new 핸드폰_번호_가리기();

        String result = proposal.solution("01033334444");
        System.out.println(result);
    }

}
