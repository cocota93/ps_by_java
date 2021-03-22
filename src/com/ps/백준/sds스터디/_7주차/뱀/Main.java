package com.ps.백준.sds스터디._7주차.뱀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
* 우리가 흔히 아는 스네이크 게임
* 자신의 머리가 몸통과 부딪히거나 벽에 부딪히면 게임종료
* 사과를 다 먹어도 게임이 종료된다.
* 게임이 진행되는 시간이 몇초인지 계산하는 문제.
*
* 주요이슈는 머리가 몸통과 부딪히는지 체크하는것 같다.
* 몸통의 길이가 가변적으로 변하니 그에대한 적절한 자료구조도 생각해봐야한다.
* -> 머리와 꼬리에도 수시로 접근해야하고 충돌체크땜에 몸통에도 접근해야하니
* 리스트가 적절하지않을까?
* -> 몸통을 이루는 좌표들은 모두 set에 넣어두고 머리와 꼬리에 대한 데이터만 별도로 관리하는것도 괜찮을것같긴한데
* 구현만 귀찮을것같기도하구
*
* move, collisionCheck, simulation
* */
class Main {

    static class POINT{
        int y;
        int x;

        public POINT(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    static int board[][];

    static char eventCommand[]; //eventCommand[시간] = 방향
    static int wall = 5;

    static int apple = 7;

    static int appleCount;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/sds스터디/_7주차/뱀/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        board = new int[n + 2][n + 2];
        for (int i = 0; i < board.length; i++) {
            board[0][i] = board[board.length - 1][i] = wall;
        }
        for (int i = 0; i < board.length; i++) {
            board[i][0] = board[i][board.length - 1] = wall;
        }

//        printBoard();


        appleCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < appleCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            board[y][x] = apple;
        }


        eventCommand = new char[10000 + 1];
        int commandCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < commandCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            String command = st.nextToken();

            eventCommand[time] = command.charAt(0);
        }


        int simulationTime = simulation();

        System.out.println(simulationTime);
    }

    private static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("---------------------");
    }

    private static void printSimul(List<POINT> snakeBody) {
        int instantBoard[][] = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            instantBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }

        for (POINT point : snakeBody) {
            instantBoard[point.y][point.x] = 1;
        }

        for (int i = 0; i < instantBoard.length; i++) {
            for (int j = 0; j < instantBoard.length; j++) {
                System.out.print(instantBoard[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("---------------------");
    }


    //게임이 끝나는시간을 구한다.
    private static int simulation() {
        List<POINT> snakeBodyList = new ArrayList<>();
        POINT snakeHead = new POINT(1, 1);
        snakeBodyList.add(new POINT(snakeHead.y, snakeHead.x));

        int curDir = 1;
        int curTime = 0;
        int takeAppleCount = 0;

        while(true){
            curTime++;

            //이동
            int nextY = snakeHead.y + dy[curDir];
            int nextX = snakeHead.x + dx[curDir];

            if(collisionCheckBody(nextY, nextX, snakeBodyList)){
                return curTime;
            }
            if(collisionCheckWall(nextY, nextX)){
                return curTime;
            }

            if (collisionCheckApple(nextY, nextX)) {
                takeAppleCount++;
//                if(takeAppleCount == appleCount) return curTime;
            } else {
                //꼬리 하나 떼기
                snakeBodyList.remove(0);
            }

            snakeHead.y = nextY;
            snakeHead.x = nextX;
            snakeBodyList.add(new POINT(snakeHead.y, snakeHead.x));


//            System.out.println("time : " + curTime + ", y : " + snakeHead.y + ", x : " + snakeHead.x);
//            printSimul(snakeBodyList);


            if (eventCommand[curTime] == 'L') {//왼쪽으로 회전
                int temp = curDir;
                temp -= 1;
                if(temp < 0) temp = 3;

                curDir = temp;
            } else if (eventCommand[curTime] == 'D') {//오른쪽으로 회전
                int temp = curDir;
                temp += 1;
                temp %= 4;

                curDir = temp;
            }
        }
    }

    private static boolean collisionCheckApple(int nextY, int nextX) {
        if (board[nextY][nextX] == apple) {
            board[nextY][nextX] = 0;
            return true;
        }

        return false;
    }

    private static boolean collisionCheckWall(int nextY, int nextX) {
        if(board[nextY][nextX] == wall) return true;

        return false;
    }

    private static boolean collisionCheckBody(int nextY, int nextX, List<POINT> snakeBodyList) {
        for (POINT point : snakeBodyList) {
            if(point.y == nextY && point.x == nextX) return true;
        }

        return false;
    }

    private static void move(POINT snakeHead, List<POINT> snakeBodyList, int curDir) {
        int nextY = snakeHead.y + dy[curDir];
        int nextX = snakeHead.x + dx[curDir];

        if(board[nextY][nextX] == wall){

            return;
        }else if(board[nextY][nextX] == apple){

            return;
        }

        //자신의 몸통과 충돌체크
    }

}
