package com.ps.백준.완전탐색.알파벳;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 전형적인 길찾기 문제같아보인다. DFS or BFS를 써야할것같은데
* 이전에 지나친곳은 가면 안된다고 하니까 재귀를 이용하여 구현하는게 좋을것 같고
* 떄문에 DFS가 적당한것 같다.
* 최대 몇칸인지를 알아야 하니 모든 경로를 다 방문해봐야 하고 그럴려면 백트래킹으로 구현되야 할것같다.
*
* 문제를 다시읽어보니 무조건 밑으로 내려가야하는게 아니라 상하좌우 네방향중 방문하지 않은곳이면 어디든 괜찮은것 같다.
* 방문여부 체크하는걸 2개를 가져야할지 하나만 가져도 될지 모르겠다. 어떤 위치에 방문했는지 까지는 필요 없고 알파벳만 저장하면 될것같은데?
*

* */


class Main {
    static int height;
    static int width;
    static char board[][];
    static boolean visited[] = new boolean[100];

    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};

    static int resultMaxDepth = 1;


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/알파벳/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        board = new char[height][width];


        for (int i = 0; i < height; i++) {
            String s = br.readLine();
            for (int j = 0; j < width; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int depth = 1;
        visited[board[0][0]] = true;
        DFS(depth, 0, 0);


        System.out.println(resultMaxDepth);
    }

    private static void DFS(int depth, int y, int x) {
        resultMaxDepth = Math.max(resultMaxDepth, depth);

        for(int dir = 0 ; dir < dx.length; dir++){
            int nextY = y + dy[dir];
            int nextX = x + dx[dir];

            if(nextY < 0 || nextY >=  board.length) continue;
            if(nextX < 0 || nextX >=  board[0].length) continue;
            if(visited[board[nextY][nextX]]) continue;
            visited[board[nextY][nextX]] = true;

            //방문여부 체크?
            //기존 알파벳 체크?

            DFS(depth + 1, nextY, nextX);
            visited[board[nextY][nextX]] = false;
        }


    }

}
