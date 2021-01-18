package com.ps.백준.완전탐색.부분순열의합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//풀이출처 : https://seol-limit.tistory.com/13
/*
* 어떻게 풀라는건지 아에 감이 안와서 바로 풀이 확인.
* 배열을 순회하면서 재귀로 호출하는데, 각 인덱스의 요소를 더했을때와 안더했을때의 값을 확인하는 방식으로 진행된다.
* */

class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/부분순열의합/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int board[] = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> container = new ArrayList<>();
        int curDepth = 0;
        int curSum = 0;
        int result = Recur(board, curDepth, curSum, s, container);
        System.out.println(result);
    }

    private static int Recur(int[] board, int curDepth, int curSum, int destSum, List<Integer> container) {
        if(curDepth == board.length - 1){
            container.add(board[curDepth]);

            if(curSum + board[curDepth] != destSum) {
                container.stream().forEach(number -> System.out.printf("%d ", number));
                int sum = container.stream().reduce((o1, o2) -> o1 + o2).get();
                System.out.printf(", sum : " + sum);
                System.out.println("");
                container.removeIf(number -> number == board[curDepth]);
                return 0;
            }

            container.stream().forEach(number -> System.out.printf("%d ", number));
            int sum = container.stream().reduce((o1, o2) -> o1 + o2).get();
            System.out.printf(", sum : " + sum);
            System.out.println("");
            container.removeIf(number -> number == board[curDepth]);
            return 1;
        }

//        if(container.stream().anyMatch(number -> number == -2) && container.stream().anyMatch(number -> number == -3)){
//            System.out.printf("asas");
//        }

        int count = 0;
        count += Recur(board, curDepth + 1, curSum, destSum, container);

        container.add(board[curDepth]);
        count += Recur(board, curDepth + 1, curSum + board[curDepth], destSum, container);
        container.removeIf(number -> number == board[curDepth]);

        return count;
    }


}
