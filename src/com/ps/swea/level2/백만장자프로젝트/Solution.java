package com.ps.swea.level2.백만장자프로젝트;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level2/백만장자프로젝트/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; ++test_case) {
            //logic...
            List<Integer> costList = new ArrayList<>();
            {
                int n = sc.nextInt();
                for (int i = 0; i < n; i++) {
                    int cost = sc.nextInt();
                    costList.add(cost);
                }
            }

            long result = 0;
            Integer high = costList.get(costList.size() - 1);
            for (int i = costList.size() - 1; i >= 1; i--) {
                Integer front = costList.get(i - 1);

                if(high < front){
                    high = front;
                }else{
                    result += high - front;
                }
            }


            System.out.printf("#%d ", test_case);
            System.out.printf("%d", result);
            System.out.printf("\n");
        }
    }

}
