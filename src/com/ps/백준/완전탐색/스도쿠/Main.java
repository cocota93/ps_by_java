package com.ps.백준.완전탐색.스도쿠;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;


/*
 * 작은 3x3박스를 고려했을떄 들어갈수있는수, 가로와 세로를 고려했을떄 들어갈수 있는 수를 모두 넣어보고 탐색해야할것 같다.
 * 재귀를 끝내는건 언제 끝내지?? 빈칸의 수를 세어두고 빈칸을 채운수와 빈칸의 수가 같을떄까지 하면 될려나??
 *
 * 재귀를 돌떄 작은 박스단위로 도는게 아니라 그냥 빈칸에 다 접근하는 방식으로 해야될것같음
 * 그럴려면 방문해야하는 빈칸의 위치를 리스트로 가지고있는게 낫지않나?
 * 스도쿠판을 모두 순회하면서 다음 위치를 선택하는건 아닌것같은데
 *
 * 리스트로 할경우 길이가 바뀌는게 신경쓰이니까 배열로 해야겠다.
 * 코드가 점점 지저분해지는게 이게 아닌것 같다는 느낌이 살짝 오는데 ㅡㅡ
 * */

class Main {

    static class Vertex {
        int y;
        int x;

        public Vertex(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int board[][] = new int[9][9];
    static int spaceCount;
    //static List<Vertex> nextSpacePosList = new ArrayList<>();
    static Vertex nextSpacePosList[];
    static boolean visitSpacePosList[];
    static boolean resultRender = false;
    static int depthForDebug = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/스도쿠/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < board.length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    spaceCount++;
                }
            }
        }

        nextSpacePosList = new Vertex[spaceCount];
        visitSpacePosList = new boolean[spaceCount];
        {
            int k = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] == 0) {
                        nextSpacePosList[k] = new Vertex(i, j);
                        k++;
                    }
                }
            }
        }

        int depth = 0;
        Recur(depth);

//        System.out.println(depthForDebug);
    }

    private static boolean Recur(int depth) {

//        depthForDebug = Math.max(depthForDebug, depth);
//        if(depthForDebug == 16){
//            System.out.println("debug");
//        }

        if (spaceCount == depth) {

            if(resultRender) return true;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.printf("%d ", board[i][j]);
                }
                System.out.println("");
            }
            resultRender = true;


            return true;
        }

        //방문 확인 할필요가 없을것 같은데?? depth가 항상 플러스 된채로 접근하니까?
        Vertex vertex = nextSpacePosList[depth];

        for (int j = 1; j < 10; j++) {
            //보드에 값 채우고
            board[vertex.y][vertex.x] = j;

            //3x3크기 체크..체크 목적은 중복만 체크하면됨.
            if (CheckDuplicate3by3(vertex.y, vertex.x)) continue;

            //좌우 일직선 확인
            if (CheckDuplicateRow(vertex.x)) continue;
            if (CheckDuplicateCol(vertex.y)) continue;

            // 재귀 호출
            boolean resultRender = Recur(depth + 1);
            if (resultRender) {
                return true;
            }

            //보드에 값 채웠던걸 다시 지워줘야 하려나?안지워도 똑같은 순서로 다른숫자 넣어서 진행될테니 필요없을듯
            //-> 지워줘야함ㅡㅡ.근데 여기 말고 for나가서 지워줘야함.
            // 안에서 해버리면 루프가 끝까지 다돌아서 자연스럽게 함수 끝났을때는 제대로 안지워짐.
//            board[vertex.y][vertex.x] = 0;
        }

        board[vertex.y][vertex.x] = 0;


        return false;
    }

    private static boolean CheckDuplicateCol(int y) {
        int checkNumber[] = new int[board.length + 1];
        for (int i = 0; i < board.length; i++) {
            int number = board[y][i];
            checkNumber[number]++;

            if (number != 0 && checkNumber[number] >= 2) {
                return true;
            }
        }

        return false;
    }

    private static boolean CheckDuplicateRow(int x) {
        int checkNumber[] = new int[board.length + 1];
        for (int i = 0; i < board.length; i++) {
            int number = board[i][x];
            checkNumber[number]++;

            if (number != 0 && checkNumber[number] >= 2) {
                return true;
            }
        }

        return false;
    }

    private static boolean CheckDuplicate3by3(int y, int x) {
        int boxStartY = (y / 3) * 3;
        int boxStartX = (x / 3) * 3;

        int checkNumber[] = new int[10];
        for (int i = boxStartY; i < boxStartY + 3; i++) {
            for (int j = boxStartX; j < boxStartX + 3; j++) {
//                if(board[i][j] == 0) continue; //빈칸은 패스

                checkNumber[board[i][j]]++;
                if (board[i][j] != 0 && checkNumber[board[i][j]] >= 2) {
                    return true;
                }
            }
        }

        return false;
    }

}
