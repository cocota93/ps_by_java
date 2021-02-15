package com.ps.백준.그래프.최소비용구하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


/*
* 가장 빠른길을 찾아야 하기 떄문에 bfs가 가장 먼저 떠오르긴 하지만
* 가중치가 다르기 때문에 일반적인 bfs는 안된다.
*
* 숨바꼭질3 문제처럼 다음 방문 후보지에 대한 누적 코스트를 인큐해두고 이미 방문했어도 더 적은 비용으로 방문 가능하다면
* 인큐해서 방문하여 푸는문제인듯??다익스트라
* */


/*
* 기본정보를 가지고있는 그래프 하나. 리스트가 적당할것같다. 별도의 자료형을 하나 만들어서? 음...
* 각 정점간의 이동 비용에 대한걸 어떤식으로 저장해둬야 할지가 제일 고민되네
* 이차원 배열로 하면 너무 느릴것같고 좀 낭비 아닌가 싶은데
* 이차원 리스트??
* 음..커스텀하게 자료형 하나 만들어서 자료형에는 도착지랑 기본비용 넣어두는게 맞는것같긴한데
* 일단 단순하게 이차원 배열로 해보까?.
* 제한시간 0.5초니까 리스트로 하자
* 간선연결 정보를 담아두는 컨테이너를 따로 하나 더 만들어두는게 나을듯
*
*
*
* 각 정점으로 이동했을떄의 누적 코스트를 저장해둘 컨테이너.
* 이전 정점에서의 거리가 아니라 누적된 코스트의 값을 저장할거니까
* 일차원배열에 누적된 코스트를 저장해두는 정도면 괜찮을것같다.
*
* 각 정점에 대한 방문표시할 일차원 배열하나
* */


/*
* 방문 체크를 할 필요가 있나? 어차피 중복으로 방문하면 비용이 커져서 자연스럽게 걸러질텐데?
*
* */


/*
* 완료.
*
* 기본비용의 경우 한번 인풋으로 받은 이후에는 안변하고 순회할만한 일이 없기 떄문에 이차원배열로 관리했던게 아주 적절했음.
* 간선의 연결정보 같은경우 순회를 할일이 있어서 리스트가 아주 적절했음.
*
* 동일한 경로에 다른 비용이 들어올수 있다는걸 몰라서 헤맸었는데 이부분은 많이 풀다보면 자연스럽게 해결될거라 생각.
* */




class Main {

    static class MoveHistory{
        int nextCity;
        long nextCost;

        public MoveHistory(int nextCity, long nextCost) {
            this.nextCity = nextCity;
            this.nextCost = nextCost;
        }
    }

    static boolean visited[];//방문여부
    static long accumulatedCosts[];//해당 정점으로 가는데 필요한 누적된 최소비용.
    static long basicCostTable[][];//기본비용
    static List<Integer> edgeGraph[];//간선연결정보

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/최소비용구하기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());//정점의 수
        edgeGraph = new List[n + 1];
        for (int i = 0; i < edgeGraph.length; i++) {
            edgeGraph[i] = new ArrayList<>();
        }
        basicCostTable = new long[n + 1][n + 1];
        for (int i = 0; i < basicCostTable.length; i++) {
            Arrays.fill(basicCostTable[i], -1);
        }

        int m = Integer.parseInt(br.readLine());//간선의수

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            long cost = Integer.parseInt(st.nextToken());


            if(basicCostTable[v1][v2] == -1){
                edgeGraph[v1].add(v2);
                basicCostTable[v1][v2] = cost;
            } else{
                basicCostTable[v1][v2] = Math.min(cost, basicCostTable[v1][v2]);
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        int startCity = Integer.parseInt(st.nextToken());
        int goalCity = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        accumulatedCosts = new long[n + 1];
        Arrays.fill(accumulatedCosts, Long.MAX_VALUE);

        BFS(startCity, goalCity);
    }

    private static void BFS(int startCity, int goalCity) {
        accumulatedCosts[startCity] = 0;

        Queue<MoveHistory> queue = new LinkedList();
        for (int i = 0; i < edgeGraph[startCity].size(); i++) {
            int nextCity = edgeGraph[startCity].get(i);
            long basicCost = basicCostTable[startCity][nextCity];
            long nextCost = accumulatedCosts[startCity] + basicCost;

            queue.add(new MoveHistory(nextCity, nextCost));
            visited[nextCity] = true;
            //누적비용은 언제 업데이트하지?꺼낼떄 하는게 맞는건가?
        }

        while(!queue.isEmpty()){
            MoveHistory moveHistory = queue.poll();
            int visitCity = moveHistory.nextCity;

            //해당 도시 방문했을때 기존 누적 비용보다 크면 더이상 진행할 필요 없음.
            if(accumulatedCosts[visitCity] <= moveHistory.nextCost) continue;
            accumulatedCosts[visitCity] = moveHistory.nextCost;


            for (int i = 0; i < edgeGraph[visitCity].size(); i++) {
                int nextCity = edgeGraph[visitCity].get(i);
                long basicCost = basicCostTable[visitCity][nextCity];
                long nextCost = accumulatedCosts[visitCity] + basicCost;

                queue.add(new MoveHistory(nextCity, nextCost));
                visited[nextCity] = true;
//                accumulatedCosts[nextCity] =
                //누적비용은 언제 업데이트하지?꺼낼떄 하는게 맞는건가?
            }
        }


        System.out.println(accumulatedCosts[goalCity]);
    }

}
