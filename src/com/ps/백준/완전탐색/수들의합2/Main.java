package com.ps.백준.완전탐색.수들의합2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
* 주어진 수들의 합이 M이 나오는 경우의수를 확인 하는 문제.
* 수가 주어질떄 항상 양수로 주어지기 떄문에 M이 나오는게 확인 된순간 그 뒤에는 더이상 확인할 필요 없다.
*
* */

class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/수들의합2/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long board[] = new long[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        int resultCount = 0;
        for (int i = 0; i < N; i++) {
            long sum = 0;
            for (int j = i; j < N; j++) {
                sum += board[j];
                if (sum == M) {
                    resultCount++;
//                    System.out.println("j : " + j);
                    break;
                }

                if(sum > M){
                    break;
                }
            }
        }


        System.out.println(resultCount);
    }

}
