package com.ps.백준.완전탐색.DSLR;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;
/*
* 첫번쨰 시도떄 풀다가 ㅍ기후 몇일이 지난 지금 다시 생각해보고 있다.
* 지금 천천히 다시 생각해보면서 어떻게 풀지 생각해보니 메모이제이션과 bfs를 같이 써서 풀면 될것같다.
* 처음 풀떄는 두개의 개념을 혼합해서 쓴다는것에 대해 이질감을 느끼고 무서워 했던것 같다.
*
* 지금 다시보니 첫번쨰에도 대충 그런느낌으로 풀긴 했던것같다. 기억이 조금 떠올랐는데 그떄는 문자열로 처리해야될지
* 정수로 처리해야할지를 상당히 혼란스러워 했던것 같다. 변환함수 하나를 정의해두자.
*
* 다음 방문지 정할떄만 배열형태로 변환해서 처리하고 나머지는 다 정수로 하면될듯?
*
* 처리 순서를 적어보면
* 1. 목적지 도착여부 확인
* 2. 각 명령어를 실행
* 3. 실행한 명령어로 만들어진 다음 방문 예정지 인큐
*
* DFS로 풀어야할지 BFS로 풀어야할지가 상당히 애매하네?
*
* */

class Main {

    static class History{
        int resultNumber;
        String historyCommand;

        public History(int resultNumber, String historyCommand) {
            this.resultNumber = resultNumber;
            this.historyCommand = historyCommand;
        }
    }


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/완전탐색/DSLR/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int TMAX = Integer.parseInt(br.readLine());

        for (int t = 0; t < TMAX; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startNumber = Integer.parseInt(st.nextToken());
            int destNumber = Integer.parseInt(st.nextToken());


            History dp[] = new History[10000];
            boolean visited[] = new boolean[10000];

            Queue<History> commandQueue = new LinkedList<>();
            dp[startNumber] = new History(startNumber, "");
            visited[startNumber] = true;
            commandQueue.add(dp[startNumber]);

            while (!commandQueue.isEmpty()) {
                History prev = commandQueue.poll();

                //D
                int resultD = (prev.resultNumber * 2) % 10000;
                if (visited[resultD] == false
                        || dp[resultD].historyCommand.length() > dp[prev.resultNumber].historyCommand.length() + 1) {
                    dp[resultD] = new History(resultD,dp[prev.resultNumber].historyCommand + "D");
                    visited[resultD] = true;
                    commandQueue.add(dp[resultD]);
                }

                //S
                int resultS = prev.resultNumber - 1;
                if (resultS <= 0) resultS = 9999;
                if (visited[resultS] == false || dp[resultS].historyCommand.length() > dp[prev.resultNumber].historyCommand.length() + 1) {
                    dp[resultS] = new History(resultS,dp[prev.resultNumber].historyCommand + "S");
                    visited[resultS] = true;
                    commandQueue.add(dp[resultS]);
                }
//
                //L
                int resultL;
                {
                    StringBuilder sb = new StringBuilder();
                    sb.append(prev.resultNumber);
                    for (int i = 4 - sb.length(); i > 0; i--) {
                        sb.insert(0, 0);
                    }

                    resultL = Integer.parseInt(sb.substring(1, 4) + sb.substring(0, 1));
                }

                if (visited[resultL] == false || dp[resultL].historyCommand.length() > dp[prev.resultNumber].historyCommand.length() + 1) {
                    dp[resultL] = new History(resultL,dp[prev.resultNumber].historyCommand + "L");
                    visited[resultL] = true;
                    commandQueue.add(dp[resultL]);
                }

//
                //R
                int resultR;
                {
                    StringBuilder sb = new StringBuilder();
                    sb.append(prev.resultNumber);
                    for (int i = 4 - sb.length(); i > 0; i--) {
                        sb.insert(0, 0);
                    }

                    resultR = Integer.parseInt(sb.substring(3, 4) + sb.substring(0, 3));
                }

                if (visited[resultR] == false || dp[resultR].historyCommand.length() > dp[prev.resultNumber].historyCommand.length() + 1) {
                    dp[resultR] = new History(resultR,dp[prev.resultNumber].historyCommand + "R");
                    visited[resultR] = true;
                    commandQueue.add(dp[resultR]);
                }

                if(visited[destNumber] == true) break;
            }


            System.out.println(dp[destNumber].historyCommand);
        }

    }
//    SDDLDSLDRDDD
    //DDLSLDDRDDDD
}
