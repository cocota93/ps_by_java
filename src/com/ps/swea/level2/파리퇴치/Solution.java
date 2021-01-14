package com.ps.swea.level2.파리퇴치;

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/swea/level2/파리퇴치/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            int m = sc.nextInt();
            int n = sc.nextInt();

            int arr[][] = new int[m][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    int val = sc.nextInt();
                    arr[i][j] = val;
                }
            }


            int max = 0;
            for (int i = 0; i < m; i++) {
                if(i + n > m){
                    continue;
                }

                for (int j = 0; j < m; j++) {
                    if(j + n > m){
                        continue;
                    }

                    int sum = 0;
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < n; l++) {
                            sum += arr[i + k][j + l];
                        }
                    }

                    max = Math.max(max, sum);
                }
            }


            System.out.printf("#%d ", test_case);
            System.out.printf("%d", max);
            System.out.printf("\n");
        }
    }

}
