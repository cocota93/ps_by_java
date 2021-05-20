package com.ps.프로그래머스.level1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 다트_게임 {

    static class ChanceResult {
        int score;
        String bonus;
        String option;

        public ChanceResult(int score, String bonus, String option) {
            this.score = score;
            this.bonus = bonus;
            this.option = option;
        }
    }

    public int solution(String dartResult) {
        Matcher matcher = Pattern.compile("([0-9]{1,2})([A-Z])([#*]?)").matcher(dartResult);
        ChanceResult[] chanceResults = new ChanceResult[3];

        int chanceIdx = 0;
        while(matcher.find()){
            int literalScore = Integer.parseInt(matcher.group(1));
            String bonus = matcher.group(2);
            String option = matcher.group(3);

            chanceResults[chanceIdx] = new ChanceResult(literalScore,bonus, option);
            chanceIdx++;
        }

        for (int i = 0; i < chanceResults.length; i++) {
            chanceResults[i].score = calBonus(chanceResults[i].score, chanceResults[i].bonus);
            if(chanceResults[i].option.equals("*")){
                if(i > 0) chanceResults[i - 1].score *= 2;
                chanceResults[i].score *= 2;
            }else if(chanceResults[i].option.equals("#")){
                chanceResults[i].score *= -1;
            }
        }


        int answer = 0;
        for (int i = 0; i < chanceResults.length; i++) {
            answer += chanceResults[i].score;
        }

        System.out.println(answer);
        return answer;

    }

    private int calBonus(int score, String s) {
        Double result = 0.0;
        if("S".equals(s)){
            result = Math.pow(score, 1);
        }else if("D".equals(s)){
            result = Math.pow(score, 2);
        }else if("T".equals(s)){
            result = Math.pow(score, 3);
        }

        return result.intValue();
    }

    public static void main(String[] args) {
        다트_게임 proposal = new 다트_게임();

//        proposal.solution("1S2D*3T");
        proposal.solution("1D2S#10S");
    }

}
