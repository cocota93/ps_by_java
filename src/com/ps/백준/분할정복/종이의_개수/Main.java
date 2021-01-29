package com.ps.백준.분할정복.종이의_개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {
    static int board[][];
    static int resultCount[] = new int[3];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/분할정복/종이의_개수/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }


        int sideLength = N;
        int baseY = 0;
        int baseX = 0;
        Recur(sideLength, baseY, baseX);

        for (int i = 0; i < resultCount.length; i++) {
            System.out.println(resultCount[i]);
        }
    }

    private static void Recur(int sideLength, int baseY, int baseX) {
        boolean isPaper = true;


        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength ; j++) {
                if(board[baseY + i][baseX + j] != board[baseY][baseX]){
                    isPaper = false;
                    break;
                }
            }

            if(!isPaper) break;
        }

        if(isPaper){
            resultCount[board[baseY][baseX]] += 1;
            return;
        } else{
            int nextSideLength = sideLength / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
//                    if(board[baseY + (nextSideLength * i)][baseX + nextSideLength * j] == 1){
//                        System.out.println("debug");
//                    }

                    Recur(nextSideLength,baseY + (nextSideLength * i), baseX + nextSideLength * j);
                }
            }
        }
    }

}
