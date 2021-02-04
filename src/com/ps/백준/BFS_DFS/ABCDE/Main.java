package com.ps.백준.BFS_DFS.ABCDE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
* 처음 문제를 봤을떄는 그냥 단순 카운트 하거나 dfs, bfs문제 아닌가? 라고 생각했지만
* a를 조사하면서 함꼐 조사했던 bc들을 나중에 또 방문하게 되네???풀리긴 할것같은데 유니온파인드로 푸는게 맞는것 같기도 하고;;
*
* 문제만 보고 예제를 안읽었을떄는 '유니온파인드로 푸는거 아닌가?' 라며 헷갈렸지만
* 예제를 좀 더 살펴보니 DFS로 푸는게 맞는것같다. depth가 4이상인경우를 찾으면될듯
* */

/*
* 친구는 양방향 관계지;;;한방향으로 생각하고 풀다보니까 마지막 예제가 안맞는 현상 있었음
* */

/*
* 인접행렬 + DFS 푸니까 시간초과 발생
* 인접리스트로는 아직 안번도 안해봤는데;;
* */

class Main {
    static int n;
    static int m;
    static List<Integer> relationList[];
    static boolean visited[];

    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/BFS_DFS/ABCDE/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        relationList = new List[n];
        for (int i = 0; i < n; i++) {
            relationList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            relationList[v1].add(v2);
            relationList[v2].add(v1);
        }

        int depth = 0;
        for (int start = 0; start < n; start++) {
            visited[start] = true;
            if(DFS(depth, start)){
                break;
            }
            visited[start] = false;
        }

        System.out.println(sb.length() == 0 ? 0 : 1);
    }

    private static boolean DFS(int depth, int from) {
        if(depth == 4){
            sb.append(1);
            return true;
        }


        for (Integer to : relationList[from]) {
            if(visited[to]) continue;

            visited[to] = true;
            if(DFS(depth + 1, to)){
                return true;
            }
            visited[to] = false;

        }

        return false;
    }

}
