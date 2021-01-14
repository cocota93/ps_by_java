package com.ps.백준.역량테스트.구슬탈출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    /*
    * 실패
    * */
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/역량테스트/구슬탈출/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        char board[][] = new char[height][width];

        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                char c = line.charAt(j);
                board[i][j] = c;
            }
        }

//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                System.out.printf("%c ", board[i][j]);
//            }
//            System.out.println("");
//        }
//        something(board, )
    }

}
