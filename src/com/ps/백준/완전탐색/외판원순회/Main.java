package com.ps.백준.완전탐색.외판원순회;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
* 모든 도시 다 방문후 출발도시로 돌아와야함
* 한번 방문한 도시는 다시 방문 못함.
* 도시간 이동하는데 드는 비용 다름
* 양방향 그래프아님. 그래서 똑같은 도시간 이동이여도 올떄, 갈떄의 비용 다름
* 최소비용으로 이동해야함
* 출발도시는 마음대로
* 막다른길은 없다고 받아들여도 될듯.
* */

/*
* 최소비용 문제니까 BFS?
* 근데 단순히 방문만 하면 끝이 아니라 뒤로 돌아가는것 없이 한번에 모두 방문해야됨
* ㅡㅡ
* DFS인데 모든 경로를 다 해보는걸로 하면 되지않을까?
* 양방향 그래프가 아니여서 방문도시에 대한 체크??를 어떻게 해야할지 모르겠음.
* */
class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/외판원순회/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int cityCount = Integer.parseInt(br.readLine());
        int board[][] = new int[cityCount][cityCount];
        for (int i = 0; i < cityCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < cityCount; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean visitCheck[][] = new boolean[cityCount][cityCount];
        int currentCity = 0;
        int visitCount = 0;
        int cost = 0;
        DFS(board, visitCheck, currentCity, visitCount, cost);

    }

    private static int DFS(int[][] board, boolean[][] visitCheck, int currentCity, int visitCount, int cost) {
//        if(visitCheck == visitCheck.length){
//
//            return cost + board[currentCity][];
//        }

        for (int from = 0; from < board.length; from++) {
            for (int to = 0; to < board.length; to++) {
            }
        }

        return 0;
    }

}
