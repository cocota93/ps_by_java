package com.ps.프로그래머스.level2;

import java.util.Arrays;

public class 전화번호_목록 {

    public boolean solution(String[] phone_book) {
        for (int i = 0; i <phone_book.length; i++) {
            for (int j = 0; j < phone_book.length; j++) {
                if(phone_book[i].length() > phone_book[j].length()){
                    continue;
                }
                if(i == j) continue;

                int endIndex = phone_book[i].length();
                String head = phone_book[j].substring(0, endIndex);
                if(head.equals(phone_book[i])){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        전화번호_목록 proposal = new 전화번호_목록();

//        String input[] = {"123", "456", "789"};
        String input[] = {"119", "97674223", "1195524421"};
        boolean solution = proposal.solution(input);
        System.out.println(solution);
    }

}
