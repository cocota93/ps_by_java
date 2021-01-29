package com.ps.백준.분할정복.쿼드트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 기본적으로 양끝에 괄호를 가지고있고ㄴㅇ
* 깊이가 깊어질떄마다 괄호가 추가된다.
*
* */


class Main {
    static int board[][];
    static String packingResult = "";

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/분할정복/쿼드트리/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char[] chars = line.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                board[i][j] = chars[j] - '0';
            }
        }


        int depth = 0;
        int sideLength = N;
        int baseY = 0;
        int baseX = 0;
        Recur(depth, sideLength, baseY, baseX);

        System.out.println(packingResult);
    }

    private static void Recur(int depth, int sideLength, int baseY, int baseX) {

        boolean isPacking = true;
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                int adjacentY = baseY + i;
                int adjacentX = baseX + j;
                if(board[adjacentY][adjacentX] != board[baseY][baseX]){
                    isPacking = false;
                    break;
                }
            }

            if(!isPacking) break;
        }

        if(isPacking){
            packingResult += "" + board[baseY][baseX];
        }else{
            packingResult += "(";

            int nextSideLength = sideLength / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int relativeY = baseY + (i * nextSideLength);
                    int relativeX = baseX + (j * nextSideLength);
                    Recur(depth + 1, nextSideLength, relativeY, relativeX);
                }
            }

            packingResult += ")";
        }
    }

}
