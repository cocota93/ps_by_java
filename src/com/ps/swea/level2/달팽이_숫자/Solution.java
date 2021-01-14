package com.ps.swea.level2.달팽이_숫자;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/swea/level2/달팽이_숫자/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            int n = sc.nextInt();
            int sequence = 1;
            int renderBoard[][] = new int[n][n];

            for(int outlineNum =  0;; outlineNum++){
                {//기억모양
                    for (int i = outlineNum; i < n - outlineNum; i++) {
                        renderBoard[outlineNum][i] = sequence;
                        sequence++;
                    }
                    if(sequence - 1 == n*n)break;

                    for (int i = outlineNum + 1; i < n - outlineNum; i++) {
                        renderBoard[i][n - 1 - outlineNum] = sequence;
                        sequence++;
                    }
                    if(sequence - 1 == n*n)break;
                }


                {
                    //니은모양
                    for (int i = 0 + 1 + outlineNum; i < n - outlineNum; i++) {
                        renderBoard[n - 1 - outlineNum][n - 1 - i] = sequence;
                        sequence++;
                    }
                    if(sequence - 1 == n*n)break;

                    for (int i = n - 1 - 1 - outlineNum; i >= outlineNum + 1; i--) {
                        renderBoard[i][outlineNum] = sequence;
                        sequence++;
                    }
                    if(sequence - 1 == n*n)break;
                }


            }

            System.out.printf("#%d ", test_case);
            System.out.println("");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d ", renderBoard[i][j]);
                }
                System.out.println("");
            }
        }
    }

}
