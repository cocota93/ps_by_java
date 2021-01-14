package com.ps.swea.level2.스도쿠_검증;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/swea/level2/스도쿠_검증/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            int arr[][] = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }




            int result = 1;

            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {

                    int checkBoard[] = new int[10];
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            int valueInBox = arr[k + i][l + j];
                            if(checkBoard[valueInBox] == 0){
                                checkBoard[valueInBox] = 1;
                            }else{
                                result = 0;
                                break;
                            }
                        }
                    }

                    if(result == 0) break;
                }
            }


            if(result == 0){
                System.out.printf("#%d ", test_case);
                System.out.printf("%d", result);
                System.out.printf("\n");
                continue;
            }



            //가로검사
            for (int i = 0; i < 9; i++) {
                int checkBoard[] = new int[10];
                for (int j = 0; j < 9; j++) {
                    int valueInBox = arr[i][j];
                    if(checkBoard[valueInBox] == 0){
                        checkBoard[valueInBox] = 1;
                    }else{
                        result = 0;
                        break;
                    }
                }
            }

            if(result == 0){
                System.out.printf("#%d ", test_case);
                System.out.printf("%d", result);
                System.out.printf("\n");
                continue;
            }

            //세로검사
            for (int i = 0; i < 9; i++) {
                int checkBoard[] = new int[10];
                for (int j = 0; j < 9; j++) {
                    int valueInBox = arr[j][i];
                    if(checkBoard[valueInBox] == 0){
                        checkBoard[valueInBox] = 1;
                    }else{
                        result = 0;
                        break;
                    }
                }
            }

            if(result == 0){
                System.out.printf("#%d ", test_case);
                System.out.printf("%d", result);
                System.out.printf("\n");
                continue;
            }


            System.out.printf("#%d ", test_case);
            System.out.printf("%d", result);
            System.out.printf("\n");

        }
    }

}
