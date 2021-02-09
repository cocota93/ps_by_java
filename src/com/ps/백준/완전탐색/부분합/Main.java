package com.ps.백준.완전탐색.부분합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

/*
* 모든경우를 다 하는것밖에 생각이 안나는데 그렇게 하면 시간제한이 0.5초라서 걸릴것같고
* 수열의 값도 정해진 뭔가가 아니라 주어지기 떄문에 어떤 규칙을 가질수는 없을것 같아서 dp로는 힘들것 같은데=_=
*
* 일단 수열을 정렬해놓고 생각해봐야할듯
* 음...문제를 다시보니까 주어진 수열의 순서를 바꾸지 않고 부분합이 s를 넘어야 하는것같음.
*
* n이 10 ~ 100000까지인데
* 만약 n이 100000이고 최소길이가 1이라고 가정하고 s를 찾으면 100000번 탐색해봐야 하고
* 최소길이가 2이면 99999번 더해봐야 알수있고
* 그렇다면 최소길이를k라고 할떄 몇인지는 알수없지만
* 최소길이 k일때 탐색(or 더하는 횟수)횟수는 100000 - k
* 근ㄷ데 k를 알수없어서 k가 1일때부터 100000떄까지를 모두 가정하고 다 해본다면
* 100000 + 99999 + 99998 + ... + 3 + 2 + 100000 - k
* 등차수열이니까 적당히 계산해보면 (k * ( k + 1)) / 2
* 시간복잡도로는 k^2정도 나오게됨.
* k를 100000라고 보면 k^2 = 10^10 = 백억.
* 1억에 1초라고 계산하면 100초를 넘어가기 떔에 이건 안됨 ㅡㅡ
* */

/*
* 찾아보니 투포인터라는 기법으로 푸는거라고 한다.
* 요런느낌으로도 생각했었는데
* 너무 섣부르게 안된다고 판단했던것같다.
* */


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/부분합/input.txt"));
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

        int answer = Integer.MAX_VALUE;
        boolean isFindAnswer = false;

        int sumStartIdx = 0;
        int sumEndIdx = 0;
        long sum = 0;

        while(sumStartIdx <= sumEndIdx){
            if(s <= sum){
                answer = Math.min(answer, sumEndIdx - sumStartIdx);
                isFindAnswer = true;

                sum -= board[sumStartIdx];
                sumStartIdx++;

            } else if(s > sum){
                if(sumEndIdx >= board.length) {
                    break;
                }
                sum += board[sumEndIdx];
                sumEndIdx++;
            }
        }


        System.out.println(isFindAnswer ? answer : 0);

    }

}
