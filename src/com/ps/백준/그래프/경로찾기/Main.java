package com.ps.백준.그래프.경로찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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
                Queue<Integer> queue = new LinkedList<>();
                queue.add(start);
                visitCheck[start] = true;

                while(!queue.isEmpty()){

                    Integer visitPlace = queue.poll();

                    if(visitPlace == end){
                        //경로찾음
                        pathExist[start][end] = true;
                        break;
                    }

                    for (Integer nextPlace : board[visitPlace]) {
                        if(!visitCheck[nextPlace]){
                            queue.add(nextPlace);
                            visitCheck[nextPlace] = true;
                        }
                    }
                }

            }
        }


//        for (int start = 0; start < board.length; start++) {
//            for (int end = 0; end < board.length; end++) {
//
//                int prevPos = start;
//                visitCheck[start] = true;
////                dfs(0, start, end, prevPos);
//                Arrays.fill(visitCheck, false);
//            }
//        }


        for (int i = 0; i < pathExist.length; i++) {
            for (int j = 0; j < pathExist[0].length; j++) {

                if(pathExist[i][j]) System.out.print(1 + " ");
                else System.out.print(0 + " ");
            }
            System.out.println();
        }
    }
}
