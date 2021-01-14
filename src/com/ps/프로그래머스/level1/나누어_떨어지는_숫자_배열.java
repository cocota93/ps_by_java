package com.ps.프로그래머스.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 나누어_떨어지는_숫자_배열 {


    public int[] solution(int[] arr, int divisor) {
        List<Integer> result = new ArrayList<>();
        for (int i : arr) {
            if(i % divisor == 0){
                result.add(i);
            }
        }

        if(result.isEmpty()){
            result.add(-1);
        }

        result.sort(Comparator.comparingInt(value -> value));

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        나누어_떨어지는_숫자_배열 proposal = new 나누어_떨어지는_숫자_배열();

        int input[] = {5, 9, 7, 10};
        int divisor = 5;
        proposal.solution(input, divisor);
    }

}
