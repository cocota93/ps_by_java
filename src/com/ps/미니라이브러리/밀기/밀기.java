package com.ps.미니라이브러리.밀기;

import java.util.Arrays;

public class 밀기 {

//정방향
    public int[] pushToRight(int[] input, int pushCount) {

        for(int j = 0; j < pushCount; ++ j){
            int temp = input[input.length - 1];
            for (int i = input.length - 1; i >= 1; i--) {
                input[i] = input[i-1];
            }
            input[0] = temp;

            System.out.println(Arrays.toString(input));
        }


        int progress = 0;

        return input;
    }

//역방향
    public int[] pushToLeft(int[] input, int pushCount) {

        for(int j = 0; j < pushCount; ++ j){
            int temp = input[0];
            for (int i = 0; i + 1 <= input.length - 1; i++) {
                input[i] = input[i + 1];
            }
            input[input.length - 1] = temp;

            System.out.println(Arrays.toString(input));
        }


        int progress = 0;

        return input;
    }

    public static void main(String[] args) {
        밀기 proposal = new 밀기();

        int input[] = {1, 2, 3, 4};
        proposal.pushToLeft(input, 4);
    }

}
