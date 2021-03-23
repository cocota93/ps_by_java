package com.ps.백준.sds스터디._8주차.연구소;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 일단 벽을 다 한번씩 쳐보고 바이러스 퍼트려본다음 안전구역 확인해 보는 방법밖에 없나?
*
* 근데 그렇게하면 벽 어디둘지만 계산해도 (n * m)^3 인데;;n과m은 최대 8이니까 8^6 = 2^18 = 262144
* 생각보다 그렇게 크지는 않네
*
* 바이러스 퍼트려보는데 걸리는 시간도 고려해야됨.
* log^(n*m) 으로 보면 돨려나?
*
* 만약 그렇다면 이것도 그렇게 오래걸리지는 않네
*
* 오래걸릴거 처럼 생기긴 했는데 생각보다 그리 오래걸리지는 않네;;
* 내가 계산을 잘못 한건가?
*
*
* */
class Main {

    static int board[][];
    static int WALL = 1;
    static int VIRUS = 2;

    static class POINT{
        int y;
        int x;

        public POINT(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/sds스터디/_8주차/연구소/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        board = new int[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < width; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < board.length * board[0].length; i++) {


            POINT wall1 = new POINT(i / board[0].length, i % board[0].length);
//            System.out.println("(" + wall1.y + ", " + wall1.x + ")");

            if(board[wall1.y][wall1.x] != 0) continue;

            for (int j = i + 1; j < board.length * board[0].length; j++) {
                POINT wall2 = new POINT(j / board[0].length, j % board[0].length);
                if(board[wall2.y][wall2.x] != 0) continue;

                for (int k = j + 1; k < board.length * board[0].length; k++) {
                    POINT wall3 = new POINT(k / board[0].length, k % board[0].length);
                    if(board[wall3.y][wall3.x] != 0) continue;



//                    if((wall1.y == 0 && wall1.x == 1) &&
//                        (wall2.y == 1 && wall2.x == 0) &&
//                        (wall3.y == 3 && wall3.x == 5)
//                    ){
//                        System.out.println("deubg");
//                    }

                    //시뮬용 board복사
                    int instantBoard[][] = new int[board.length][board[0].length];
                    for (int c = 0; c < board.length; c++) {
                        instantBoard[c] = Arrays.copyOf(board[c], board[c].length);
                    }

                    POINT wallArray[] = new POINT[3];
                    wallArray[0] = wall1;
                    wallArray[1] = wall2;
                    wallArray[2] = wall3;

                    //임의의 벽 설정
                    for (int l = 0; l < wallArray.length; l++) {
                        instantBoard[wallArray[l].y][wallArray[l].x] = WALL;
                    }


                    answer = Math.max(simulation(wallArray, instantBoard), answer);
                }
            }
        }

        System.out.println(answer);
    }

    private static int simulation(POINT[] wallArray, int[][] instantBoard) {

        //바이러스 확산
        Queue<POINT> nextPollutionPlace = new LinkedList<>();
        boolean visited[][] = new boolean[instantBoard.length][instantBoard[0].length];
        for (int i = 0; i < instantBoard.length; i++) {
            for (int j = 0; j < instantBoard[0].length; j++) {
                if(instantBoard[i][j] == VIRUS){
                    nextPollutionPlace.add(new POINT(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while(!nextPollutionPlace.isEmpty()){
            POINT visitPlace = nextPollutionPlace.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nextY = visitPlace.y + dy[dir];
                int nextX = visitPlace.x + dx[dir];
                if(nextY < 0 || instantBoard.length <= nextY) continue;
                if(nextX < 0 || instantBoard[0].length <= nextX) continue;
                if(visited[nextY][nextX]) continue;
                if(instantBoard[nextY][nextX] != 0) continue;

                nextPollutionPlace.add(new POINT(nextY, nextX));
                visited[nextY][nextX] = true;
                instantBoard[nextY][nextX] = VIRUS;
            }
        }


        //안전공간 계산
        int answer = 0;
        for (int i = 0; i < instantBoard.length; i++) {
            for (int j = 0; j < instantBoard[0].length; j++) {
                if(instantBoard[i][j] == 0) answer++;
            }
        }

//        if(answer == 35){
//            System.out.println("debug");
//        }

        return answer;
    }

}
