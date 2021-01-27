package com.ps.백준.그리디.풀지못한문제.수묶기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.FileInputStream;
import java.util.StringTokenizer;


/*
* 정답과 계산과정은 long으로
* 0이랑 -는 묶지말고 단독으로 처리. 0이랑 - 둘다 있으면 서로 곱하기 시키면됨.
*
* 문제를 읽고 고민했던 부분은 어떻게 묶었을떄 그 합이 최대가 나오는지 모른다는것이다.
* 그냥 가장 큰수끼리 묶으면 될지 아니면 가장큰수랑 가장 작은수랑 묶는게 나은지 정확히 모른다.
* 그 다음 힌트를 모르겠다.
*
* {1, 2, 3, 4}
* {1, 2, 3, 100}
* 으로 간단하게 계산해봤는데 그냥 앞에서부터 두개씩 묶어서 계산한게 항상 큰듯?너무 당연한건가?
* 만약 묶은것끼리 더한뒤 곱하는 문제였으면 양끝에서부터 묶는게 더 크다.
* (위에 예제기준으로. {(1 + 4) * (2 + 3) = 25, (1 + 2) * (3 + 4) = 21}, {(1 + 100) * (2 + 3) = 505, (1 + 2) * (3 + 100) = 309   )
* 그럼 위에껀 그렇다치고 만약 문제가 복잡해서 어떻게 해야 더 큰값이 만들어지는지 예측이 안된다면 어떠카지??
*
*
*
*
*
* 1이 섞여있으면 더하는게 더 큼.
* -가 2개면 곱하는게 더큼
* 0이랑 -랑 동시에있으면 묶어서 곱한게 더 큼
* 0아닌수랑 -랑 있으면 -만 따로 처리하는게 더 큼.
*
*
* 풀이출처 : https://mygumi.tistory.com/220
*
* */

class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/그리디/수묶기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int boardLength = Integer.parseInt(br.readLine());
        int board[] = new int[boardLength];
        for (int i = 0; i < boardLength; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(board);

        for (int i = 0; i < board.length; i++) {
        }


    }

}
