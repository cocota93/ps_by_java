package com.ps.백준.그래프.줄세우기;

import java.io.*;
import java.util.*;


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/줄세우기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int indegreeCnt[] = new int[n + 1];
//        List<List<Integer>> edgeGraphList = new ArrayList<>();
        List<Integer> edgeGraphList[] = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            edgeGraphList[i] = new ArrayList<>();
        }
//        boolean edgeGraph[][] = new boolean[n + 1][n + 1];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

//            edgeGraph[from][to] = true;
            edgeGraphList[from].add(to);
            indegreeCnt[to]++;
        }

        Queue<Integer> indegreeZeroQueue = new LinkedList<>();
        List<Integer> visitSequenceList = new ArrayList<>();

        for (int i = 1; i < indegreeCnt.length; i++) {
            if(indegreeCnt[i] == 0){
                indegreeZeroQueue.add(i);
            }
        }


        while(!indegreeZeroQueue.isEmpty()){
            Integer visitPos = indegreeZeroQueue.poll();
            visitSequenceList.add(visitPos);

            for (Integer connectedPos : edgeGraphList[visitPos]) {
                indegreeCnt[connectedPos]--;
                if(indegreeCnt[connectedPos] == 0){
                    indegreeZeroQueue.add(connectedPos);
                }
            }
//            for (int connectedPos = 1; connectedPos < edgeGraphList[visitPos].size(); connectedPos++) {
//                boolean connected = edgeGraphList[visitPos][connectedPos];
//                if(!connected) continue;
//
//                indegreeCnt[connectedPos]--;
//
//                if(indegreeCnt[connectedPos] == 0){
//                    indegreeZeroQueue.add(connectedPos);
//                }
//            }
        }

        for (Integer integer : visitSequenceList) {
            bw.write(integer + " ");
        }

        bw.flush();
        bw.close();
    }

}
