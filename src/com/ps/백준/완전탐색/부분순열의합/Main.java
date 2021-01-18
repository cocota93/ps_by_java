package com.ps.백준.완전탐색.부분순열의합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//풀이출처 : https://seol-limit.tistory.com/13
/*
* 어떻게 풀라는건지 아에 감이 안와서 바로 풀이 확인.
* 배열을 순회하면서 재귀로 호출하는데, 각 인덱스의 요소를 더했을때와 안더했을때의 값을 확인하는 방식으로 진행된다.
* */

class Main {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/부분순열의합/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int board[] = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        int curDepth = 0;
        int curSum = 0;
        int result = Recur(board, curDepth, curSum, s) - 1;//아무것도 안더하는 케이스 하나를 뺴줌
        System.out.println(result);
    }

    private static int Recur(int[] board, int curDepth, int curSum, int destSum) {
        if(curDepth == board.length){
            //재귀로 코드를 작성할떄 이 종료부에서는 딱 체크만 하는것 같다.
            //만약 여기서 뭔가 값이 변경될경우 로직 구성이 상당히 애매해지는경우가 많은것 같음
            //예를들면 여기서 board에 무엇인가를 넣을경우 크기가 바뀌기 떄문에 이전에 계산한 인덱스가 안맞을수 있음.
            //결국 코드 더러워지고 안그래도 머리아픈 재귀인데 이상하게 꼬일가능성 매우 높아짐.

            if(curSum != destSum) return 0;
            return 1;
        }

        int count = 0;
        count += Recur(board, curDepth + 1, curSum, destSum);
        count += Recur(board, curDepth + 1, curSum + board[curDepth], destSum);

        return count;
    }


}
