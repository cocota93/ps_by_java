package com.ps.백준.역량테스트.뱀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.io.FileInputStream;
import java.util.StringTokenizer;


class Main {

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/역량테스트/뱀/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int board[][] = new int[n][n];

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            board[y][x] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        int[][] comannd = new int[L][2];
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            char rot = st.nextToken().charAt(0);

            comannd[i][0] = time;
            comannd[i][1] = (rot == 'L') ? -1 : 1;
        }


        int time = solution(0, 0, 0, comannd);
    }

    private static int solution(int curX, int curY, int curDir, int[][] command) {


        return 0;
    }

}
