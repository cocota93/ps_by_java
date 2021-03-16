package com.ps.백준.그래프.궁금한민호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
* 어떤 도시로 이동하는데 필요한 최단시간이 인풋으로 주어지는데 이러한 값들을 이용하여
* 필요한 도로의 수와 도로의 비용에 대한 합을 구해야함.
*
* 음. 최소스패닝알고리즘(프림 알고리즘, 크루스칼 알고리즘)이 생각난다. 기존 트리형태의 입력에서 일부 간선을 지워
* 특정 형태의 그래프를 만드는 알고리즘. 해당 문제와 비슷한것 같음.
*
* 프림알고리즘이랑 크루스칼 알고리즘이랑 약간 헷갈렸었는데 다시한번 정리해보면
* 프림알고리즘은 bfs + 우선순위큐 로 구현해서 일부 간선들을 선택해가는 느낌
* 크루스칼 알고리즘은 유니온파인드를 이용하여 하나로 만들어가는 느낌
* */


/*
* 잘 안풀리길래 찾아보니까 플로이드 알고리즘으로 푸는문제였음.
* 문제에서 '모든 도시의 쌍으로..blahblah'할떄 알았어야 했던것 같은데...
*
* 풀이참고 : https://steady-coding.tistory.com/105
* */

class Main {


    static int simpleDist[][];
    static int optimalDist[][];
    static int INF = 987654321;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/궁금한민호/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        simpleDist = new int[n + 1][n + 1];
        optimalDist = new int[n + 1][n + 1];

        for (int i = 1; i < optimalDist.length; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j < optimalDist.length; j++) {
                int cost = Integer.parseInt(st.nextToken());
                optimalDist[i][j] = cost;
                simpleDist[i][j] = cost;
            }
        }


        for (int k = 1; k < optimalDist.length; k++) {
            for (int i = 1; i < optimalDist.length; i++) {
                for (int j = 1; j < optimalDist.length; j++) {

                    if(i == j) continue;
                    if(i == k) continue;
                    if(j == k) continue;


                   if(optimalDist[i][j] > optimalDist[i][k] + optimalDist[k][j]){
                        System.out.println(-1);
                        return;
                    }

                   //if(optimalDist[i][j] == optimalDist[i][k] + optimalDist[k][j])
                   //는 optimalDist[i][j]로 가는 경로에 중간경로 k가 있다는 의미 이니
                   // 해당 k라는 지점을 살리기 위해 simpleDist[i][j]에 INF를 넣음으로써
                   //원래 경로를 유추할수 있도록 한다.
                   if(optimalDist[i][j] == optimalDist[i][k] + optimalDist[k][j]){
                       simpleDist[i][j] = INF;
                   }

                }
            }
        }

        int roadCount = 0;
        int roadCostSum = 0;
        for (int i = 1; i < simpleDist.length; i++) {

            //모든 도로의 합을 구하라고 하는데 만들어진 simpleDist는 대칭행렬같은 모양을 띄기 떄문에
            //절반만 더하기 위해서 아래와 같은 코드를 변경해야 했다.
            //for (int j = 1; j < simpleDist.length; j++)
            for (int j = i; j < simpleDist.length; j++) {
                if (simpleDist[i][j] != INF) {
                    roadCount++;
                    roadCostSum += simpleDist[i][j];
                }
            }
        }


        System.out.println(roadCostSum);

    }

}
