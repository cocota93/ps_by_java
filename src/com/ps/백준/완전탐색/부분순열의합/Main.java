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
    static int board[];
    static int destSum;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/부분순열의합/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        destSum = Integer.parseInt(st.nextToken());

        board = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        int curDepth = 0;
        int curSum = 0;
        int result = Recur(curDepth, curSum);
        if(destSum == 0) result -= 1;
        System.out.println(result);
    }

    private static int Recur(int curDepth, int curSum) {
        if(curDepth == board.length){
            if(curSum != destSum) return 0;
            return 1;
        }

        int count = 0;
        count += Recur(curDepth + 1, curSum);
        count += Recur(curDepth + 1, curSum + board[curDepth]);

        return count;
    }


}
