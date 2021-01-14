package com.ps.백준.BFS_DFS.바이러스;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;


class Main {

    /*
    * dfs, bfs기본문제랑 크게 다르지 않음.
    * */
    private static int DFS(int searchIndex, int[][] interlineState, boolean[] visitCheck) {
        int visitCount = 0;
        visitCheck[searchIndex] = true;
        visitCount++;
//        System.out.println("vertex : " + searchIndex);

        for (int i = 1; i < interlineState[0].length; i++) {
            if(interlineState[searchIndex][i] == 1 && visitCheck[i] == false){
                visitCount += DFS(i, interlineState, visitCheck);
            }
        }
        
        return visitCount;
    }

    private static int BFS(int searchIndex, int[][] interlineState, boolean[] visitCheck) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(searchIndex);
        visitCheck[searchIndex] = true;

        int result = 0;
        for(;!queue.isEmpty();){
            Integer startVertex = queue.poll();

            for (int i = 0; i < visitCheck.length; i++) {
                if(visitCheck[i] == false && interlineState[startVertex][i] == 1){
                    visitCheck[i] = true;
                    queue.offer(i);
                    result++;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/BFS_DFS/바이러스/input.txt"));
        Scanner sc = new Scanner(System.in);

        int computerCount = sc.nextInt();
        int directConnectionsCount = sc.nextInt();
        boolean visitCheck[] = new boolean[computerCount + 1];
        int interlineState[][] = new int[computerCount + 1][computerCount + 1];

        for (int i = 0; i < directConnectionsCount; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            interlineState[v1][v2] = interlineState[v2][v1] = 1;
        }

        int searchIndex = 1;

//        int visitCount = DFS(searchIndex, interlineState, visitCheck) - 1;
        int visitCount = BFS(searchIndex, interlineState, visitCheck);


        System.out.println(visitCount);
    }

}
