package com.ps.프로그래머스.level2.풀지못한문제;

import java.util.ArrayList;
import java.util.List;

public class 괄호변환 {

    public String solution(String p) {
        if(p.isEmpty()){
            return "";
        }

        String u = p;
        String v = "";

//        if(checkBestAnswer(u)){
//            List<String> parseResult = parseBalanceString(v);
//            u = parseResult.get(0);
//            v = parseResult.get(1);
//        }else{
//
//        }


        String answer = "";
        return answer;
    }

    public List<String> parseBalanceString(String s){
        char[] chars = s.toCharArray();
        StringBuilder sm = new StringBuilder();;
        int balanceScore = 0;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            sm.append(chars[i]);

            if(chars[i] == '('){
                balanceScore++;
            }else{
                balanceScore--;
            }

            if(balanceScore == 0){
                result.add(sm.toString());

                if(i + 1 < chars.length){
                    result.add(s.substring(i + 1));
                }else{
                    result.add("");
                }
                break;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        괄호변환 proposal = new 괄호변환();

        proposal.solution("(()())()");
    }

}
