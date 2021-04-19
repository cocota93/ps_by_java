package com.ps.백준.위상정렬.ACM크래프트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


/*
* 이정도 수준의 문제를 여러번 풀어봐야할것같음.
* */


class Main {



    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/위상정렬/ACM크래프트/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());//건물의 수
            int k = Integer.parseInt(st.nextToken());//건물 순서 규칙

            int[] buildCostArray = new int[n];

            //건물당 건설에 걸리는 시간
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                int cost = Integer.parseInt(st.nextToken());
                buildCostArray[i] = cost;
            }


            int[] indegreeCountArray = new int[n];
            List<Integer> outdegreeList[] = new List[n];
            for (int i = 0; i < outdegreeList.length; i++) {
                outdegreeList[i] = new ArrayList<>();
            }

            //건설 순서
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int first = Integer.parseInt(st.nextToken()) - 1;
                int second = Integer.parseInt(st.nextToken()) - 1;

                indegreeCountArray[second]++;
                outdegreeList[first].add(second);
            }


            //승리하기 위해 건설해야하는 건물의 번호
            int goalBuildNum = Integer.parseInt(br.readLine()) - 1;


            int[] delayTimeArray = new int[n];
            Queue<Integer> indegreeZeroQueue = new LinkedList<>();
            for (int i = 0; i < indegreeCountArray.length; i++) {
                if(indegreeCountArray[i] == 0){
                    indegreeZeroQueue.add(i);
                    delayTimeArray[i] = buildCostArray[i];
                }
            }

            //동시에 넣은것중 가장 오래걸리는 시간만큼 지연이 되었다가 진행되어야함..
            //동시에 넣은걸 어떤식으로 구분하지?
            //특정 건물을 짓는데 필요한 최대지연시간을 모두 저장해버리면 됨.
            while(!indegreeZeroQueue.isEmpty()){
                Integer visitPlace = indegreeZeroQueue.poll();

                for (Integer connectedPlace : outdegreeList[visitPlace]) {
                    indegreeCountArray[connectedPlace]--;
                    delayTimeArray[connectedPlace] = Math.max(delayTimeArray[connectedPlace], delayTimeArray[visitPlace] + buildCostArray[connectedPlace]);

                    if(indegreeCountArray[connectedPlace] == 0){
                        indegreeZeroQueue.add(connectedPlace);
                    }
                }

            }

            System.out.println(delayTimeArray[goalBuildNum]);
        }

    }

}
