package com.ps.인프런.stringarray;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {


    public static Integer[] solution(int[] input) {
        Stack<Integer> tempStack = new Stack<>();
        Integer[] result = new Integer[input.length];

        for (int i = 0; i < input.length; i++) {
            tempStack.clear();
            for (int j = i; j < input.length; j++) {

                if(tempStack.empty()){
                    tempStack.push(input[j]);
                    continue;
                }

                if(input[i] < input[j]){
                    result[i] = tempStack.size();
                    break;
                }

                tempStack.push(input[j]);
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int[] input = {73, 74, 75, 71, 69, 72, 76, 73};
        Integer[] solution = solution(input);
        System.out.println(Arrays.toString(solution));
    }

}
