package com.ps.백준.sds스터디._8주차.스타트와링크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;



/*
* 그냥 딱봐도 완전탐색 문제같다.
* 재귀로 풀면될듯.
*
* 능력치의 합들을 구하고 정렬했을떄 원소간 차이가 가장 작은걸 구하면 되지않을까?
* 그리고 재귀아니고 그냥 반복문 2개로도 가능하지않나?
* * */

/*
* 막상풀어보니까 잘 안되네. 일단 패스
* */

/*
*
* */

class Main {

    static int n;
    static int board[][];
    static boolean combinationFlag[];
    static int answer = 99999999;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/sds스터디/_8주차/스타트와링크/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        combinationFlag = new boolean[n];

        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int determineCount = 0;
        recur(determineCount);


//        List<Integer> statList = new ArrayList<>();;
//        for (int i = 0; i < board.length; i++) {
//            for (int j = i + 1; j < board[0].length; j++) {
//                if(i == j) continue;
//
//                statList.add(board[i][j] + board[j][i]);
//            }
//        }

//        statList.sort(Comparator.comparingInt(Integer::intValue));
//
//        int answer = 10000;
//        for (int i = 1; i < statList.size(); i++) {
//            int diff = Math.abs(statList.get(i - 1) - statList.get(i));
//            if(diff == 0){
//                System.out.println("dubg");
//            }
//            answer = Math.min(answer, diff);
//        }


        System.out.println(answer);
    }

    private static void recur(int determineCount) {
        if(determineCount == n){
            int flagCount = 0;
            for (int i = 0; i < combinationFlag.length; i++) {
                if(combinationFlag[i]) flagCount++;
            }
            if(flagCount != n/2) return;

            int sum1 = 0;
            for (int i = 0; i < combinationFlag.length; i++) {
                if(!combinationFlag[i]) continue;

                for (int j = 0; j < combinationFlag.length; j++) {
                    if (i == j) continue;
                    if(!combinationFlag[j]) continue;

                    sum1 += board[i][j];
                }
            }

            int sum2 = 0;
            for (int i = 0; i < combinationFlag.length; i++) {
                if(combinationFlag[i]) continue;

                for (int j = 0; j < combinationFlag.length; j++) {
                    if (i == j) continue;
                    if(combinationFlag[j]) continue;

                    sum2 += board[i][j];
                }
            }

            int diff = Math.abs(sum1 - sum2);
            if(answer > diff){
                answer = diff;
            }
            return;
        }

        combinationFlag[determineCount] = false;
        recur(determineCount + 1);

        combinationFlag[determineCount] = true;
        recur(determineCount + 1);
    }

}
