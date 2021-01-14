package com.ps.프로그래머스.level1.풀지못한문제;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class 다트_게임 {

    public int solution(String dartResult) {
        dartResult = dartResult.replaceAll("\t", "");
        List<Integer> result =new ArrayList<>();

        for (int start = 0; start < dartResult.length(); ) {
//            "asd".
//            String.digit
            String asd  = "asd";
//            asd.
            String scoreSetString = dartResult.substring(start, Math.min(start + 4, dartResult.length()));
//            scoreSetString.chars().map(Character::getNumericValue).filter(value -> StringUtils)
            int score = Integer.parseInt(scoreSetString.substring(0, 2));
            score = calBonus(score, scoreSetString.substring(1, 2));

            if(hasOption(scoreSetString)){
                String option = scoreSetString.substring(2, 3);
                if("*".equals(option)){
                    if(!result.isEmpty()){
                        int lastResultValue = result.get(result.size() - 1);
                        lastResultValue *= 2;
                        result.remove(result.size() - 1);
                        result.add(lastResultValue);
                    }

                    score *= 2;

                    result.add(score);
                }else if("#".equals(option)){
                    score = score * -1;
                    result.add(score);
                }

                start += 3;
                continue;
            }

            result.add(score);
            start += 2;
        }

//        result.stream().forEach( obj -> System.out.print(obj + " "));
        int sum = result.stream().mapToInt(Integer::intValue).sum();

//        System.out.println();
        System.out.println(sum);


        return sum;
    }

    private String parseOnlyNumber(String s){
        String collect = s.chars().filter(obj -> '0' <= obj && obj <= '9').map(Character::getNumericValue).mapToObj(obj -> "" + obj).collect(Collectors.joining());
        return collect;
//        return Integer.parseInt(collect);
    }

    private boolean hasOption(String s) {
        if(s.length() != 3){
            return false;
        }

        if(!s.contains("*") && !s.contains("#")){
            return false;
        }


        return true;
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

        proposal.solution("1D2S#10S");
    }

}
