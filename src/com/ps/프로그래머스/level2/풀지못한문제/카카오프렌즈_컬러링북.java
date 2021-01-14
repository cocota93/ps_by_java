package com.ps.프로그래머스.level2.풀지못한문제;

import java.util.Arrays;

public class 카카오프렌즈_컬러링북 {

    public int[] solution(int m, int n, int[][] picture) {
        for (int[] ints : picture) {
            for (int anInt : ints) {
                System.out.print("" + anInt + ", ");
            }
//            System.out.println("m = " + m + ", n = " + n + ", picture = " + Arrays.deepToString(picture));
            System.out.println();
        }

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
//        answer[0] = numberOfArea;
//        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void main(String[] args) {
        카카오프렌즈_컬러링북 proposal = new 카카오프렌즈_컬러링북();

        int[] result = proposal.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
        System.out.println(Arrays.toString(result));
    }

}
