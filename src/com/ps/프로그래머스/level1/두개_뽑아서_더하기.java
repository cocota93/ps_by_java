package com.ps.프로그래머스.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 두개_뽑아서_더하기 {


    public int[] solution(int[] input) {

        Set<Integer> store = new HashSet<>();

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {

                store.add(input[i] + input[j]);
            }
        }


        int[] result = store.stream().sorted().mapToInt(Integer::intValue).toArray();
        return result;
    }

    public static void main(String[] args) {
        두개_뽑아서_더하기 proposal = new 두개_뽑아서_더하기();

//        int input[] = {2,1,3,4,1};
        int input[] = {5,0,2,7};
        int[] result = proposal.solution(input);
        System.out.println(Arrays.toString(result));
    }

}
