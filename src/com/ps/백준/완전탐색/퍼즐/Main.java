package com.ps.백준.완전탐색.퍼즐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


/*
* 완탐문제라고 느껴지긴 하는데 dfs로 풀어야할지, bfs로 풀어야할지, 단순 재귀인지
* 감이안온다.
*
* 퍼즐을 움직일떄마다 전체 판의 정보를 스냅샷처럼 남기는 방법정도만 생각나는데...
* 이전에 시도한건지는 어떻게 체크하지?
*
*
* 퍼즐 전체의 정보를 매번 복사하여 재귀로 구현하던가
* 퍼즐을 어떻게 잘 계산해서 중복체크를 할수있게해서 bfs로 구현해야할것같음.
*
* 키밸류 형태로 방문여부 체크하고
* 키밸류 형태로 해당 형태까지의 최소 비용거리 계산
* 근데 맵이 데이터가 클떄나 빠르지 작을떄는 단순탐색에 비해서 오히려 더 느린경우도 있다고 하던데 괜찮나??
*
* 위에처럼 할려고 하면 매번 해시값을 이용하여 보드의 상태를 새로 만들고 그걸 기준으로 다음 해시값을 만들어야 해서 느릴것같은데? 데이터가 적어서 괜찮나?
* */


class Main {

    static class BoardInfo {
        long boardHash;
        String boardMeta;

        public BoardInfo(long boardHash, String boardMeta) {
            this.boardHash = boardHash;
            this.boardMeta = boardMeta;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/퍼즐/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int startBoard[][] = new int[3][3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                startBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long goalHash = 123456780;
        long startHash = MakeHash(startBoard);
        String startBoardMeta = MakeBoardMeta(startBoard);
        int moveCost = 0;

        Queue<BoardInfo> queue = new LinkedList<>();
        Map<Long, Integer> costContainer = new HashMap<>();
        queue.add(new BoardInfo(startHash, startBoardMeta));
        costContainer.put(startHash, 0);

        while(!queue.isEmpty()){
            BoardInfo nextBoard = queue.poll();



        }

        System.out.println(startHash);
    }

    private static String MakeBoardMeta(int[][] startBoard) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(startBoard[i][j]);
            }
        }

        return sb.toString();
    }

    private static long MakeHash(int[][] board) {
        StringBuilder sb = new StringBuilder();
//        sb.append(1);//board[0][0] 의 값이 0이여서 가장 앞에있는 숫자가 0인경우를 없애기위해...굳이 필요없을것 같기도??

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }

        return Long.parseLong(sb.toString());
    }


}
