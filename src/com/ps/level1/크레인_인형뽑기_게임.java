package com.ps.level1;

import java.util.Arrays;

/**크레인 인형뽑기 게임*/
public class 크레인_인형뽑기_게임 {

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        System.out.println(Arrays.deepToString(board));
        System.out.println(Arrays.toString(moves));
        System.out.println("ihihih");
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        solution(board, moves);
    }
}
