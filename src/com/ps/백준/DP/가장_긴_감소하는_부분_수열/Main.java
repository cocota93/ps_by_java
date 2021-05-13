package com.ps.백준.DP.가장_긴_감소하는_부분_수열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/가장_긴_감소하는_부분_수열/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] board = new int[n];
        for (int i = 0; i < board.length; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        int[] minningCount = new int[n];
        minningCount[0] = 1;

        for (int i = 1; i < board.length; i++) {

            //i보다 왼쪽에서 i보다 크면서 부분수열의 길이가 가장 큰걸 찾아야됨.
            int longestIdx = i;
            for (int j = i - 1; j >= 0; j--) {
                if(board[j] > board[i] &&
                        minningCount[j] > minningCount[longestIdx]){
                    longestIdx = j;
                }
            }

            minningCount[i] = minningCount[longestIdx] + 1;
        }

        int answer = Arrays.stream(minningCount).max().getAsInt();
        System.out.println(answer);
    }

}
