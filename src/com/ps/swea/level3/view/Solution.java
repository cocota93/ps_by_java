package com.ps.swea.level3.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


class Solution {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/swea/level3/view/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = 10;

        for (int test_case = 1; test_case <= T; ++test_case) {
            int width = Integer.parseInt(br.readLine());
            int board[] = new int[width];
            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < width; i++) {
                int height = Integer.parseInt(st.nextToken());
                board[i] = height;
            }

            int freeResult = 0;
            for (int i = 2; i < width - 2; i++) {
                int compareLeftResult1 = board[i] - board[i - 1];
                if(compareLeftResult1 < 1) continue;

                int compareLeftResult2 = board[i] - board[i - 2];
                if(compareLeftResult2 < 1) continue;

                int compareRightResult1 = board[i] - board[i + 1];
                if(compareRightResult1 < 1) continue;

                int compareRightResult2 = board[i] - board[i + 2];
                if(compareRightResult2 < 1) continue;

                List<Integer> forSort = new ArrayList<>();
                forSort.add(board[i]);
                forSort.add(board[i - 1]);
                forSort.add(board[i - 2]);
                forSort.add(board[i + 1]);
                forSort.add(board[i + 2]);

                forSort.sort((o1, o2) -> o2 - o1);

                Integer firstHeight = forSort.get(0);
                Integer secondHeight = forSort.get(1);

                freeResult += firstHeight - secondHeight;
            }



            System.out.printf("#%d ", test_case);
            System.out.printf("%d", freeResult);
//            Arrays.stream(board).forEach(obj -> System.out.printf("%d ", obj));
            System.out.printf("\n");
        }
    }

}
