package com.ps.프로그래머스.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class H인덱스 {


    public int solution(int[] input) {
        List<Integer> list = Arrays.stream(input).boxed().collect(Collectors.toList());
        Integer length = Collections.max(list);


        int result = 0;
        for (int i = 0; i <= 1000; i++) {
            int h = i;
            long count = list.stream().filter(obj -> obj >= h).count();

            if(h <= count){
                result = Math.max(result,h);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        H인덱스 proposal = new H인덱스();

        int input[] = {3, 0, 6, 1, 5};
        int result = proposal.solution(input);
        System.out.println(result);
    }

}
