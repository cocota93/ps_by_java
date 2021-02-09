package com.ps.백준.완전탐색.알고스팟;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* bfs로 풀고 queue만들떄 priority Queue로 만들면 되지않을까?
* 큐에 데이터 넣을떄 이동위치랑 부신 벽의 개수 넣고
* priority정렬 기준을 부신 벽의 개수가 적은 순서대로
* -> 나중에 알고보니 이게 다익스트라였음;;
*
* 즉 부시는 벽의 개수가 가중치가 되는상황.
* */

/*
* 벽을 부숴야 된다는거가 결국 가중치가 달라지는 상황 아닌가?
* 그럼 다익스트라로 풀어야 하는건가?
*
* 벽을 안부시면 가중치가 0
* 벽을 부시면 가중치가 1이 되는거잖아?
*
* */


/*
* 이미 방문을 했는데 가중치가 더 적게해서 방문하게 되는 상황이 생길수도 있나 고민해봤는데
* 이미 방문했지만 가중치가 같은 상황이 와서 재방문을 스킵하는 상황은 올수 있어도
* 가중치가 더 적은 상황이 올수는 없을것 같다. priority queue를 사용함으로써 항상 가장 작은 가중치를 먼저
* 방문하고 소비하기 떄문에 가중치의 종류가 하나라면 그런상황은 올수 없을것 같고 만약
* 가중치가 여러 복합적인 개념이 혼합되어있다면 가능할지도??
* */


class Main {

    static class MoveHistory {
        int y;
        int x;
        int brokenWallCount;

        public MoveHistory(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public MoveHistory(int y, int x, int brokenWallCount) {
            this.y = y;
            this.x = x;
            this.brokenWallCount = brokenWallCount;
        }

//comparable상속
    }



    static int board[][];
    static boolean visited[][];
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/알고스팟/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        board = new int[height][width];
        visited = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            String row = br.readLine();
            for (int j = 0; j < width; j++) {
                board[i][j] = row.charAt(j) - '0';
            }
        }

//        for (int i = 0; i < height; i++) {
//            System.out.println(Arrays.toString(board[i]));
//
//        }


        bfs();

    }

    private static void bfs() {
        Queue<MoveHistory> queue = new PriorityQueue<>(Comparator.comparingInt(MoveHistory -> MoveHistory.brokenWallCount));
        queue.add(new MoveHistory(0, 0));

        while(!queue.isEmpty()){
            MoveHistory move = queue.poll();
            if (move.y == board.length - 1 && move.x == board[0].length - 1) {
                System.out.println(move.brokenWallCount);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = move.y + dy[i];
                int nextX = move.x + dx[i];

                if(nextY < 0 || nextY >= board.length) continue;
                if(nextX < 0 || nextX >= board[0].length) continue;
                if(visited[nextY][nextX]) continue;
                visited[nextY][nextX] = true;


                int brokenCount = move.brokenWallCount + board[nextY][nextX];

                queue.add(new MoveHistory(nextY, nextX, brokenCount));
            }

        }
    }

}
