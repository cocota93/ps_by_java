package com.ps.프로그래머스.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 이상한_문자_만들기 {

    public String solution(String s) {
        List<String> tokenList = new ArrayList<>();

        String[] s1 = s.split(" ", -1);//요 -1이 엄청 중요하네.만약 인풋의 맨뒤에 공백이 있을때 -1안넣으면 트림처리됨.
        for (int i = 0; i < s1.length; i++) {
            String[] s2 = s1[i].split("");
            for (int j = 0; j < s2.length; j++) {
                if(j % 2 == 0){
                    s2[j] = s2[j].toUpperCase();
                }else{
                    s2[j] = s2[j].toLowerCase();
                }
            }

            String collect = Arrays.stream(s2).collect(Collectors.joining());
            tokenList.add(collect);
        }

        return tokenList.stream().collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        이상한_문자_만들기 proposal = new 이상한_문자_만들기();


        String result = proposal.solution(" try hello world ");
        System.out.println(result);
    }

}
