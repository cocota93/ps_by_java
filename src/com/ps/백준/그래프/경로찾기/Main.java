package com.ps.백준.그래프.경로찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
* 한창 bfs관련 문제를 풀다가 이 문제를 만났더니 bfs가 떠올랐다.
* 문제에서는 경로만 찾으면 된다고 했지만 인풋이 인접행렬로 주어지니
* dfs로 푸는걸 의도한게 아닐까 싶다.
*
*
* 방향그래프였네?
* */


class Main {

    static List<Integer> board[];
    static boolean visitCheck[];
    static boolean pathExist[][];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/경로찾기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        board = new List[n];
        for (int i = 0; i < board.length; i++) {
            board[i] = new ArrayList<>();
        }

        visitCheck = new boolean[n];
        pathExist = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < n; j++) {
                boolean isVertex = Integer.parseInt(st.nextToken()) == 1;
                if(isVertex){
                    board[i].add(j);
                }
            }
        }

        for (int start = 0; start < board.length; start++) {
            for (int end = 0; end < board.length; end++) {

//                if(start == end) continue;

//                if(start == 2 && end == 2){
//                    System.out.println("debug");
//                }

                int prevPos = start;
                visitCheck[start] = true;
                dfs(0, start, end, prevPos);
                Arrays.fill(visitCheck, false);
            }
        }


        for (int i = 0; i < pathExist.length; i++) {
            for (int j = 0; j < pathExist[0].length; j++) {

                if(pathExist[i][j]) System.out.print(1 + " ");
                else System.out.print(0 + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int depth, int startPos, int endPos, int prevPos) {

//        if(depth != 0 && endPos == prevPos){
//            pathExist[startPos][endPos] = true;
//            return;
//        }

        if(depth == board.length){
            return;
        }


        for (Integer nextPos : board[prevPos]) {
            if(nextPos == endPos) {
                pathExist[startPos][endPos] = true;
                return;
            }

            if(visitCheck[nextPos]) continue;
            visitCheck[nextPos] = true;

            dfs(depth + 1, startPos, endPos, nextPos);
            visitCheck[nextPos] = false;

        }

    }

}
