package com.ps.백준.sds스터디._7주차._2048_easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 재귀를 통한 모든경우 시뮬레이션 해야할것같은데
* 재귀할떄마다 게임판을 저장해도 되나??그렇게 안하면 적당한 모든경우 시뮬레이션 할 방법이 안떠오르는데
* */

class Main {

//    static int board[][];
    static int answer;
    static int n;

    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    static boolean mergeState[][];
    static int dirHistory[];
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/sds스터디/_7주차/_2048_easy/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                answer = Math.max(board[i][j], answer);
            }
        }

//        mergeState = new boolean[n][n];

        int depth = 1;

//        int dirHistory[] = new int[5 + 1];
        dirHistory = new int[5 + 1];
        Arrays.fill(dirHistory, -1);
        dirHistory[1] = 0;

        recur(depth, board);

        System.out.println(answer);
    }

    private static void boardCopy(int[][] from, int[][] to) {
        for (int i = 0; i < to.length; i++) {
            to[i] = Arrays.copyOf(from[i], from[i].length);
        }
    }

    private static void recur(int depth, int[][] oldBoard) {
        if (depth > 5) {

            return;
        }


        for (int dir = 0; dir < 4; dir++) {
            int instantBoard[][] = new int[n][n];
            boardCopy(oldBoard, instantBoard);

            mergeState = new boolean[n][n];

            dirHistory[depth] = dir;
//            if(dirHistory[1] == 1 && dirHistory[2] == 2 && dirHistory[3] == 3 && dirHistory[4] == 0 && dirHistory[5] == 3 && depth == 5){
//                System.out.println("needCheck");
//            }
            tilt(instantBoard, dir);
//            boardPrint(instantBoard);



            String pauseString = "";
            if(depth == 1){
                pauseString += "break";
            }else if(depth == 2) {
                pauseString += "break";
            }else if(depth == 3){
                pauseString += "break";
            }else if(depth == 4){
                pauseString += "break";
            }else if(depth == 5){
                pauseString += "break";
            }



//            if ((dirHistory[1] == 1 && depth == 1) ||
//                (dirHistory[1] == 1 && dirHistory[2] == 2 && depth == 2) ||
//                (dirHistory[1] == 1 && dirHistory[2] == 2 && dirHistory[3] == 3 && depth == 3) ||
//                (dirHistory[1] == 1 && dirHistory[2] == 2 && dirHistory[3] == 3 && dirHistory[4] == 0 && depth == 4) ||
//                (dirHistory[1] == 1 && dirHistory[2] == 2 && dirHistory[3] == 3 && dirHistory[4] == 0 && dirHistory[5] == 3 && depth == 5)
//            ) {
//                System.out.println("depth : " + depth + ", dir : " + dir);
//                boardPrint(instantBoard);
//            }





            recur(depth + 1, instantBoard);
            dirHistory[depth] = -1;
        }
    }

    //tilt, move, merge

    private static void tilt(int[][] instantBoard, int dir) {


        if(dir == 0){
            for (int y = 0; y < instantBoard.length; y++) {
                for (int x = 0; x < instantBoard[0].length; x++) {
                    if(instantBoard[y][x] == 0) continue;

                    move(instantBoard, dir, y, x);
                }
            }
        }else if(dir == 1){
            for (int y = 0; y < instantBoard.length; y++) {
                for (int x = instantBoard[0].length - 1; x >= 0; x--) {
                    if(instantBoard[y][x] == 0) continue;

                    move(instantBoard, dir, y, x);
                }
            }
        }else if(dir == 2){
            for (int y = instantBoard.length - 1; y >= 0; y--) {
                for (int x = 0; x < instantBoard[0].length; x++) {
                    if(instantBoard[y][x] == 0) continue;

                    move(instantBoard, dir, y, x);
                }
            }
        }else if(dir == 3){
            for (int y = 0; y < instantBoard.length; y++) {
                for (int x = 0; x < instantBoard[0].length; x++) {
                    if(instantBoard[y][x] == 0) continue;

                    move(instantBoard, dir, y, x);
                }
            }
        }
    }


    private static void move(int[][] instantBoard, int dir, int y, int x) {
        int nextY = y + dy[dir];
        int prevY = y;
        int nextX = x + dx[dir];
        int prevX = x;
        for (; 0 <= nextY && nextY < instantBoard.length && 0 <= nextX && nextX < instantBoard[0].length;
             nextY += dy[dir], prevY += dy[dir], nextX += dx[dir], prevX += dx[dir] ) {

//            if(board[nextY][nextX] == 3){
//                break;
//            }

            //이동하다가 나와 같은 숫자를 만나면 병합
            if (instantBoard[nextY][nextX] == instantBoard[prevY][prevX] &&
                    !mergeState[nextY][nextX]) {
                instantBoard[nextY][nextX] *= 2;
                instantBoard[prevY][prevX] = 0;

//                if(instantBoard[nextY][nextX] == 128){
//                    System.out.println("debug");
//                }
                answer = Math.max(answer, instantBoard[nextY][nextX]);
                mergeState[nextY][nextX] = true;


                break;
            }

            if(instantBoard[nextY][nextX] != 0){
                break;
            }

            instantBoard[nextY][nextX] = instantBoard[prevY][prevX];
            instantBoard[prevY][prevX] = 0;
        }
    }

    private static void boardPrint(int[][] instantBoard) {
        for (int i = 0; i < instantBoard.length; i++) {
            for (int j = 0; j < instantBoard[0].length; j++) {
                System.out.print(instantBoard[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("--------------------");
    }

}
