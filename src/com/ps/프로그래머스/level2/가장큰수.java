package com.ps.프로그래머스.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 가장큰수 {

    public String solution(int[] numbers) {
        if(numbers.length == 1){
            return "" + numbers[0];
        }
        if(numbers.length == 0){
            return "" + 0;
        }

        List<String> fixedInput = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.toList());
        fixedInput.sort((o1, o2)-> (o2 + o1).compareTo(o1 + o2));//문자열이라서 o1 + o2 와 o2 + o1의 결과가 다른걸 이용한 소팅




        String answer = "";
        answer = fixedInput.stream().collect(Collectors.joining());
        if(answer.replace("0", "").compareTo("") == 0){
            answer = "0";
        }
        return answer;
    }

    public static void main(String[] args) {
        가장큰수 proposal = new 가장큰수();

        int input[] = {3, 30, 34, 5, 9};
        proposal.solution(input);
    }

}
