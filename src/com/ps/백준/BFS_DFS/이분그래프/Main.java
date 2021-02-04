package com.ps.백준.BFS_DFS.이분그래프;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


/*
* 풀려면 이분그래프가 뭔지 일단 알아야 한다.
* 참고 : https://jellyinghead.tistory.com/14
* 내가 이해한걸로는 2가지 색상으로 모든 정점을 칠해야 하고 그 방법은 DFS든 BFS는 사용해서 모든 정점에 대해
* 번갈아가면서 칠하면 된다. 인접해있다는 말은 정점간에 간선으로 연결되어있다는 말이다.
*  절대 인덱스가 1차이나는 걸로 이해하면 안된다.
*  어쩃든 이렇게 칠했을떄 인접한 정점간에 똑같은 색의 정점이 있으면 안된다.
*
* BFS가 좀 더 상상하기 쉬운것 같아서 BFS로 푸는게 나을것 같고
* 구현방법은 방문한 정점과 인접한 정점을 방문하기 위해 다음 방문지 큐에 어떤 정점을 방문할건지 넣을떄
* 다음 방문지가 이미 방문되었고 색이 현재 방문지와 색이 같으면 이분그래프가 아닌걸로 판단하면 될것같다.
* */

class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/BFS_DFS/이분그래프/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int vertexCount = Integer.parseInt(st.nextToken());
            int edgeCount = Integer.parseInt(st.nextToken());

            List<Integer> edgeList[] = new List[vertexCount + 1];
            for (int i = 0; i < edgeList.length; i++) {
                edgeList[i] = new ArrayList<>();
            }


            for (int i = 0; i < edgeCount; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                edgeList[v1].add(v2);
                edgeList[v2].add(v1);
            }

            int visited[] = new int[vertexCount + 1];

            boolean isBiGraph = true;
            for(int tryEdgeSequence = 1; tryEdgeSequence < visited.length; ++tryEdgeSequence){
                Queue<Integer> nextPlaceQueue = new LinkedList<>();
                if(visited[tryEdgeSequence] != 0) continue;

                nextPlaceQueue.add(tryEdgeSequence);
                visited[tryEdgeSequence] = 1;

                while(!nextPlaceQueue.isEmpty()){
                    Integer visitVertex = nextPlaceQueue.poll();
                    Integer visitVertexColor = visited[visitVertex];

                    for (Integer nextPlace : edgeList[visitVertex]) {
                        if(visited[nextPlace] == visited[visitVertex]) {
                            //색이같음.
                            isBiGraph = false;
                            break;
                        }

                        //색이 칠해져있음.
                        if(visited[nextPlace] != 0) continue;

                        nextPlaceQueue.add(nextPlace);
                        if(visitVertexColor == 1){
                            visited[nextPlace] = 2;
                        } else{
                            visited[nextPlace] = 1;
                        }
                    }

                    if(isBiGraph == false){
                        break;
                    }
                }

                if(isBiGraph == false){
                    break;
                }
            }

            if(isBiGraph){
                System.out.println("YES");
            }else{
                System.out.println("NO");

            }
        }

    }

}
