package com.ps.백준.그래프.운동;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;


/*
* 시작지점과 도착지점이 같을때 만들어지는 경로중에서 최단 경로.
* 두 마을을 왕복하는 경우도 최단경로에 포함됨.
*
* 방향그래프
* 경로를 찾는게 불가능한경우 -1출력
* 시작지점은 정해지지 않았고 최단경로이기만 하면 어디든 상관없음.
*
* */

/*
* 어떻게 풀어야할지 모르겠음.
* 특히 시작지점과 도착지점이 같은데 그럼 비용을 어떤식으로 처리해야할지 모르겠음.
* 막연하게 플로이드 알고리즘 쓰면 되는거 아닌가? 라는 생각도 들었는데
* 이전에 플로이드 사용해본 경험을 토대로 추측해보면 사이클이 이루어질때는 사용할수 없는것같음.
* ex) floyd[1][1], floyd[2][2], ... floyd[n][n]은 다 0
* -> 찾아보니 플로이드 알고리즘을 조금 변형하면 순환 여부를 알수 있음.
* -> 참고 : https://steady-coding.tistory.com/101
* */


class Main {

    static int dist[][];
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/운동/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());//도시의 수
        int e = Integer.parseInt(st.nextToken());//도로의 수

        dist = new int[n + 1][n + 1];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
//                if(i == j) continue;

                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[from][to] = Math.min(cost, dist[from][to]);
        }

        int answer = INF;
        for (int k = 1; k < dist.length; k++) {
            for (int i = 1; i < dist.length; i++) {
                for (int j = 1; j < dist.length; j++) {
                    if(i == j) continue;


                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }

                }
            }
        }

        for (int k = 1; k < dist.length; k++) {
            for (int i = 1; i < dist.length; i++) {
                for (int j = 1; j < dist.length; j++) {
                    if(i == j) continue;

                    //서로 INF가 아닌값이 있다는것은 순환을 의미.
                    if(dist[i][j] != INF && dist[j][i] != INF){
                        answer = Math.min(answer, dist[i][j] + dist[j][i]);
                    }
                }
            }
        }



        if(answer == INF){
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }
    }

}
