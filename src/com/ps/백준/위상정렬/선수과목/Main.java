package com.ps.백준.위상정렬.선수과목;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;

/*
* 진입차수가 0인것부터 수강하고
* 해당 과목을 들음으로써 조건이 만족되는 후행과목들을 방문해 진입차수를 하나씩 줄여준다.
*
* 처리순서는 제일 처음 듣는것부터처리하면 될려나? 아니면 거꾸로 해야되나?
* -> 처음듣는것붜 해도 별 문제 없을것 같은데? 풀수는 있을것 같은데 제대로 풀기 위해서 정리노트 한번 들춰보자
* -> 각각의 노드는 진입차수와 진출리스트를 가지고 있어야겠네
* -> 진입차수가 0이 된 순서대로 처리 할수 있도록 큐가 하나 있어야 되고 실제 방문 순서를 기록 할수 있는 리스트가 하나 필요함
* */

/*
* 예전에 위상정렬 처음 공부할떄는 이해하는것도 괴로웠는데 이젠 정리한거 한번 보는걸로도
* 문제 해결에 막힘이 없다. ㅎㅎ
* */

class Main {

    static int n;//과목의 수
    static int m;//선수 조건의 수

    static List<Integer> edgeGraph[];//edgeGraph[from].add(to)
    static int indegreeCount[];


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/위상정렬/선수과목/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        edgeGraph = new List[n];
        for (int i = 0; i < edgeGraph.length; i++) {
            edgeGraph[i] = new ArrayList<>();
        }
        indegreeCount = new int[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;

            edgeGraph[from].add(to);
            indegreeCount[to]++;
        }

        Queue<Integer> indegreeZeroPlaceQueue = new LinkedList<>();
        List<Integer> visitPlaceList = new ArrayList<>();
        int completeTimeTable[] = new int[indegreeCount.length];
        for (int i = 0; i < indegreeCount.length; i++) {
            if(indegreeCount[i] == 0){
                indegreeZeroPlaceQueue.add(i);
                completeTimeTable[i] = 1;
            }
        }

        while (!indegreeZeroPlaceQueue.isEmpty()){
            Integer visitPlace = indegreeZeroPlaceQueue.poll();
            visitPlaceList.add(visitPlace);

            for (Integer connectedPlace : edgeGraph[visitPlace]) {
                indegreeCount[connectedPlace]--;
                if(indegreeCount[connectedPlace] == 0){
                    indegreeZeroPlaceQueue.add(connectedPlace);
                    completeTimeTable[connectedPlace] = completeTimeTable[visitPlace] + 1;
                }
            }
        }

        for (int i = 0; i < completeTimeTable.length; i++) {
            System.out.print(completeTimeTable[i] + " ");
        }


    }

}
