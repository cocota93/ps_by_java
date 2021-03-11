package com.ps.백준.그래프.웜홀;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class Main {

    static class CostTable{
        int endCity;
        int cost;

        public CostTable(int endCity, int cost) {
            this.endCity = endCity;
            this.cost = cost;
        }
    }

//    static int INF = Integer.MAX_VALUE;
//    static int INF = 987654321;

    static List<CostTable> costTable[];
    static int optimalDist[];


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/웜홀/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());//지점의 수
            int m = Integer.parseInt(st.nextToken());//도로의 수
            int w = Integer.parseInt(st.nextToken());//웜홀의 수


            costTable = new List[n + 1];
            for (int i = 0; i < costTable.length; i++) {
                costTable[i] = new ArrayList<>();
            }

            optimalDist = new int[n + 1];
//            for (int i = 0; i < optimalDist.length; i++) {
//                optimalDist[i] = INF;
//                하면 오답처리됨
//            }



            /*도로의 정보*/
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                costTable[v1].add(new CostTable(v2, cost));
                costTable[v2].add(new CostTable(v1, cost));
            }

            /*웜홀의 정보*/
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                costTable[start].add(new CostTable(end, -cost));
            }


            boolean infinityLoop = false;
            optimalDist[1] = 0;
            for (int i = 1; i < costTable.length - 1; i++) {//정점의 - 1개 번

                for (int j = 1; j < costTable.length; j++) {

                    for (CostTable costObj : costTable[j]) {
                        if(optimalDist[costObj.endCity] > optimalDist[j] + costObj.cost){
                            optimalDist[costObj.endCity] = optimalDist[j] + costObj.cost;
                        }
                    }
                }

            }

            for (int j = 1; j < costTable.length; j++) {

                for (CostTable costObj : costTable[j]) {
                    if(optimalDist[costObj.endCity] > optimalDist[j] + costObj.cost){
                        infinityLoop = true;
                        break;
                    }
                }

                if(infinityLoop) break;
            }

            if(infinityLoop){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

}
