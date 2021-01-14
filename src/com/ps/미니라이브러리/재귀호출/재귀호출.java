package com.ps.미니라이브러리.재귀호출;

import java.util.Arrays;


public class 재귀호출 {


    public void solution(int current, int maxLength, int result[]) {
        if(current >= maxLength){
            print(result);
        }else {
            for (int i = 1; i <= maxLength; i++) {
                if(isNotContaining(result, i)){
                    result[current] = i;
                    solution(current + 1, maxLength, result);
                    result[current] = 0;
                }
            }
        }
    }

    private boolean isNotContaining(int[] result, int i) {
        boolean b = Arrays.stream(result).anyMatch(o -> o == i);
        return !b;
    }

    private void print(int[] result) {
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        재귀호출 proposal = new 재귀호출();

//        int input[] = {1, 2, 3, 4};
        int input[] = new int[4];
        proposal.solution(0, input.length, input);
    }

}
