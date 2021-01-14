package com.ps.프로그래머스.level1;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class 크레인_인형뽑기_게임 {

    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;


        for (int i = 0; i < moves.length; i++) {
            int col = moves[i] - 1;
            for (int row = 0; row < board.length; row++) {
                if(board[row][col] != 0){
                    System.out.println("===============");
                    System.out.printf("row : %s,  col : %s", row, col);
                    System.out.println();

                    if(!stack.isEmpty() && stack.peek() == board[row][col]){
                        Integer pop = stack.pop();
                        System.out.println("pop : " + pop);
                        result += 2;
                    }else{
                        stack.push(board[row][col]);
                        System.out.println("push : " + board[row][col]);
                    }

                    board[row][col] = 0;
                    break;
                }
            }
        }


        List<Integer> collect = stack.stream().collect(Collectors.toList());
        System.out.println(collect);
        return result;
    }

    public static void main(String[] args) {
        크레인_인형뽑기_게임 proposal = new 크레인_인형뽑기_게임();

        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        int result = proposal.solution(board, moves);
        System.out.println(result);
    }
}


