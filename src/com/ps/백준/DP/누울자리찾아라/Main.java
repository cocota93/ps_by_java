package com.ps.백준.DP.누울자리찾아라;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
*
* */


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/누울자리찾아라/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        boolean board[][] = new boolean[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                board[i][j] = s.charAt(j - 1) == '.';
            }
        }

        for (int i = 0; i < board.length; i++) {
            board[0][i] = board[board.length - 1][i] = false;
        }

        for (int i = 0; i < board.length; i++) {
            board[i][0] = board[i][board.length - 1] = false;
        }

//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board.length; j++) {
//                System.out.printf("%d ", board[i][j] ? 1 : 0);
//            }
//            System.out.println("");
//        }


        int laydownSpaceCountFromRow = 0;
        for (int i = 0; i < board.length; i++) {
            int blankCount = 0;
            for (int j = 0; j < board.length; j++) {

                if(board[i][j] == false){
                    if(blankCount >= 2){
                        laydownSpaceCountFromRow++;
                    }
                    blankCount = 0;
                    continue;
                }

                blankCount++;
            }
        }


        int laydownSpaceCountFromCol = 0;
        for (int i = 0; i < board.length; i++) {
            int blankCount = 0;
            for (int j = 0; j < board.length; j++) {

                if(board[j][i] == false){
                    if(blankCount >= 2){
                        laydownSpaceCountFromCol++;
                    }
                    blankCount = 0;
                    continue;
                }

                blankCount++;
            }
        }

        System.out.println(laydownSpaceCountFromRow + " " + laydownSpaceCountFromCol);


    }

}
