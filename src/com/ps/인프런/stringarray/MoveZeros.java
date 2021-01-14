package com.ps.인프런.stringarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MoveZeros {

    public static int[] solution(int[] input) {

        int progress = 0;
        for (int i = 0; i < input.length; i++) {
            if(input[i] == 0) continue;

            input[progress] = input[i];
            progress++;
        }

        for(; progress < input.length; ++progress){
            input[progress] = 0;
        }

        return input;
    }

    public static void main(String[] args) {
        int[] input = {0,3,2,0,8,5};
        int[] result = solution(input);
        System.out.println(Arrays.toString(result));
    }
}
