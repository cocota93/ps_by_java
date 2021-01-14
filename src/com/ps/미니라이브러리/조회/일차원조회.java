package com.ps.미니라이브러리.조회;

import java.util.Arrays;

public class 일차원조회 {


    public int[] solution(int[] input) {
        int fixedInput[] = new int[input.length + 2];
        fixedInput[0] = fixedInput[fixedInput.length - 1] = -1;
        for (int i = 1; i <= input.length; i++) {
            fixedInput[i] = input[i - 1];
        }

        int result[] = new int[input.length];
        for (int i = 1; i < fixedInput.length - 1; i++) {
            if(fixedInput[i - 1] == fixedInput[i] || fixedInput[i] == fixedInput[i + 1]){
                result[i - 1] = 1;
            }
        }


        System.out.println(Arrays.toString(result));
        int progress = 0;

        return input;
    }

    public static void main(String[] args) {
        일차원조회 proposal = new 일차원조회();

        int input[] = {1, 2, 3, 3, 5};
        proposal.solution(input);
    }

}
