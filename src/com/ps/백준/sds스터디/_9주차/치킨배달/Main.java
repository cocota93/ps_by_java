package com.ps.백준.sds스터디._9주차.치킨배달;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


class Main {

    static class POINT {
        int y;
        int x;

        public POINT(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n;
    static int m;//남겨야 하는 치킨집의 수

    static int board[][];
    static boolean aliveChickenFlag[];
    static List<POINT> chickenPosList;
    static List<POINT> homePosList;
    static int answer = 99999999;

    static int EMPTY = 0;
    static int HOME = 1;
    static int CHICKEN = 2;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/sds스터디/_9주차/치킨배달/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        chickenPosList = new ArrayList<>();
        homePosList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == CHICKEN){
                    chickenPosList.add(new POINT(i, j));
                }else if(board[i][j] == HOME){
                    homePosList.add(new POINT(i, j));
                }
            }
        }


        aliveChickenFlag = new boolean[chickenPosList.size()];

        int selectCount = 0;
        int lastSelectCount = 0;
        recur(selectCount, lastSelectCount);


        System.out.println(answer);
    }

    private static void recur(int selectCount, int lastSelectIdx) {
        if(selectCount == m){
//            System.out.println(Arrays.toString(aliveChickenFlag));

            List<POINT> aliveChickenPosList = new ArrayList<>();
            for (int i = 0; i < aliveChickenFlag.length; i++) {
                if(aliveChickenFlag[i]){
                    aliveChickenPosList.add(chickenPosList.get(i));
                }
            }

            int sum = 0;
            for (POINT homePos : homePosList) {
                int minDistance = Integer.MAX_VALUE;
                for (POINT chickenPos : aliveChickenPosList) {
                    int distance = calDistance(homePos, chickenPos);
                    if(minDistance > distance){
                        minDistance = distance;
                    }
                }

                sum += minDistance;
            }

            if(sum < answer){
                answer = sum;
            }

            return;
        }

        for (int i = lastSelectIdx; i < aliveChickenFlag.length; i++) {
            if(aliveChickenFlag[i]) continue;

            aliveChickenFlag[i] = true;
            recur(selectCount + 1, i + 1);
            aliveChickenFlag[i] = false;
        }
    }

    private static int calDistance(POINT homePos, POINT chickenPos) {
        return Math.abs(homePos.y - chickenPos.y) + Math.abs(homePos.x - chickenPos.x);
    }

}
