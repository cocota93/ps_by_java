package com.ps.백준.완전탐색.N_Queen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 제한시간을 10초나 준다.
 * 잘 모르겠어서 찾아보니까 백트래킹 문제라고 한다.
 * 백트래킹이 뭔가 했는데 여태 내가 재귀관련 문제 풀면서
 * blah[x] = true;
 * dfs()
 * blah[x] = false;
 * 이런식의 코드를 짰던게 백트래킹인것 같다.
 * */

/*
 * 이 문제는 N X N 크기의 체스판 위에서의 문제를 해결해야 하지만
 * 헹 or 열 단위로 체크할일이 많아서 일차원배열 형태로 구현하는게 훨씬 간단해진다.
 * 배열[행] = 열
 * 형태로 구현하면 된다.
 * */

/*
* 해답코드 보니까 이해되긴 하는데 음...머릿속으로 선명하게 이미지가 그려지지는 않는다.
* 일단 넘어가야하는걸까? 아니면 다른 문제들을 계속 풀어보는게 맞는걸까?
*
* 풀이출처 : https://st-lab.tistory.com/118?category=862595
* https://pangsblog.tistory.com/30
* */


class Main {

    static int board[];
    static int N;
    static int resultCount;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/N_Queen/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N];


        //퀸이 없는경우를 0으로 표현하기 위해선 1부터 시작해야함
        Recur(0);

        System.out.println(resultCount);
    }

    private static void Recur(int visitY) {
        if (N == visitY) {
            resultCount++;
            return;
        }

        for (int x = 0; x < N; x++) {//루프가 증가할떄마다 각 열에 퀸이 있을떄의 경우를 시뮬레이션
            board[visitY] = x;
            if(IsPossible(visitY)){
                Recur(visitY + 1);
            }
            //board[visitY] = - 1;
            //이 함수 스택 안에 있는한 visitY는 안바뀌고
            // 결국 다음 루프떄 똑같은 board[visitY]에 x만 바뀐채 덮어씌우기 떄문에
            //굳이 board[visitY] = -1 같은거 안해도됨.
        }


    }

    private static boolean IsPossible(int checkY) {
        for (int i = 0; i < checkY; i++) {
            //각행을 순회하면서 같은 열에 퀸이 있는지 확인
            if(board[i] == board[checkY]) return false;

            //대각선체크. x증가량과 y증가량이 같으면 대각선인거니까 그걸로 확인.
            if(Math.abs(i - checkY) == Math.abs(board[i] - board[checkY])) return false;

        }

        return true;
    }

}
