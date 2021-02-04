package com.ps.백준.그래프.연결요소의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

//문제에서 말하는 연결요소가 정확히 뭘 말하는지는 모르겠는데 유니온파인드 문제 아닌가?
//주어진 시간은 3초
//dfs로도 할수는 있을것 같은데 시간초과 발생할듯? 아닌가?
//-> 다시 보니까 단순 dfs로는 안될듯. 한정점에서 다른정점으로 가는 간선이 3개이상이 될수있어서...백트래킹도 다른문제 발생.
//-> 유니온파인드도 안될것같은게 완전연결 형태의 그래프면 부모가 여러명이 될수도있는거 아닌가? 유니온파인드도 아닌것같은데;;

/*
* 단순dfs가 맞았음 ㅡㅡ 인접리스트 연습겸 인접리스트로 풀어봐야겠다.
* */

class Main {
    static int n;
    static int m;
    static List<Integer> board[];
    static boolean visited[];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/연결요소의개수/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());//정점의 개수
        m = Integer.parseInt(st.nextToken());//간선의 개수
        board = new List[n + 1];
        for (int i = 0; i < board.length; i++) {
            board[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            board[v1].add(v2);
            board[v2].add(v1);
        }

        int answer = 0;
        for (int startVertex = 1; startVertex < visited.length; startVertex++) {
            if(!visited[startVertex]){
                visited[startVertex] = true;
                DFS(startVertex);
                answer++;
            }
        }

        System.out.println(answer);

    }

    private static void DFS(int from) {
        for (Integer to : board[from]) {
            if(visited[to]) continue;
            visited[to] = true;
            DFS(to);
        }
    }

}
