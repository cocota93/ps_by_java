package com.ps.백준.mst.우주신과의_교감;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/*
* 프림으로 풀려고했는데 뭔가 부자연스럽게 계속 꼬이는것 같아서 풀이보니까 크루스칼로 푸네
* */

class Main {

    static class OpenListInfo{
        int v1;
        int v2;
        double cost;


        public OpenListInfo(int v1, int v2, double cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }




    static int n;//우주신들의 수
    static int m;//이미 연결된 신들과의 통로 수
    static int[] unionInfo;
    static double answer;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("src/com/ps/백준/mst/우주신과의_교감/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        unionInfo = new int[n];
        for (int i = 0; i < unionInfo.length; i++) {
            unionInfo[i] = i;
        }

//        answer = 0.0;

        Queue<OpenListInfo> queue = new PriorityQueue<>(1, Comparator.comparingDouble(o -> o.cost));
        Point[] godPosArray = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            godPosArray[i] = new Point(x, y);
        }

        for (int i = 0; i < m; i++) {
            //이미 연결되어있던 통로
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            doUnion(v1, v2);
//            answer += calDistance(godPosArray[v1], godPosArray[v2]);
        }

        for (int i = 0; i < godPosArray.length; i++) {
            for (int j = i + 1; j < godPosArray.length; j++) {
                if(i == j) continue;

                queue.add(new OpenListInfo(i, j, calDistance(godPosArray[i], godPosArray[j])));
            }
        }


        kruskal(queue, godPosArray);

        System.out.println(String.format("%.2f", answer));
    }

    private static void doUnion(int target1, int target2) {
        int parent1 = findParent(target1);
        int parent2 = findParent(target2);

        if(parent1 == parent2) return;

        unionInfo[Math.max(parent1, parent2)] = Math.min(parent1, parent2);
    }

    private static int findParent(int target) {
        int parent = unionInfo[target];
        if(parent == target) return parent;

        int topParent = findParent(parent);
        unionInfo[target] = topParent;
        return unionInfo[target];
    }

    private static boolean isSameParent(int target1, int target2) {
        return findParent(target1) == findParent(target2);
    }

    private static void kruskal(Queue<OpenListInfo> queue, Point[] godPosArray) {

        while(!queue.isEmpty()){
            OpenListInfo openListInfo = queue.poll();

            if(isSameParent(openListInfo.v1, openListInfo.v2)) continue;

            doUnion(openListInfo.v1, openListInfo.v2);
            answer += calDistance(godPosArray[openListInfo.v1], godPosArray[openListInfo.v2]);
        }
    }


//    private static Double calDistance(POINT visitPlace, POINT point) {
//        return Double.valueOf(Math.abs(visitPlace.y - point.y) + Math.abs(visitPlace.x - point.x));
//    }

//    private static Double calDistance(POINT visitPlace, POINT point) {
//        return Math.sqrt(Math.pow(visitPlace.y - point.y, 2) + Math.pow(visitPlace.x - point.x, 2));
//    }


//    private static Double calDistance(Point visitPlace, Point point) {
//        return (double) (Math.abs(visitPlace.y - point.y) + Math.abs(visitPlace.x - point.x));
//    }

    private static Double calDistance(Point visitPlace, Point point) {
        return Math.sqrt(Math.pow(visitPlace.y - point.y, 2) + Math.pow(visitPlace.x - point.x, 2));
    }

}
