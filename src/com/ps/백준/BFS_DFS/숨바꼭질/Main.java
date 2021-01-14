package com.ps.백준.BFS_DFS.숨바꼭질;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {

    /*
     * 풀이참고 : https://velog.io/@leeinae/Algorithm-%EB%B0%B1%EC%A4%801697-%EC%88%A8%EB%B0%94%EA%BC%AD%EC%A7%88
     *
     * 정점과 간선에 대한 정보가 제대로 주어지지 않은것 같아서 이게 어떻게 bfs, dfs문제인지 감이 안왔다.
     * 정점은 현재위치이고 1초후 이동할수있는 후보지들이 간선의 정보였다.
     * 간선을 만든다는 느낌도 조금 든다.
     * */

    static class TileInfo {
        int pos;
        int moveCost;

        public TileInfo(int pos, int moveCost) {
            this.pos = pos;
            this.moveCost = moveCost;
        }
    }

    private static void DFS(int myPos, int broPos) {
        boolean visitCheck[] = new boolean[100001];
        Queue<TileInfo> queue = new LinkedList<>();
        queue.add(new TileInfo(myPos, 0));


        int result = 0;
        for (; !queue.isEmpty(); ) {

            TileInfo currentState = queue.poll();
            if (currentState.pos == broPos) {
                result = currentState.moveCost;
                break;
            }

            {
                int nextPos = currentState.pos + 1;
                if (nextPos >= 0 && nextPos < visitCheck.length
                        && visitCheck[nextPos] == false) {
                    queue.add(new TileInfo(nextPos, currentState.moveCost + 1));
                    visitCheck[nextPos] = true;
                }
            }

            {
                int nextPos = currentState.pos - 1;
                if (nextPos >= 0 && nextPos < visitCheck.length
                        && visitCheck[nextPos] == false) {
                    queue.add(new TileInfo(nextPos, currentState.moveCost + 1));
                    visitCheck[nextPos] = true;
                }
            }

            {
                int nextPos = currentState.pos * 2;
                if (nextPos >= 0 && nextPos < visitCheck.length
                        && visitCheck[nextPos] == false) {
                    queue.add(new TileInfo(nextPos, currentState.moveCost + 1));
                    visitCheck[nextPos] = true;
                }
            }
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/BFS_DFS/숨바꼭질/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int myPos = Integer.parseInt(st.nextToken());
        int broPos = Integer.parseInt(st.nextToken());

        DFS(myPos, broPos);

    }

}
