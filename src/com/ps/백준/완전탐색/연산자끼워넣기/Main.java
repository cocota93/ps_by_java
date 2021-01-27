package com.ps.백준.완전탐색.연산자끼워넣기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

//완전탐색인데 연산자를 어떤 순서로 조합할지가 조금 다른 문제.
//그 외에는 별다른 특이사항은 없는것 같다.
//아 연산자가 n -1개 주어진다.
//연산자 어떤 순서로 할건지 정할때 NextPermutation구현해서 해야될려나?
//-> 다른 사람들의 코드를 보니 백트래킹을 이용해서 구현했다. 그렇게 하니까 훨씬 쉽게 구현된다...
// 어떻게 해야 이런 판단을 할수 있을까?

class Main {
    static int sequence[];
    static int remainOperatorCount[];
    static long resultMax = Long.MIN_VALUE;
    static long resultMin = Long.MAX_VALUE;


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/연산자끼워넣기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        remainOperatorCount = new int[4];
        for (int i = 0; i < 4; i++) {
            remainOperatorCount[i] = Integer.parseInt(st.nextToken());
        }


        int depth = 0;
        Recur(depth, sequence[depth]);

        System.out.println(resultMax);
        System.out.println(resultMin);
    }

    private static void Recur(int depth, long prevSum) {
        if(depth == sequence.length - 1){
            resultMax = Math.max(prevSum, resultMax);
            resultMin = Math.min(prevSum, resultMin);
            return;
        }


        for (int operatorType = 0; operatorType < remainOperatorCount.length; operatorType++) {
            if(remainOperatorCount[operatorType] <= 0) continue;


            remainOperatorCount[operatorType]--;
            switch (operatorType){
                case 0:
                    Recur(depth + 1, prevSum + sequence[depth + 1]);
                    break;
                case 1:
                    Recur(depth + 1, prevSum - sequence[depth + 1]);
                    break;
                case 2:
                    Recur(depth + 1, prevSum * sequence[depth + 1]);
                    break;
                case 3:
                    Recur(depth + 1, prevSum / sequence[depth + 1]);
                    break;
            }
            remainOperatorCount[operatorType]++;


        }
    }
}
