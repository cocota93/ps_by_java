package com.ps.백준.그래프.줄세우기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


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

        boolean edgeGraph[][] = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edgeGraph[from][to] = true;
            indegreeCnt[to]++;
        }

        Queue<Integer> indegreeZeroQueue = new LinkedList<>();
        LinkedList<Integer> visitSequenceList = new LinkedList<>();

        for (int i = 1; i < indegreeCnt.length; i++) {
            if(indegreeCnt[i] == 0){
                indegreeZeroQueue.add(i);
            }
        }


        while(!indegreeZeroQueue.isEmpty()){
            Integer visitPos = indegreeZeroQueue.poll();
            visitSequenceList.add(visitPos);

            for (int connectedPos = 1; connectedPos < edgeGraph[visitPos].length; connectedPos++) {
                boolean connected = edgeGraph[visitPos][connectedPos];
                if(!connected) continue;

                indegreeCnt[connectedPos]--;

                if(indegreeCnt[connectedPos] == 0){
                    indegreeZeroQueue.add(connectedPos);
                }
            }
        }

        for (Integer integer : visitSequenceList) {
            bw.write(integer + " ");
        }

        bw.flush();
        bw.close();
    }

}
