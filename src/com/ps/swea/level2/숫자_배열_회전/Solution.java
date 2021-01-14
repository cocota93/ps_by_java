package com.ps.swea.level2.숫자_배열_회전;

import java.util.Scanner;
import java.io.FileInputStream;

//참고 : https://regularmember.tistory.com/26
class Solution {

    public static int[][] Rotate(int src[][]){
        int n = src.length;
        int rotateResult[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotateResult[j][n - 1 - i] = src[i][j];
            }
        }

        return rotateResult;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/swea/level2/숫자_배열_회전/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            int n = sc.nextInt();
            int arr[][] = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int[][] rotate90 = Rotate(arr);
            int[][] rotate180 = Rotate(rotate90);
            int[][] rotate270 = Rotate(rotate180);


            System.out.printf("#%d ", test_case);
            System.out.println("");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d", rotate90[i][j]);
                }
                System.out.printf(" ");
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d", rotate180[i][j]);
                }
                System.out.printf(" ");
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d", rotate270[i][j]);
                }
                System.out.println("");
            }

//            System.out.printf("\n");
        }
    }

}
