package com.ps.프로그래머스.level1;

import java.util.Arrays;
import java.util.Comparator;

public class 제일_작은_수_제거하기 {

    public int[] solution(int[] arr) {
        if(arr.length == 1){
            return new int[]{-1};
        }

        int minValue = Arrays.stream(arr).min().getAsInt();
        int[] result = Arrays.stream(arr).filter(value -> value != minValue).toArray();

        return result;
    }

    public static void main(String[] args) {
        제일_작은_수_제거하기 proposal = new 제일_작은_수_제거하기();

        int input[] = {3,4,1,2};
        int[] result = proposal.solution(input);
        System.out.println(Arrays.toString(result));
    }

}
