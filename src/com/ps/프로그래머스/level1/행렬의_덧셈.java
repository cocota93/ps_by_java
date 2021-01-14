package com.ps.프로그래머스.level1;

import java.util.Arrays;

public class 행렬의_덧셈 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        행렬의_덧셈 proposal = new 행렬의_덧셈();

        int input1[][] = {{1,2},{2,3}};
        int input2[][] = {{3,4},{5,6}};
        int[][] result = proposal.solution(input1, input2);
        System.out.println(Arrays.deepToString(result));
    }

}
