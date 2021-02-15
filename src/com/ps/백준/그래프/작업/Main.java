package com.ps.백준.그래프.작업;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;

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




class Main {

    static class Work{
        int timeCost;
        int workNumber;
        int refCount; //현재 자신을 가리키고 있는 수
        Queue<Integer> needPreCompleteQueue = new LinkedList<>();//자신의 후행 리스트
    }


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/com/ps/백준/그래프/작업/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        List<Work> workQueue = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Work work = new Work();
            work.workNumber = i + 1;
            workQueue.add(work);
        }


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Work work = workQueue.get(i);

            int needTimeCost = Integer.parseInt(st.nextToken());
            work.timeCost = needTimeCost;

            int needAlreadyCompleteCount = Integer.parseInt(st.nextToken());
            work.refCount = needAlreadyCompleteCount;
            for (int j = 0; j < needAlreadyCompleteCount; j++) {
                int preWorkNumber = Integer.parseInt(st.nextToken());
                Work preWork = workQueue.get(preWorkNumber);
                preWork.needPreCompleteQueue.add(work.workNumber);
            }
        }


        while(workQueue.isEmpty()){



        }




    }

}
