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
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/타임머신/input.txt"));
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

        long calTable[] = new long[cityCount + 1];
        for (int i = 0; i < calTable.length; i++) {
            calTable[i] = INF;
        }


        calTable[1] = 0;
        for (int i = 0; i < cityCount - 1; i++) {
            for (int j = 0; j < edgeCount; j++) {

                if(calTable[costTable[j].startCity] == INF) continue;

                if(calTable[costTable[j].endCity] > calTable[costTable[j].startCity] + costTable[j].cost){
                    calTable[costTable[j].endCity] = calTable[costTable[j].startCity] + costTable[j].cost;
                }

            }
        }

        boolean check = false;
        for (int i = 0; i < edgeCount; i++) {
            if(calTable[costTable[i].startCity] != INF && calTable[costTable[i].endCity] > calTable[costTable[i].startCity] + costTable[i].cost){
                check = true;
                break;
            }
        }


        if(check){
            System.out.println(-1);
        }else {
            for (int i = 2; i <= cityCount; i++) {
                if(calTable[i] == INF){
                    System.out.println(-1);
                }else{
                    System.out.println(calTable[i]);
                }
            }
        }


    }

}
