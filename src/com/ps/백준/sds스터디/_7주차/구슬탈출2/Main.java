package com.ps.백준.sds스터디._7주차.구슬탈출2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 공이 구멍을 지나가기만 해도 들어가는걸로 인정되네
* */

/*
* 재귀, bfs둘다 방문체크를 어떻게 할지가 문제네
* 빨강공이랑 파랑공 둘다 체크를 해야될려나?
* 하나만 해도 두개다 하는 효과를 내는 방법 없을려나?
*
* 문제에서 10번 이하로 움직이라고 했음.
* 그러면 4^10개의 경우의 수가 생기구 1048576개의 경우의수?
* 그러면 그냥 방문체크 없이 모든 경우의수 다 해보면 되지않을까?
*
* */


class Main {

    static class Ball{
        int y;
        int x;
        int color;

        public Ball(int y, int x, int color) {
            this.y = y;
            this.x = x;
            this.color = color;
        }
    }

    static int goalY;
    static int goalX;

    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    static char board[][];
    static int answer;


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/sds스터디/_7주차/구슬탈출2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

//        char board[][] = new char[height][width];
        board = new char[height][width];
        Ball red = null;
        Ball blue = null;

        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                char c = line.charAt(j);
                board[i][j] = c;

                if(board[i][j] == 'R') red = new Ball(i, j, 1);
                if(board[i][j] == 'B') blue = new Ball(i, j, 2);
            }
        }

        answer = 999;
        int depth = 1;
        recur(depth, red, blue);

        if(answer == 999){
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }
    }

    static void recur(int depth, Ball oldRed, Ball oldBlue){
        if(depth > 10){
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            Ball newRed = new Ball(oldRed.y, oldRed.x, oldRed.color);
            Ball newBlue = new Ball(oldBlue.y, oldBlue.x, oldBlue.color);
            int hallInColor = tilt(newRed, newBlue, dir);

            if(hallInColor == 0){
                recur(depth + 1, newRed, newBlue);
            } else if(hallInColor == 1){
                answer = Math.min(answer, depth);
                break;
            }
        }
    }

    //어떤공도 홀에 안들어간경우 0반환
    //빨간공이 홀에 들어갈경우 1반환

    //파란공이 홀에 들어갈경우 2반환
    //두개의 공이 동시에 홀에 들어간경우 2반환
    private static int tilt(Ball newRed, Ball newBlue, int dir) {
        int hallInColor = 0;
        //12시방향
        if (dir == 0) {
            Ball firstMover;
            Ball secondMover;
            if (newRed.y <= newBlue.y) {
                firstMover = newRed;
                secondMover = newBlue;
            } else {
                firstMover = newBlue;
                secondMover = newRed;
            }

            hallInColor = move(dir, firstMover, secondMover);
            return hallInColor;
        } else if (dir == 1) {
            Ball firstMover;
            Ball secondMover;
            if (newRed.x <= newBlue.x) {
                firstMover = newBlue;
                secondMover = newRed;
            } else {
                firstMover = newRed;
                secondMover = newBlue;
            }

            hallInColor = move(dir, firstMover, secondMover);
            return hallInColor;
        } else if (dir == 2) {
            Ball firstMover;
            Ball secondMover;
            if (newRed.y >= newBlue.y) {
                firstMover = newRed;
                secondMover = newBlue;
            } else {
                firstMover = newBlue;
                secondMover = newRed;
            }


            hallInColor = move(dir, firstMover, secondMover);
            return hallInColor;
        } else if (dir == 3) {
            Ball firstMover;
            Ball secondMover;
            if (newRed.x <= newBlue.x) {
                firstMover = newRed;
                secondMover = newBlue;
            } else {
                firstMover = newBlue;
                secondMover = newRed;
            }

            hallInColor = move(dir, firstMover, secondMover);
            return hallInColor;
        }

        return hallInColor;
    }

    private static int move(int dir, Ball firstMover, Ball secondMover) {
        int hallInColor = 0;

        for (; ; ) {
            int nextY = firstMover.y + dy[dir];
            int nextX = firstMover.x + dx[dir];
            if (board[nextY][nextX] == '#') {
                break;
            }
            if (board[nextY][nextX] == 'O' && firstMover.color == 2) {
                return firstMover.color;
            }
            if(nextY == secondMover.y && nextX == secondMover.x){
                break;
            }
            if (board[nextY][nextX] == 'O' && firstMover.color == 1) {
                hallInColor = firstMover.color;
            }

            firstMover.y = nextY;
            firstMover.x = nextX;
        }

        for (; ; ) {
            int nextY = secondMover.y + dy[dir];
            int nextX = secondMover.x + dx[dir];
            if (board[nextY][nextX] == '#') {
                break;
            }
            if (board[nextY][nextX] == 'O' && secondMover.color == 2) {
                return secondMover.color;
            }
            if(nextY == firstMover.y && nextX == firstMover.x){
                break;
            }
            if (board[nextY][nextX] == 'O' && secondMover.color == 1) {
                hallInColor = secondMover.color;
            }

            secondMover.y = nextY;
            secondMover.x = nextX;
        }

        return hallInColor;
    }

}
