package com.ps.미니라이브러리.조회;

import java.util.Arrays;

public class 이차원조회 {


    public int[][] solution(int[][] input) {
        int fixedInput[][] = new int[input.length + 2][input[0].length + 2];
        for (int i = 0; i < fixedInput[0].length; i++) {
            fixedInput[0][i] = fixedInput[fixedInput.length - 1][i] = -1;
        }

        for (int i = 0; i < fixedInput.length; i++) {
            fixedInput[i][0] = fixedInput[i][fixedInput[0].length - 1] = -1;
        }

        for (int i = 1; i < fixedInput.length - 1; i++) {
            for (int j = 1; j < fixedInput[0].length - 1; j++) {
                fixedInput[i][j] = input[i - 1][j - 1];
            }
        }

        int result[][] = new int[input.length][input[0].length];
        for (int i = 1; i < fixedInput.length - 1; i++) {
            for (int j = 1; j < fixedInput[0].length - 1; j++) {
                if(fixedInput[i][j - 1] == fixedInput[i][j] || fixedInput[i][j] == fixedInput[i][j + 1] ){
                    result[i - 1][j - 1] = 1;
                } else if(fixedInput[i - 1][j] == fixedInput[i][j] || fixedInput[i][j] == fixedInput[i + 1][j] ){
                    result[i - 1][j - 1] = 1;
                }
            }
            System.out.println(Arrays.toString(result[i - 1]));
        }





        int progress = 0;

        return input;
    }

    public static void main(String[] args) {
        이차원조회 proposal = new 이차원조회();

        int input[][] = {{2,3,1,1,4}, {1,3,2,3,4}, {1,2,7,3,7}};
        proposal.solution(input);
    }

}
