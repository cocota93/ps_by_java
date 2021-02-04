package com.ps.백준.BFS_DFS.숨바꼭질3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


/*
* 먼저 찾았다고 더 빠르다 보장할수 없을텐데 언제 종료하지??
* */

/*
* 재귀로 풀었더니 스택오버플로우 떠서 이전에 숨바꼭질1 문제 풀었던거 보니 큐로 풀었길래 큐로 시도
* 그러고보니 스택오버플로 난다는거에서 BFS로 풀어야한다는걸 눈치 챘어야했음.
* -> 어제 정리한 내용중에 가중치 같을떄 bfs쓴다고 정리해놓고 지금 이문제는 가중치 다른데 쓰고있네 ㅡㅡ
* -> 정석대로면 쓰면 안되는듯. BFS로 푼 사람들은 많은것 같은데 질문검색 게시판에 이거에 대해서 뭐라하는말 있었음.
* */

/*
*
* 큐로 풀었지만 시간초과 발생...어카지
* -> 숨바꼭질1문제와 주요 차이점은 순간이동을 했을떄의 비용이 0이라는점이다.
* 떄문에 큐에 인큐후 정렬을 해야해서 비용이 적은것 먼저 해줘야 한다고 한다.
* https://jaimemin.tistory.com/583
* 위 링크에서는 우선순위 큐를 사용하라고 하는데 일반 큐로 정렬 이용해도 같은 결과 나올줄 알고
* 그냥 정렬 한번 수행해서 제출해봤는데 시간초과발생한다.
* -> 그래도 시간초과 발생.
* */

/*
* 비용이 더 적으면 이미 방문했어도 큐에 인큐해야되는데 방문한적 있으면 인큐 못하도록 막아놔서 계속 헤맸음 ㅡㅡ
* */

class Main {
    static int broPos;
    static int costTable[];
    static boolean visited[];
//    static Queue<CostInfo> nextMoveQueue = new PriorityQueue<>(Comparator.comparingInt(costInfo -> costInfo.cost));
    static Queue<CostInfo> nextMoveQueue = new LinkedList<>();

    static class CostInfo{
        int pos;
        int cost;

        public CostInfo(int pos, int cost) {
            this.pos = pos;
            this.cost = cost;
        }
    }


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/BFS_DFS/숨바꼭질3/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int subinStartPos = Integer.parseInt(st.nextToken());
        broPos = Integer.parseInt(st.nextToken());

        costTable = new int[100000 + 1];
        visited = new boolean[100000 + 1];

        for (int i = 0; i < costTable.length; i++) {
            costTable[i] = Integer.MAX_VALUE;
        }

        nextMoveQueue.add(new CostInfo(subinStartPos, 0));
//        visited[subinStartPos] = true;
//        costTable[subinStartPos] = -1;

        BFS();

        System.out.println(costTable[broPos]);
    }

    private static void BFS() {

        while(!nextMoveQueue.isEmpty()){
            CostInfo curPlace = nextMoveQueue.poll();

            if(visited[curPlace.pos] && costTable[curPlace.pos] <= curPlace.cost) continue;

            visited[curPlace.pos] = true;
            costTable[curPlace.pos] = curPlace.cost;


//            if(curPlace.pos == broPos){
//                System.out.println("debug");
//            }

            {
                int nextPos = curPlace.pos * 2;
                int nextCost = curPlace.cost;
                if(nextPos >= 0 && nextPos < visited.length ){
                    if(nextPos > 0){
                        visited[nextPos] = true;
                        nextMoveQueue.add(new CostInfo(nextPos, nextCost));
                    }
                }
            }

            {
                int nextPos = curPlace.pos + 1;
                int nextCost = curPlace.cost + 1;
                if(nextPos >= 0 && nextPos < visited.length ){
                    visited[nextPos] = true;
                    nextMoveQueue.add(new CostInfo(nextPos, nextCost));
                }
            }

            {
                int nextPos = curPlace.pos - 1;
                int nextCost = curPlace.cost + 1;
                if(nextPos >= 0 && nextPos < visited.length ){
                    visited[nextPos] = true;
                    nextMoveQueue.add(new CostInfo(nextPos, nextCost));
                }
            }



//            nextMoveQueue.stream().sorted(Comparator.comparingInt(costInfo -> costInfo.cost));
        }

    }

}
