package com.ps.백준.투포인터.구간의합구하기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
* 이문제를 처음 풀었던건 두달전인 2012.02.5.
* 지금 이 문제를 다시 보면서 왜 이렇게 쉬운문제를 제출 실패상태로 두고 넘어갔는지
* 의아해 하면서 풀었는데 방금 또 시간초과로 제출 실패했다.
* 음...
* */

/*
* 음...해설 참고해서 풀고 나니까 그제서야 좀 이해가 된다.
* 누적합 = 일부구간 + 일부구간 이라
* 누적합 - 일부구간 = 나머지구간
* 이렇게 되버리네..
* 뭔가 별거 아닌거같은데 놀랍네;;
* */

class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/투포인터/구간의합구하기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());//수의개수
        int m = Integer.parseInt(st.nextToken());//구해야하는 구간의 수
        int board[] = new int[n + 1];


        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i < board.length; i++) {
            board[i] = board[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int t = 0; t < m; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());

            int sum = board[endIdx] - board[startIdx - 1];

            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
    }

}
