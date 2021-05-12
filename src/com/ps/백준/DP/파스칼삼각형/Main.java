package com.ps.백준.DP.파스칼삼각형;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


//dp[행][열] = 해당 행 0번째 열부터 주어진 열까지의 합

class Main {

    static int r;//꼭지점 행
    static int c;//꼭지점 열
    static int w;//한 변의 길이

    static int[][] board;//board[r+w][r+w]. 첫번쨰 행과 열은 사용안하고 비워둠. 1행 1열부터 시작

    //배열의 크기는 전적으로 r(행)과 w(변의 길이)에 의해서 결정됨
    //r + w

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DP/파스칼삼각형/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        /*
        * #
        * ##
        * ###
        * ####
        * #####
        * 이러한 형태로 만들어서 계산
        * */
        board = new int[r+w][r+w];
        for (int i = 1; i < board.length; i++) {
            board[i][1] = 1;
            board[i][i] = 1;
        }

        for (int y = 3; y < board.length; y++) {
            for (int x = 2; x < y; x++) {
                board[y][x] = board[y - 1][x - 1] + board[y - 1][x];
            }
        }

//        for (int y = 1; y < board.length; y++) {
//            for (int x = 1; x <= y; x++) {
//                System.out.print(board[y][x] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("----------");

        int answer = 0;
        for (int y = r; y < r + w; y++) {
            int limitAddCount = y - r;

            for (int x = c; x <= c + limitAddCount; x++) {
                answer += board[y][x];
            }
        }

        System.out.println(answer);



    }

}
