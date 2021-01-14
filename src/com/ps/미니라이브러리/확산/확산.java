package com.ps.미니라이브러리.확산;

import java.util.Arrays;

/*
nx, ny를 활용하는 방법
*
* */
public class 확산 {


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

        int dx[] = new int[]{0, 0, -1, 1};
        int dy[] = new int[]{-1, 1, 0, 0};
        int result[][] = new int[input.length + 2][input[0].length + 2];
        for (int i = 1; i < fixedInput.length - 1; i++) {
            for (int j = 1; j < fixedInput[0].length - 1; j++) {
                for (int d = 0; d < 4; d++) {
                    int nx = j + dx[d];
                    int ny = i + dy[d];

                    result[ny][nx] += fixedInput[i][j];
                }
            }
            System.out.println(Arrays.toString(result[i - 1]));
        }


        int progress = 0;

        return input;
    }

    public static void main(String[] args) {
        확산 proposal = new 확산();

        int input[][] = {{2,3,1,1,4}, {1,3,2,3,4}, {1,2,7,3,7}};
        proposal.solution(input);
    }

}
