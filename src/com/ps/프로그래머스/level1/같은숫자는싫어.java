package com.ps.프로그래머스.level1;

import java.util.*;
import java.util.stream.Collectors;

public class 같은숫자는싫어 {


    public int[] solution(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int old = arr[0];
        result.add(old);
        for (int i = 1; i < arr.length; i++) {
            if(old != arr[i]){
                result.add(arr[i]);
                old = arr[i];
            }
        }



        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        같은숫자는싫어 proposal = new 같은숫자는싫어();

        int input[] = {1,1,3,3,0,1,1};
        int[] result = proposal.solution(input);
        System.out.println(Arrays.toString(result));
    }

}
