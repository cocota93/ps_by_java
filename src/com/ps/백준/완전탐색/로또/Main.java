package com.ps.백준.완전탐색.로또;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
 * nextPermuation이랑 별 차이 없어보이는데??
 * -> 차이있음 ㅡㅡ
 * 13C6 = 1235520 / 720 = 1716
 *
 *
 *
 *
 * */

class Main {
    static int S[];
    static boolean usedNumber[];
    static int board[];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/로또/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());
        if(k == 0) return;


        while(true){

            S = new int[k];
            for (int i = 0; i < S.length; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            usedNumber = new boolean[k];
            board = new int[6];

            int depth = 0;
            int orderDigit = 0;
            Recur(depth, orderDigit);



            st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            if(k == 0) return;
            System.out.println("");
        }

    }

    private static void Recur(int depth, int prevOrderDigit) {
        if(depth == board.length){
            for (int i = 0; i < board.length; i++) {
                System.out.printf("%d ", board[i]);
            }
            System.out.println("");
            return;
        }


        for (int i = 0; i < S.length; i++) {
            if(usedNumber[i] == true) continue;
            if(depth != 0 && board[depth - 1] >= S[i]) continue;

            usedNumber[i] = true;
            board[depth] = S[i];
            Recur(depth + 1, prevOrderDigit + 1);
            board[depth] = 0;
            usedNumber[i] = false;
        }

    }

}
