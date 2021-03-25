package com.ps.백준.sds스터디._9주차.사다리_조작;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    static int ladder[][];

    static int empty = 0;
    static int tunnel = 1;
    static int answer;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/sds스터디/_9주차/사다리_조작/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());//세로선의 개수
        int m = Integer.parseInt(st.nextToken());//가로선의 개수
        int h = Integer.parseInt(st.nextToken());//각 세로선마다 놓을수 있는 가로선(=가로점선)의 최대개수
        //

        ladder = new int[h][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;//a번 가로점선
            int b = Integer.parseInt(st.nextToken()) - 1;//b에서 b+1까지 연결하겠다.

            ladder[a][b] = tunnel;
        }

        boolean enable = flowCheck(ladder);
        if(enable) System.out.println(0);

        answer = 999;
        int depth = 0;
        int myTunnelY[] = new int[3];
        int myTunnelX[] = new int[3];
        recur(depth + 1, myTunnelY, myTunnelX);

        if(answer == 999){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
    }

    private static void recur(int depth, int[] myTunnelY, int[] myTunnelX) {
        if(depth == 4){
            return;
        }

        for (int y = 0; y < ladder.length; y++) {
            for (int x = 0; x < ladder[0].length - 1; x++) {


                if(ladder[y][x] == tunnel) continue;
                if(x - 1 >= 0 && ladder[y][x - 1] == tunnel) continue;//가로선은 연속할수없음
                if(x + 1 < ladder[0].length && ladder[y][x + 1] == tunnel) continue;//가로선은 연속할수없음

                ladder[y][x] = tunnel;

                boolean enable = flowCheck(ladder);
                if(enable) answer = Math.min(answer, depth);
                recur(depth + 1, myTunnelY, myTunnelX);
                ladder[y][x] = empty;
            }
        }
    }

    private static boolean flowCheck(int[][] ladder) {

        for (int ladderNum = 0; ladderNum < ladder[0].length; ladderNum++) {
            int startY = 0;
            int startX = ladderNum;

            int y = startY;
            int x = startX;


            for (int i = 0; i < ladder.length; i++) {

                if(ladder[y][x] == tunnel) x++;
                else if(x - 1 >= 0 && ladder[y][x - 1] == tunnel) x--;
                y++;
            }

            if(startX != x) return false;
        }

        return true;
    }

}
