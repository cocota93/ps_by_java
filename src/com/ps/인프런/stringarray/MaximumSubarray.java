package com.ps.인프런.stringarray;

import java.util.Arrays;

//TODO 답지보고 풀기는 했지만 비슷한 문제를 다시풀어야되면 못풀것같음.
public class MaximumSubarray {


    public int solution(int[] input) {

        int newSum = input[0];
        int prevNewSum = input[0];
        int max = input[0];

        for (int i = 1; i < input.length; i++){
            prevNewSum = newSum;
            newSum = Math.max(input[i], newSum + input[i]);
            System.out.println("preNewSum : " + prevNewSum +  ", newSum : " + newSum + ", " + "input[" + i + "] : " + input[i]);
            max = Math.max(newSum, max);
            System.out.println("max : " + max);

            System.out.println("=====");
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray proposal = new MaximumSubarray();

        int input[] = {-2,1,-3,4,-1,2,1,-5,4};
        int result = proposal.solution(input);
        System.out.println(result);
    }

}
