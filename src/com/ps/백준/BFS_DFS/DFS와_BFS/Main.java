package com.ps.백준.BFS_DFS.DFS와_BFS;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    //풀이 출처 : https://m.blog.naver.com/lm040466/221787478911


    /*
    * dfs
    * 1. 해당 정점 방문기록
    * 2. 해당 정점에서 다른정점으로 가는 간선을 모두 돌아보면서 아직 방문 안된 정점이 있다면 해당 정점으로 이동.
    * 3. 반복
    * */
    public static void dfs(int visitVertex, int interlineState[][], boolean visitCheck[]) {
        visitCheck[visitVertex] = true;
        System.out.print(visitVertex + " ");

        //visitVertext라는 정점을 중심으로 한 간선탐색
        for (int i = 0; i < interlineState[0].length; i++) {
            if (interlineState[visitVertex][i] == 1 //간선이 있고
                    && visitCheck[i] == false // 아직 방문을 안한 정점이라면
            ) {
                dfs(i, interlineState, visitCheck);
            }
        }
    }


    /*
    * bfs
    * 기본 컨셉은 모든 정점을 돌아다니면서 자신과 연결된 정점들을 방문 후보지 queue에 넣어두고 큐가 empty될떄까지 반복하는것.
    * 1. 시작정점을 방문후보queue에 넣는다.
    * 2. 방문후보queue에서 다음 방문할 정점을 꺼낸다.
    * 3. 해당 정점과 연결된 모든 정점을 후보queue에 넣는다.
    * 4. 2번부터 반복.
    * */
    public static void bfs(int startVertex, int interlineState[][], boolean visitCheck[]) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);
        visitCheck[startVertex] = true;
        System.out.print(startVertex + " ");

        for (; !queue.isEmpty(); ) {
            Integer vertex = queue.poll();

            for (int i = 0; i < interlineState[0].length; i++) {
                if (interlineState[vertex][i] == 1
                        && visitCheck[i] == false) {
                    queue.offer(i);
                    visitCheck[i] = true;
                    System.out.print(i + " ");
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/DFS_BFS/DFS와_BFS/input.txt"));
        Scanner sc = new Scanner(System.in);

        int vertexCount = sc.nextInt();
        int interlineCount = sc.nextInt();
        int searchStart = sc.nextInt();//정점번호 1번부터

        int interlineState[][] = new int[vertexCount + 1][vertexCount + 1];
        boolean visitCheck[] = new boolean[vertexCount + 1];

        for (int i = 1; i <= interlineCount; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            interlineState[v1][v2] = 1;
            interlineState[v2][v1] = 1;
        }

        dfs(searchStart, interlineState, visitCheck);

        visitCheck = new boolean[vertexCount + 1];
        System.out.println("");

        bfs(searchStart, interlineState, visitCheck);

        System.out.println("");
    }

}
