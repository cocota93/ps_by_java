package com.ps.백준.자료구조.집합의표현;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 정확히 어떻게 풀어야할지는 모르겠지만
* dfs, bfs를 이용하는 문제 아닌가? 하는 생각이 스쳐지나간다.
* -> '유니온 파인드' 라는것을 이용해야 한다고 한다.
* */

/*
* 처음에 유니온파인드 개념 확인후 구현해볼떄 누가 더 부모인지 순서를 두는게 의미가 있다고 생각해서
* 그렇게 구현했다가 순서가 무의미하게 바꿨는데
* 지금 되돌아보니 문제에서 특별한 제약사항을 주는게 아니라면 순서는 무의미한게 맞는것같다.
* 특히 find함수에서 해당 노드가 가장 최상위 노드를 가리키도록 하는 코드떄문에 그렇다.
* */


class Main {

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/자료구조/집합의표현/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int container[] = new int[n + 1];
        for (int i = 0; i < container.length ; i++) {
            container[i] = i;
        }
        int commandCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < commandCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());//0은 합집합으로 만들기, 1은 합집합인지 확인하기
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            if(command == 0){
                doUnion(container, node1, node2);
            }else if(command == 1){
                boolean isSame = isSampParent(container, node1, node2);

                if(isSame){
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }else {
                System.out.println("not support command");
            }
        }

    }

    private static int find(int[] container, int node) {
        if(container[node] == node){
            return node;
        }

        container[node] = find(container, container[node]);
        return container[node];
    }

    private static void doUnion(int[] container, int node1, int node2) {
        //요부분이 제출실패의 주요 원인이었음. find호출하면서 node의 부모가 새로 갱신될수 있고
        //기존에 다른 것들과 합집합이었다면 최상위끼리 계산해야 하는데 그렇게 하지 않았음.
        int node1Parent = find(container, node1);
        int node2Parent = find(container, node2);

        if (node1Parent == node2Parent) return;
        container[Math.max(node1Parent,node2Parent)] = Math.min(node1Parent,node2Parent);
    }


    private static boolean isSampParent(int[] container, int node1, int node2) {
        int parent1 = find(container, node1);
        int parent2 = find(container, node2);

        return parent1 == parent2;
    }

}
