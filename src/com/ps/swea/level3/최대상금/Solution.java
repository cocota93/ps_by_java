package com.ps.swea.level3.최대상금;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


class Solution {
//풀이 출처 : https://hoho325.tistory.com/114


    //fail
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/swea/level3/최대상금/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T;
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; ++test_case) {
            st = new StringTokenizer(br.readLine(), " ");
            String[] inputBoard = st.nextToken().split("");
            int board[] = new int[inputBoard.length];
            for (int i = 0; i < inputBoard.length; i++) {
                board[i] = Integer.parseInt(inputBoard[i]);
            }
            int totalChance = Integer.parseInt(st.nextToken());
            Integer resultCombination = Integer.parseInt(IntegerArrayToJoinning(board));
            int result = DFS(board, totalChance, 0, 0, resultCombination);

            System.out.printf("#%d ", test_case);
            System.out.printf("%s", result);
            System.out.printf("\n");
        }
    }

    private static void BubbleSort(int[] board, int startIdx) {
        for(int i = startIdx; i < board.length; ++i){
            for (int j = i + 1; j < board.length; j++) {
                if(board[i] <= board[j]) {
                    swap(board, i, j);
                }
            }
        }
        System.out.printf("recover : %s ", IntegerArrayToJoinning(board));
    }

    private static int DFS(int[] board, int totalChance, int useChance, int startIdx, Integer resultCombination) {
//        int result = Integer.parseInt(IntegerArrayToJoinning(board));
        if(totalChance == useChance){
            String stringResult = IntegerArrayToJoinning(board);
//            System.out.printf("result : %s, ", stringResult);
            return Integer.parseInt(stringResult);
        }

        for(int i = startIdx; i < board.length; ++i){
            for (int j = i + 1; j < board.length; j++) {
                if(board[i] <= board[j]) {
//                    System.out.printf("swap before : %s, ", IntegerArrayToJoinning(board));
                    swap(board, i, j);
//
                    int makeCombination = DFS(board, totalChance, useChance + 1, i, resultCombination);
//                    System.out.println(makeCombination);
                    resultCombination = Math.max(resultCombination, makeCombination);

                    swap(board, j, i);
//                    System.out.printf("recover : %s ", IntegerArrayToJoinning(board));
//                    System.out.println("");
                }
            }

        }

//        if(result == 0){
//            result = Integer.parseInt(IntegerArrayToJoinning(board));
//
//            if(board.length >= 2 && totalChance - useChance % 2 != 0){
//                swap(board,board.length - 1,board.length - 2);
//                result = Integer.parseInt(IntegerArrayToJoinning(board));
//            }
//        }

//        System.out.printf("recover : %s ", IntegerArrayToJoinning(board));

        return resultCombination;
    }

    private static String IntegerArrayToJoinning(int[] board) {
        String stringResult = Arrays.stream(board).boxed().map(obj -> "" + obj).collect(Collectors.joining());
        return stringResult;
    }

    private static void swap(int[] board, int i, int j) {
        int temp = board[i];
        board[i] = board[j];
        board[j] = temp;
    }

}
