package com.ps.백준.완전탐색.ATM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


/*
* 푸는건 어떻게든 풀겠는데 문제의 의도가 뭔지 잘 모르겠다.
* 메모이제이션을 의도한걸까?
* N이 최대 1000이라고 한다. 시간복잡도는 N!정도 될것같다.
* 메모이제이션 없이 매번 합을 구한다면 무조건 시간초과될듯.
*
* 위 생각대로 풀었더니 통과됐다. 근데 이게 그리디인가? 이건 그냥 dp아닌가??
* */

class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/ATM/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;



        int N = Integer.parseInt(br.readLine());
        int memo[] = new int[N];
        int cost[] = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cost);

        memo[0] = cost[0];
        for (int i = 1; i < memo.length; i++) {
            memo[i] = memo[i - 1] + cost[i];
        }


        int sum = 0;
        for (int i = 0; i < memo.length; i++) {
            sum += memo[i];
        }

        System.out.println(sum);
    }

}
