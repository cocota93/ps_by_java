package com.ps.백준.그래프.작업;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 그림을 그려보니 큐에 넣어서 어떻게 해야할것같긴한데 실제 구현을 어떤식으로 해야할지 모르겠네
* 각각에 작업들에 대해 선행작업가 다 처리되었는지 확인할때 어떤식으록 구현해야할지가 고민임
* 각각의 작업들이 자신의 선행작업에 대해 리스트로 가지고 있어야하나? 아니면 비트마스크 같은걸로 체크해야하나??
*
* 각각의 작업들이 선행작업 리스트를 들고 있고 자신이 완료되면 순회하면서 자신을 가지고있는 애들이 누군지 확인하고
* 선행작업 리스트에서 빼준다면?
* n^2정도의 시간복잡도를 갖게될듯.
* n은 만
* n^2 는 1억
* 시간제한은 2초.
* 괜찮을것같은데? 어차피 n^2도 최악일때고
*
* */

/*
* 위상정렬 알고리즘을 사용해야 한다고 한다.
* 위상정렬 문제는 처음
*
* 위상정렬의 개념이 내가 처음에 생각했던 순회하면서 삭제와 유사하다.
* 난 리스트에 요소를 삭제한다는게 좀 맘에 안들었었는데
* 큐를 활용해서 극복하는것같다.
* 그리고 또다른 차이점은 자신보다 먼저 끝나야 하는 녀석들의 리스트를 들고있지않고
* 자신의 후행?리스트를 들고있다가 자신이 끝나면 후행리스트를 순회하면서 카운트를 하나씩 줄여준다.
* 이렇게 해버리니 불필요한 탐색이 없어져 버린다
*
* ㅜㅜ위상정렬 개념 보고왔는데도 혼자 구현할려니까 잘 안되네
* */


/*
* 위상정렬의 기본 개념중 진입차수와 진출차수라는게 있다
* 진입차수(in-degree) : 특정 정점으로 들어오는 간선의 수
* 진출차수(out-degree) : 특정 정점에서 밖으로 나가는 간선의 수
*
*
* 출처 : https://steady-coding.tistory.com/182
*
* 답안코드 보고 따라구현했는데 그래도 어렵게 느껴진다.
* 비슷한 문제를 더 풀어봐야할듯.
* */



class Main {

    static int n;
    static int indegree[];
    static int timeCost[];
    static ArrayList<ArrayList<Integer>> edgeGraph;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/그래프/작업/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        edgeGraph = new ArrayList<>();//자신을 가리키는 정점들의 리스트를 갖게된다.
        for (int i = 0; i < n + 1; i++) {
            edgeGraph.add(new ArrayList<>());
        }

        indegree = new int[n + 1];
        timeCost = new int[n + 1];

        for (int startVertex = 1; startVertex < n + 1; startVertex++) {
            st = new StringTokenizer(br.readLine(), " ");

            timeCost[startVertex] = Integer.parseInt(st.nextToken());

            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int endVertex = Integer.parseInt(st.nextToken());
                edgeGraph.get(endVertex).add(startVertex);
                indegree[startVertex]++;
            }
        }

        int answer = topologicalSort();
        bw.write(answer + "");

        bw.flush();
        bw.close();
    }

    private static int topologicalSort() {
        Queue<Integer> q = new LinkedList<>();

        int result[] = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            result[i] = timeCost[i];//해당 작업을 완료하는데 필요한 최소시간

            if(indegree[i] == 0){ //진입차수가 0인것. 선행작업이 없어서 가장 먼저 시작하는 녀석들 인큐.
                q.add(i);
            }
        }


        while(!q.isEmpty()){
            int now = q.poll();

            for (Integer head : edgeGraph.get(now)) {

                indegree[head]--;

                //head번의 일을 완료하는데 필요한 시간이 더 긴게 있다면 거기에 따라가야하므로
                //기존꺼와 새로운거를 비교하여 더 큰걸로 적용.
                result[head] = Math.max(result[head], result[now] + timeCost[head]);

                if(indegree[head] == 0){
                    q.add(head);
                }
                
            }

        }

        int answer = 0;
        for (int i = 0; i < result.length; i++) {
            answer = Math.max(answer, result[i]);
        }

        return answer;
    }

}
