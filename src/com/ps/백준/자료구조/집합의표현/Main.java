package com.ps.백준.자료구조.집합의표현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 정확히 어떻게 풀어야할지는 모르겠지만
* dfs, bfs를 이용하는 문제 아닌가? 하는 생각이 스쳐지나간다.
* -> '유니온 파인드' 라는것을 이용해야 한다고 한다.
*
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
        for (int i = 0; i < container.length; i++) {
            container[i] = i;
        }
        int commandCount = Integer.parseInt(st.nextToken());

        for (int i = 0; i < commandCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());//0은 합집합으로 만들기, 1은 합집합인지 확인하기
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            if(command == 0){
                doUnion(container, parent, child);
            }else if(command == 1){
                boolean isSame = isSampParent(container, parent, child);

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

    private static void doUnion(int[] container, int hopeParent, int hopeChild) {
        if (isUnion(container, hopeParent, hopeChild)) return;

        container[hopeParent] = hopeParent;
        container[hopeChild] = hopeParent;
    }

    private static boolean isUnion(int[] container, int hopeParent, int hopeChild) {
        //두 집합중 더 부모가 되고싶은 녀석을 hopeParent라고 한다.
        //hopeParent의 부모가 자신이면서 hopeChild와 같은 부모를 가질경우 이미 합쳐져있는것.
        int finalParent = find(container, hopeParent);
        if(isSampParent(container, hopeParent, hopeChild) && finalParent == hopeParent) return true;

        return false;
    }

    private static boolean isSampParent(int[] container, int node1, int node2) {
        int parent1 = find(container, node1);
        int parent2 = find(container, node2);

        return parent1 == parent2;
    }

}
