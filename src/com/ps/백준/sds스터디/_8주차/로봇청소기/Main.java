package com.ps.백준.sds스터디._8주차.로봇청소기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 전형적인 재귀 or bfs를 통한 완탐문제 같다.
 * 문제에서 어떤방향으로 갈지 제시하고 있으니 재귀가 더 적합할듯
 * */

/*
* 이해안되서 해설보고 풀었음. 처음ㅇ dfs로 시도했다가 문제가 제대로 이해안되서 한참헤맴.
* 실제 푼거는 bfs로 해결
* */

class Main {

    static class POINT{
        int y;
        int x;
        int dir;

        public POINT(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }


    static int board[][];
    static boolean visited[][];

    static int WALL = 1;

    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0 , -1};

    static int answer;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/sds스터디/_8주차/로봇청소기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        board = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < width; j++) {
                board[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[height][width];

        bfs(startY, startX, dir);

//        int depth = 1;
//        visited[startY][startX] = true;
//        answer = 1;
//        recur(depth, startY, startX, dir);

        System.out.println(answer);
    }

    private static void bfs(int startY, int startX, int startDir) {

        Queue<POINT> queue = new LinkedList<>();
        queue.add(new POINT(startY, startX, startDir));
        visited[startY][startX] = true;
        answer = 1;

        while(!queue.isEmpty()){
//            printBoard();
            POINT visitPlace = queue.poll();
            boolean allDirBlock = true;

            int nextDir = visitPlace.dir;
            for (int i = 0; i < 4; i++) {
//                int nextDir = (visitPlace.dir + 3) % 4;
                nextDir = (nextDir + 3) % 4;
                int nextY = visitPlace.y + dy[nextDir];
                int nextX = visitPlace.x + dx[nextDir];

                if(nextY < 0 || board.length <= nextY) continue;
                if(nextX < 0 || board[0].length <= nextX) continue;
                if(board[nextY][nextX] == WALL) continue;
                if(visited[nextY][nextX]) continue;

                visited[nextY][nextX] = true;
                answer++;
                queue.add(new POINT(nextY, nextX, nextDir));
                allDirBlock = false;
                break;
            }

            if(allDirBlock) {
                int backDir = (nextDir + 2) % 4;
                int nextY = visitPlace.y + dy[backDir];
                int nextX = visitPlace.x + dx[backDir];

                if(nextY < 0 || board.length <= nextY) break;
                if(nextX < 0 || board[0].length <= nextX) break;
                if(board[nextY][nextX] == WALL) break;
//                if(visited[nextY][nextX]) break;

                if(!visited[nextY][nextX]){
                    visited[nextY][nextX] = true;
                    answer++;
                }
                queue.add(new POINT(nextY, nextX, nextDir));
            }
        }

    }

    private static void recur(int depth, int oldY, int oldX, int oldDir) {
        printBoard();

        int nextDir = oldDir;
        boolean allDirBlock = true;
        for (int i = 0; i < 4; i++) {
            nextDir = (nextDir + 3) % 4;

            int nextY = oldY + dy[nextDir];
            int nextX = oldX + dx[nextDir];
            if(nextY < 0 || board.length <= nextY){
//                nextDir = (nextDir + 3) % 4;
                continue;
            }
            if (nextX < 0 || board[0].length <= nextX) {
//                nextDir = (nextDir + 3) % 4;
                continue;
            }
            if(board[nextY][nextX] == WALL) {
//                nextDir = (nextDir + 3) % 4;
                continue;
            }
            if(visited[nextY][nextX]) {
//                nextDir = (nextDir + 3) % 4;
                continue;
            }

            visited[nextY][nextX] = true;
            answer++;
            recur(depth + 1, nextY, nextX, nextDir);
            allDirBlock = false;
            break;
        }


        if(allDirBlock){
            int backDir = (nextDir + 2) % 4;

            int nextY = oldY + dy[backDir];
            int nextX = oldX + dx[backDir];
            if(nextY < 0 || board.length <= nextY) return;
            if(nextX < 0 || board[0].length <= nextX) return;
            if(board[nextY][nextX] == WALL) return;
//            if(visited[nextY][nextX]) return;

            visited[nextY][nextX] = true;
            answer++;
            recur(depth + 1, nextY, nextX, nextDir);
        }

    }

    private static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1) System.out.print("#" + " ");
                if(visited[i][j]) System.out.print((7) + " ");
                else if(board[i][j] == 0) System.out.print(0 + " ");

            }
            System.out.println();
        }

        System.out.println("-----------------");
    }
//    private static void printBoard() {
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if(board[i][j] == 1) System.out.print(1 + " ");
//                if(visited[i][j]) System.out.print(7 + " ");
//                else if(board[i][j] == 0) System.out.print(0 + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println("-----------------");
//    }

}
