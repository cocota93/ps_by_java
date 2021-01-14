package com.ps.swea.level2.어디에_단어가_들어갈_수_있을까;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level2/어디에_단어가_들어갈_수_있을까/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[n + 2][n + 2];
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    int block = sc.nextInt();
                    arr[i][j] = block;
                }
            }

            int result = 0;
            //가로검사
            for (int i = 1; i < n + 1; i++) {
                int sequenceCount = 0;
                for (int j = 1; j < n + 2; j++) {
                    if(arr[i][j] == 1){
                        sequenceCount++;
                    }else {
                        if(sequenceCount == k){
                            result++;
                        }
                        sequenceCount = 0;
                    }
                }

                if(sequenceCount == k){
                    result++;
                }
            }

            //세로검사
            for (int i = 1; i < n + 1; i++) {
                int sequenceCount = 0;
                for (int j = 1; j < n + 2; j++) {
                    if(arr[j][i] == 1){
                        sequenceCount++;
                    }else {
                        if(sequenceCount == k){
                            result++;
                        }
                        sequenceCount = 0;
                    }
                }

                if(sequenceCount == k){
                    result++;
                }
            }


            System.out.printf("#%d ", test_case);
            System.out.printf("%d", result);
            System.out.printf("\n");
        }
    }

}
