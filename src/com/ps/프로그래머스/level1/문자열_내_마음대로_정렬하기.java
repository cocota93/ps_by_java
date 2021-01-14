package com.ps.프로그래머스.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class 문자열_내_마음대로_정렬하기 {

    public String[] solution(String[] strings, int n) {
        List<String> fixedInput = Arrays.stream(strings).collect(Collectors.toList());
//        fixedInput.sort(Comparator.comparing(obj -> obj.charAt(n)));
        fixedInput.sort(((o1, o2) -> {
            int cal = o1.charAt(n) - o2.charAt(n);
            if(cal == 0){
                return o1.compareTo(o2);
            }
            return cal;
        }));

        return fixedInput.toArray(new String[fixedInput.size()]);
    }

    public static void main(String[] args) {
        문자열_내_마음대로_정렬하기 proposal = new 문자열_내_마음대로_정렬하기();

        String input[] = {"sun", "bed", "car"};
        int n = 1;
        proposal.solution(input, n);
    }

}
