package com.ps.백준.그래프.타임머신;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


class Main {

    static class Edge{
        int startCity;
        int endCity;
        long cost;

        public Edge(int startCity, int endCity, long cost) {
            this.startCity = startCity;
            this.endCity = endCity;
            this.cost = cost;
        }
    }

    static Edge costTable[];
    static long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/그래프/타임머신/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(),  " ");
        int cityCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        costTable = new Edge[edgeCount];

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine(),  " ");
            int startCity = Integer.parseInt(st.nextToken());
            int endCity = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            costTable[i] = new Edge(startCity, endCity, cost);
        }

        long optimalTable[] = new long[cityCount + 1];
        for (int i = 0; i < optimalTable.length; i++) {
            optimalTable[i] = INF;
        }


        //1번 도시에서 출발하여 나머지 도시로 가는 가장 빠른시간 구하기

        optimalTable[1] = 0;//1번도시에서 1번도시로 가는데에는 0초.
        for (int i = 0; i < cityCount - 1; i++) {

            for (int j = 0; j < edgeCount; j++) {

                if(optimalTable[costTable[j].startCity] == INF) continue;//startCity까지 가는데 얼마나 걸리는지 아직 알수없다 or 갈수없다.

                //목적지까지 가는데 비용이 기존보다 작은경우 새롭게 업데이트.
                //이러한 행위를 모든 정점을 순회하며 반복함으로써 가장 짦은거리를 알수 있도록 업데이트.
                //뒤에 업데이트 된 내용떄문에 앞에가 또 바뀌어야되는 상황이 올수 있으니
                // 몇번 더 반복해줘야 하는데 간선의 개수는 '정점의 개수 -1' 까지 존재 할수 있으니
                //'정점의 개수 - 1'번 만큼 반복해줘야 한다.
                if(optimalTable[costTable[j].endCity] > optimalTable[costTable[j].startCity] + costTable[j].cost){
                    optimalTable[costTable[j].endCity] = optimalTable[costTable[j].startCity] + costTable[j].cost;
                }
            }
        }


        boolean infinityLoop = false;
        for (int i = 0; i < edgeCount; i++) {
            //위에서 필요한 업데이트 횟수를 다 돌았는데도 더 짦은 거리를 만들수 있다는건 음수사이클이 발생한다는 의미.
            if(optimalTable[costTable[i].startCity] != INF && optimalTable[costTable[i].endCity] > optimalTable[costTable[i].startCity] + costTable[i].cost){
                infinityLoop = true;
                break;
            }
        }


        if(infinityLoop){
            System.out.println(-1);
        }else {
            for (int i = 2; i <= cityCount; i++) {
                if(optimalTable[i] == INF){
                    System.out.println(-1);
                }else{
                    System.out.println(optimalTable[i]);
                }
            }
        }


    }

}
