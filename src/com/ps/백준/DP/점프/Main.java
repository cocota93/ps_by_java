package com.ps.백준.DP.점프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 한쪽 방향으로 먼저 싹다 처리하고 (가로)
* 다른 한쪽 싹다처리(세로)
* 했더니 제대로된 계산이 안된다.
* 다른 사람들 풀이를 보니 행열순서로 차례대로 함
* */

class Main {

    static int n;
    static int board[][];
    static long pathCount[][];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/점프/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        pathCount = new long[n][n];

        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < board.length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        pathCount[0][0] = 1;

//        Init();
//        printBox(pathCount);

        //오른쪽으로 가는경우
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(pathCount[i][j] == 0) continue;
                if(board[i][j] == 0) continue;

                int moveCount = board[i][j];
                if(i + moveCount < board.length){
                    pathCount[i + moveCount][j] += pathCount[i][j];
                }

                if(j + moveCount < board[0].length) {
                    pathCount[i][j + moveCount] += pathCount[i][j];
                }
            }
        }

//        printBox(pathCount);

        System.out.println(pathCount[pathCount.length - 1][pathCount[0].length - 1]);
    }

    private static void Init() {
        //첫시작후 일단 오른쪽으로만 가는 경우
        for (int i = 0; i < board[0].length; ) {
            int moveCount = board[0][i];
            if(i + moveCount >= board[0].length) {
//                i++;
//                continue;
                break;
            }

            pathCount[0][i + moveCount] = 1;
            i += moveCount;
        }

        //첫시작후 아래쪽으로 가는 경우
        for (int i = 0; i < board.length; ) {
            int moveCount = board[i][0];
            if(i + moveCount >= board.length) {
//                i++;
//                continue;
                break;
            }

//            pathCount[i + moveCount][0] = pathCount[i][0] + 1;
            pathCount[i + moveCount][0] = 1;
            i += moveCount;
        }
    }

    private static void printBox(long[][] pathCount) {
        for (int i = 0; i < pathCount.length; i++) {
            for (int j = 0; j < pathCount[0].length; j++) {
                System.out.print(pathCount[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("------------");
    }

}
