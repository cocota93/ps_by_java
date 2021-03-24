package com.ps.백준.sds스터디._9주차.감시;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


//cctv는 자기자신이 위치한곳도 감시가능.
//다른 cctv 건너뛸수있음.
//cctv최대 개수는 8개
//각각의 cctv를 4개방향으로 돌려보며 최소 사각지대 카운팅하면 될거같음.
//4^8
//전형적인 재귀완탐문제

class Main {

    static class CCTV{
        int y;
        int x;
        int dir;
        int type;

        public CCTV(int y, int x, int dir, int type) {
            this.y = y;
            this.x = x;
            this.dir = dir;
            this.type = type;
        }
    }

    static int board[][];
    static List<CCTV> cctvList;

    static int WALL = 6;
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};


    static int answer = 999;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/sds스터디/_9주차/감시/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        board = new int[height][width];
        cctvList = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < board[0].length; j++) {
                int obj = Integer.parseInt(st.nextToken());
                if(obj == WALL) board[i][j] = WALL;
                else if(obj == 0) board[i][j] = 0;
                else{
                    cctvList.add(new CCTV(i,j,0,obj));
                }
            }
        }

        int depth = 0;
        recur(depth);

        if(answer == 999) System.out.println(0);
        else System.out.println(answer);
    }

    private static void recur(int depth) {
        if (depth == cctvList.size()) {
            int instantBoard[][] = new int[board.length][board[0].length];
            for (int i = 0; i < instantBoard.length; i++) {
                instantBoard[i] = Arrays.copyOf(board[i], board[i].length);
            }

            paint(instantBoard);
            answer = Math.min(answer, countInvisibleSpace(instantBoard));
            return;
        }


        for (int dir = 0; dir < 4; dir++) {
            cctvList.get(depth).dir = dir;
            recur(depth + 1);
        }
    }

    private static int countInvisibleSpace(int[][] instantBoard) {
        int invisibleSpaceCount = 0;

        for (int[] ints : instantBoard) {
            for (int space : ints) {
                if (space == 0) {
                    invisibleSpaceCount++;
                }
            }
        }

        return invisibleSpaceCount;
    }

    private static void paint(int[][] instantBoard) {

        for (CCTV cctv : cctvList) {
            int front = cctv.dir;
            int right = (cctv.dir + 1) % 4;
//            int left = (4 - Math.abs((cctv.dir - 1))) % 4;
            int left = (cctv.dir + 3) % 4;
            int rear = (cctv.dir + 2) % 4;

            if(cctv.type == 1){
                paintStraight(instantBoard, cctv.y, cctv.x, right);
            }else if(cctv.type == 2){
                paintStraight(instantBoard, cctv.y, cctv.x, left);
                paintStraight(instantBoard, cctv.y, cctv.x, right);
            }else if(cctv.type == 3){
                paintStraight(instantBoard, cctv.y, cctv.x, front);
                paintStraight(instantBoard, cctv.y, cctv.x, right);
            }else if(cctv.type == 4){
                paintStraight(instantBoard, cctv.y, cctv.x, front);
                paintStraight(instantBoard, cctv.y, cctv.x, left);
                paintStraight(instantBoard, cctv.y, cctv.x, right);
            }else if(cctv.type == 5){
                paintStraight(instantBoard, cctv.y, cctv.x, front);
                paintStraight(instantBoard, cctv.y, cctv.x, left);
                paintStraight(instantBoard, cctv.y, cctv.x, right);
                paintStraight(instantBoard, cctv.y, cctv.x, rear);
            }
        }
    }

    private static void paintStraight(int[][] instantBoard, int y, int x, int dir) {

        instantBoard[y][x] = 1;

        int nextY = y;
        int nextX = x;
        while(true){
            nextY = nextY + dy[dir];
            nextX = nextX + dx[dir];

            if(nextY < 0 || nextY >= instantBoard.length) break;
            if(nextX < 0 || nextX >= instantBoard[0].length) break;
            if(instantBoard[nextY][nextX] == WALL) break;

            instantBoard[nextY][nextX] = 1;
        }
    }

}
