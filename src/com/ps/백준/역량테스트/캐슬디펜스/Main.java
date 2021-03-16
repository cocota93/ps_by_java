package com.ps.백준.역량테스트.캐슬디펜스;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.*;

/*
* 가장 가까이 있는 적 공격
* 거리가 같은경우 왼쪽 먼저.
* 모든 궁수는 동시에 공격
* 한턴이 끝날떄마다 몬스터는 한칸씩 내려옴
* 몬스터가 성에 도달하면 해당 몬스터는 게임에서 제외
* 모든 몬스터가 격자판에서 제외되면 게임끝
* 궁수의 위치는 게임 시작시 임의로 지정.
*
* 거리에 대한 계산
* 격자판의 두 위치 (r1, c1), (r2, c2)의 거리는 |r1-r2| + |c1-c2|이다.
* */

/*
* 게임의 결과에 영향을 미치는건 게임 시작시 임의로 지정해주는 궁수의 위치가 유일.
* 나머지는 인풋과 규칙으로 주어진 그대로 진행됨.
*
* 그냥 문제에서 주어진대로 몬스터가 한칸씩 내려오는걸 시뮬레이션 해도 될것 같긴한데
* 성이 위쪽으로 한칸씩 움직이는게 훨씬 더 구현이 쉬울것 같기도하구...
* 그냥 이렇게 풀면되나? 뭔가 더 떠오르는게 없네?
*
* 5*4*3 = 60
* 3 * 2 = 6
*
* nC3 - 1
*
* 15 * 14 * 13 = 2730
* 6
* 455 - 1
*
*
* 9
* */

class Main {

    static class Target{
        int y;
        int x;
        int dist;

        public Target(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

    static int originBoard[][];
    static int board[][];
    static int archerPosX[];

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/역량테스트/캐슬디펜스/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());//행의 수
        int m = Integer.parseInt(st.nextToken());//열의 수
        int d = Integer.parseInt(st.nextToken());//궁수 공격 거리

        originBoard = new int[n][m];
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                originBoard[i][j] = Integer.parseInt(st.nextToken());
                board[i][j] = originBoard[i][j];
            }
        }

        archerPosX = new int[3];

        int answer = 0;
        for (int archer1Pos = 0; archer1Pos < m; archer1Pos++) {
            archerPosX[0] = archer1Pos;
            for (int archer2Pos = archer1Pos + 1; archer2Pos < m; archer2Pos++) {
                archerPosX[1] = archer2Pos;
                for (int archer3Pos = archer2Pos + 1; archer3Pos < m; archer3Pos++) {
                    archerPosX[2] = archer3Pos;

//                    if(archer1Pos == 0 && archer2Pos == 2 && archer3Pos == 3){
//                        System.out.println("debug");
//                    }

                    for (int i = 0; i < originBoard.length; i++) {
                        board[i] = Arrays.copyOf(originBoard[i], originBoard[i].length);
                    }
                    answer = Math.max(Simulation(n, d), answer);
                }
            }
        }

        System.out.println(answer);
    }

    private static int Simulation(int archerPosY, int attackRange) {
        int killCount = 0;
        int archerCount = archerPosX.length;
        boolean hasKill[] = new boolean[archerCount];


        Queue<Target> pq = new PriorityQueue<>(board[0].length, (target1, target2) -> {
            if(target1.dist == target2.dist){
                return target1.x - target2.x;
            }
            return target1.dist - target2.dist;
        });

        List<Target> killTargetList = new ArrayList<>();

        for (int turnCount = 0; turnCount < board.length; turnCount++) {
            Arrays.fill(hasKill, false);

            //궁수별 공격대상 판단
            for (int archerNum = 0; archerNum < archerCount; archerNum++) {

//                if(archerPosX[0] == 0 && archerPosX[1] == 2 && archerPosX[2] == 4){
//                    if(archerNum == 1){
//                        if(turnCount == 3){
//                            System.out.println("debug");
//                        }
//                    }
//                }



                for (int y = board.length - 1 - turnCount; y >= 0; y--) {

                    for (int x = 0; x < board[0].length; x++) {
                        if(board[y][x] != 1) continue;//적이없으면 건너뜀.

                        int dist = GetDistance(y, x, archerPosY, archerPosX[archerNum]);
                        if(dist <= attackRange){
                            pq.add(new Target(y,x,dist));
                        }
                    }

                    //각 행이 끝날때마다 아래의 if(!pq.isEmpty()) 로직을 선제적으로
                    //수행해버렸더니 거리는 두칸 위에 있는것과 대각선 한칸위에 있는것중에 두칸위에 있는게
                    //더 왼쪽에 있어서 선택이 되어야함에도 확인도 못하고 넘어가게 되서 계속 틀렸음.
                }

                //해당 궁수가 누구 죽일건지 선택끝.
                if (!pq.isEmpty()) {
                    Target killTarget = pq.poll();//가장 가까운녀석 누군지 선택
                    killTargetList.add(new Target(killTarget.y,killTarget.x,-1));
                    pq.clear();
                }
            }

            for (Target target : killTargetList) {
                //타겟 리스트에 있어도 board[target.y][target.x]가 0이 아닌경우 이미 다른 궁수가 죽인녀석. 카운트 하지않음.
                if (board[target.y][target.x] != 0)
                {
                    board[target.y][target.x] = 0;
                    killCount++;
                }
            }

//            ForDebugging(killCount, killTargetList, turnCount);

            killTargetList.clear();


            archerPosY--;



        }




        return killCount;
    }

    private static void ForDebugging(int killCount, List<Target> killTargetList, int turnCount) {
        if(archerPosX[0] == 0 && archerPosX[1] == 2 && archerPosX[2] == 4)
        {
            System.out.println("turn : " + turnCount + "");
            System.out.print("kill : ");
            for (Target target : killTargetList) {
//                    System.out.print("y : " + target.y + ", x : " + target.x );
                System.out.print("(" + target.y + ", " + target.x + "), ");
            }
            System.out.println();

            System.out.println("killCount : " + killCount);

            System.out.println("-----");
        }
    }

    private static int GetDistance(int y, int x, int archerPosY, int archerPosX) {
        return Math.abs(y - archerPosY) + Math.abs(x - archerPosX);
    }


}
