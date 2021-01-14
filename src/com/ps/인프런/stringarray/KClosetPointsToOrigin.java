package com.ps.인프런.stringarray;

import java.util.*;

/**강사님은 PriorityQueue를 사용하셨지만 PriorityQUeue사용시 삽입시마다 정렬이 수행되서 비효율적이지 않나? 차라리 리스트에 다 넣고 한번만 정렬하는게 나을거같은데*/
public class KClosetPointsToOrigin {


    class Point{
        Integer x;
        Integer y;

        public Point() {
        }

        public Point(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Double calDistance(Point dest){
            Double sqrt = Math.sqrt((dest.x - this.x) * (dest.x - this.x) + (dest.y - this.y) * (dest.y - this.y));
            return sqrt;
        }
    }


//    public int[][] solution(int[][] input, int k) {
//        List<Point> fixedInput = new ArrayList<>();
//        for (int[] row : input) {
//            fixedInput.add(new Point(row[0], row[1]));
//        }
//
//        Point origin = new Point(0, 0);
//
//        fixedInput.sort(Comparator.comparingDouble(o -> o.calDistance(origin)));
//
//        Point kClosetPoint = fixedInput.get(k);
//
//        return new int[][]{{kClosetPoint.x, kClosetPoint.y}};
//    }

    public int[][] solution(int[][] input, int k) {
        Point origin = new Point(0, 0);
        Queue<Point> sortedSet = new PriorityQueue<>(input.length, Comparator.comparingDouble(o -> o.calDistance(origin)));
        for (int[] row : input) {
            sortedSet.add(new Point(row[0], row[1]));
        }

        Point shortestPoint = sortedSet.peek();
        for (Point point : sortedSet) {
            Double distance = point.calDistance(origin);
            System.out.println("distance : " + distance);
        }

        return new int[][]{{shortestPoint.x, shortestPoint.y}};
    }

    public static void main(String[] args) {
        KClosetPointsToOrigin proposal = new KClosetPointsToOrigin();

        int input[][] =  {{1,3},{-2,2}};
        int k = 1;
        int[][] result = proposal.solution(input, k);
        System.out.println(Arrays.deepToString(result));
    }

}
